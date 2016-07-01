package com.example.vale.tag;

/**
 * Created by Usuario on 28/06/2016.
 */
public class Estado {

    private boolean[] arrayEstados;

    public Estado(int elementos) {
        this.arrayEstados=new boolean[elementos];
    }

    public boolean estaMarcado(int posicion){
        return arrayEstados[posicion];
    }
    public void actualizarEstado(int posicion,boolean estado){
        arrayEstados[posicion]=estado;
    }
}

