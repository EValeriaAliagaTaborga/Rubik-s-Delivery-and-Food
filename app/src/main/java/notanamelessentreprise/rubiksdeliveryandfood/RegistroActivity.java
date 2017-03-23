package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtUsuario;
    private EditText txtCelular;
    private EditText txtDomicilio;
    private EditText txtEmail;
    private EditText txtContrasenia;
    private EditText txtRepContrasenia;
    private EditText txtNombreFactura;
    private EditText txtNIT;
    private Button btnRegistrarse;
    private SQLiteDatabase db;
    public static final int VERSION = 1;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        context = this;

        BaseDeDatos crearBD = new BaseDeDatos(context,VERSION);
        db = crearBD.getWritableDatabase();

        txtNombre = (EditText) findViewById(R.id.txtNombreyApellido);
        txtUsuario = (EditText) findViewById(R.id.txtNombreUsuario);
        txtCelular = (EditText) findViewById(R.id.txtCelularTelefono);
        txtContrasenia = (EditText) findViewById(R.id.txtContrasenia);
        txtRepContrasenia = (EditText) findViewById(R.id.txtRepContrasenia);
        txtDomicilio = (EditText) findViewById(R.id.txtDomicilio);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtNombreFactura = (EditText) findViewById(R.id.txtNomFac);
        txtNIT = (EditText) findViewById(R.id.txtNIT);
        btnRegistrarse = (Button) findViewById(R.id.btnRegistrarse);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("nombre",txtNombre.getText().toString());
                values.put("nombreusuario",txtUsuario.getText().toString());
                values.put("celulartelefono fijo",txtCelular.getText().toString());
                values.put("domicilio",txtDomicilio.getText().toString());
                values.put("email",txtEmail.getText().toString());
                values.put("contrasenia",txtContrasenia.getText().toString());
                values.put("repcontrasenia",txtRepContrasenia.getText().toString());
                values.put("nombrefactura",txtNombreFactura.getText().toString());
                values.put("nit",txtNIT.getText().toString());


                db.insert("nombre", null, values);
                db.insert("nombreusuario", null, values);
                db.insert("celulartelefono", null, values);
                db.insert("domicilio", null, values);
                db.insert("email", null, values);
                db.insert("contrasenia", null, values);
                db.insert("repcontrasenia", null, values);
                db.insert("nombrefactura", null, values);
                db.insert("nit", null, values);
                db.close();

                Toast.makeText(getApplicationContext(), "Registro Agregado", Toast.LENGTH_SHORT).show();
                reiniciarActividad();
            }
        });







    }

    private void reiniciarActividad() {
        Intent a=new Intent(getApplicationContext(),MainActivity.class);
        finish();
        startActivity(a);
    }

}
