package mx.unam.fi.sosa.electrostore;

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

public class Componentes extends AppCompatActivity {

    ListView listaComponentes;
    TextView txtCategoria;
    Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_componentes);
        listaComponentes=(ListView)findViewById(R.id.Componentes);
        txtCategoria=(TextView)findViewById(R.id.txtCategoria);
        btnEditar=(Button) findViewById(R.id.btnEditar);

        //Mostrar diálogo cuando se apriete editar
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Componentes.this);
                View view =getLayoutInflater().inflate(R.layout.dialogo_editar, null);
                //EditText edtValor = (EditText) view.findViewById(R.id.edtValor);
                //EditText edtCantidad = (EditText) view.findViewById(R.id.edtCantidad);
                //Button btnEditar = (Button) view.findViewById(R.id.btnEditar);
                mBuilder.setView(view);
                AlertDialog dialogoEditar = mBuilder.create();
                dialogoEditar.show();
            }
        });

        txtCategoria.setText(MainActivity.categoria);
        //Configurar El arrayList para que obtenga la informacion de las bases de datos
        ArrayList<String> listaElementos=new ArrayList<>();
        listaElementos.add("Componente 1");
        listaElementos.add("Componente 2");
        listaElementos.add("Componente 3");
        listaElementos.add("Componente 4");
        listaElementos.add("Componente 5");

        //Configurar adaptador para que llene según lo que se presionó
        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaElementos);
        listaComponentes.setAdapter(adaptador);

        listaComponentes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
