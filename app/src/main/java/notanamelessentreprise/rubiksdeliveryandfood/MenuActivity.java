package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

public class MenuActivity extends AppCompatActivity {

    private LinearLayout lyhHamburguesa;
    private LinearLayout lyhPizza;
    private LinearLayout lyhHotDog;
    private LinearLayout lyhPollo;
    private LinearLayout lyhExtras;
    private ImageView imgHamburguesa;
    private ImageView imgPizza;
    private ImageView imgHotDog;
    private ImageView imgPollo;
    private ImageView imgExtras;

    private Context context;

    //hola c:
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        context = this;

        lyhHamburguesa =(LinearLayout) findViewById(R.id.lyhHamburguesa);
        lyhPizza =(LinearLayout) findViewById(R.id.lyhPizza);
        lyhHotDog =(LinearLayout) findViewById(R.id.lyhHotDog);
        lyhPollo =(LinearLayout) findViewById(R.id.lyhPollo);
        lyhExtras =(LinearLayout) findViewById(R.id.lyhExtras);
        imgHamburguesa = (ImageView) findViewById(R.id.imgHamburguesa);
        imgPizza = (ImageView) findViewById(R.id.imgPizza);
        imgHotDog = (ImageView) findViewById(R.id.imgHotDog);
        imgPollo = (ImageView) findViewById(R.id.imgPollo);
        imgExtras = (ImageView) findViewById(R.id.imgExtras);

        Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
                "/btnham_zpss2i2xyad.png").placeholder(R.drawable.rubik2).into(imgHamburguesa);
        Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
                "/btnpizza_zpsshpdbgwm.png").placeholder(R.drawable.rubik2).into(imgPizza);
        Picasso.with(context).load("").placeholder(R.drawable.rubik2).into(imgHotDog);
        Picasso.with(context).load("").placeholder(R.drawable.rubik2).into(imgPollo);
        Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
                "/btnextras_zpseca2wzwu.png").placeholder(R.drawable.rubik2).into(imgExtras);

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
