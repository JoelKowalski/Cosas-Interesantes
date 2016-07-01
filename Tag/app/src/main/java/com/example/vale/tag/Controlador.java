package com.example.vale.tag;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;

import static com.example.vale.tag.R.id.LblTitulo;
import static com.example.vale.tag.R.id.LstOpciones;

/**
 * Created by Usuario on 29/06/2016.
 */
public class Controlador  implements AdapterView.OnItemClickListener {
    Context c;

    public Controlador(Context c) {
        this.c = c;
    }




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Estado estado= (Estado) parent.getTag();
            if(!estado.estaMarcado(position)){
                estado.actualizarEstado(position,true);
                view.setBackgroundColor(Color.BLUE);
            }else{
                view.setBackgroundColor(Color.WHITE);
                estado.actualizarEstado(position,false);
            }
        }

}