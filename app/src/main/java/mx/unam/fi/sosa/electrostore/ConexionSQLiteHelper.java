package mx.unam.fi.sosa.electrostore;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import mx.unam.fi.sosa.electrostore.utilidades.utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper{


    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(utilidades.CREAR_TABLA_RESISTENCIAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS resistencias");
        onCreate(db);
    }
}
