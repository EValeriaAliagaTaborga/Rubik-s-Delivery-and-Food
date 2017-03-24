package notanamelessentreprise.rubiksdeliveryandfood;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.R.attr.name;

/**
 * Created by Valeria on 23/03/2017.
 */

//public class BaseDeDatos extends SQLiteOpenHelper {

   /* public static final String NOMBREBD = "base_de_datos.db";

    //Versión de la base de datos
    public static final int VERSION = 1;

    public BaseDeDatos(Context context) {
        super(context, NOMBREBD, null, VERSION);
    }

    //Método utilizado cuando se crea la base de datos.
    public void onCreate(SQLiteDatabase db)
    {
      /*  mockData(db);
        db.execSQL("CREATE TABLE " + UsuariosContract.UsuarioEntry.TABLE_NAME + " ("
                + UsuariosContract.UsuarioEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + UsuariosContract.UsuarioEntry.NAME + " TEXT NOT NULL,"
                + UsuariosContract.UsuarioEntry.USERNAME + " TEXT NOT NULL,"
                + UsuariosContract.UsuarioEntry.PHONE_NUMBER + " TEXT NOT NULL,"
                + UsuariosContract.UsuarioEntry.ADDRESS + " TEXT NOT NULL,"
                + UsuariosContract.UsuarioEntry.EMAIL + " TEXT NOT NULL,"
                + UsuariosContract.UsuarioEntry.PASSWORD + " TEXT NOT NULL,"
                + UsuariosContract.UsuarioEntry.NIT + " TEXT NOT NULL,"
                + UsuariosContract.UsuarioEntry.INVOICENAME + " TEXT)");


        // Contenedor de valores
        ContentValues values = new ContentValues();

        // Pares clave-valor
        values.put(UsuariosContract.UsuarioEntry.NAME, "Rosa Zambrana");
        values.put(UsuariosContract.UsuarioEntry.USERNAME, "Rosa");
        values.put(UsuariosContract.UsuarioEntry.PASSWORD, "i3915");
        values.put(UsuariosContract.UsuarioEntry.ADDRESS, "Ovejuyo muy muy lejos");
        values.put(UsuariosContract.UsuarioEntry.EMAIL, "ros@gmail.com");
        values.put(UsuariosContract.UsuarioEntry.PHONE_NUMBER, "67060037");
        values.put(UsuariosContract.UsuarioEntry.INVOICENAME, "Zambrana");
        values.put(UsuariosContract.UsuarioEntry.NIT, "3335952");

        // Insertar...
        db.insert(UsuariosContract.UsuarioEntry.TABLE_NAME, null, values);*/



        /*db.execSQL("create table rubik (id integer(12) AUTO_INCREMENT not null PRIMARY KEY, nombre varchar(100), " +
                "nombreusuario varchar(100), celulartelefono integer(8), domicilio varchar(100), email varchar(100)," +
                " contrasenia varchar(100), repcontrasenia varchar(100), nombrefactura varchar(100), nit integer(100));");
        //TODO agregar tabla productos Vale
        //db.execSQL("create table productos (......)");

        Log.d("Todos los tablas: ", "Se crearon las tablas");
*/
        //TODO agregar productos al menos 5 Todos
        /*ContentValues producto1=new ContentValues();
        producto1.put("nombre","Hamburgues de pinia");
        db.insert("productos",null,producto1);*/

   // }

  /*  //Método utilizado cuando se actualiza la base de datos
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public long guardarUsuario(Usuario usuario) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(
                UsuariosContract.UsuarioEntry.TABLE_NAME,
                null,
                usuario.toContentValues());

    }



    public static boolean CheckIsDataAlreadyInDBorNot(SQLiteDatabase sqldb, String TableName,
                                                      String dbfield, String fieldValue) {
        //SQLiteDatabase sqldb = EGLifeStyleApplication.sqLiteDatabase;
        String Query = "Select * from " + TableName + " where " + dbfield + " = " + fieldValue;
        Cursor cursor = sqldb.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            return false;
        }
        return true;
    }
    @Override

    private void mockData(SQLiteDatabase sqLiteDatabase) {
        mockLawyer(sqLiteDatabase, new Usuario("Carlos Perez", "Abogado penalista",
                "300 200 1111", "Gran profesional con experiencia de 5 años en casos penales.",
                "carlos_perez.jpg","","",""));
        mockLawyer(sqLiteDatabase, new Usuario("Daniel Samper", "Abogado accidentes de tráfico",
                "300 200 2222", "Gran profesional con experiencia de 5 años en accidentes de tráfico.",
                "daniel_samper.jpg","","",""));
        mockLawyer(sqLiteDatabase, new Usuario("Lucia Aristizabal", "Abogado de derechos laborales",
                "300 200 3333", "Gran profesional con más de 3 años de experiencia en defensa de los trabajadores.",
                "lucia_aristizabal.jpg","","",""));
        mockLawyer(sqLiteDatabase, new Usuario("Marina Acosta", "Abogado de familia",
                "300 200 4444", "Gran profesional con experiencia de 5 años en casos de familia.",
                "marina_acosta.jpg","","",""));
        mockLawyer(sqLiteDatabase, new Usuario("Olga Ortiz", "Abogado de administración pública",
                "300 200 5555", "Gran profesional con experiencia de 5 años en casos en expedientes de urbanismo.",
                "olga_ortiz.jpg","","",""));
        mockLawyer(sqLiteDatabase, new Usuario("Pamela Briger", "Abogado fiscalista",
                "300 200 6666", "Gran profesional con experiencia de 5 años en casos de derecho financiero",
                "pamela_briger.jpg","","",""));
        mockLawyer(sqLiteDatabase, new Usuario("Rodrigo Benavidez", "Abogado Mercantilista",
                "300 200 1111", "Gran profesional con experiencia de 5 años en redacción de contratos mercantiles",
                "rodrigo_benavidez.jpg","","",""));
        mockLawyer(sqLiteDatabase, new Usuario("Tom Bonz", "Abogado penalista",
                "300 200 1111", "Gran profesional con experiencia de 5 años en casos penales.",
                "tom_bonz.jpg","","",""));
    }

    public long mockLawyer(SQLiteDatabase db, Usuario usuario) {
        return db.insert(
                UsuariosContract.UsuarioEntry.TABLE_NAME,
                null,
                usuario.toContentValues());
    }*/

//}
