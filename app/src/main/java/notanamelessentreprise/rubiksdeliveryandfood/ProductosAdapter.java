package notanamelessentreprise.rubiksdeliveryandfood;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ProductosAdapter extends ArrayAdapter<Productos> {

    public ProductosAdapter(Context context, List<Productos> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_producto, parent, false);
        }

        ImageView imgFoto = (ImageView) convertView.findViewById(R.id.imgFotoProducto);
        TextView lblNombre = (TextView) convertView.findViewById(R.id.lblNombreProducto);
      //  TextView descripcionTextView = (TextView) convertView.findViewById(R.id.lblDescripcionProducto);
        TextView lblPrecio = (TextView) convertView.findViewById(R.id.lblPrecioProducto);

        Productos p = getItem(position);

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
