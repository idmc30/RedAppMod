package proyecto.contol.idmc.appred.redapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class codigosAdicionales extends AppCompatActivity implements View.OnClickListener  {
    TextView textorecibeedad,textosmi,textodiagnostico,textovacuna,textomedicamento,textoinsumo,textoprocedimiento,textobservaciones,textoDescripcion,textoTopes,textoOtrosDiagnosticos;
    int tamanio=21;
    String edadanio,edadmes,edaddia;
    CardView cardViewSMI,cardViewVacuna,cardViewDiagnostico,cardViewMedicamento,cardViewInsumo,cardViewProcedimiento,cardViewObservacion,cardViewTopes,cardViewOtroDiagnosticos;
    Button btncodPrincipal, btnCodAdicionalSupl, btnCodAdicionalPasaritos,btnCodAdicionalEstimula,btnCodAdicionalAgudezaVisual,btnCodAdicionalSaludMental;
    //ListView listview;
    //String [] codadicionales;

    public void inicializandoElementos(){

        btncodPrincipal=(Button)findViewById(R.id.btnprincipal);
        btncodPrincipal.setOnClickListener(this);
        btnCodAdicionalSupl=(Button)findViewById(R.id.btnsuplemento);
        btnCodAdicionalSupl.setOnClickListener(this);
        btnCodAdicionalPasaritos=(Button)findViewById(R.id.btnprofilaxis);
        btnCodAdicionalPasaritos.setOnClickListener(this);
        btnCodAdicionalEstimula=(Button)findViewById(R.id.btnestimulacion);
        btnCodAdicionalEstimula.setOnClickListener(this);
        btnCodAdicionalAgudezaVisual=(Button)findViewById(R.id.btnagudezavisaul);
        btnCodAdicionalAgudezaVisual.setOnClickListener(this);
        btnCodAdicionalSaludMental=(Button)findViewById(R.id.btnsaludmental);
        btnCodAdicionalSaludMental.setOnClickListener(this);


        cardViewSMI=(CardView) findViewById(R.id.carvSMI);
        cardViewVacuna = (CardView) findViewById(R.id.carvVacuna);
        cardViewDiagnostico=(CardView) findViewById(R.id.carvDiagnostico);
        cardViewMedicamento= (CardView) findViewById(R.id.carvMedicamento);
        cardViewInsumo= (CardView) findViewById(R.id.carvInsumo);
        cardViewProcedimiento= (CardView) findViewById(R.id.carvProcedimiento);
        cardViewObservacion=(CardView) findViewById(R.id.carvObservacion);
        cardViewTopes=(CardView) findViewById(R.id.carvTopes);
        cardViewOtroDiagnosticos=(CardView) findViewById(R.id.carvOtrosDiagnosticos);

        textosmi=(TextView)findViewById(R.id.txtSmi);
        textovacuna=(TextView)findViewById(R.id.txtVacuna);
        textodiagnostico = (TextView) findViewById(R.id.texDiagnotico);
        textomedicamento=(TextView)findViewById(R.id.txtMedicamento);
        textoinsumo=(TextView)findViewById(R.id.txtInsumos);
        textoprocedimiento=(TextView)findViewById(R.id.txtProcedimiento);
        textobservaciones=(TextView) findViewById(R.id.txtObservaciones);
        textoDescripcion=(TextView) findViewById(R.id.txtdescripcion);
        textoTopes=(TextView) findViewById(R.id.txtTopes);
        textoOtrosDiagnosticos=(TextView) findViewById(R.id.txtOtrosDiagnosticos);


        textorecibeedad=(TextView)findViewById(R.id.txteresultadoedad);
        //asigno los texview el id
    }

    private void menorsesisdias(){
        btncodPrincipal.setText("001");
        textoDescripcion.setText("Control de crecimiento y desarrollo en menores de 0 - 4 años ");
        textosmi.setText("- Peso, Lactancia Materna Exclusiva,\n- Talla , N° CRED , \n- Rn Prematuro, Bajo peso al nacer, \n- Enfermedad congenista/secuela al nacer,\n- TAP/EEDP o TEPSI, \n- Consejeria Nutricional, Tamizaje salud mental\n");
        textovacuna.setText("- BCG (102) si es que niño no fue inmunizado\n");
        textodiagnostico.setText("- Z00.1:Control de salud de rutina del niño \n(niño normal)");
        textoinsumo.setText("- 29754 jeringa y aguja 27x1 1/2\n");
        textoprocedimiento.setText("- 99403: consejeria nutricional,\n- 90471: inmunizaciones,\n- 99207: tamizaje salud mental\n");
        textobservaciones.setText("- Lactancia materna exclusiva\n");

        cardViewSMI.setVisibility(View.VISIBLE);
        cardViewVacuna.setVisibility(View.VISIBLE);
        cardViewInsumo.setVisibility(View.VISIBLE);
        cardViewProcedimiento.setVisibility(View.VISIBLE);
        cardViewObservacion.setVisibility(View.VISIBLE);

        cardViewMedicamento.setVisibility(View.GONE);
        cardViewTopes.setVisibility(View.GONE);
        cardViewOtroDiagnosticos.setVisibility(View.GONE);
        btnCodAdicionalEstimula.setVisibility(View.GONE);
        btnCodAdicionalSupl.setVisibility(View.GONE);
        btnCodAdicionalAgudezaVisual.setVisibility(View.GONE);
        btnCodAdicionalPasaritos.setVisibility(View.GONE);

    }

    private void sincodigosadicionales(){
        btncodPrincipal.setText("001");
        textoDescripcion.setText("Control de crecimiento y desarrollo en menores de 0 - 4 años ");
        textosmi.setText("- Peso, Lactancia Materna Exclusiva,\n- Talla , N° CRED , \n- Rn Prematuro, Bajo peso al nacer, \n- Enfermedad congenista/secuela al nacer,\n- TAP/EEDP o TEPSI, \n- Consejeria Nutricional, Tamizaje salud mental\n");
        textodiagnostico.setText("- Z00.1:Control de salud de rutina del niño \n(niño normal)");
        textoprocedimiento.setText("- 99403: consejeria nutricional,\n- 99207: tamizaje salud mental");
        textobservaciones.setText("- Lactancia materna exclusiva\n");

        cardViewVacuna.setVisibility(View.GONE);
        cardViewInsumo.setVisibility(View.GONE);
        cardViewMedicamento.setVisibility(View.GONE);
        cardViewTopes.setVisibility(View.GONE);
        cardViewOtroDiagnosticos.setVisibility(View.GONE);

        btnCodAdicionalEstimula.setVisibility(View.GONE);
        btnCodAdicionalSupl.setVisibility(View.GONE);
        btnCodAdicionalAgudezaVisual.setVisibility(View.GONE);
        btnCodAdicionalPasaritos.setVisibility(View.GONE);
        btnCodAdicionalSaludMental.setVisibility(View.GONE);
        btncodPrincipal.setVisibility(View.GONE);
    }

    private void mayorquinceciasmenorveinte(){

        btncodPrincipal.setText("001");
        textoDescripcion.setText("Control de crecimiento y desarrollo en menores de 0 - 4 años ");
        textosmi.setText("- Peso, Lactancia Materna Exclusiva,\n- Talla , N° CRED , \n- Rn Prematuro, Bajo peso al nacer, \n- Enfermedad congenista/secuela al nacer,\n- TAP/EEDP o TEPSI, \n- Consejeria Nutricional, Tamizaje salud mental\n");
        textodiagnostico.setText("- Z00.1:Control de salud de rutina del niño \n(niño normal)");
        textoprocedimiento.setText("- 99403: consejeria nutricional,\n- 99207: tamizaje salud mental");
        textobservaciones.setText("- Lactancia materna exclusiva\n");

        cardViewSMI.setVisibility(View.VISIBLE);
        cardViewObservacion.setVisibility(View.VISIBLE);

        cardViewVacuna.setVisibility(View.GONE);
        cardViewInsumo.setVisibility(View.GONE);
        cardViewMedicamento.setVisibility(View.GONE);
        cardViewTopes.setVisibility(View.GONE);
        cardViewOtroDiagnosticos.setVisibility(View.GONE);

        btnCodAdicionalSupl.setVisibility(View.GONE);
        btnCodAdicionalAgudezaVisual.setVisibility(View.GONE);
        btnCodAdicionalPasaritos.setVisibility(View.GONE);
        btnCodAdicionalSaludMental.setVisibility(View.GONE);
    }


    private void adicionalsupleestimulacion(){
        btncodPrincipal.setText("001");
        textoDescripcion.setText("Control de crecimiento y desarrollo en menores de 0 - 4 años ");
        textosmi.setText("- Peso, Lactancia Materna Exclusiva,\n- Talla , N° CRED , \n- Rn Prematuro, Bajo peso al nacer, \n- Enfermedad congenista/secuela al nacer,\n- TAP/EEDP o TEPSI, \n- Consejeria Nutricional, Tamizaje salud mental\n");
        textovacuna.setText("- Vacuna contra rotavirus (127),\n- vacuna IPV (316),\n- vacuna pentavalente (124),\n- vacuna contra neumococo (126)\n");
        textodiagnostico.setText("- Z00.1:Control de salud de rutina del niño \n(niño normal)");
        textoinsumo.setText("- 29752: jeringa 25g x 1 autoretractil\n");
        textoprocedimiento.setText("- 99403: consejeria nutricional,\n- 90471: inmunizaciones,\n- 99207: tamizaje salud mental\n");
        textobservaciones.setText("- Lactancia materna exclusiva\n");

        cardViewSMI.setVisibility(View.VISIBLE);
        cardViewVacuna.setVisibility(View.VISIBLE);
        cardViewInsumo.setVisibility(View.VISIBLE);
        cardViewProcedimiento.setVisibility(View.VISIBLE);
        cardViewObservacion.setVisibility(View.VISIBLE);

        cardViewMedicamento.setVisibility(View.GONE);
        cardViewTopes.setVisibility(View.GONE);
        cardViewOtroDiagnosticos.setVisibility(View.GONE);
        btnCodAdicionalEstimula.setVisibility(View.GONE);
        btnCodAdicionalSupl.setVisibility(View.GONE);
        btnCodAdicionalAgudezaVisual.setVisibility(View.GONE);
        btnCodAdicionalPasaritos.setVisibility(View.GONE);

    }


    private void adicionalsumplemento(){

        btncodPrincipal.setText("001");
        textoDescripcion.setText("Control de crecimiento y desarrollo en menores de 0 - 4 años ");
        textosmi.setText("- Peso, Lactancia Materna Exclusiva,\n- Talla , N° CRED , \n- Rn Prematuro, Bajo peso al nacer, \n- Enfermedad congenista/secuela al nacer,\n- TAP/EEDP o TEPSI, \n- Consejeria Nutricional, Tamizaje salud mental\n");
        textodiagnostico.setText("- Z00.1:Control de salud de rutina del niño \n(niño normal)");
        textoprocedimiento.setText("- 99403: consejeria nutricional,\n- 90471: inmunizaciones,\n- 99207: tamizaje salud mental\n");
        textobservaciones.setText("- Lactancia materna exclusiva\n");

        cardViewSMI.setVisibility(View.VISIBLE);

        cardViewProcedimiento.setVisibility(View.VISIBLE);
        cardViewObservacion.setVisibility(View.VISIBLE);

        cardViewMedicamento.setVisibility(View.GONE);
        cardViewTopes.setVisibility(View.GONE);
        cardViewOtroDiagnosticos.setVisibility(View.GONE);
        cardViewVacuna.setVisibility(View.GONE);
        cardViewInsumo.setVisibility(View.GONE);

        btnCodAdicionalEstimula.setVisibility(View.GONE);
        btnCodAdicionalAgudezaVisual.setVisibility(View.GONE);
        btnCodAdicionalPasaritos.setVisibility(View.GONE);
        btnCodAdicionalSaludMental.setVisibility(View.GONE);

    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigos_adicionales);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//para que se ejecute si o si en forma vertical

        inicializandoElementos();

        //creo variables para recoger los datos enviados
        Intent intent=getIntent();
        Bundle bundle= intent.getExtras();
        edadanio= (String) bundle.get("edadPacienteAnio");
        edadmes= (String) bundle.get("edadPacientMeses");
        edaddia= (String) bundle.get("edadPacientDias");

        try {
            if(Integer.parseInt(edadanio)==0 && Integer.parseInt(edadmes)==0  ){
                //System.out.print("Tienen "+edaddia+"dias de nacido");
                textorecibeedad.setText("Edad: "+edaddia+" dias" );
                textorecibeedad.setTextSize(tamanio);

                if (Integer.parseInt(edaddia)<=6){
                    menorsesisdias();
                }else if(Integer.parseInt(edaddia)>=7 &&Integer.parseInt(edaddia)<=14 ){
                    sincodigosadicionales();
                    Toast.makeText(codigosAdicionales.this, "NO SE APLICAN CÓDIGOS ADICIONALES", Toast.LENGTH_SHORT).show();
                    Toast.makeText(codigosAdicionales.this, "Codigo Principal 001", Toast.LENGTH_LONG).show();

                }else if(Integer.parseInt(edaddia)>=15 && Integer.parseInt(edaddia)<=20) {

                    mayorquinceciasmenorveinte();

                }else if(Integer.parseInt(edaddia)>=21 && Integer.parseInt(edaddia)<=29 ){

                    sincodigosadicionales();
                    Toast.makeText(codigosAdicionales.this, "NO SE APLICAN CÓDIGOS ADICIONALES", Toast.LENGTH_SHORT).show();
                    Toast.makeText(codigosAdicionales.this, "Codigo Principal 001", Toast.LENGTH_LONG).show();
                }



            }else if(Integer.parseInt(edadanio)==0 && Integer.parseInt(edadmes)>0  ){
                //System.out.print("Tienen "+edadmes+" mes y " +(Integer.parseInt(edaddia))+" dias de nacido" );
                textorecibeedad.setText("Edad: "+edadmes+" meses y " +(Integer.parseInt(edaddia))+" dias" );
                textorecibeedad.setTextSize(tamanio);

                switch (Integer.parseInt(edadmes)){
                    case 1:

                        mayorquinceciasmenorveinte();
                        break;
                    case 2:
                        btncodPrincipal.setText("001");
                        textoDescripcion.setText("Control de crecimiento y desarrollo en menores de 0 - 4 años ");
                        textosmi.setText("- Peso, Lactancia Materna Exclusiva,\n- Talla , N° CRED , \n- Rn Prematuro, Bajo peso al nacer, \n- Enfermedad congenista/secuela al nacer,\n- TAP/EEDP o TEPSI, \n- Consejeria Nutricional, Tamizaje salud mental\n");
                        textovacuna.setText("- BCG (102) si es que niño no fue inmunizado\n");
                        textodiagnostico.setText("- Z00.1:Control de salud de rutina del niño \n(niño normal)");
                        textoinsumo.setText("- 29754 jeringa y aguja 27x1 1/2\n");
                        textoprocedimiento.setText("- 99403: consejeria nutricional,\n- 90471: inmunizaciones,\n- 99207: tamizaje salud mental\n");
                        textobservaciones.setText("- Lactancia materna exclusiva\n");

                        cardViewSMI.setVisibility(View.VISIBLE);
                        cardViewVacuna.setVisibility(View.VISIBLE);
                        cardViewInsumo.setVisibility(View.VISIBLE);
                        cardViewProcedimiento.setVisibility(View.VISIBLE);
                        cardViewObservacion.setVisibility(View.VISIBLE);

                        cardViewMedicamento.setVisibility(View.GONE);
                        cardViewTopes.setVisibility(View.GONE);
                        cardViewOtroDiagnosticos.setVisibility(View.GONE);

                        btnCodAdicionalSupl.setVisibility(View.GONE);
                        btnCodAdicionalAgudezaVisual.setVisibility(View.GONE);
                        btnCodAdicionalPasaritos.setVisibility(View.GONE);
                        btnCodAdicionalSaludMental.setVisibility(View.GONE);

                        break;
                    case 3:
                        sincodigosadicionales();
                        break;
                    case 4:
                        adicionalsupleestimulacion();
                        break;

                    case 5:
                        adicionalsumplemento();
                        break;
                    case 6:

                        btncodPrincipal.setText("001");
                        textoDescripcion.setText("Control de crecimiento y desarrollo en menores de 0 - 4 años ");
                        textosmi.setText("- Peso, Lactancia Materna Exclusiva,\n- Talla , N° CRED , \n- Rn Prematuro, Bajo peso al nacer, \n- Enfermedad congenista/secuela al nacer,\n- TAP/EEDP o TEPSI, \n- Consejeria Nutricional, Tamizaje salud mental\n");
                        textovacuna.setText("- Vacuna antipolio (313),-\n vacuna pentavalente (124)\n");
                        textodiagnostico.setText("- Z00.1:Control de salud de rutina del niño \n(niño normal)");
                        textoinsumo.setText("- 29752: jeringa 25g x 1 autoretractil\n");
                        textoprocedimiento.setText("- 99403: consejeria nutricional,-\n 90471: inmunizaciones,-\n 99207: tamizaje salud mental,\n- 85018: dosaje de hemgolobina en caso de no contar con este servicio referir \n");
                        textobservaciones.setText("- Lactancia materna exclusiva\n");

                        cardViewProcedimiento.setVisibility(View.VISIBLE);
                        cardViewObservacion.setVisibility(View.VISIBLE);

                        cardViewMedicamento.setVisibility(View.GONE);
                        cardViewTopes.setVisibility(View.GONE);
                        cardViewOtroDiagnosticos.setVisibility(View.GONE);
                        cardViewVacuna.setVisibility(View.GONE);
                        cardViewInsumo.setVisibility(View.GONE);

                        btnCodAdicionalEstimula.setVisibility(View.GONE);
                        btnCodAdicionalAgudezaVisual.setVisibility(View.GONE);
                        btnCodAdicionalPasaritos.setVisibility(View.GONE);
                        btnCodAdicionalSaludMental.setVisibility(View.GONE);

                        break;
                    case 7:
                        btncodPrincipal.setText("001");
                        textoDescripcion.setText("Control de crecimiento y desarrollo en menores de 0 - 4 años ");
                        textosmi.setText("- Peso, Lactancia Materna Exclusiva,\n- Talla , N° CRED , \n- Rn Prematuro, Bajo peso al nacer, \n- Enfermedad congenista/secuela al nacer,\n- TAP/EEDP o TEPSI, \n- Consejeria Nutricional, Tamizaje salud mental\n");
                        textovacuna.setText("- Vacuna contra la influenza (405)\n");
                        textodiagnostico.setText("- Z00.1:Control de salud de rutina del niño \n(niño normal)");
                        textoinsumo.setText("- 29752: jeringa 25g x 1 autoretractil\n");
                        textoprocedimiento.setText("- 99403: consejeria nutricional,\n- 90471: inmunizaciones,\n- 99207: tamizaje salud mental\n");
                        textobservaciones.setText("- Lactancia materna exclusiva\n");

                        cardViewSMI.setVisibility(View.VISIBLE);
                        cardViewVacuna.setVisibility(View.VISIBLE);
                        cardViewInsumo.setVisibility(View.VISIBLE);
                        cardViewProcedimiento.setVisibility(View.VISIBLE);
                        cardViewObservacion.setVisibility(View.VISIBLE);

                        cardViewMedicamento.setVisibility(View.GONE);
                        cardViewTopes.setVisibility(View.GONE);
                        cardViewOtroDiagnosticos.setVisibility(View.GONE);
                        btnCodAdicionalEstimula.setVisibility(View.GONE);
                        btnCodAdicionalSupl.setVisibility(View.GONE);
                        btnCodAdicionalAgudezaVisual.setVisibility(View.GONE);
                        btnCodAdicionalPasaritos.setVisibility(View.GONE);

                        break;
                    case 8:
                        btncodPrincipal.setText("001");
                        textoDescripcion.setText("Control de crecimiento y desarrollo en menores de 0 - 4 años ");
                        textosmi.setText("- Peso, Lactancia Materna Exclusiva,\n- Talla , N° CRED , \n- Rn Prematuro, Bajo peso al nacer, \n- Enfermedad congenista/secuela al nacer,\n- TAP/EEDP o TEPSI, \n- Consejeria Nutricional, Tamizaje salud mental\n");
                        textovacuna.setText("- Vacuna contra la influenza (405)\n");
                        textodiagnostico.setText("- Z00.1:Control de salud de rutina del niño \n(niño normal)");
                        textoinsumo.setText("- 29752: jeringa 25g x 1 autoretractil\n");
                        textoprocedimiento.setText("- 99403: consejeria nutricional,\n- 90471: inmunizaciones,\n- 99207: tamizaje salud mental\n");
                        textobservaciones.setText("- Lactancia materna exclusiva\n");

                        cardViewSMI.setVisibility(View.VISIBLE);
                        cardViewVacuna.setVisibility(View.VISIBLE);
                        cardViewInsumo.setVisibility(View.VISIBLE);
                        cardViewProcedimiento.setVisibility(View.VISIBLE);
                        cardViewObservacion.setVisibility(View.VISIBLE);

                        cardViewMedicamento.setVisibility(View.GONE);
                        cardViewTopes.setVisibility(View.GONE);
                        cardViewOtroDiagnosticos.setVisibility(View.GONE);

                        btnCodAdicionalEstimula.setVisibility(View.GONE);
                        btnCodAdicionalAgudezaVisual.setVisibility(View.GONE);
                        btnCodAdicionalPasaritos.setVisibility(View.GONE);
                        btnCodAdicionalSaludMental.setVisibility(View.GONE);
                        break;
                    case 9:
                        textosmi.setText("PESO -   TALLA - CRED  - R.N.PREMATURO - BAJO PESO AL NACER - ENFER. CONGENITA/ SECUELA AL NACER - TAP/EEDP O TEPSI - CONSEJERIA NUTRICIONAL - TAMIZAJE SALUD MENTAL)");
                        textodiagnostico.setText("CONTROL DE SALUD DE RUTINA DEL NIÑO  (Z001) - CONSULTA PARA LA ATENCION DE OTROS NIÑOS O DE LACTANTES SANOS (Z762)-OTRAS MEDIDAS PROFILACTICAS ESPECIFICAS (Z298)");
                        textomedicamento.setText("SUPLEMENTOS DE MICRONUTRIENTES - SULFATO FERROSO GOTAS");
                        textoprocedimiento.setText("CONSEJERIA NUTRICIONAL  - TAMIZAJE SALUD MENTAL");
                        cardViewObservacion.setVisibility(View.GONE);
                        cardViewVacuna.setVisibility(View.GONE);
                        cardViewInsumo.setVisibility(View.GONE);
                        //codadicionales= new String[]{"016","007"};
                        break;
                    case 10:
                        textosmi.setText("PESO -   TALLA - CRED  - R.N.PREMATURO - BAJO PESO AL NACER - ENFER. CONGENITA/ SECUELA AL NACER - TAP/EEDP O TEPSI - CONSEJERIA NUTRICIONAL - TAMIZAJE SALUD MENTAL)");
                        textodiagnostico.setText("CONTROL DE SALUD DE RUTINA DEL NIÑO  (Z001) - OTRAS MEDIDAS PROFILACTICAS ESPECIFICAS (Z298)");
                        textomedicamento.setText("SUPLEMENTOS DE MICRONUTRIENTES - SULFATO FERROSO GOTAS");
                        textoprocedimiento.setText("CONSEJERIA NUTRICIONAL  - TAMIZAJE SALUD MENTAL");
                        cardViewObservacion.setVisibility(View.GONE);
                        cardViewVacuna.setVisibility(View.GONE);
                        cardViewInsumo.setVisibility(View.GONE);
                        //codadicionales= new String[]{"007"};

                        break;
                    case 11:
                        textosmi.setText("PESO -   TALLA - CRED  - R.N.PREMATURO - BAJO PESO AL NACER - ENFER. CONGENITA/ SECUELA AL NACER - TAP/EEDP O TEPSI - CONSEJERIA NUTRICIONAL - TAMIZAJE SALUD MENTAL)");
                        textodiagnostico.setText("CONTROL DE SALUD DE RUTINA DEL NIÑO  (Z001) - CONSULTA PARA LA ATENCION DE OTROS NIÑOS O DE LACTANTES SANOS (Z762)-OTRAS MEDIDAS PROFILACTICAS ESPECIFICAS (Z298)");
                        textomedicamento.setText("SUPLEMENTOS DE MICRONUTRIENTES - SULFATO FERROSO GOTAS");
                        textoprocedimiento.setText("CONSEJERIA NUTRICIONAL  - TAMIZAJE SALUD MENTAL");
                        cardViewObservacion.setVisibility(View.GONE);
                        cardViewVacuna.setVisibility(View.GONE);
                        cardViewInsumo.setVisibility(View.GONE);
                        //codadicionales= new String[]{"007"};
                        break;

                }


            }else if(Integer.parseInt(edadanio)>0 && Integer.parseInt(edadmes)>0  ){
                //System.out.print("Tienen "+edadanio+" año - " +edadmes+" mes y "+edaddia+" dias de nacido" );
                textorecibeedad.setText("Edad: "+edadanio+" años - " +edadmes+" meses y "+edaddia+" dias" );
                textorecibeedad.setTextSize(tamanio);
            }

        }catch (Exception xp){
            Toast.makeText(getApplicationContext(),"Error" ,Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onClick(View v) {
             switch (v.getId()){
                 case R.id.btnprincipal:
                     menorsesisdias();
                     if(Integer.parseInt(edaddia)>=15 && Integer.parseInt(edaddia)<=20) {
                       mayorquinceciasmenorveinte();
                     }else if(Integer.parseInt(edaddia)<=6){

                         menorsesisdias();
                     }else if(Integer.parseInt(edaddia)>=20 && Integer.parseInt(edaddia)<=29){

                         sincodigosadicionales();
                     }

                     break;

                 case R.id.btnprofilaxis:
                     Toast.makeText(codigosAdicionales.this, "Profilaxis", Toast.LENGTH_SHORT).show();
                     break;

                 case R.id.btnsuplemento:

                     textoDescripcion.setText("Suplemento de multimicronutrientes\n");
                     textosmi.setText("Administracion suplemento nutricional\n");
                     textodiagnostico.setText("- Z29.8: Otras medidas profilacticas\n");
                     textoTopes.setText("01 - 01 - 12\n");
                     cardViewTopes.setVisibility(View.VISIBLE);
                     cardViewMedicamento.setVisibility(View.VISIBLE);
                     if(Integer.parseInt(edaddia)==7){
                         textomedicamento.setText("03536: Sulfato ferroso 25 mg/ml x 30 ml\n");
                     }if(Integer.parseInt(edaddia)>=8 || Integer.parseInt(edaddia)<=11 ){
                          textomedicamento.setText("S0001: Suplemento de micronutrientes (cantidad 30 sobres)\n");

                      }

                         textomedicamento.setText("03536: Sulfato ferroso 25 mg/ml x 30 ml\n");




                     break;

                 case R.id.btnestimulacion:

                     textoDescripcion.setText("Estimulacion Temparna\n");
                     textodiagnostico.setText("- Z76.2: Consulta para atencion de niños y lactantes sanos\n");
                     textoprocedimiento.setText("99411: Estimulacion temprana solo utiliza este procedimiento el nivel II (hospital)\n");

                     cardViewTopes.setVisibility(View.GONE);
                     cardViewSMI.setVisibility(View.GONE);
                     cardViewVacuna.setVisibility(View.GONE);
                     cardViewInsumo.setVisibility(View.GONE);
                     cardViewMedicamento.setVisibility(View.GONE);
                     cardViewObservacion.setVisibility(View.GONE);
                     cardViewOtroDiagnosticos.setVisibility(View.GONE);

                     break;

                 case R.id.btnagudezavisaul:
                     Toast.makeText(codigosAdicionales.this, "Agudeza Visual", Toast.LENGTH_SHORT).show();
                     break;

                 case R.id.btnsaludmental:

                     textoDescripcion.setText("Deteccion de problemas en salud mental\n");
                     textodiagnostico.setText("- Z13.3: Examen de pesquisa especial para transtornos mentales y de comportamiento, para pacientes normales si son pacientes patologicos se deberá consignar el diagnostico \n- Z13.3 seguido del dignostico motivo de la patologia (F99.X,F32.9, F41.9, Z72.1, T74.8, R45.6 o todos los diagnosticos del CIE X que empiezen con F)\n");
                     textoprocedimiento.setText("- 99403: consejeria nutricional,\n- 90471: inmunizaciones,\n- 99207: tamizaje salud mental\n");
                     textoTopes.setText(" 01 - 02 - 04\n");
                     cardViewTopes.setVisibility(View.VISIBLE);

                     cardViewSMI.setVisibility(View.GONE);
                     cardViewVacuna.setVisibility(View.GONE);
                     cardViewInsumo.setVisibility(View.GONE);
                     cardViewProcedimiento.setVisibility(View.GONE);
                     cardViewMedicamento.setVisibility(View.GONE);
                     cardViewObservacion.setVisibility(View.GONE);
                     cardViewOtroDiagnosticos.setVisibility(View.GONE);

                     break;


             }
    }
}
