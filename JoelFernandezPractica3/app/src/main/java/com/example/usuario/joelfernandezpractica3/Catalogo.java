package com.example.usuario.joelfernandezpractica3;

import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class Catalogo extends Fragment {


public List<Producto> listaproductos=null;
    public List<Bitmap> listaimagenes=null;
    public Catalogo() {
        super();
    }

    RecyclerView mRecycleView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_catalogo, container, false);
        listaproductos=Controlador.damelista();
        listaimagenes=Controlador.damelistaImagenes();
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);
        mRecycleView=(RecyclerView)rootView.findViewById(R.id.rv_recycler_view);
        AdaptadorRecycleCatalogo adapter = new AdaptadorRecycleCatalogo(listaimagenes,listaproductos,mRecycleView,rootView.getContext());
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return rootView;
    }


}
