package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MenuActivity extends AppCompatActivity {

    private LinearLayout lyhHamburguesa;
    private LinearLayout lyhPizza;
    private LinearLayout lyhHotDog;
    private LinearLayout lyhPollo;
    private LinearLayout lyhExtras;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        context = this;

        lyhHamburguesa=(LinearLayout) findViewById(R.id.lyhHamburguesa);
        lyhPizza=(LinearLayout) findViewById(R.id.lyhPizza);
        lyhHotDog=(LinearLayout) findViewById(R.id.lyhHotDog);
        lyhPollo=(LinearLayout) findViewById(R.id.lyhPollo);
        lyhExtras=(LinearLayout) findViewById(R.id.lyhExtras);

        lyhHamburguesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MenuHamburguesaActivity.class);
                startActivity(intent);
            }
        });

        lyhPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MenuPizzaActivity.class);
                startActivity(intent);
            }
        });

        lyhHotDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MenuHotDogActivity.class);
                startActivity(intent);
            }
        });

        lyhPollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MenuPolloActivity.class);
                startActivity(intent);
            }
        });

        lyhExtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MenuExtrasActivity.class);
                startActivity(intent);
            }
        });
    }
}
