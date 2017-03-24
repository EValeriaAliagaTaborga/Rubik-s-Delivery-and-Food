package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText txtUsuario;
    private EditText txtPassword;
    private TextView lblregis;



    String usuario_registrado;
    String password_registrado;

    private Context context;

    //private boolean usuarioRegistrado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context=this;


       // Intent b=getIntent();
       // usuario_registrado = (b.getStringArrayExtra("datos_de_cliente"))[1];
       // password_registrado = (b.getStringArrayExtra("datos_de_cliente"))[6];

        btnLogin=(Button)findViewById(R.id.btnLogin);
        txtUsuario=(EditText)findViewById(R.id.txtUsuario);
        txtPassword=(EditText)findViewById(R.id.txtPassword);
        lblregis=(TextView)findViewById(R.id.lblregis);


        lblregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, RegistroActivity.class);
                startActivity(intent);
            }
        });


       btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                String campo_usuario = txtUsuario.getText().toString();
                String campo_password = txtPassword.getText().toString();


              /*  if ((campo_usuario.compareTo("Rosa") == 0 && campo_password.compareTo("i3915") == 0) || (campo_usuario.compareTo("Vale S") == 0 && campo_password.compareTo("valexd") == 0)
                        || (campo_usuario.compareTo("Vale A") == 0 && campo_password.compareTo("vale05") == 0) || (campo_usuario.compareTo("Diego") == 0 && campo_password.compareTo("diego") == 0)
                        || (usuario_registrado.compareTo(campo_usuario) ==0 && password_registrado.compareTo(campo_password) == 0)) {*/

                /*if ((campo_usuario.compareTo("Rosa") == 0 && campo_password.compareTo("i3915") == 0) || (campo_usuario.compareTo("Vale S") == 0 && campo_password.compareTo("valexd") == 0)
                            || (campo_usuario.compareTo("Vale A") == 0 && campo_password.compareTo("vale05") == 0) || (campo_usuario.compareTo("Diego") == 0 && campo_password.compareTo("diego") == 0)) {

                    MainActivity.setConCuenta(true);

                    SharedPreferences prefs =
                            getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("usuario", campo_usuario);
                    editor.putString("password", campo_password);

                    editor.commit();
                    //Toast.makeText(getApplicationContext(), "Usuario: " + campo_usuario + ", Password: " + campo_password, Toast.LENGTH_SHORT).show();
                    Intent a = new Intent(context, MenuPrincipalActivity.class);
                    startActivity(a);
                    finish();

                } else {
                    txtResultado.setText("Login fallido");
                }*/


                //TODO desde db.

               // if(campo_password.matches("")){

                //} else if (campo_usuario.matches("")){
                //    Toast.makeText(getApplicationContext(), "Por favor, introduzca el nombre de Usuario.", Toast.LENGTH_SHORT.show());
                //}
                //}
            }
        });

    }
    //de nuevo

}

