package com.example.usuario.joelfernandezpractica3;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class Catalogo extends Fragment {


public List<Producto> listaproductos=null;
    public Catalogo() {
        super();
    }

    RecyclerView mRecycleView;
    //Simplemente, inflo en contenido del fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_catalogo, container, false);
        listaproductos=Controlador.damelista();
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);
        mRecycleView=(RecyclerView)rootView.findViewById(R.id.rv_recycler_view);
        AdaptadorRecycle adapter = new AdaptadorRecycle(listaproductos,mRecycleView);
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return rootView;
    }
}
