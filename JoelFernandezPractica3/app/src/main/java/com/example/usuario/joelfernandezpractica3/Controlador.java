package com.example.usuario.joelfernandezpractica3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;

import java.util.List;

/**
 * Created by Usuario on 22/07/2016.
 */
public class Controlador implements View.OnClickListener {
    private static Context c;
    public static List<Producto> listaProductos =null;
    public static List<Bitmap> listaimagenes =null;

    public Bitmap bitmap;
    public Controlador(Context c) {
        this.c = c;
    }
    @Override
    public void onClick(View v) {
        int vista = v.getId();
        switch (vista) {

        }
    }
    public static void llamarAsync(String peticion){
      new AsyncTaskDescargaDatos(c).execute("nombre="+peticion);
    }
    public static void mostrarListaPersonas(List<Producto> lista) {
        Bitmap bitmap=null;
       listaProductos=lista;
/*
        for(Producto p:lista) {
            try {

                Log.i("Producto",p.toString());
                bitmap = new AsyncTaskImagenes(c).execute(p.getImagen()).get();
                listaimagenes.add(bitmap);
            } catch (Throwable t) {
                Log.d("Error", "Error descargando la imagen", t);
            }
        }*/

       abrirActividadCatalogo();
    }

    public static void abrirActividadCatalogo() {
        Activity a = null;
        a = (Activity) c;
        Intent i = new Intent(c, VentanaTab.class);
        a.startActivity(i);
    }
    public static List<Bitmap> damelistaImagenes(){
        return  listaimagenes;
    }
    public static List<Producto> damelista(){
        return  listaProductos;
    }
}




