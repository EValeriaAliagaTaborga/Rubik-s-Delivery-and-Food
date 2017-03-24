package notanamelessentreprise.rubiksdeliveryandfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class PerfilActivity extends AppCompatActivity {
    private static final int opcion1= 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;
    private static final int opcion4 = 4;
    private static final int opcion5 = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
