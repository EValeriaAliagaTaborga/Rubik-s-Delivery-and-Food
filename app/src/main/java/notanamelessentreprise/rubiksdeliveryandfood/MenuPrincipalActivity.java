package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class MenuPrincipalActivity extends AppCompatActivity {

    private Context context;

    private LinearLayout lyvMenu;
    private LinearLayout lyvContactenos;
    private LinearLayout lyvCalculadora;
    private LinearLayout lyvVideos;
    private LinearLayout lyvPerfil;
    private ImageView imgMenu;
    private ImageView imgContactenos;
    private ImageView imgCalculadora;
    private ImageView imgVideos;
    private ImageView imgPerfil;


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
        imgMenu = (ImageView) findViewById(R.id.imgMenu);
        imgContactenos = (ImageView) findViewById(R.id.imgContactenos);
        imgCalculadora = (ImageView) findViewById(R.id.imgCalculadora);
        imgVideos = (ImageView) findViewById(R.id.imgVideos);
        imgPerfil = (ImageView) findViewById(R.id.imgPerfil);

        //Imagenes con Picasso: URL y PlaceHolder para espera de descarga

        Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
                "/Menu%20icons/btnmenu_zpsurqwg1vf.png").placeholder(R.drawable.rubik2).into(imgMenu);
        Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
                "/Menu%20icons/btncontact_zpsjdeyfx7x.png").placeholder(R.drawable.rubik2).into(imgContactenos);
        Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
                "/Menu%20icons/btncalculadora_zpsvri3rnor.png").placeholder(R.drawable.rubik2).into(imgCalculadora);
        Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
                "/Menu%20icons/btnvideos_zpsaagvtdcc.png").placeholder(R.drawable.rubik2).into(imgVideos);
        Picasso.with(context).load("http://i1278.photobucket.com/albums/y518/TaurineSGH/Programacion%20III" +
                "/Menu%20icons/btnperfil_zps1ly0aevv.png").placeholder(R.drawable.rubik2).into(imgPerfil);



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
                Intent intent = new Intent(context, ContactenosActivity.class);
                startActivity(intent);
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
                Intent intent = new Intent(context, PerfilActivity.class);
                startActivity(intent);
            }
        });
    }
}
