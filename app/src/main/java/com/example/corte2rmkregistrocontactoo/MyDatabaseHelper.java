package com.example.corte2rmkregistrocontactoo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class    MyDatabaseHelper extends SQLiteOpenHelper {

    private final Context context;
    private static final String DATABASE_NAME = "Directory.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME =  "my_contacts";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "friend_name";
    private static final String COLUMN_LAST_NAME = "friend_last_name"; //1
    private static final String COLUMN_AGE = "friend_age";//2
    private static final String COLUMN_PHONE = "friend_phone";
    private static final String COLUMN_MAIL = "friend_mail";
    private static final String COLUMN_CITY = "friend_city";//3
    private static final String COLUMN_GENDER = "friend_gender"; // 4
    // ;//5 registros adicionales.

    //public  static  final
    public MyDatabaseHelper(@Nullable MainActivity context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //vamos a crear la query sql
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        COLUMN_NAME + " TEXT, " +
                        COLUMN_LAST_NAME + " TEXT, " +
                        COLUMN_AGE + " INTEGER, "+
                        COLUMN_PHONE + " INTEGER, "+
                        COLUMN_MAIL + " TEXT, " +
                        COLUMN_CITY + " TEXT, " +
                        COLUMN_GENDER + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }
// creo este metodo  para agregar contactos., y luego meterlo en la tabla de la base de datos.

    void addContact(String name, String last_name, String age, String phone, String mail, String city, String gender){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();// almaceno los datos de la aplicacion.
        cv.put(COLUMN_NAME,name);
        cv.put(COLUMN_LAST_NAME,last_name);
        cv.put(COLUMN_AGE,age);
        cv.put(COLUMN_PHONE,phone);
        cv.put(COLUMN_MAIL,mail);
        cv.put(COLUMN_CITY,city);
        cv.put(COLUMN_GENDER,gender);
        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1){

            Toast.makeText(context, "Error agregando contacto.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Contacto agregado exitosamente.", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase(); // hace que el objeto tenga los metodos de la cosa get readable database
        Cursor cursor = null; // revisa que la bd no esta vacia.
        if(db != null){

            cursor = db.rawQuery(query,null); // la primera es la query, asi le puse a la variable que me contiene la consulta.
        }
        return cursor;
    }
}
