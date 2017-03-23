package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Valeria on 23/03/2017.
 */

public class BaseDeDatos extends SQLiteOpenHelper
{
    public static final String NOMBREBD = "curso_android.sqlite";
    //Versión de la base de datos
    public BaseDeDatos(Context context, int VERSION)
    {
        super(context, NOMBREBD, null, VERSION);
    }

    //Método utilizado cuando se crea la base de datos.
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table rubik (id integer(12) AUTO_INCREMENT not null PRIMARY KEY, nombre varchar(100), " +
                "nombreusuario varchar(100), celulartelefono integer(8), domicilio varchar(100), email varchar(100)," +
                " contrasenia varchar(100), repcontrasenia varchar(100), nombrefactura varchar(100), nit integer(100));");
        //TODO agregar tabla productos Vale
        //db.execSQL("create table productos (......)");

        Log.d("Todos los tablas: ", "Se crearon las tablas");

        //TODO agregar productos al menos 5 Todos
        /*ContentValues producto1=new ContentValues();
        producto1.put("nombre","Hamburgues de pinia");
        db.insert("productos",null,producto1);*/

    }

    //Método utilizado cuando se actualiza la base de datos
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

}
