package com.example.usuario.joelfernandezpractica3;

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
    public TextView nombre, intro,mTextView3,mTextView4;
    public MyViewHolderCatalogo(View v) {
        super(v);
        v.setOnClickListener(this);
        imagenproducto=(ImageView)v.findViewById(R.id.imagen_master);
        mCardView = (CardView) v.findViewById(R.id.card_view);
        nombre = (TextView) v.findViewById(R.id.tv_nombre);
        intro = (TextView) v.findViewById(R.id.tv_intro);
       // mTextView3 = (TextView) v.findViewById(R.id.textView2);
      //  mTextView4 = (TextView) v.findViewById(R.id.textView3);
       // LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mCardView.getLayoutParams();
       // layoutParams.height = 67;
       // RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) layout.getLayoutParams();
      //  params.height =67;
      //  layout.setLayoutParams(params);
     //   intro.setVisibility(View.INVISIBLE);
     //   mTextView3.setVisibility(View.INVISIBLE);
      //  mTextView4.setVisibility(View.INVISIBLE);
    }


    @Override
    public void onClick(View v) {

        Log.d("onClick ", String.valueOf(getPosition()));

      //  intro.setVisibility(View.VISIBLE);
      //  mTextView3.setVisibility(View.VISIBLE);
      //  mTextView4.setVisibility(View.VISIBLE);
       // LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mCardView.getLayoutParams();
     //   layoutParams.height = 400;
     //   RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) layout.getLayoutParams();
     //   params.height = 400;
     //   layout.setLayoutParams(params);

    }
}