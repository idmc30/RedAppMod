package proyecto.contol.idmc.appred.redapp;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    // DatePicker fechnacimiento;
    EditText prestacion ;
    TextView fechnacimiento;
    Button btn;
    int anio, mes, dia;
    static final int DIALOG_ID = 0;
    //private static DatePickerDialog.OnDateSetListener oyenteSelectorFecha;
    public int codigoprestacion, aniodenacimiento, edadpaciente;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //Capturo la fecha actual del Sistema
        Calendar fechactual = Calendar.getInstance();
        anio = fechactual.get(Calendar.YEAR);
        mes = fechactual.get(Calendar.MONTH) + 1;
        dia = fechactual.get(Calendar.DAY_OF_MONTH);

        btn = (Button) findViewById(R.id.btnvalidar);//primero obtengo el id del boton
        prestacion = (EditText) findViewById(R.id.codprestacionaltxt);
        fechnacimiento = (TextView) findViewById(R.id.fechnacimientotxt);

        btn.setOnClickListener(this);//luego le doy la propiedad setoncliclisten si implemento el onclick
        fechnacimiento.setOnClickListener(this);




        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void calcularFecha() {
        //Toast.makeText(getApplicationContext(),"asdasdsad",Toast.LENGTH_SHORT).show();
        //fechnacimiento.setText(anio+"/"+mes+"/"+dia);
        codigoprestacion = Integer.parseInt(prestacion.getText().toString());
        String fechanacimiento = fechnacimiento.getText().toString();
        String[] separador = fechanacimiento.split("/");
        aniodenacimiento = Integer.parseInt(separador[2]);
        edadpaciente = anio - aniodenacimiento;

    }

    @Override
    public void onClick(View v) {
       // String campo1=Integer.toString(codigoprestacion);
        String camp1=prestacion.getText().toString();
        String camp2=fechnacimiento.getText().toString();

        //CODIGO DE RENZO
        Log.i("irwin campo 1", camp1);

        if (TextUtils.isEmpty(camp1)) {
            Toast.makeText(this,"UNO DE SUS CAMPOS ESTA VACIO",Toast.LENGTH_SHORT).show();
            //nuevocomentario
        }else{
            switch (v.getId()) {

                case R.id.btnvalidar:
                    calcularFecha();
                    //vamos a enviar la edad calculada a la siguiente pantalla
                    final Intent pantallacombinacion = new Intent(this, codigosAdicionales.class);//creamos la nueva ventana
                    //Toast.makeText(getApplicationContext(), "el valor de la fecha es:" + codigoprestacion, Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Ok:", Toast.LENGTH_SHORT).show();
                    pantallacombinacion.putExtra("edadPaciente", edadpaciente); //(identificador,datoqueenvio)
                    pantallacombinacion.putExtra("codPrestacion", codigoprestacion);
                    //declaro una variable para convertir de int a string y poderlo comparar
                    startActivity(pantallacombinacion);//inicio la pantalla
                    break;

                case R.id.fechnacimientotxt:

                    Calendar now = Calendar.getInstance();
                    DatePickerDialog dpd = DatePickerDialog.newInstance(MainActivity.this, now.get(Calendar.YEAR), now.get(Calendar.MONTH),now.get(Calendar.DAY_OF_MONTH));
                    dpd.show(getFragmentManager(), "Datepickerdialog");
                 break;
            }
        }

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://proyecto.contol.idmc.appred.redapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://proyecto.contol.idmc.appred.redapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        fechnacimiento.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
    }
}
