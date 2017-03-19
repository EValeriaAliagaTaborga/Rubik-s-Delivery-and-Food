package notanamelessentreprise.rubiksdeliveryandfood;

import android.app.ExpandableListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MenuExtrasActivity extends AppCompatActivity {

        private LinkedHashMap<String, GroupInfo> subjects = new LinkedHashMap<String, GroupInfo>();
        private ArrayList<GroupInfo> deptList = new ArrayList<GroupInfo>();

        private CustomAdapter listAdapter;
        private ExpandableListView simpleExpandableListView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu_extras);

            // add data for displaying in expandable list view
            loadData();

            //get reference of the ExpandableListView
            simpleExpandableListView = (ExpandableListView) findViewById(R.id.simpleExpandableListView);
            // create the adapter by passing your ArrayList data
            listAdapter = new CustomAdapter(MenuExtrasActivity.this, deptList);
            // attach the adapter to the expandable list view
            simpleExpandableListView.setAdapter(listAdapter);

            //expand all the Groups
            expandAll();

            // setOnChildClickListener listener for child row click
            simpleExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                    //get the group header
                    GroupInfo headerInfo = deptList.get(groupPosition);
                    //get the child info
                    ChildInfo detailInfo =  headerInfo.getProductList().get(childPosition);
                    //display it or do something with it
                    Toast.makeText(getBaseContext(), " Clicked on :: " + headerInfo.getName()
                            + "/" + detailInfo.getName(), Toast.LENGTH_LONG).show();
                    return false;
                }
            });
            // setOnGroupClickListener listener for group heading click
            simpleExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                @Override
                public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                    //get the group header
                    GroupInfo headerInfo = deptList.get(groupPosition);
                    //display it or do something with it
                    Toast.makeText(getBaseContext(), " Header is :: " + headerInfo.getName(),
                            Toast.LENGTH_LONG).show();

                    return false;
                }
            });


        }

        //method to expand all groups
        private void expandAll() {
            int count = listAdapter.getGroupCount();
            for (int i = 0; i < count; i++){
                simpleExpandableListView.expandGroup(i);
            }
        }

        //method to collapse all groups
        private void collapseAll() {
            int count = listAdapter.getGroupCount();
            for (int i = 0; i < count; i++){
                simpleExpandableListView.collapseGroup(i);
            }
        }

        //load some initial data into out list
        private void loadData(){

            addProduct("Guarniciones","Papas Fritas");
            addProduct("Guarniciones","Arroz");

           // addProduct("Papas Fritas","Pequeño");


            addProduct("Gaseosas","Coca Cola");
            addProduct("Gaseosas","Fanta");
            addProduct("Gaseosas","Sprite");

            addProduct("Salsas","Mayonesa");
            addProduct("Salsas","Ketchup");
            addProduct("Salsas","Mostaza");
            addProduct("Salsas","Barbacoa");
            addProduct("Salsas","Miel y mostaza");

        }



        //here we maintain our products in various departments
        private int addProduct(String department, String product){

            int groupPosition = 0;

            //check the hash map if the group already exists
            GroupInfo headerInfo = subjects.get(department);
            //add the group if doesn't exists
            if(headerInfo == null){
                headerInfo = new GroupInfo();
                headerInfo.setName(department);
                subjects.put(department, headerInfo);
                deptList.add(headerInfo);
            }

            //get the children for the group
            ArrayList<ChildInfo> productList = headerInfo.getProductList();
            //size of the children list
            int listSize = productList.size();
            //add to the counter
            listSize++;

            //create a new child and add that to the group
            ChildInfo detailInfo = new ChildInfo();
            detailInfo.setSequence(String.valueOf(listSize));
            detailInfo.setName(product);
            productList.add(detailInfo);
            headerInfo.setProductList(productList);

            //find the group position inside the list
            groupPosition = deptList.indexOf(headerInfo);
            return groupPosition;
        }


}
