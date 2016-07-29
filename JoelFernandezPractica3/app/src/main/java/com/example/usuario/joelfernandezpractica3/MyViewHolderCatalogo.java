package com.example.usuario.joelfernandezpractica3;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Usuario on 27/07/2016.
 */
public class MyViewHolderCatalogo extends RecyclerView.ViewHolder  implements View.OnClickListener {
    public CardView mCardView;

    ImageView imagenproducto;
    public TextView nombre, intro;
    public MyViewHolderCatalogo(View v) {
        super(v);
        v.setOnClickListener(this);
        imagenproducto=(ImageView)v.findViewById(R.id.imagen_master);
        mCardView = (CardView) v.findViewById(R.id.card_view);
        nombre = (TextView) v.findViewById(R.id.tv_nombre);
        intro = (TextView) v.findViewById(R.id.tv_intro);

    }
    @Override
    public void onClick(View v) {

        Log.d("onClick ", String.valueOf(getPosition()));


    }
}