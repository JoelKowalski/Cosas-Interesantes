package com.example.usuario.joelfernandezpractica3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Date;
import java.util.List;

/**
 * Created by Usuario on 26/07/2016.
 */
public class HistoricoVista extends Fragment {


    RecyclerView mRecycleView;
    List<HistoricoModelo> listahistoricos;
    DataBase database;
    HistoricoModelo hm;
    public HistoricoVista() {
        super();
    }


    //Simplemente, inflo en contenido del fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_historico, container, false);
        database=new DataBase(rootView.getContext(), "MiDB", null, 1);
        listahistoricos= database.DameHistoricos();
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view2);
        rv.setHasFixedSize(true);
        mRecycleView=(RecyclerView)rootView.findViewById(R.id.rv_recycler_view);
        AdaptadorRecycleHistorico adapter = new AdaptadorRecycleHistorico(listahistoricos,mRecycleView,rootView.getContext());
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        database=new DataBase(getContext(), "MiDB", null, 1);
        listahistoricos= database.DameHistoricos();
        RecyclerView rv = (RecyclerView) getView().findViewById(R.id.rv_recycler_view2);
        rv.setHasFixedSize(true);
        mRecycleView=(RecyclerView)getView().findViewById(R.id.rv_recycler_view);
        AdaptadorRecycleHistorico adapter = new AdaptadorRecycleHistorico(listahistoricos,mRecycleView,getContext());
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

    }
}

