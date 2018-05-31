package mx.unam.fi.sosa.electrostore;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.unam.fi.sosa.electrostore.entidades.Cables;
import mx.unam.fi.sosa.electrostore.entidades.Capacitores;
import mx.unam.fi.sosa.electrostore.entidades.Diodos;
import mx.unam.fi.sosa.electrostore.entidades.Integrados;
import mx.unam.fi.sosa.electrostore.entidades.LEDs;
import mx.unam.fi.sosa.electrostore.entidades.Otros;
import mx.unam.fi.sosa.electrostore.entidades.Potenciometros;
import mx.unam.fi.sosa.electrostore.entidades.Resistencias;
import mx.unam.fi.sosa.electrostore.entidades.Transistores;
import mx.unam.fi.sosa.electrostore.utilidades.utilidades;

public class Componentes extends AppCompatActivity {

    ListView listViewComponentes;
    TextView txtCategoria;
    Button btnEditar;
    ArrayList<Resistencias> listaResistencias;
    ArrayList<Capacitores> listaCapacitores;
    ArrayList<Potenciometros> listaPotenciometros;
    ArrayList<Diodos> listaDiodos;
    ArrayList<LEDs> listaLEDs;
    ArrayList<Transistores> listaTransistores;
    ArrayList<Integrados> listaIntegrados;
    ArrayList<Cables> listaCables;
    ArrayList<Otros> listaOtros;
    ArrayList<String> listaComponentes;
    ConexionSQLiteHelper conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_componentes);
        conexion=new ConexionSQLiteHelper(getApplicationContext(),"bd_componentes",null,1);
        listViewComponentes=(ListView)findViewById(R.id.Componentes);
        txtCategoria=(TextView)findViewById(R.id.txtCategoria);
        btnEditar=(Button) findViewById(R.id.btnEditar);

        txtCategoria.setText(MainActivity.categoria);

        switch (MainActivity.categoria){
            case "Resistencias":
                consultarListaResistencias();
                break;
            case "Capacitores":
                consultarListaCapacitores();
                break;
            case "Potenciómetros":
                consultarListaPotenciometros();
                break;
            case "Diodos":
                consultarListaDiodos();
                break;
            case "LEDs":
                consultarListaLEDs();
                break;
            case "Transistores":
                consultarListaTransistores();
                break;
            case "C. Integrados":
                consultarListaIntegrados();
                break;
            case "Cables":
                consultarListaCables();
                break;
            case "Otros":
                consultarListaOtros();
                break;
        }


        listViewComponentes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void consultarListaOtros() {
        SQLiteDatabase db =conexion.getReadableDatabase();
        Otros otro = null;
        listaOtros=new ArrayList<Otros>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_OTROS,null);
        while (cursor.moveToNext()){
            otro=new Otros();
            otro.setValor(cursor.getString(0));
            otro.setCantidad(cursor.getString(1));
            listaOtros.add(otro);
        }
        listaComponentes = new ArrayList<String>();
        for (int i=0; i<listaOtros.size();i++){
            listaComponentes.add(listaOtros.get(i).getValor()+" - "+listaOtros.get(i).getCantidad());
        }
        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaComponentes);
        listViewComponentes.setAdapter(adaptador);
    }

    private void consultarListaCables() {
        SQLiteDatabase db =conexion.getReadableDatabase();
        Cables cable = null;
        listaCables=new ArrayList<Cables>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_CABLES,null);
        while (cursor.moveToNext()){
            cable=new Cables();
            cable.setValor(cursor.getString(0));
            cable.setCantidad(cursor.getString(1));
            listaCables.add(cable);
        }
        listaComponentes = new ArrayList<String>();
        for (int i=0; i<listaCables.size();i++){
            listaComponentes.add(listaCables.get(i).getValor()+" Calibre - "+listaCables.get(i).getCantidad());
        }
        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaComponentes);
        listViewComponentes.setAdapter(adaptador);
    }

    private void consultarListaIntegrados() {
        SQLiteDatabase db =conexion.getReadableDatabase();
        Integrados integrado = null;
        listaIntegrados=new ArrayList<Integrados>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_INTEGRADOS,null);
        while (cursor.moveToNext()){
            integrado=new Integrados();
            integrado.setValor(cursor.getString(0));
            integrado.setCantidad(cursor.getString(1));
            listaIntegrados.add(integrado);
        }
        listaComponentes = new ArrayList<String>();
        for (int i=0; i<listaIntegrados.size();i++){
            listaComponentes.add(listaIntegrados.get(i).getValor()+" - "+listaIntegrados.get(i).getCantidad());
        }
        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaComponentes);
        listViewComponentes.setAdapter(adaptador);
    }

    private void consultarListaTransistores() {
        SQLiteDatabase db =conexion.getReadableDatabase();
        Transistores transistor = null;
        listaTransistores=new ArrayList<Transistores>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_TRANSISTORES,null);
        while (cursor.moveToNext()){
            transistor=new Transistores();
            transistor.setValor(cursor.getString(0));
            transistor.setCantidad(cursor.getString(1));
            listaTransistores.add(transistor);
        }
        listaComponentes = new ArrayList<String>();
        for (int i=0; i<listaTransistores.size();i++){
            listaComponentes.add(listaTransistores.get(i).getValor()+" - "+listaTransistores.get(i).getCantidad());
        }
        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaComponentes);
        listViewComponentes.setAdapter(adaptador);
    }

    private void consultarListaLEDs() {
        SQLiteDatabase db =conexion.getReadableDatabase();
        LEDs LED = null;
        listaLEDs=new ArrayList<LEDs>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_LEDS,null);
        while (cursor.moveToNext()){
            LED=new LEDs();
            LED.setValor(cursor.getString(0));
            LED.setCantidad(cursor.getString(1));
            listaLEDs.add(LED);
        }
        listaComponentes = new ArrayList<String>();
        for (int i=0; i<listaLEDs.size();i++){
            listaComponentes.add(listaLEDs.get(i).getValor()+" - "+listaLEDs.get(i).getCantidad());
        }
        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaComponentes);
        listViewComponentes.setAdapter(adaptador);
    }

    private void consultarListaDiodos() {
        SQLiteDatabase db =conexion.getReadableDatabase();
        Diodos diodo = null;
        listaDiodos=new ArrayList<Diodos>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_DIODOS,null);
        while (cursor.moveToNext()){
            diodo=new Diodos();
            diodo.setValor(cursor.getString(0));
            diodo.setCantidad(cursor.getString(1));
            listaDiodos.add(diodo);
        }
        listaComponentes = new ArrayList<String>();
        for (int i=0; i<listaDiodos.size();i++){
            listaComponentes.add(listaDiodos.get(i).getValor()+" - "+listaDiodos.get(i).getCantidad());
        }
        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaComponentes);
        listViewComponentes.setAdapter(adaptador);
    }

    private void consultarListaPotenciometros() {
        SQLiteDatabase db =conexion.getReadableDatabase();
        Potenciometros potenciometro = null;
        listaPotenciometros=new ArrayList<Potenciometros>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_POTENCIOMETROS,null);
        while (cursor.moveToNext()){
            potenciometro=new Potenciometros();
            potenciometro.setValor(cursor.getString(0));
            potenciometro.setCantidad(cursor.getString(1));
            listaPotenciometros.add(potenciometro);
        }
        listaComponentes = new ArrayList<String>();
        for (int i=0; i<listaPotenciometros.size();i++){
            listaComponentes.add(listaPotenciometros.get(i).getValor()+" kΩ - "+listaPotenciometros.get(i).getCantidad());
        }
        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaComponentes);
        listViewComponentes.setAdapter(adaptador);
    }

    private void consultarListaCapacitores() {
        SQLiteDatabase db =conexion.getReadableDatabase();
        Capacitores capacitor = null;
        listaCapacitores=new ArrayList<Capacitores>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_CAPACITORES,null);
        while (cursor.moveToNext()){
            capacitor=new Capacitores();
            capacitor.setValor(cursor.getString(0));
            capacitor.setCantidad(cursor.getString(1));
            listaCapacitores.add(capacitor);
        }
        listaComponentes = new ArrayList<String>();
        for (int i=0; i<listaCapacitores.size();i++){
            listaComponentes.add(listaCapacitores.get(i).getValor()+" F - "+listaCapacitores.get(i).getCantidad());
        }
        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaComponentes);
        listViewComponentes.setAdapter(adaptador);
    }

    private void consultarListaResistencias() {
        SQLiteDatabase db =conexion.getReadableDatabase();
        Resistencias resistencia = null;
        listaResistencias=new ArrayList<Resistencias>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ utilidades.TABLA_RESISTENCIAS,null);
        while (cursor.moveToNext()){
            resistencia=new Resistencias();
            resistencia.setValor(cursor.getString(0));
            resistencia.setCantidad(cursor.getString(1));
            listaResistencias.add(resistencia);
        }
        listaComponentes = new ArrayList<String>();
        for (int i=0; i<listaResistencias.size();i++){
            listaComponentes.add(listaResistencias.get(i).getValor()+" Ω - "+listaResistencias.get(i).getCantidad());
        }
        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaComponentes);
        listViewComponentes.setAdapter(adaptador);
    }

    public void onClick(View view) {
        Intent miIntent=new Intent(Componentes.this,Editar.class);
        startActivity(miIntent);
    }
}
