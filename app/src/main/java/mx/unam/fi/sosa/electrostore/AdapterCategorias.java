package mx.unam.fi.sosa.electrostore;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterCategorias extends RecyclerView.Adapter<AdapterCategorias.ViewHolderCategorias> implements View.OnClickListener{

    ArrayList<CategoriasVo> listaCategorias;
    private View.OnClickListener listener;

    public AdapterCategorias(ArrayList<CategoriasVo> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    @NonNull
    @Override
    public AdapterCategorias.ViewHolderCategorias onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_categorias,null,false);
        view.setOnClickListener(this);
        return new ViewHolderCategorias(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCategorias.ViewHolderCategorias holder, int position) {
        holder.Etinombre.setText(listaCategorias.get(position).getNombre());
        holder.imagen.setImageResource(listaCategorias.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return listaCategorias.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderCategorias extends RecyclerView.ViewHolder {
        TextView Etinombre;
        ImageView imagen;

        public ViewHolderCategorias(View itemView) {
            super(itemView);
            Etinombre= (TextView) itemView.findViewById(R.id.CategoriaNombre);
            imagen=(ImageView) itemView.findViewById(R.id.CategoriaImagen);
        }
    }
}
