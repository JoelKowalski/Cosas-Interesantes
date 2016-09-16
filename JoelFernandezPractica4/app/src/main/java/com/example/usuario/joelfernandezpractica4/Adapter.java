package com.example.usuario.joelfernandezpractica4;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Usuario on 16/09/2016.
 */
public class Adapter extends BaseAdapter {
    private Context context;
    private List<Recado> recados;

    public Adapter(Context c, List<Recado> recados) {
        context = c;
        this.recados = recados;

    }

    public int getCount() {
        return recados.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;

        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_item, parent, false);
        }

        // Set data into the view.
        TextView tvfecha = (TextView) rowView.findViewById(R.id.tvTitle);
        TextView tvnombre = (TextView) rowView.findViewById(R.id.textView);
        TextView tvtelefono = (TextView) rowView.findViewById(R.id.textView2);
        TextView tventrega = (TextView) rowView.findViewById(R.id.textView3);
        TextView tvrecogida = (TextView) rowView.findViewById(R.id.textView4);
        TextView tvdescripcion = (TextView) rowView.findViewById(R.id.textView5);
        TextView tvfechamax = (TextView) rowView.findViewById(R.id.textView6);

        tvfecha.setText(recados.get(position).getFecha_hora());
        tvnombre.setText(recados.get(position).getNombre_cliente());
        tvtelefono.setText(recados.get(position).getTelefono());
        tventrega.setText(recados.get(position).getDireccion_entrega());
        tvrecogida.setText(recados.get(position).getDireccion_recogida());
        tvdescripcion.setText(recados.get(position).getDescripcion());
        tvfechamax.setText(recados.get(position).getFecha_hora_maxima());



        return rowView;
    }
}