package mx.unam.fi.sosa.electrostore;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import mx.unam.fi.sosa.electrostore.utilidades.utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper{

    //final String CREAR_TABLA_RESISTENCIAS="CREATE TABLE resistencias (valores String, cantidad String)";

    public ConexionSQLiteHelper(Context context,String name, SQLiteDatabase.CursorFactory factory,int version) {
        super(context, "bd_componentes",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(utilidades.CREAR_TABLA_RESISTENCIAS);
        db.execSQL(utilidades.CREAR_TABLA_CAPACITORES);
        db.execSQL(utilidades.CREAR_TABLA_POTENCIOMETROS);
        db.execSQL(utilidades.CREAR_TABLA_DIODOS);
        db.execSQL(utilidades.CREAR_TABLA_LEDS);
        db.execSQL(utilidades.CREAR_TABLA_TRANSISTORES);
        db.execSQL(utilidades.CREAR_TABLA_INTEGRADOS);
        db.execSQL(utilidades.CREAR_TABLA_CABLES);
        db.execSQL(utilidades.CREAR_TABLA_OTROS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+utilidades.TABLA_RESISTENCIAS);
        db.execSQL("DROP TABLE IF EXISTS "+utilidades.TABLA_CAPACITORES);
        db.execSQL("DROP TABLE IF EXISTS "+utilidades.TABLA_POTENCIOMETROS);
        db.execSQL("DROP TABLE IF EXISTS "+utilidades.TABLA_DIODOS);
        db.execSQL("DROP TABLE IF EXISTS "+utilidades.TABLA_LEDS);
        db.execSQL("DROP TABLE IF EXISTS "+utilidades.TABLA_TRANSISTORES);
        db.execSQL("DROP TABLE IF EXISTS "+utilidades.TABLA_INTEGRADOS);
        db.execSQL("DROP TABLE IF EXISTS "+utilidades.TABLA_CABLES);
        db.execSQL("DROP TABLE IF EXISTS "+utilidades.TABLA_OTROS);
        onCreate(db);
    }
}
