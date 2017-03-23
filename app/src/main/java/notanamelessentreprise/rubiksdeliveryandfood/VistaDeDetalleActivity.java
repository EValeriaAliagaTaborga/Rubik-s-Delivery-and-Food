package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class VistaDeDetalleActivity extends AppCompatActivity {

    private Context context;

    private String nombre;
    private String precio;
    private String descripcion;
    private String fotoUrl;

    private TextView lblNombreProd;
    private TextView lblPrecioProd;
    private TextView lblDescripcionProd;
    private ImageView imgFotoUrlProd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_de_detalle);

        Intent b = getIntent();
        nombre = b.getStringArrayExtra("datos_producto")[0];
        precio = b.getStringArrayExtra("datos_producto")[1];
        descripcion = b.getStringArrayExtra("datos_producto")[2];
        fotoUrl = b.getStringArrayExtra("datos_producto")[3];

        context = this;

        lblNombreProd = (TextView) findViewById(R.id.lblNombreProd);
        lblPrecioProd = (TextView) findViewById(R.id.lblPrecioProd);
        lblDescripcionProd = (TextView) findViewById(R.id.lblDescripcionProd);
        imgFotoUrlProd = (ImageView) findViewById(R.id.imgFotoUrlProd);

        lblNombreProd.setText(nombre);
        lblPrecioProd.setText(precio);
        lblDescripcionProd.setText(descripcion);

        Glide.with(context)
                .load(fotoUrl)
                .centerCrop()
                .crossFade()
                .into(imgFotoUrlProd);


    }
}