package notanamelessentreprise.rubiksdeliveryandfood;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import notanamelessentreprise.rubiksdeliveryandfood.Productos1.SubCategoria;
import notanamelessentreprise.rubiksdeliveryandfood.Productos1.SubCategoria.ItemList;

public class MenuExtrasActivity extends AppCompatActivity {
    private ArrayList<Productos1>pProductosArrayList;
    private ArrayList<SubCategoria>pSubItemArrayList;
    private ArrayList<SubCategoria>pSubItemArrayList2;
    private ArrayList<SubCategoria>pSubItemArrayList3;
    private LinearLayout mLinearListView;
    boolean esPrimerClick =false;
    boolean esSegundoClick = false;
      /*  private LinkedHashMap<String, GroupInfo> subjects = new LinkedHashMap<String, GroupInfo>();
        private ArrayList<GroupInfo> deptList = new ArrayList<GroupInfo>();

        private CustomAdapter listAdapter;
        private ExpandableListView simpleExpandableListView;

        private ArrayList<String> listaDeTamanios = new ArrayList<String>();*/

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu_extras);
            mLinearListView=(LinearLayout)findViewById(R.id.linear_listview);

            //Papas fritas
            ArrayList<ItemList> mItemListArray = new ArrayList<ItemList>();
            mItemListArray.add(new ItemList("Pequeño","Bs. 5"));
            mItemListArray.add(new ItemList("Mediano","Bs. 7"));
            mItemListArray.add(new ItemList("Grande","Bs. 10"));

            //Arroz
            ArrayList<ItemList> mItemListArray0 = new ArrayList<ItemList>();
            mItemListArray0.add(new ItemList("Pequeño","Bs. 10"));
            mItemListArray0.add(new ItemList("Grande","Bs. 15"));

            //Soda CocaCola y esos
            ArrayList<ItemList> mItemListArray2 = new ArrayList<ItemList>();
            mItemListArray2.add(new ItemList("Pequeño","Bs. 5"));
            mItemListArray2.add(new ItemList("Mediano","Bs. 7.5"));
            mItemListArray2.add(new ItemList("Grande","Bs. 10"));

            //Tradicional
            ArrayList<ItemList> mItemListArray03 = new ArrayList<>();
            mItemListArray03.add(new ItemList("Mayonesa","Bs. 0.5"));
            mItemListArray03.add(new ItemList("Ketchup","Bs. 0.5"));
            mItemListArray03.add(new ItemList("Mostaza","Bs. 0.5"));
            mItemListArray03.add(new ItemList("Llajua Tradicional","Bs. 1"));

            //Extravagante
            ArrayList<ItemList> mItemListArray3 = new ArrayList<>();
            mItemListArray3.add(new ItemList("Salsa Golf","Bs. 1"));
            mItemListArray3.add(new ItemList("Salsa Barbacoa","Bs. 3"));
            mItemListArray3.add(new ItemList("Miel y Mostaza","Bs. 3"));
            mItemListArray3.add(new ItemList("Hot Mustard","Bs. 3"));
            mItemListArray3.add(new ItemList("Salsa Picante","Bs. 3"));

            pSubItemArrayList = new ArrayList<SubCategoria>();
            pSubItemArrayList2 = new ArrayList<SubCategoria>();
            pSubItemArrayList3 = new ArrayList<SubCategoria>();

            pSubItemArrayList.add(new SubCategoria("Papas Fritas",mItemListArray));
            pSubItemArrayList.add(new SubCategoria("Arroz",mItemListArray0));

            pSubItemArrayList2.add(new SubCategoria("Coca Cola",mItemListArray2));
            pSubItemArrayList2.add(new SubCategoria("Fanta",mItemListArray2));
            pSubItemArrayList2.add(new SubCategoria("Sprite",mItemListArray2));

            pSubItemArrayList3.add(new SubCategoria("Tradicional",mItemListArray03));
            pSubItemArrayList3.add(new SubCategoria("Extravagante",mItemListArray3));


            pProductosArrayList = new ArrayList<Productos1>();
            pProductosArrayList.add(new Productos1("Guarniciones",pSubItemArrayList));
            pProductosArrayList.add(new Productos1("Gaseosas",pSubItemArrayList2));
            pProductosArrayList.add(new Productos1("Salsas",pSubItemArrayList3));

            for (int i =0; i < pProductosArrayList.size(); i++){
                LayoutInflater inflater = null;
                inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View mLinearView = inflater.inflate(R.layout.primera_fila,null);

                final TextView mProductoNombre = (TextView)mLinearView.findViewById(R.id.textViewNombre);
                final RelativeLayout mLinearFirstArrow = (RelativeLayout)mLinearView.findViewById(R.id.linearFirst);
                final ImageView mImageArrowFirst = (ImageView)mLinearView.findViewById(R.id.imageFirstArrow);
                final LinearLayout mLinearScrollSecond = (LinearLayout)mLinearView.findViewById(R.id.linear_scroll);

                if (esPrimerClick == false){
                    mLinearScrollSecond.setVisibility(View.GONE);
                    mImageArrowFirst.setBackgroundResource(R.drawable.fle_costado);
                }else{
                    mLinearScrollSecond.setVisibility(View.VISIBLE);
                    mImageArrowFirst.setBackgroundResource(R.drawable.fle_abajo);
                }
                mLinearFirstArrow.setOnTouchListener(new View.OnTouchListener(){
                    @Override
                    public boolean onTouch(View v, MotionEvent event){
                        if(esPrimerClick==false){
                            esPrimerClick=true;
                            mImageArrowFirst.setBackgroundResource(R.drawable.fle_abajo);
                            mLinearScrollSecond.setVisibility(View.VISIBLE);
                        }else{
                            esPrimerClick = false;
                            mImageArrowFirst.setBackgroundResource(R.drawable.fle_costado);
                            mLinearScrollSecond.setVisibility(View.GONE);
                        }
                        return false;
                    }

                });

                final String name = pProductosArrayList.get(i).getpNombre();
                mProductoNombre.setText(name);

                for(int j = 0 ; j < pProductosArrayList.get(i).getmSubCategoriaList().size();j++){
                    LayoutInflater inflater2 = null;
                    inflater2 = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View mLinearView2 = inflater2.inflate(R.layout.segunda_fila,null);

                    TextView mSubItemNombbre = (TextView) mLinearView2.findViewById(R.id.textViewTitle);
                    final RelativeLayout mLinearSecondArrow = (RelativeLayout)mLinearView2.findViewById(R.id.linearSecond);
                    final ImageView mImageArrowSecond = (ImageView) mLinearView2.findViewById(R.id.imageSecondArrow);
                    final LinearLayout mLinearScrollThird = (LinearLayout) mLinearView2.findViewById(R.id.linear_scroll_third);

                    if(esSegundoClick == false){
                        mLinearScrollThird.setVisibility(View.GONE);
                        mImageArrowSecond.setBackgroundResource(R.drawable.fle_costado);
                    }else{
                        mLinearScrollThird.setVisibility(View.VISIBLE);
                        mImageArrowSecond.setBackgroundResource(R.drawable.fle_abajo);
                    }
                    mLinearSecondArrow.setOnTouchListener(new View.OnTouchListener(){
                        @Override
                        public boolean onTouch(View v, MotionEvent event){
                            if(esSegundoClick == false){
                                esSegundoClick = true;
                                mImageArrowSecond.setBackgroundResource(R.drawable.fle_abajo);
                                mLinearScrollThird.setVisibility(View.VISIBLE);
                            }else {
                                esSegundoClick = false;
                                mImageArrowSecond.setBackgroundResource(R.drawable.fle_costado);
                                mLinearScrollThird.setVisibility(View.GONE);
                            }
                            return false;
                        }
                    });

                    final String catecoryName = pProductosArrayList.get(i).getmSubCategoriaList().get(j).getpSubCategoriaNombre();
                    mSubItemNombbre.setText(catecoryName);

                    for(int k = 0; k <pProductosArrayList.get(i).getmSubCategoriaList().get(j).getmItemListArray().size();k++){
                        LayoutInflater inflater3 = null;
                        inflater3 = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        View mLinearView3 = inflater3.inflate(R.layout.tercera_fila,null);
                        TextView mItemName = (TextView) mLinearView3.findViewById(R.id.textViewItemName);
                        TextView mItemPrecio = (TextView) mLinearView3.findViewById(R.id.textViewItemPrecio);
                        final String itemName = pProductosArrayList.get(i).getmSubCategoriaList().get(j).getmItemListArray().get(k).getItemNombre();
                        final String itemPrecio = pProductosArrayList.get(i).getmSubCategoriaList().get(j).getmItemListArray().get(k).getItemPrecio();
                        mItemName.setText(itemName);
                        mItemPrecio.setText(itemPrecio);
                        mLinearScrollThird.addView(mLinearView3);
                    }
                    mLinearScrollSecond.addView(mLinearView2);
                }
                mLinearListView.addView(mLinearView);
            }

        /*    final ListView lista=(ListView)findViewById(R.id.listView);

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
                            + "/" + detailInfo.getName(), Toast.LENGTH_LONG).show();
                   //lista.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) lista);
                    return false;
         //       }
            });
            // SetOnGroupClickListener escucha para el encabezado de grupo
            simpleExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                @Override
                public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                    //Obtener el encabezado del grupo
                    GroupInfo headerInfo = deptList.get(groupPosition);
                    //display it or do something with it
                   /* Toast.makeText(getBaseContext(), " Header is :: " + headerInfo.getName(),
                            Toast.LENGTH_LONG).show();

                    return false;
           //     }
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
            return groupPosition;*/
        }


}
