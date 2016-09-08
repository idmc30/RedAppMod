package proyecto.contol.idmc.appred.redapp;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;

import java.sql.Date;
import java.util.Calendar;


public class InicioSistema extends AppCompatActivity  implements View.OnClickListener{


    RadioGroup radioGroup;
    CardView cardViewIndicadoruno, carViewdIndicadordos, carViewSeguimientoPaciente;
    Button btnindicadorNinio,btnIndicadorGestante,btnSegPaciente;
    EditText dia, mes, anio;
    int fechactualdia, fechaactualanio,fechactualmes,edadDia,edadAnio,edadMes;
    String[] edadFecha;
    String pAnio,pMes,pDia;
    double diasVividos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sistema);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//para que se ejecute si o si en forma vertical

        dia= (EditText)findViewById(R.id.txtdia);
        mes=(EditText)findViewById(R.id.txtmes);
        anio=(EditText)findViewById(R.id.textanio);
        dia.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String D=  String.valueOf(dia.length()); // mes.setText(String.valueOf(dia.length()));
                //mes.setText(String.valueOf(dia.length()));
                switch (D){
                    case "2":
                        //Toast.makeText(InicioSistema.this,"asdasdsa",Toast.LENGTH_SHORT).show();
                        mes.requestFocus();
                        break;
                    default:
                        //Toast.makeText(InicioSistema.this,"DEBE INGRESAR UN NÚMERO",Toast.LENGTH_SHORT).show();
                        dia.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        mes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String M = String.valueOf(mes.length()); // mes.setText(String.valueOf(dia.length()));
                switch (M) {
                    case "2":
                        anio.requestFocus();
                        break;
                }
            }
            @Override
            public void afterTextChanged(Editable s) { }
        });



        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        cardViewIndicadoruno = (CardView) findViewById(R.id.tipoindicadoruno);
        carViewdIndicadordos = (CardView) findViewById(R.id.tipoindicadordos);
        carViewSeguimientoPaciente= (CardView) findViewById(R.id.seguimientoPaciente);
        cardViewIndicadoruno.setVisibility(View.GONE);
       // carViewdIndicadordos.setVisibility(View.INVISIBLE);

        btnindicadorNinio=(Button) findViewById(R.id.btnninio);
        btnIndicadorGestante=(Button)findViewById(R.id.btngestante);
        btnSegPaciente=(Button) findViewById(R.id.btnpacientsegui);
        btnindicadorNinio.setOnClickListener(this);
        btnIndicadorGestante.setOnClickListener(this);
        btnSegPaciente.setOnClickListener(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rdbninio) {
                    // textocambiaestado.setVisibility(View.VISIBLE);
                    cardViewIndicadoruno.setVisibility(View.VISIBLE);
                    carViewdIndicadordos.setVisibility(View.GONE);

                } else if (checkedId == R.id.rdbgestante) {
                    cardViewIndicadoruno.setVisibility(View.GONE);
                    carViewdIndicadordos.setVisibility(View.VISIBLE);
                }
            }
        });
    }



    public void calcularEdad(){
        Calendar fechactual = Calendar.getInstance();
        fechactualdia = fechactual.get(Calendar.DAY_OF_MONTH);
        fechactualmes = fechactual.get(Calendar.MONTH) + 1;
        fechaactualanio = fechactual.get(Calendar.YEAR);
        edadAnio=Integer.parseInt(anio.getText().toString());
        edadMes=Integer.parseInt(mes.getText().toString());
        edadDia=Integer.parseInt(dia.getText().toString());


        Fecha ofecha = new Fecha();

         edadFecha= ofecha.getDiffDates(Date.valueOf(Integer.toString(edadAnio)+"-"+Integer.toString(edadMes)+"-"+Integer.toString(edadDia)),Date.valueOf(Integer.toString(fechaactualanio)+"-"+Integer.toString(fechactualmes)+"-"+Integer.toString(fechactualdia))).split(",");

        if(Integer.parseInt(edadFecha[0])==0 && Integer.parseInt(edadFecha[1])==0  ){
            pDia=edadFecha[3];
        }else if(Integer.parseInt(edadFecha[0])==0 && Integer.parseInt(edadFecha[1])>0  ){
            pMes=edadFecha[1];
            pDia=edadFecha[3];
        }else if(Integer.parseInt(edadFecha[0])>0 && Integer.parseInt(edadFecha[1])>0  ){
            if(Integer.parseInt(edadFecha[1])>=12){
                int restarMesesAnios=Integer.parseInt(edadFecha[0])*12;
                pAnio=edadFecha[0];
                pMes=String.valueOf(Integer.parseInt(edadFecha[1])-restarMesesAnios);
                pDia=edadFecha[3];
            }else{
                pAnio=edadFecha[0];
                pMes=String.valueOf(Integer.parseInt(edadFecha[1]));
                pDia=edadFecha[3];
            }
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnninio:
                calcularEdad();
                //Toast.makeText(getApplicationContext(),"AÑOS: "+edadFecha[0]+"--MESES: "+edadFecha[1] +"--DIAS:"+edadFecha[3] , Toast.LENGTH_SHORT).show();
                final Intent pantallacombinacion = new Intent(this, codigosAdicionales.class);//creamos la nueva ventana
                pantallacombinacion.putExtra("edadPacienteAnio", pAnio); //(identificador,datoqueenvio)
                pantallacombinacion.putExtra("edadPacientMeses", pMes);
               pantallacombinacion.putExtra("edadPacientDias", pDia);
                //declaro una variable para convertir de int a string y poderlo comparar
                startActivity(pantallacombinacion);//inicio la pantalla
                break;

            case R.id.btngestante:
                Toast.makeText(getApplicationContext(),"gestante", Toast.LENGTH_SHORT).show();

                break;

            case R.id.btnpacientsegui:

                //Toast.makeText(getApplicationContext(),"seguimiento paciente", Toast.LENGTH_SHORT).show();
                final Intent pantallasegpaciente = new Intent(this, principalPaciente.class);//creamos la nueva ventana
                startActivity(pantallasegpaciente);//inicio la pantalla
                break;


        }
    }

    }



