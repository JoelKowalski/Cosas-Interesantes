package com.example.usuario.joelfernandezpractica1;

/**
 * Created by Usuario on 10/06/2016.
 */
public class Imagenes {
    int[] ImagenesMotos={R.drawable.moto1,R.drawable.moto2,R.drawable.moto3,R.drawable.moto4,R.drawable.moto5};
    int[] ImagenesCoches={R.drawable.coche1,R.drawable.coche3,R.drawable.coche2,R.drawable.coche4,R.drawable.coche5};
    String[] datosImagenes={"Imagenes de Motos","Imagenes de Coches"};



    public int dameEstaMoto(int pos){
        return ImagenesMotos[pos];
    }
    public int dameEsteCoche(int pos ){
        return ImagenesCoches[pos];
    }
    public String[] dameDatos(){
        return datosImagenes;
    }
    public int longitud(){
        return 5;
    }
}
