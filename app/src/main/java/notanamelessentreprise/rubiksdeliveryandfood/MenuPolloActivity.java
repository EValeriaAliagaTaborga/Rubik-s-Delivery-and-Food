package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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

public class MenuPolloActivity extends AppCompatActivity {


    private Context context;

    private ImageButton btnimgAnadirPedidoPo;
    private Toolbar tlbVerOrdenPo;
    private TextView lblPrecioTotalPo;

    // Paso 1
    private DatabaseReference databaseRef;

    private ListView productsListView;
    private ProductosAdapter productosAdapter;

    private double precioTotalPo = 0.00;

    private static final int opcion1= 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;
    private static final int opcion4 = 4;
    private static final int opcion5 = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pollo);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = this;

        btnimgAnadirPedidoPo = (ImageButton) findViewById(R.id.btnimgAnadirPedidoPo);
        tlbVerOrdenPo = (Toolbar) findViewById(R.id.tlbVerOrdenPo);
        lblPrecioTotalPo = (TextView) findViewById(R.id.lblPrecioTotalPo);


        precioTotalPo = MenuActivity.precio;
        lblPrecioTotalPo.setText(Double.toString(precioTotalPo)+"0");

        ArrayList<Productos> products = new ArrayList<>();
        productosAdapter = new ProductosAdapter(context, products,lblPrecioTotalPo);

        productsListView = (ListView) findViewById(R.id.lstPollos);
        productsListView.setAdapter(productosAdapter);


        // Firebase

        // Paso 2
        databaseRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference productosRef = databaseRef.child("pollos"); //nombre de la rama

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

        btnimgAnadirPedidoPo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MenuActivity.class);
                precioTotalPo = Double.parseDouble(lblPrecioTotalPo.getText().toString());
                MenuActivity.setPrecio(precioTotalPo);
                lblPrecioTotalPo.setText(Double.toString(MenuActivity.getPrecio())+"0");
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

        tlbVerOrdenPo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, VerOrdenActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, opcion1, Menu.NONE, "Perfil");
        menu.add(Menu.NONE, opcion2, Menu.NONE, "Informacion de la app");
        menu.add(Menu.NONE, opcion3, Menu.NONE, "Historial");
        menu.add(Menu.NONE, opcion4, Menu.NONE, "Log In");
        menu.add(Menu.NONE, opcion5, Menu.NONE, "Cerrar Sesion");

        return true;
    }

}
