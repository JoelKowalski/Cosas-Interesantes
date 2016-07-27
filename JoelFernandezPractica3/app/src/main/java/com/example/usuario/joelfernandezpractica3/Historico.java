package com.example.usuario.joelfernandezpractica3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Usuario on 26/07/2016.
 */
public class Historico extends Fragment {



    public Historico() {
        super();
    }


    //Simplemente, inflo en contenido del fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_historico, container, false);

        return rootView;
    }
}

