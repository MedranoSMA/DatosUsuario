package mx.carpediemsoft.datosusuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

private Button Anterior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);



        Anterior = (Button)findViewById(R.id.idBotonEditar);
        Anterior.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

        onBackPressed();
            }
        });

       TextView Nombre=(TextView)findViewById(R.id.tvNombre);
       TextView FechaNac=(TextView)findViewById(R.id.tvFecha);
        TextView NumTel=(TextView)findViewById(R.id.tvTel);
        TextView Email=(TextView)findViewById(R.id.tvEmail);
        TextView Datos=(TextView)findViewById(R.id.tvDato);


       Bundle bundle =this.getIntent().getExtras();
        Nombre.setText(bundle.getString("NOMBRE"));
        FechaNac.setText("Fecha Nacimiento: " + bundle.getString("DATE"));
        NumTel.setText("Teléfono: "+ bundle.getString("TEL"));
        Email.setText("E-Mail: " + bundle.getString("EMAIL"));
        Datos.setText("Descripción: "+ bundle.getString("DATA"));


    }

    @Override
    public void onBackPressed(){
    super.onBackPressed();
}

}
