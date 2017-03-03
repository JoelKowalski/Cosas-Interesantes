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
 * Created by Usuario on 06/02/2017.
 */
public class RecycleDetalleLinea extends RecyclerView.Adapter<DetalleLineaVewHolder> {

    public List<Estacion> listaestaciones;
    Context context;
    RecyclerView mRecycleView;

    public RecycleDetalleLinea(List<Estacion> listaestaciones, Context c,RecyclerView mRecycle) {

        this.listaestaciones=listaestaciones;
        this.context=c;
        this.mRecycleView=mRecycle;

    }


    @Override
    public DetalleLineaVewHolder onCreateViewHolder(ViewGroup parent,int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_detallelinea, parent, false);
        DetalleLineaVewHolder vh = new DetalleLineaVewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int pos = mRecycleView.getChildAdapterPosition(v);




            }

        });
        return vh;
    }



    @Override
    public void onBindViewHolder(DetalleLineaVewHolder holder, int position) {
        holder.nombre.setText(listaestaciones.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return listaestaciones.size();
    }



}