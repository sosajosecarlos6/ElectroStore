package mx.unam.fi.sosa.electrostore;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import mx.unam.fi.sosa.electrostore.utilidades.utilidades;

public class Registro extends AppCompatActivity {

    EditText campoValor, campoCantidad;
    Spinner comboCategorias;
    String[] mCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogo_editar);

        campoValor=(EditText)findViewById(R.id.edtValor);
        campoCantidad=(EditText)findViewById(R.id.edtCantidad);
        comboCategorias =(Spinner)findViewById(R.id.spinner_categorias);
        mCategorias=getResources().getStringArray(R.array.combo_categorias);
        llenarSpinner();
    }

    private void llenarSpinner() {
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mCategorias);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        comboCategorias.setAdapter(adapter);
    }


    public void onClick(View view) {
        registrarComponentes();
    }

    private void registrarComponentes() {
        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this,"bd_componentes",null,1);
        SQLiteDatabase db=conexion.getWritableDatabase();
        String insert="INSERT INTO "+utilidades.TABLA_RESISTENCIAS+" ("+utilidades.CAMPO_VALOR+","+utilidades.CAMPO_CANTIDAD+")"+" VALUES ('"+campoValor.getText().toString()+"', '"+campoCantidad.getText().toString()+"')";
        db.execSQL(insert);
        db.close();
    }
}
