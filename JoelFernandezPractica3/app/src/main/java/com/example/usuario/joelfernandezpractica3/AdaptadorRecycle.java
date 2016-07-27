package com.example.usuario.joelfernandezpractica3;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Usuario on 26/07/2016.
 */
public class AdaptadorRecycle extends RecyclerView.Adapter<MyViewHolder> {
    public List<Producto> mDataset;
    RecyclerView mRecycleView;

    public AdaptadorRecycle(List<Producto> myDataset,View v) {
        mDataset = myDataset;
        mRecycleView= (RecyclerView) v;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int pos = recyclerView().getChildAdapterPosition(v);
               Log.i("FOHLODC",damefila(pos).getNombre());
                }

        });
        return vh;
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.nombre.setText(mDataset.get(position).getNombre());
        holder.intro.setText(mDataset.get(position).getIntro());



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