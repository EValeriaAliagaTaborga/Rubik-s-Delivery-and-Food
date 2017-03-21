package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private ImageView imgLogo;
    private Button btnSignIn;
    private static boolean conCuenta = false;

    public static boolean getConCuenta() {
        return conCuenta;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        imgLogo=(ImageView) findViewById(R.id.imgLogo);
        btnSignIn=(Button)findViewById(R.id.btnSignIn);

        imgLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MenuPrincipalActivity.class);
                startActivity(intent);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
