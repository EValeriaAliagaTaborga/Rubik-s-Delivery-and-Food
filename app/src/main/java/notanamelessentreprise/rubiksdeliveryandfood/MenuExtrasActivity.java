package notanamelessentreprise.rubiksdeliveryandfood;

import android.app.ExpandableListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MenuExtrasActivity extends AppCompatActivity {

        private LinkedHashMap<String, GroupInfo> subjects = new LinkedHashMap<String, GroupInfo>();
        private ArrayList<GroupInfo> deptList = new ArrayList<GroupInfo>();

        private CustomAdapter listAdapter;
        private ExpandableListView simpleExpandableListView;

        private ArrayList<String> listaDeTamanios = new ArrayList<String>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu_extras);

            final ListView lista=(ListView)findViewById(R.id.listView);

            listaDeTamanios.add("Pequenio");
            listaDeTamanios.add("Brande");

            // Agregar datos para mostrarlos en la vista de lista expandible
            loadData();

            //Obtener referencias del ExpandableListView
            simpleExpandableListView = (ExpandableListView) findViewById(R.id.simpleExpandableListView);
            // Cree el adaptador pasando sus datos de ArrayList
            listAdapter = new CustomAdapter(MenuExtrasActivity.this, deptList);
            // Adjunte el adaptador a la vista de lista expandible
            simpleExpandableListView.setAdapter(listAdapter);

            //Ampliar todos los Grupos

            expandAll();

            // SetOnChildClickListener escucha para fila
            simpleExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                    //Obtener el encabezado del grupo
                    GroupInfo headerInfo = deptList.get(groupPosition);
                    //Obtener información sobre el niño
                    ChildInfo detailInfo =  headerInfo.getProductList().get(childPosition);
                /*    //display it or do something with it
                    Toast.makeText(getBaseContext(), " Clicked on :: " + headerInfo.getName()
                            + "/" + detailInfo.getName(), Toast.LENGTH_LONG).show();*/
                   //lista.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) lista);
                    return false;
                }
            });
            // SetOnGroupClickListener escucha para el encabezado de grupo
            simpleExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                @Override
                public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                    //Obtener el encabezado del grupo
                    GroupInfo headerInfo = deptList.get(groupPosition);
                    //display it or do something with it
                   /* Toast.makeText(getBaseContext(), " Header is :: " + headerInfo.getName(),
                            Toast.LENGTH_LONG).show();*/

                    return false;
                }
            });


        }

        //Método para expandir todos los grupos
        private void expandAll() {
            int count = listAdapter.getGroupCount();
            for (int i = 0; i < count; i++){
                simpleExpandableListView.expandGroup(i);
            }
        }

        //Método para colapsar todos los grupos
        private void collapseAll() {
            int count = listAdapter.getGroupCount();
            for (int i = 0; i < count; i++){
                simpleExpandableListView.collapseGroup(i);
            }
        }

        //Cargar algunos datos iniciales en lista
        private void loadData(){

            addProduct("Guarniciones","Papas Fritas");
            addProduct("Guarniciones","Arroz");

            addProduct("Gaseosas","Coca Cola");
            addProduct("Gaseosas","Fanta");
            addProduct("Gaseosas","Sprite");

            addProduct("Salsas","Mayonesa");
            addProduct("Salsas","Ketchup");
            addProduct("Salsas","Mostaza");
            addProduct("Salsas","Barbacoa");
            addProduct("Salsas","Miel y mostaza");

        }



        //Aquí mantenemos nuestros productos en varios departamentos
        private int addProduct(String department, String product){

            int groupPosition = 0;

            //Comprobar el mapa hash si el grupo ya existe
            GroupInfo headerInfo = subjects.get(department);
            //Agregue el grupo si no existe
            if(headerInfo == null){
                headerInfo = new GroupInfo();
                headerInfo.setName(department);
                subjects.put(department, headerInfo);
                deptList.add(headerInfo);
            }

            //conseguir a los niños para el grupo
            ArrayList<ChildInfo> productList = headerInfo.getProductList();
            //Tamaño de la lista de niños
            int listSize = productList.size();
            //Agregar al contador
            listSize++;

            //Crear un nuevo hijo y añadirlo al grupo
            ChildInfo detailInfo = new ChildInfo();
            detailInfo.setSequence(String.valueOf(listSize));
            detailInfo.setName(product);
            productList.add(detailInfo);
            headerInfo.setProductList(productList);

            //Encontrar la posición de grupo dentro de la lista
            groupPosition = deptList.indexOf(headerInfo);
            return groupPosition;
        }


}
