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

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.squareup.picasso.Picasso;

//import static notanamelessentreprise.rubiksdeliveryandfood.R.id.sliderLayout;

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
    //ViewPager viewPager;
    private Context context;
    private SliderLayout SliderLayout;


    //hola c: j
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        
        context = this;

        SliderLayout sliderShow = (SliderLayout) findViewById(R.id.slider);
        lyhHamburguesa = (LinearLayout) findViewById(R.id.lyhHamburguesa);
        lyhPizza = (LinearLayout) findViewById(R.id.lyhPizza);
        lyhHotDog = (LinearLayout) findViewById(R.id.lyhHotDog);
        lyhPollo = (LinearLayout) findViewById(R.id.lyhPollo);
        lyhExtras = (LinearLayout) findViewById(R.id.lyhExtras);
        imgHamburguesa = (ImageView) findViewById(R.id.imgHamburguesa);
        imgPizza = (ImageView) findViewById(R.id.imgPizza);
        imgHotDog = (ImageView) findViewById(R.id.imgHotDog);
        imgPollo = (ImageView) findViewById(R.id.imgPollo);
        imgExtras = (ImageView) findViewById(R.id.imgExtras);

        //Slide con daimajia
        TextSliderView textSliderView = new TextSliderView(this);
        textSliderView
                .description("Game of Thrones")
                .image("http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");
        textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView baseSliderView) {
                Toast.makeText(context, "Una serie que la Vale A. no ve :v", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ArmaloHamburguesaActivity.class);
                startActivity(intent);
            }
        });
        sliderShow.addSlider(textSliderView);


        //Slide con daimajia 2
        TextSliderView textSliderView2 = new TextSliderView(this);
        textSliderView2
                .description("JJ")
                .image("https://68.media.tumblr.com/2abdbf9df59501afec40948d673e5bd8/tumblr_oi7q6mvIjl1v0ltm0o1_1280.jpg");
        textSliderView2.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView baseSliderView) {
                Toast.makeText(context, "El husbando 2D de Vale A. xD", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ArmaloPizzaActivity.class);
                startActivity(intent);
            }
        });
        sliderShow.addSlider(textSliderView2);

        //Slide con daimajia 3
        TextSliderView textSliderView3 = new TextSliderView(this);
        textSliderView3
                .description("JJ2")
                .image("https://68.media.tumblr.com/2abdbf9df59501afec40948d673e5bd8/tumblr_oi7q6mvIjl1v0ltm0o1_1280.jpg");
        textSliderView3.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView baseSliderView) {
                Toast.makeText(context, "El husbando 2D de Vale A. xD x2", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ArmaloHotDogActivity.class);
                startActivity(intent);
            }
        });
        sliderShow.addSlider(textSliderView3);

        Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
                "/btnham_zpss2i2xyad.png").placeholder(R.drawable.rubik2).resize(100,100).into(imgHamburguesa);
        Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
                "/btnpizza_zpsshpdbgwm.png").placeholder(R.drawable.rubik2).resize(100,100).into(imgPizza);
        Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
                "/btnhotdog_zpsk1mbupua.png").placeholder(R.drawable.rubik2).resize(100,100).into(imgHotDog);
        Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
                "/btnpollo_zpskviqlidb.png").placeholder(R.drawable.rubik2).resize(100,100).into(imgPollo);
        Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
                "/btnextras_zpseca2wzwu.png").placeholder(R.drawable.rubik2).resize(100,100).into(imgExtras);


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


        //SLIDE CON VIEWPAGER
        //viewPager = (ViewPager)findViewById(R.id.viewPager);
        //ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        //viewPager.setAdapter(viewPagerAdapter);
        //viewPager.setOnClickListener(new View.OnClickListener() {
        //    public void onClick(View v)
        //    {
        //        Toast.makeText(getApplicationContext(), "Notificación Toast", Toast.LENGTH_LONG);
        //    }
        //});


    }
}



