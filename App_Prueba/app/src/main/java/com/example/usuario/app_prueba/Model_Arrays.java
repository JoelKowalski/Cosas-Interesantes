package com.example.usuario.app_prueba;

/**
 * Created by Usuario on 10/06/2016.
 */
public class Model_Arrays {

    int[] Arrayimagenesrandom ={R.drawable.chrysanthemum,R.drawable.desert,R.drawable.hydrangeas,R.drawable.jellyfish,R.drawable.koala
            ,R.drawable.lighthouse,R.drawable.penguins,R.drawable.tulips};
    int[] Arrayimagenesbanderas ={R.drawable.alemania,R.drawable.america,R.drawable.francia,R.drawable.italia,R.drawable.portugal,R.drawable.suecia};

    public int getArrayimagenesrandom(int pos) {
        return Arrayimagenesrandom[pos];
    }
    public int getArrayimagenesbanderas(int pos) {
        return Arrayimagenesbanderas[pos];
    }



    public int getCountrandom(){
        return Arrayimagenesrandom.length;
    }
}
