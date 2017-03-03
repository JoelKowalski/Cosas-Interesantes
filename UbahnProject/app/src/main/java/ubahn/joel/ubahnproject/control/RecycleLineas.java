package ubahn.joel.ubahnproject.control;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import ubahn.joel.ubahnproject.R;
import ubahn.joel.ubahnproject.model.Estacion;
import ubahn.joel.ubahnproject.remote.AsyncTaskDetalleLinea;
import ubahn.joel.ubahnproject.view.DetalleLinea;


/**
 * Created by Usuario on 04/02/2017.
 */
public class RecycleLineas extends RecyclerView.Adapter<LineasViewHolder> {

    public List<String> nombreestaciones;
    Context context;
    RecyclerView mRecycleView;
    ArrayList<Estacion> listaestaciones;
    public RecycleLineas(List<String> listaestaciones, Context c,RecyclerView mRecycle) {

        this.nombreestaciones=listaestaciones;
        this.context=c;
        this.mRecycleView=mRecycle;

    }


    @Override
    public LineasViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_lineas, parent, false);
        LineasViewHolder vh = new LineasViewHolder(v);
        listaestaciones=new ArrayList<>();
        v.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int pos = mRecycleView.getChildAdapterPosition(v);
                try {
                    listaestaciones= (ArrayList<Estacion>)new AsyncTaskDetalleLinea(context).execute(pos).get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                Intent intent=new Intent(context, DetalleLinea.class);
                intent.putExtra("estaciones",listaestaciones);
                context.startActivity(intent);
            }

        });
        return vh;
    }



    @Override
    public void onBindViewHolder(LineasViewHolder holder, int position) {
        switch(position){
            case 0:
                holder.origencabecera.setText(nombreestaciones.get(position));
                holder.destinocabcera.setText(nombreestaciones.get(position+1));
                holder.linea.setText(mRecycleView.getResources().getString(R.string.linea) + " " + 1);
                holder.linea.setTextColor(mRecycleView.getResources().getColor(R.color.linea1));
                break;
            case 1:
                holder.origencabecera.setText(nombreestaciones.get(position+1));
                holder.destinocabcera.setText(nombreestaciones.get(position+2));
                holder.linea.setText(mRecycleView.getResources().getString(R.string.linea)+" "+2);
                holder.linea.setTextColor(mRecycleView.getResources().getColor(R.color.linea2));
                break;
            case 2:
                holder.origencabecera.setText(nombreestaciones.get(position+2));
                holder.destinocabcera.setText(nombreestaciones.get(position+3));
                holder.linea.setText(mRecycleView.getResources().getString(R.string.linea)+" "+3);
                holder.linea.setTextColor(mRecycleView.getResources().getColor(R.color.linea3));
                break;
            case 3:
                holder.origencabecera.setText(nombreestaciones.get(position+3));
                holder.destinocabcera.setText(nombreestaciones.get(position+4));
                holder.linea.setText(mRecycleView.getResources().getString(R.string.linea)+" "+4);
                holder.linea.setTextColor(mRecycleView.getResources().getColor(R.color.linea4));
                break;
            case 4:
                holder.origencabecera.setText(nombreestaciones.get(position+4));
                holder.destinocabcera.setText(nombreestaciones.get(position+5));
                holder.linea.setText(mRecycleView.getResources().getString(R.string.linea)+" "+5);
                holder.linea.setTextColor(mRecycleView.getResources().getColor(R.color.linea5));
                break;
            case 5:
                holder.origencabecera.setText(nombreestaciones.get(position+5));
                holder.destinocabcera.setText(nombreestaciones.get(position+6));
                holder.linea.setText(mRecycleView.getResources().getString(R.string.linea)+" "+6);
                holder.linea.setTextColor(mRecycleView.getResources().getColor(R.color.linea6));
                break;
            case 6:
                holder.origencabecera.setText(nombreestaciones.get(position+6));
                holder.destinocabcera.setText(nombreestaciones.get(position+7));
                holder.linea.setText(mRecycleView.getResources().getString(R.string.linea)+" "+7);
                holder.linea.setTextColor(mRecycleView.getResources().getColor(R.color.linea7));
                break;
            case 7:
                holder.origencabecera.setText(nombreestaciones.get(position+7));
                holder.destinocabcera.setText(nombreestaciones.get(position+8));
                holder.linea.setText(mRecycleView.getResources().getString(R.string.linea)+" "+8);
                holder.linea.setTextColor(mRecycleView.getResources().getColor(R.color.linea8));
                break;
            case 8:
                holder.origencabecera.setText(nombreestaciones.get(position+8));
                holder.destinocabcera.setText(nombreestaciones.get(position+9));
                holder.linea.setText(mRecycleView.getResources().getString(R.string.linea)+" "+9);
                holder.linea.setTextColor(mRecycleView.getResources().getColor(R.color.linea9));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return nombreestaciones.size()/2;
    }



}