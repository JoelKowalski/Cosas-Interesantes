package com.example.usuario.joelfernandezpractica3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import java.util.List;

/**
 * Created by Usuario on 22/07/2016.
 */
public class Controlador implements View.OnClickListener {
    private static Context c;
    public static List<Producto> listaProductos =null;
    public Controlador(Context c) {
        this.c = c;
    }
    @Override
    public void onClick(View v) {
        int vista = v.getId();
        switch (vista) {
            case R.id.btnmesas:
                llamarAsync("Mesa");
                break;
            case R.id.btnacces:
                llamarAsync("Acces");
                break;
            case R.id.btncascos:
                llamarAsync("Cascos");
                break;
            case R.id.btncontrolador:
                llamarAsync("Controladora");
                break;
            case R.id.btnsoftware:
                llamarAsync("Software");
                break;
            case R.id.btnmonitor:
                llamarAsync("Monitor");
                break;
        }
    }
    public void llamarAsync(String peticion){
      new AsyncTaskDescargaDatos(this.c).execute("nombre="+peticion);
    }
    public static void mostrarListaPersonas(List<Producto> lista) {
       listaProductos=lista;
       abrirActividadCatalogo();
    }
    public static void abrirActividadCatalogo() {
        Activity a = null;
        a = (Activity) c;
        Intent i = new Intent(c, VentanaTab.class);
        a.startActivity(i);
    }
    public static List<Producto> damelista(){
        return  listaProductos;
    }
}




