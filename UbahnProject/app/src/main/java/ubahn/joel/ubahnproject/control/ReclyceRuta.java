package ubahn.joel.ubahnproject.control;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ubahn.joel.ubahnproject.R;
import ubahn.joel.ubahnproject.model.Estacion;

/**
 * Created by Usuario on 05/02/2017.
 */
public class ReclyceRuta extends RecyclerView.Adapter<RutasViewHolder> {

    public List<String> listaestaciones;
    Context context;
    RecyclerView mRecycleView;

    public ReclyceRuta(List<String> listaestaciones, Context c,RecyclerView mRecycle) {

        this.listaestaciones=listaestaciones;
        this.context=c;
        this.mRecycleView=mRecycle;

    }


    @Override
    public RutasViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_detallelinea, parent, false);
        RutasViewHolder vh = new RutasViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int pos = mRecycleView.getChildAdapterPosition(v);




            }

        });
        return vh;
    }



    @Override
    public void onBindViewHolder(RutasViewHolder holder, int position) {
        holder.nombre.setText(listaestaciones.get(position));
    }

    @Override
    public int getItemCount() {
        return listaestaciones.size();
    }



}