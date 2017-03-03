package ubahn.joel.ubahnproject.control;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ubahn.joel.ubahnproject.R;

/**
 * Created by Usuario on 04/02/2017.
 */
public class LineasViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
    public CardView mCardView;


    public TextView origencabecera,destinocabcera,linea;
    public LineasViewHolder(View v) {
        super(v);
        v.setOnClickListener(this);

        mCardView = (CardView) v.findViewById(R.id.card_view_linea);
        origencabecera = (TextView) v.findViewById(R.id.textViewcabecera1);
        destinocabcera = (TextView) v.findViewById(R.id.textViewcabecera2);
        linea = (TextView) v.findViewById(R.id.textViewlinea);


    }
    @Override
    public void onClick(View v) {

        // Log.d("onClick ", String.valueOf(getPosition()));


    }
}