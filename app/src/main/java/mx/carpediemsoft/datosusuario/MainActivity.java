package mx.carpediemsoft.datosusuario;


import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;


import java.util.Calendar;

public class MainActivity extends   AppCompatActivity {

    private int año;
    private int mes;
    private int dia;
    private EditText idDate;
    private Button idBoton;
    private static final int DIALOGO = 0;
    private static DatePickerDialog.OnDateSetListener oirFecha;
    private Button Siguiente;
    EditText Nombre, FechaNac, NumTel, Email, Datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idDate = (EditText) findViewById(R.id.idDate);
        idBoton = (Button) findViewById(R.id.idBoton);
        Calendar c = Calendar.getInstance();

        Nombre =(EditText)findViewById(R.id.idNombre);
        FechaNac=(EditText)findViewById(R.id.idDate) ;
        NumTel=(EditText)findViewById(R.id.idTel);
        Email=(EditText)findViewById(R.id.idEmail);
        Datos=(EditText)findViewById(R.id.iddescripcion);

        Siguiente = (Button) findViewById(R.id.idBotonSiguiente);
        Siguiente.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                EnviarDatos();
            }
        });

        /*año= c.get(Calendar.YEAR);
        mes= c.get(Calendar.MONTH);
        dia= c.get(Calendar.DAY_OF_MONTH);*/
        //  mostrarFecha();
        oirFecha = new DatePickerDialog.OnDateSetListener() {
           /* idBotonSiguiente=(Button)

            findViewById(R.id.idBotonSiguiente);

            idBotonSiguiente.OnClickListener(new View.OnClickListener()

            {

                @Override
                public void onClick (View v){
                Intent idBotonSiguiente = new Intent(MainActivity.this, DetalleContacto.class)


            }
            }         );*/

            @Override
            public void onDateSet(DatePicker view, int dayOfMonth, int monthOfYear, int year) {
                dia = dayOfMonth;
                mes = monthOfYear;
                año = year;
                mostrarFecha();
            }
        };

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 0:
                return new DatePickerDialog(this, oirFecha, dia, mes, año);

        }
        return null;
    }

    public void mostrarCalendario(View control) {
        showDialog(DIALOGO);


    }
private void EnviarDatos(){
       // String nombre, fechanac;
    //nombre=Nombre.getText().toString();
   // fechanac=FechaNac.getText().toString();

    Intent intent= new Intent (MainActivity.this, DetalleContacto.class);
   Bundle b =new Bundle();
    b.putString("NOMBRE", Nombre.getText().toString());
    b.putString("DATE",FechaNac.getText().toString());
    b.putString("TEL",NumTel.getText().toString());
    b.putString("EMAIL",Email.getText().toString());
    b.putString("DATA",Datos.getText().toString());
    //Siguiente.putExtra("Nombre",nombre);
    //Siguiente.putExtra("FechaNac", fechanac);
    intent.putExtras(b);
    startActivity(intent);
    //startActivity(Siguiente);
}
    public void mostrarFecha() {
        idDate.setText(año + "/" + (mes + 1) + "/" + dia);

    }


}