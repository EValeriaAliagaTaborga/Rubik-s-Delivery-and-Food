package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

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
    ViewPager viewPager;


    private Context context;

    //hola c: j
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        context = this;

        viewPager = (ViewPager)findViewById(R.id.viewPager);
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

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);

        //Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
        //        "/btnham_zpss2i2xyad.png").placeholder(R.drawable.rubik2).resize(100,100).into(imgHamburguesa);
        //Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
        //        "/btnpizza_zpsshpdbgwm.png").placeholder(R.drawable.rubik2).resize(100,100).into(imgPizza);
        //Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
        //        "/btnhotdog_zpsk1mbupua.png").placeholder(R.drawable.rubik2).resize(100,100).into(imgHotDog);
        //Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
        //        "/btnpollo_zpskviqlidb.png").placeholder(R.drawable.rubik2).resize(100,100).into(imgPollo);
        //Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
        //        "/btnextras_zpseca2wzwu.png").placeholder(R.drawable.rubik2).resize(100,100).into(imgExtras);



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

        viewPager.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), "Notificación Toast", Toast.LENGTH_LONG);
            }
        });


    }


}
