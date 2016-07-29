package com.example.usuario.joelfernandezpractica3;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Usuario on 29/07/2016.
 */
public class MyViewHolderHistorico extends RecyclerView.ViewHolder  implements View.OnClickListener {
    public CardView mCardView;

    ImageView imagenhistorico;
    public TextView fecha, nombre;
    public MyViewHolderHistorico(View v) {
        super(v);
        v.setOnClickListener(this);
        imagenhistorico = (ImageView) v.findViewById(R.id.imagen_master);
        mCardView = (CardView) v.findViewById(R.id.card_view);
        nombre = (TextView) v.findViewById(R.id.tv_nombreh);
        fecha = (TextView) v.findViewById(R.id.tv_fecha);
    }

    @Override
    public void onClick(View v) {

    }
}
