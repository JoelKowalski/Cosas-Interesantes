package com.example.usuario.joelfernandezpractica3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Usuario on 29/07/2016.
 */

public class AdaptadorRecycleHistorico extends RecyclerView.Adapter<MyViewHolderHistorico> {
    public List<HistoricoModelo> mDataset;
    RecyclerView mRecycleView;
    Context context;
    public AdaptadorRecycleHistorico( List<HistoricoModelo> myDataset, View v, Context c) {

        mDataset = myDataset;
        mRecycleView= (RecyclerView) v;
        this.context=c;

    }


    @Override
    public MyViewHolderHistorico onCreateViewHolder(ViewGroup parent,int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_historico, parent, false);
        MyViewHolderHistorico vh = new MyViewHolderHistorico(v);
        v.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }

        });
        return vh;
    }



    @Override
    public void onBindViewHolder(MyViewHolderHistorico holder, int position) {
        holder.nombre.setText(mDataset.get(position).getNombre());
        holder.fecha.setText(mDataset.get(position).getFecha());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}