package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MenuPrincipalActivity extends AppCompatActivity {

    private Context context;

    private LinearLayout lyvMenu;
    private LinearLayout lyvContactenos;
    private LinearLayout lyvCalculadora;
    private LinearLayout lyvVideos;
    private LinearLayout lyvPerfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        context = this;

        lyvMenu = (LinearLayout) findViewById(R.id.lyvMenu);
        lyvContactenos = (LinearLayout) findViewById(R.id.lyvContactenos);
        lyvCalculadora = (LinearLayout) findViewById(R.id.lyvCalculadora);
        lyvVideos = (LinearLayout) findViewById(R.id.lyvVideos);
        lyvPerfil = (LinearLayout) findViewById(R.id.lyvPerfil);

        lyvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MenuActivity.class);
                startActivity(intent);
            }
        });

        lyvContactenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        lyvCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        lyvVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        lyvPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
