package notanamelessentreprise.rubiksdeliveryandfood;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.content.res.AppCompatResources;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

import static android.content.ContentValues.TAG;

public class ProductosAdapter extends ArrayAdapter<Productos> {

//    private CheckBox checkBox;
    private TextView lblPrecioTotal;
    private static double precioTotal;
    private ImageButton imgbtnCheck;

    public static double getPrecioTotal() {
        return precioTotal;
    }

    public static void setPrecioTotal(double precioTotal1) {
        precioTotal = precioTotal1;
    }

    public ProductosAdapter(Context context, List<Productos> objects, TextView lblPrecioTotal) {
        super(context, 0, objects);
        this.lblPrecioTotal = lblPrecioTotal;
        precioTotal = MenuActivity.getPrecio();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_producto, parent, false);
        }

        ImageView imgFoto = (ImageView) convertView.findViewById(R.id.imgFotoProducto);
        TextView lblNombre = (TextView) convertView.findViewById(R.id.lblNombreProducto);
      //  TextView descripcionTextView = (TextView) convertView.findViewById(R.id.lblDescripcionProducto);
        TextView lblPrecio = (TextView) convertView.findViewById(R.id.lblPrecioProducto);
        imgbtnCheck = (ImageButton) convertView.findViewById(R.id.imgbtnCheck);


        final Productos p = getItem(position);


        //TODO hacer q cambie la imagen de check

        imgbtnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(p.getChecked()) {
                    precioTotal -= p.getPrecio();
//                    imgbtnCheck.setImageBitmap(BitmapFactory.decodeResource(Resources.getSystem(),android.R.drawable.checkbox_off_background));
                    VerOrdenActivity.listaDePedidos.remove(p);
                    p.setChecked(false);
                } else {
                    precioTotal += p.getPrecio();
//                    imgbtnCheck.setImageBitmap(BitmapFactory.decodeResource(Resources.getSystem(), android.R.drawable.checkbox_on_background) );
                    VerOrdenActivity.listaDePedidos.add(p);
                    p.setChecked(true);
                }
                Log.i(TAG, "check en boton de "+p.getNombre()+" con checked "+p.getChecked());
                lblPrecioTotal.setText(Double.toString(precioTotal) +"0");
            }
        });

        lblNombre.setText(p.getNombre());
       // descripcionTextView.setText(p.getDescripcion());
        lblPrecio.setText(p.getPrecio() + "");

        Glide.with(getContext())
                .load(p.getFotoUrl())
                .centerCrop()
                .crossFade()
                .into(imgFoto);

        return convertView;

    }
}

