package com.example.usuario.joelfernandezpractica1;

/**
 * Created by Usuario on 10/06/2016.
 */
public class Imagenes {
    int[] ImagenesBanderas={R.drawable.alemania,R.drawable.america,R.drawable.francia,R.drawable.italia,R.drawable.portugal,R.drawable.suecia};
    int[] ImagenesCoches={R.drawable.coche1,R.drawable.coche3,R.drawable.coche2,R.drawable.coche4,R.drawable.coche5};


    public int dameLongitudBanderas(){
        return ImagenesBanderas.length;
    }
    public int dameLongitudCoches(){
        return ImagenesCoches.length;
    }
    public int dameEstaBandera(int pos){
        return ImagenesBanderas[pos];
    }
    public int dameEsteCoche(int pos ){
        return ImagenesCoches[pos];
    }
}
