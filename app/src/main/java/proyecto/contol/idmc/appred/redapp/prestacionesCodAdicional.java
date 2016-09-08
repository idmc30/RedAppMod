package proyecto.contol.idmc.appred.redapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class prestacionesCodAdicional extends AppCompatActivity {
    TextView textorecibeedad,textosmi,textovacuna,textodiagnostico,textomedicamento,textoinsumo,textoprocedimiento;
    String valorCodAdicion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestaciones_cod_adicional);

        Intent intent=getIntent();
        Bundle bundle= intent.getExtras();
        valorCodAdicion= (String) bundle.get("codigoAdicional");
        inicializandoVariables();
      if (Integer.parseInt(valorCodAdicion) == 007 ){
          textosmi.setText("ADMINIST.SUPLEMENTOS");
          textosmi.setTextSize(20);
          textovacuna.setText("NO");
          textovacuna.setTextSize(20);
          textodiagnostico.setText("OTRAS MEDIDAS PROFILACTICAS ESPECIFICAS(Z298) ");
          textodiagnostico.setTextSize(20);
          textomedicamento.setText("SULP. DE MICRONUTRIENTES (S0001)");
          textomedicamento.setTextSize(20);;
          textoinsumo.setText("NO");
          textoinsumo.setTextSize(20);
          textoprocedimiento.setText("NO");
          textoprocedimiento.setTextSize(20);
      }else {
          textosmi.setText("OTRO DATOS");
          textosmi.setTextSize(20);
          textovacuna.setText("NO");
          textovacuna.setTextSize(20);
          textodiagnostico.setText("NO");
          textodiagnostico.setTextSize(20);
          textomedicamento.setText("NO");
          textomedicamento.setTextSize(20);
          textosmi.setTextSize(20);
          textoinsumo.setText("NO");
          textoinsumo.setTextSize(20);
          textoprocedimiento.setText("NO");
          textoprocedimiento.setTextSize(20);
      }

    }
    public void inicializandoVariables(){
        textosmi=(TextView)findViewById(R.id.SMI);
        textovacuna=(TextView)findViewById(R.id.txtvacuna);
        textodiagnostico=(TextView)findViewById(R.id.texDiagnotico);
        textomedicamento=(TextView)findViewById(R.id.txtmedicamento);
        textoinsumo=(TextView)findViewById(R.id.txtinsumos);
        textoprocedimiento=(TextView)findViewById(R.id.txtprocedimiento);

    }

}
