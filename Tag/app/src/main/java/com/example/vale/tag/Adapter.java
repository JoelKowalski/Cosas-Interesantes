package com.example.vale.tag;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Usuario on 29/06/2016.
 */
class AdaptadorTitulares extends ArrayAdapter<Lista_elementos> {
    Estado estado=new Estado();
    Lista_elementos[] datos;
    AdaptadorTitulares(Context context, Lista_elementos[] datos) {
        super(context, R.layout.listitem_titular, datos);
        this.datos=datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View item = convertView;
        ViewHolder holder;

        if (item == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.listitem_titular, null);

            holder = new ViewHolder();
            holder.titulo = (TextView) item.findViewById(R.id.LblTitulo);
            item.setTag(holder);
        } else {
            holder = (ViewHolder) item.getTag();
        }
        if(estado.isCaps(position)){
            item.setBackgroundColor(Color.BLUE);
        }else{
            item.setBackgroundColor(Color.WHITE);
        }
        holder.titulo.setText(datos[position].getTitulo());


        return (item);
    }
    static class ViewHolder {
        TextView titulo;

    }
}