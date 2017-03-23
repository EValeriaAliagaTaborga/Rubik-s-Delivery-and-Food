package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.nfc.Tag;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MenuPizzaActivity extends AppCompatActivity {

    private Context context = this;

    private ImageButton btnimgAnadirPedidoP;
    private Toolbar tlbVerOrdenP;
    private TextView lblPrecioTotalP;
  //  private CheckBox checkBox;
    //private ImageButton imgbtnCheck;

    // Paso 1
    private DatabaseReference databaseRef;
//    private String s;

    private ListView productsListView;
    private ProductosAdapter productosAdapter;
    private double precioTotalP = 0.00;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pizza);

        context = this;

        btnimgAnadirPedidoP = (ImageButton) findViewById(R.id.btnimgAnadirPedidoP);
        tlbVerOrdenP = (Toolbar) findViewById(R.id.tlbVerOrdenP);
        lblPrecioTotalP = (TextView) findViewById(R.id.lblPrecioTotalP);
       // imgbtnCheck = (ImageButton) findViewById(R.id.imgbtnCheck);

        precioTotalP = MenuActivity.precio;
        lblPrecioTotalP.setText(Double.toString(precioTotalP)+"0");

        final ArrayList<Productos> products = new ArrayList<>();
        productosAdapter = new ProductosAdapter(context, products, lblPrecioTotalP);

        productsListView = (ListView) findViewById(R.id.lstPizzas);
        productsListView.setAdapter(productosAdapter);

        // Firebase

        // Paso 2
        databaseRef = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference productosRef = databaseRef.child("pizzas"); //nombre de la rama

        productosRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                productosAdapter.clear();
                for (DataSnapshot msgSnapshot : snapshot.getChildren()) {
                    Productos msg = msgSnapshot.getValue(Productos.class);
                    productosAdapter.add(msg);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getApplicationContext(), R.string.cancel_process, Toast.LENGTH_SHORT).show();
            }
        });



        btnimgAnadirPedidoP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MenuActivity.class);
                precioTotalP = Double.parseDouble(lblPrecioTotalP.getText().toString());
                MenuActivity.setPrecio(precioTotalP);
                lblPrecioTotalP.setText(Double.toString(MenuActivity.getPrecio())+"0");
                startActivity(intent);

                }
        });

        productsListView.setClickable(true);
        productsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> array, View vista, int posicion, long id) {

               // Log.i("Click", "click en el elemento" + posicion + "de la lista");
//                TextView texto = (TextView) vista.findViewById(android.R.id.text1);
  //              String producto = texto.getText().toString();
                //Log.e("Item seleccionado", producto);

                Productos prod = (Productos)productsListView.getItemAtPosition(posicion);
                String[] datosProducto = new String[] {prod.getNombre(), String.valueOf(prod.getPrecio()),prod.getDescripcion(),prod.getFotoUrl()};

                Intent intent = new Intent(context, VistaDeDetalleActivity.class);
                // Toast.makeText(context, nombreProd + String.valueOf(precioProd)+fotoProd, Toast.LENGTH_SHORT).show();
                intent.putExtra("datos_producto", datosProducto);
                startActivity(intent);

            }
        });

        tlbVerOrdenP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, VerOrdenActivity.class);
                startActivity(intent);
            }
        });
    }
}
