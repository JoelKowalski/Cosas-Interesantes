package com.example.usuario.joelfernandezpractica3;

import android.content.Context;
import android.view.View;

import java.util.List;

/**
 * Created by Usuario on 22/07/2016.
 */
public class Controlador implements View.OnClickListener {
    private Context c;
    public List<Producto> listaProductos =null;
    public Controlador(Context c) {
        this.c = c;
    }
    @Override
    public void onClick(View v) {
        int vista = v.getId();
        switch (vista) {
            case R.id.btnmesas:
                llamarAsync("mesa");
                break;
            case R.id.btnacces:
                llamarAsync("accesorio");
                break;
            case R.id.btncascos:
                llamarAsync("cascos");
                break;
            case R.id.btncontrolador:
                llamarAsync("controlador");
                break;
            case R.id.btnsoftware:
                llamarAsync("software");
                break;
        }
    }
    public void llamarAsync(String peticion){
       listaProductos=new AsyncTaskDescargaDatos(this.c).execute(peticion);
    }
   

}

