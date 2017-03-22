package notanamelessentreprise.rubiksdeliveryandfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class AppBarPrueba extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar_prueba);

        Toolbar toolbarDeVerdad = (Toolbar) findViewById(R.id.toolbar2);
        toolbarDeVerdad.hasExpandedActionView();
    }
}
