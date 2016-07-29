package com.example.usuario.joelfernandezpractica3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Date;
import java.util.List;

/**
 * Created by Usuario on 26/07/2016.
 */
public class AdaptadorRecycleCatalogo extends RecyclerView.Adapter<MyViewHolderCatalogo> {
    public List<Producto> mDataset;
    public List<Bitmap> mDatasetImage;
    public HistoricoModelo hm;
    DataBase database;
    RecyclerView mRecycleView;
Context context;
    public AdaptadorRecycleCatalogo(List<Bitmap> myDatasetImage, List<Producto> myDataset, View v, Context c) {
        mDatasetImage=myDatasetImage;
        mDataset = myDataset;
        mRecycleView= (RecyclerView) v;
        this.context=c;

    }


    @Override
    public MyViewHolderCatalogo onCreateViewHolder(ViewGroup parent,int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_catalogo, parent, false);
        MyViewHolderCatalogo vh = new MyViewHolderCatalogo(v);
        v.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                java.util.Date fecha = new Date();
                int pos = recyclerView().getChildAdapterPosition(v);
                hm=new HistoricoModelo(String.valueOf(fecha),damefila(pos).getNombre());
                database=new DataBase(context, "MiDB", null, 1);
                database.insertarHistorico(hm);
                Intent intent = new Intent(context, DetalleCatalogo.class);
                Producto producto = new Producto(damefila(pos).getIntro(), damefila(pos).getImagen(), damefila(pos).getNombre(), damefila(pos).getPrecio(), damefila(pos).getUnidades(), damefila(pos).getDescripcion(), damefila(pos).getCategoria());
                intent.putExtra("clave", producto);
                context.startActivity(intent);
            }

        });
        return vh;
    }



    @Override
    public void onBindViewHolder(MyViewHolderCatalogo holder, int position) {
        holder.nombre.setText(mDataset.get(position).getNombre());
        holder.intro.setText(mDataset.get(position).getIntro());
        //holder.imagenproducto.setImageBitmap(mDatasetImage.get(position));



    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
    public Producto damefila(int posicion){
        return this.mDataset.get(posicion);
    }
    public RecyclerView recyclerView(){
        return this.mRecycleView;
    }

}