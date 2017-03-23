package notanamelessentreprise.rubiksdeliveryandfood;

import java.util.ArrayList;

/**
 * Created by HP on 22/3/2017.
 */

public class Productos1 {
    private String pNombre;
    private ArrayList<SubCategoria> mSubCategoriaList;
    private ArrayList<SubCategoria1> mSubCategoriaList1;

    public Productos1(String pNombre, ArrayList<SubCategoria> mSubCategoriaList){
        super();
        this.pNombre = pNombre;
        this.mSubCategoriaList = mSubCategoriaList;
    }

    /*public Productos1(String pNombre, ArrayList<SubCategoria1> mSubCategoriaList1){
        super();
        this.pNombre = pNombre;
        this.mSubCategoriaList1 = mSubCategoriaList1;
    }*/

    public String getpNombre(){
        return pNombre;
    }
    public void setpNombre(String pNombre){
        this.pNombre = pNombre;
    }
    public ArrayList<SubCategoria>getmSubCategoriaList(){

        return mSubCategoriaList;
    }
    public void setmSubCategoriaList(ArrayList<SubCategoria> mSubCategoriaList){
        this.mSubCategoriaList = mSubCategoriaList;
    }
    /*

    public ArrayList<SubCategoria1> getSubCategoriaList1(){
        return mSubCategoriaList1;
    }*/


    public static class SubCategoria{
        private String pSubCategoriaNombre;
        private ArrayList<ItemList> mItemListArray;

        public SubCategoria(String pSubCategoriaNombre,ArrayList<ItemList> mItemListArray){
            super();
            this.pSubCategoriaNombre = pSubCategoriaNombre;
            this.mItemListArray = mItemListArray;
        }

        public String getpSubCategoriaNombre(){
            return pSubCategoriaNombre;
        }

        public  void setpSubCategoriaNombre (String pSubCategoriaNombre){
            this.pSubCategoriaNombre = pSubCategoriaNombre;
        }
        public ArrayList<ItemList> getmItemListArray(){
            return mItemListArray;
        }
        public void setmItemListArray(ArrayList<ItemList> mItemListArray){
            this.mItemListArray = mItemListArray;
        }


        public static class ItemList{
            private String itemNombre;
            private String itemPrecio;

            public ItemList(String itemNombre, String itemPrecio){
                super();
                this.itemNombre = itemNombre;
                this.itemPrecio = itemPrecio;
            }
            public String getItemNombre(){
                return itemNombre;
            }
            public void setItemNombre(String itemNombre){
                this.itemNombre = itemNombre;
            }
            public String getItemPrecio(){
                return itemPrecio;
            }
            public void setItemPrecio(String itemPrecio){
                this.itemPrecio = itemPrecio;
            }
        }
    }
    public static class SubCategoria1{
        private String pSubCategoriaNombre1;

        public SubCategoria1(String pSubCategoriaNombre1){
            super();
            this.pSubCategoriaNombre1 = pSubCategoriaNombre1;
        }

        public String getpSubCategoriaNombre1(){

            return pSubCategoriaNombre1;
        }

        public  void setpSubCategoriaNombre1 (String pSubCategoriaNombre1){
            this.pSubCategoriaNombre1 = pSubCategoriaNombre1;
        }
    }
}
