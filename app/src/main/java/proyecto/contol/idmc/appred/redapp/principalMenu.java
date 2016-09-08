package proyecto.contol.idmc.appred.redapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class principalMenu extends AppCompatActivity implements View.OnClickListener {

    Spinner spiner;
    Button btnacepto;
    EditText editTextdni;
    int posicion_inicial;
    String nombre_cs;
    Context context=this;
    CheckBox chekterminos;
    String[] datos= new String[]{"Seleccione un elmento", "CENTO DE SALUD A","CENTRO DE SALUD B","CENTRO DE SALUD C","CENTRO DE SALUD D","CENTRO DE SALUD E","CENTRO DE SALUD F","CENTRO DE SALUD G"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//para que se ejecute si o si en forma vertical
        chekterminos=(CheckBox)findViewById(R.id.checkbox);
        editTextdni=(EditText)findViewById(R.id.edittextDni);
        btnacepto=(Button)findViewById(R.id.btnaceptocondiciones);
        btnacepto.setOnClickListener(this);
        spiner=(Spinner)findViewById(R.id.ltscentrosalud);
        ArrayAdapter<String> adaptador= new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,datos);
        spiner.setAdapter(adaptador);
        spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        posicion_inicial=0;
                        break;
                    case 1:
                        Toast.makeText(getBaseContext(),"valor: "+ datos[position],Toast.LENGTH_SHORT).show();
                        nombre_cs=datos[position];
                        posicion_inicial=1;
                        break;
                    case 2:
                        Toast.makeText(getBaseContext(),"valor: "+ datos[position],Toast.LENGTH_SHORT).show();
                        nombre_cs=datos[position];
                        posicion_inicial=1;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        editTextdni.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                switch (editTextdni.length()){
                    case 8:
                        //OCULTO EL TECLADO
                        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(editTextdni.getWindowToken(), 0);
                        //****
                        Toast.makeText(principalMenu.this, "SELECCIONE UN CENTRO DE SALUD", Toast.LENGTH_SHORT).show();
                        //spiner.requestFocus();
                        spiner.setFocusable(true);
                        break;
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });






    }

    @Override
    public void onClick(View v) {
        String centrosalud=spiner.getSelectedItem().toString();
        String dni=editTextdni.getText().toString();
        //StringBuffer result= new StringBuffer();
        //result.append("Algo").append(chekterminos.isChecked());

        if (TextUtils.isEmpty(dni)) {
            Toast.makeText(getBaseContext(),"debe ingresar dni",Toast.LENGTH_SHORT).show();
        }else if(dni.length()< 8){
            Toast.makeText(getBaseContext(),"No es un dni",Toast.LENGTH_SHORT).show();
        }else if(posicion_inicial==0){
            Toast.makeText(getBaseContext(),"Debe seleccionar un Centro de Salud",Toast.LENGTH_SHORT).show();
        }else{
            switch (v.getId()){
                case R.id.btnaceptocondiciones:
                    // Toast.makeText(getBaseContext(),"ACEPT LAS CONDICIONES",Toast.LENGTH_SHORT).show();
                   /* Toast.makeText(getBaseContext(),"para guardar: "+nombre_cs,Toast.LENGTH_SHORT).show();
                    Intent actividadPrincipal= new Intent().setClass(SplashActivity.this,MainActivity.class);
                    startActivity(actividadPrincipal);
                    finish();*/

                    if (chekterminos.isChecked()==false){
                        Toast.makeText(getBaseContext(),"Acepte la licencia",Toast.LENGTH_SHORT).show();

                    }else{
                        Intent actividadPrincipal= new Intent().setClass(principalMenu.this,InicioSistema.class);
                        startActivity(actividadPrincipal);
                        finish();


                    }


                    /*AlertDialog.Builder cuandroDialogo= new AlertDialog.Builder(context);
                    cuandroDialogo.setMessage("Esta seguro que desea continuar?")
                            .setCancelable(false)
                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //lo que quiero que haga
                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //lo que quiero que haga
                                }
                            });
                    AlertDialog alertDialog= cuandroDialogo.create();
                    alertDialog.show();

                    break;*/
            }

        }







    }
    }

