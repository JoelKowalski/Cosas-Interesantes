package com.example.usuario.joelfernandezpractica2.Control;

/**
 * Created by Usuario on 27/06/2016.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.usuario.joelfernandezpractica2.Model.Model_Lista;
import com.example.usuario.joelfernandezpractica2.R;

import java.util.List;

public class Adaptador_Lista extends RecyclerView.Adapter<Adaptador_Lista.MyViewHolder> {

    private List<Model_Lista> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView titulo, fecha, cantidad;

        public MyViewHolder(View view) {
            super(view);
            titulo = (TextView) view.findViewById(R.id.titulo);
            fecha = (TextView) view.findViewById(R.id.fecha);
            cantidad = (TextView) view.findViewById(R.id.cantidad);
        }
    }


    public Adaptador_Lista(List<Model_Lista> Array_list) {
        this.list = Array_list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Model_Lista lista = list.get(position);
        holder.titulo.setText(lista.getTitulo());
        holder.fecha.setText(lista.getFecha());
        holder.cantidad.setText(String.valueOf(lista.getCantidad()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}