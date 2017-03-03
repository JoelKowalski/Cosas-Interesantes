package ubahn.joel.ubahnproject.control;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import ubahn.joel.ubahnproject.R;

/**
 * Created by Usuario on 06/02/2017.
 */
public class DetalleLineaVewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
    public CardView mCardView;


    public TextView nombre;
    public DetalleLineaVewHolder(View v) {
        super(v);
        v.setOnClickListener(this);
        mCardView = (CardView) v.findViewById(R.id.card_view_detalle);
        nombre = (TextView) v.findViewById(R.id.tv_nombre);


    }
    @Override
    public void onClick(View v) {

        // Log.d("onClick ", String.valueOf(getPosition()));


    }
}