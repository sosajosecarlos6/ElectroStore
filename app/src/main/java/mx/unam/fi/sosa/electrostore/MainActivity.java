package mx.unam.fi.sosa.electrostore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<CategoriasVo> listaCategorias;
    RecyclerView recyclerCategorias;
    public static String categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaCategorias=new ArrayList<>();
        recyclerCategorias=findViewById(R.id.Categorias);
        recyclerCategorias.setLayoutManager(new GridLayoutManager(this,2));

        LlenarCategorias();

        AdapterCategorias adapter=new AdapterCategorias(listaCategorias);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),listaCategorias.get(recyclerCategorias.getChildAdapterPosition(view)).getNombre(),Toast.LENGTH_SHORT).show();
                categoria=listaCategorias.get(recyclerCategorias.getChildAdapterPosition(view)).getNombre();
                Intent miIntent = new Intent(MainActivity.this, Componentes.class);
                startActivity(miIntent);
            }
        });

        recyclerCategorias.setAdapter(adapter);
    }

    private void LlenarCategorias() {
        listaCategorias.add(new CategoriasVo("Resistencias",R.drawable.resistencia));
        listaCategorias.add(new CategoriasVo("Capacitores",R.drawable.capacitor));
        listaCategorias.add(new CategoriasVo("Potenciómetros",R.drawable.potenciometro));
        listaCategorias.add(new CategoriasVo("Diodos",R.drawable.diodo));
        listaCategorias.add(new CategoriasVo("LEDs",R.drawable.led));
        listaCategorias.add(new CategoriasVo("Transistores",R.drawable.transistor));
        listaCategorias.add(new CategoriasVo("C. Integrados",R.drawable.integrado));
        listaCategorias.add(new CategoriasVo("Cables",R.drawable.cables));
        listaCategorias.add(new CategoriasVo("Otros",R.drawable.otros));
    }
}
