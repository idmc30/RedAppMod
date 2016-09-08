package proyecto.contol.idmc.appred.redapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    /*private static final long SPLAH_SCREAM_DELAY=3000;
    private long ms=0;
    private long SplahTime=4000;//tiempo de duracion*/

    Spinner spiner;
    Button btnacepto;
    EditText editTextdni;
    int posicion_inicial;
    String nombre_cs;
    Context context=this;

    String[] datos= new String[]{"Seleccione un elmento", "CENTO DE SALUD A","CENTRO DE SALUD B"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//para que se ejecute si o si en forma vertical
       /* TimerTask task= new TimerTask() {
            @Override
            public void run() {
                  Intent actividadPrincipal= new Intent().setClass(SplashActivity.this,MainActivity.class);
                startActivity(actividadPrincipal);
                finish();
            }
        };
        Timer tiempodeejecucion= new Timer();
        tiempodeejecucion.schedule(task,SPLAH_SCREAM_DELAY);*/

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

    }

    @Override
    public void onClick(View v) {
        String centrosalud=spiner.getSelectedItem().toString();
        String dni=editTextdni.getText().toString();;
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

                    AlertDialog.Builder cuandroDialogo= new AlertDialog.Builder(context);
                    cuandroDialogo.setMessage("TERMINOS Y CONDCIONES TERMINOS Y CONDCIONES TERMINOS Y CONDCIONES TERMINOS Y CONDCIONES TERMINOS Y CONDCIONES TERMINOS Y CONDCIONES")
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

                    break;
            }

        }







    }
}
