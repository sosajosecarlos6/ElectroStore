package mx.unam.fi.sosa.electrostore;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import mx.unam.fi.sosa.electrostore.utilidades.utilidades;

public class Editar extends AppCompatActivity {

    Spinner comboCategorias;
    int posicion;
    EditText campoValor, campoCantidad;
    ConexionSQLiteHelper conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        comboCategorias=findViewById(R.id.spinner_categorias);
        campoValor=(EditText)findViewById(R.id.edtValor);
        campoCantidad=(EditText)findViewById(R.id.edtCantidad);

        conexion=new ConexionSQLiteHelper(getApplicationContext(),"bd_componentes",null,1 );

        ArrayAdapter<CharSequence>adapterSpinner=ArrayAdapter.createFromResource(this,R.array.combo_categorias,android.R.layout.simple_spinner_item);
        comboCategorias.setAdapter(adapterSpinner);

        comboCategorias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    Toast.makeText(parent.getContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
                }
                posicion=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAñadir:
                switch (posicion) {
                    case 0:
                        Toast.makeText(getApplicationContext(),"Seleccione una categoria",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        AñadirResistencia();
                        break;
                    case 2:
                        AñadirCapacitor();
                        break;
                    case 3:
                        AñadirPotenciometros();
                        break;
                    case 4:
                        AñadirDiodos();
                        break;
                    case 5:
                        AñadirLEDs();
                        break;
                    case 6:
                        AñadirTransistores();
                        break;
                    case 7:
                        AñadirIntegrados();
                        break;
                    case 8:
                        AñadirCables();
                        break;
                    case 9:
                        AñadirOtros();
                        break;
                }
                break;
            case R.id.btnActualizar:
                switch (posicion) {
                    case 0:
                        Toast.makeText(getApplicationContext(),"Seleccione una categoria",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        ActualizarResistencia();
                        break;
                    case 2:
                        ActualizarCapacitor();
                        break;
                    case 3:
                        ActualizarPotenciometros();
                        break;
                    case 4:
                        ActualizarDiodos();
                        break;
                    case 5:
                        ActualizarLEDs();
                        break;
                    case 6:
                        ActualizarTransistores();
                        break;
                    case 7:
                        ActualizarIntegrados();
                        break;
                    case 8:
                        ActualizarCables();
                        break;
                    case 9:
                        ActualizarOtros();
                        break;
                }
                break;
            case R.id.btnEliminar:
                switch (posicion) {
                    case 0:
                        Toast.makeText(getApplicationContext(),"Seleccione una categoria",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        EliminarResistencia();
                        break;
                    case 2:
                        EliminarCapacitor();
                        break;
                    case 3:
                        EliminarPotenciometros();
                        break;
                    case 4:
                        EliminarDiodos();
                        break;
                    case 5:
                        EliminarLEDs();
                        break;
                    case 6:
                        EliminarTransistores();
                        break;
                    case 7:
                        EliminarIntegrados();
                        break;
                    case 8:
                        EliminarCables();
                        break;
                    case 9:
                        EliminarOtros();
                        break;
                }
                break;
            case R.id.btnRegresar:
                Intent miIntent =new Intent(Editar.this,MainActivity.class);
                startActivity(miIntent);
                break;
        }
    }

    private void EliminarOtros() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        db.delete(utilidades.TABLA_OTROS,utilidades.CAMPO_VALOR_Otr+"=?", new String[]{campoValor.getText().toString()});
        Toast.makeText(getApplicationContext(),"Se ha eliminado",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void EliminarCables() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        db.delete(utilidades.TABLA_CABLES,utilidades.CAMPO_VALOR_Cab+"=?", new String[]{campoValor.getText().toString()});
        Toast.makeText(getApplicationContext(),"Se ha eliminado",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void EliminarIntegrados() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        db.delete(utilidades.TABLA_INTEGRADOS,utilidades.CAMPO_VALOR_Int+"=?", new String[]{campoValor.getText().toString()});
        Toast.makeText(getApplicationContext(),"Se ha eliminado",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void EliminarTransistores() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        db.delete(utilidades.TABLA_TRANSISTORES,utilidades.CAMPO_VALOR_Tra+"=?", new String[]{campoValor.getText().toString()});
        Toast.makeText(getApplicationContext(),"Se ha eliminado",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void EliminarLEDs() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        db.delete(utilidades.TABLA_LEDS,utilidades.CAMPO_VALOR_Led+"=?", new String[]{campoValor.getText().toString()});
        Toast.makeText(getApplicationContext(),"Se ha eliminado",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void EliminarDiodos() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        db.delete(utilidades.TABLA_DIODOS,utilidades.CAMPO_VALOR_Dio+"=?", new String[]{campoValor.getText().toString()});
        Toast.makeText(getApplicationContext(),"Se ha eliminado",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void EliminarPotenciometros() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        db.delete(utilidades.TABLA_POTENCIOMETROS,utilidades.CAMPO_VALOR_Pot+"=?", new String[]{campoValor.getText().toString()});
        Toast.makeText(getApplicationContext(),"Se ha eliminado",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void EliminarCapacitor() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        db.delete(utilidades.TABLA_CAPACITORES,utilidades.CAMPO_VALOR_Cap+"=?", new String[]{campoValor.getText().toString()});
        Toast.makeText(getApplicationContext(),"Se ha eliminado",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void ActualizarOtros() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(utilidades.CAMPO_CANTIDAD_Otr,campoCantidad.getText().toString());
        db.update(utilidades.TABLA_OTROS,values,utilidades.CAMPO_VALOR_Otr+"=?", new String[]{campoValor.getText().toString()});
        Toast.makeText(getApplicationContext(),"Se ha actualizado la cantidad",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void ActualizarCables() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(utilidades.CAMPO_CANTIDAD_Cab,campoCantidad.getText().toString());
        db.update(utilidades.TABLA_CABLES,values,utilidades.CAMPO_VALOR_Cab+"=?", new String[]{campoValor.getText().toString()});
        Toast.makeText(getApplicationContext(),"Se ha actualizado la cantidad",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void ActualizarIntegrados() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(utilidades.CAMPO_CANTIDAD_Int,campoCantidad.getText().toString());
        db.update(utilidades.TABLA_INTEGRADOS,values,utilidades.CAMPO_VALOR_Int+"=?", new String[]{campoValor.getText().toString()});
        Toast.makeText(getApplicationContext(),"Se ha actualizado la cantidad",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void ActualizarTransistores() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(utilidades.CAMPO_CANTIDAD_Tra,campoCantidad.getText().toString());
        db.update(utilidades.TABLA_TRANSISTORES,values,utilidades.CAMPO_VALOR_Tra+"=?", new String[]{campoValor.getText().toString()});
        Toast.makeText(getApplicationContext(),"Se ha actualizado la cantidad",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void ActualizarLEDs() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(utilidades.CAMPO_CANTIDAD_Led,campoCantidad.getText().toString());
        db.update(utilidades.TABLA_LEDS,values,utilidades.CAMPO_VALOR_Led+"=?", new String[]{campoValor.getText().toString()});
        Toast.makeText(getApplicationContext(),"Se ha actualizado la cantidad",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void ActualizarDiodos() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(utilidades.CAMPO_CANTIDAD_Dio,campoCantidad.getText().toString());
        db.update(utilidades.TABLA_DIODOS,values,utilidades.CAMPO_VALOR_Dio+"=?", new String[]{campoValor.getText().toString()});
        Toast.makeText(getApplicationContext(),"Se ha actualizado la cantidad",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void ActualizarPotenciometros() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(utilidades.CAMPO_CANTIDAD_Pot,campoCantidad.getText().toString());
        db.update(utilidades.TABLA_POTENCIOMETROS,values,utilidades.CAMPO_VALOR_Pot+"=?", new String[]{campoValor.getText().toString()});
        Toast.makeText(getApplicationContext(),"Se ha actualizado la cantidad",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void ActualizarCapacitor() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(utilidades.CAMPO_CANTIDAD_Cap,campoCantidad.getText().toString());
        db.update(utilidades.TABLA_CAPACITORES,values,utilidades.CAMPO_VALOR_Cap+"=?", new String[]{campoValor.getText().toString()});
        Toast.makeText(getApplicationContext(),"Se ha actualizado la cantidad",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void AñadirOtros() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        String insert="INSERT INTO "+ utilidades.TABLA_OTROS+" ("+utilidades.CAMPO_VALOR_Otr+","+utilidades.CAMPO_CANTIDAD_Otr+")"+" VALUES ('"+campoValor.getText().toString()+"', '"+campoCantidad.getText().toString()+"')";
        db.execSQL(insert);
        Toast.makeText(getApplicationContext(),"Se ha añadido",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void AñadirCables() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        String insert="INSERT INTO "+ utilidades.TABLA_CABLES+" ("+utilidades.CAMPO_VALOR_Cab+","+utilidades.CAMPO_CANTIDAD_Cab+")"+" VALUES ('"+campoValor.getText().toString()+"', '"+campoCantidad.getText().toString()+"')";
        db.execSQL(insert);
        Toast.makeText(getApplicationContext(),"Se ha añadido",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void AñadirIntegrados() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        String insert="INSERT INTO "+ utilidades.TABLA_INTEGRADOS+" ("+utilidades.CAMPO_VALOR_Int+","+utilidades.CAMPO_CANTIDAD_Int+")"+" VALUES ('"+campoValor.getText().toString()+"', '"+campoCantidad.getText().toString()+"')";
        db.execSQL(insert);
        Toast.makeText(getApplicationContext(),"Se ha añadido",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void AñadirTransistores() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        String insert="INSERT INTO "+ utilidades.TABLA_TRANSISTORES+" ("+utilidades.CAMPO_VALOR_Tra+","+utilidades.CAMPO_CANTIDAD_Tra+")"+" VALUES ('"+campoValor.getText().toString()+"', '"+campoCantidad.getText().toString()+"')";
        db.execSQL(insert);
        Toast.makeText(getApplicationContext(),"Se ha añadido",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void AñadirLEDs() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        String insert="INSERT INTO "+ utilidades.TABLA_LEDS+" ("+utilidades.CAMPO_VALOR_Led+","+utilidades.CAMPO_CANTIDAD_Led+")"+" VALUES ('"+campoValor.getText().toString()+"', '"+campoCantidad.getText().toString()+"')";
        db.execSQL(insert);
        Toast.makeText(getApplicationContext(),"Se ha añadido",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void AñadirDiodos() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        String insert="INSERT INTO "+ utilidades.TABLA_DIODOS+" ("+utilidades.CAMPO_VALOR_Dio+","+utilidades.CAMPO_CANTIDAD_Dio+")"+" VALUES ('"+campoValor.getText().toString()+"', '"+campoCantidad.getText().toString()+"')";
        db.execSQL(insert);
        Toast.makeText(getApplicationContext(),"Se ha añadido",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void AñadirPotenciometros() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        String insert="INSERT INTO "+ utilidades.TABLA_POTENCIOMETROS+" ("+utilidades.CAMPO_VALOR_Pot+","+utilidades.CAMPO_CANTIDAD_Pot+")"+" VALUES ('"+campoValor.getText().toString()+"', '"+campoCantidad.getText().toString()+"')";
        db.execSQL(insert);
        Toast.makeText(getApplicationContext(),"Se ha añadido",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void AñadirCapacitor() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        String insert="INSERT INTO "+ utilidades.TABLA_CAPACITORES+" ("+utilidades.CAMPO_VALOR_Cap+","+utilidades.CAMPO_CANTIDAD_Cap+")"+" VALUES ('"+campoValor.getText().toString()+"', '"+campoCantidad.getText().toString()+"')";
        db.execSQL(insert);
        Toast.makeText(getApplicationContext(),"Se ha añadido",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void EliminarResistencia() {
        SQLiteDatabase db=conexion.getWritableDatabase();
        db.delete(utilidades.TABLA_RESISTENCIAS,utilidades.CAMPO_VALOR_Res+"=?", new String[]{campoValor.getText().toString()});
        Toast.makeText(getApplicationContext(),"Se ha eliminado",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void ActualizarResistencia() {
        //ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this,"bd_componentes",null,1);
        SQLiteDatabase db=conexion.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(utilidades.CAMPO_CANTIDAD_Res,campoCantidad.getText().toString());
        db.update(utilidades.TABLA_RESISTENCIAS,values,utilidades.CAMPO_VALOR_Res+"=?", new String[]{campoValor.getText().toString()});
        Toast.makeText(getApplicationContext(),"Se ha actualizado la cantidad",Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void AñadirResistencia() {
        //ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this,"bd_componentes",null,1);
        SQLiteDatabase db=conexion.getWritableDatabase();
        String insert="INSERT INTO "+ utilidades.TABLA_RESISTENCIAS+" ("+utilidades.CAMPO_VALOR_Res+","+utilidades.CAMPO_CANTIDAD_Res+")"+" VALUES ('"+campoValor.getText().toString()+"', '"+campoCantidad.getText().toString()+"')";
        db.execSQL(insert);
        Toast.makeText(getApplicationContext(),"Se ha añadido",Toast.LENGTH_SHORT).show();
        db.close();
    }


}
