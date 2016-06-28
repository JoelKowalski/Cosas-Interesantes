package com.example.usuario.joelfernandezpractica2.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.usuario.joelfernandezpractica2.Control.Adaptador_Lista;
import com.example.usuario.joelfernandezpractica2.Model.Model_Lista;
import com.example.usuario.joelfernandezpractica2.R;

import java.util.ArrayList;
import java.util.List;

public class View_list extends AppCompatActivity {
    private List<Model_Lista> lista = new ArrayList<>();
    private RecyclerView recyclerView;
    private Adaptador_Lista mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new Adaptador_Lista(lista);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }
    private void prepareMovieData() {
        Model_Lista movie = new Model_Lista("titulo", "fecha", 2015);
        lista.add(movie);

        movie = new Model_Lista("titulo", "fecha", 2015);
        lista.add(movie);
        movie = new Model_Lista("titulo", "fecha", 2015);
        lista.add(movie);
        movie = new Model_Lista("Inside Out", "fecha", 2015);
        lista.add(movie);
        movie = new Model_Lista("Inside Out", "fecha", 2015);
        lista.add(movie);
        movie = new Model_Lista("Inside Out", "Animation, Kids & Family", 2015);
        lista.add(movie);
        movie = new Model_Lista("Inside Out", "Animation, Kids & Family", 2015);
        lista.add(movie);
        movie = new Model_Lista("Inside Out", "Animation, Kids & Family", 2015);
        lista.add(movie); movie = new Model_Lista("Inside Out", "Animation, Kids & Family", 2015);
        lista.add(movie);
        movie = new Model_Lista("Inside Out", "Animation, Kids & Family", 2015);
        lista.add(movie);
        movie = new Model_Lista("Inside Out", "Animation, Kids & Family", 2015);
        lista.add(movie);
        movie = new Model_Lista("Inside Out", "Animation, Kids & Family", 2015);
        lista.add(movie);
        movie = new Model_Lista("Inside Out", "Animation, Kids & Family", 2015);
        lista.add(movie);
        movie = new Model_Lista("Inside Out", "Animation, Kids & Family", 2015);
        lista.add(movie);
        movie = new Model_Lista("Inside Out", "Animation, Kids & Family", 2015);
        lista.add(movie);
        movie = new Model_Lista("Inside Out", "Animation, Kids & Family", 2015);
        lista.add(movie); movie = new Model_Lista("Inside Out", "Animation, Kids & Family", 2015);
        lista.add(movie);
        movie = new Model_Lista("Inside Out", "Animation, Kids & Family", 2015);
        lista.add(movie);
        movie = new Model_Lista("Inside Out", "Animation, Kids & Family", 2015);
        lista.add(movie);
        movie = new Model_Lista("Inside Out", "Animation, Kids & Family", 2015);
        lista.add(movie);
        movie = new Model_Lista("Inside Out", "Animation, Kids & Family", 2015);
        lista.add(movie); movie = new Model_Lista("Inside Out", "Animation, Kids & Family", 2015);
        lista.add(movie);
        movie = new Model_Lista("Inside Out", "Animation, Kids & Family", 2015);
        lista.add(movie); movie = new Model_Lista("Inside Out", "Animation, Kids & Family", 2015);
        lista.add(movie); movie = new Model_Lista("Inside Out", "Animation, Kids & Family", 2015);
        lista.add(movie); movie = new Model_Lista("Inside Out", "Animation, Kids & Family", 2015);
        lista.add(movie);
        movie = new Model_Lista("Inside Out", "Animation, Kids & Family", 2015);
        lista.add(movie);
        movie = new Model_Lista("Inside Out", "Animation, Kids & Family", 2015);
        lista.add(movie);









        mAdapter.notifyDataSetChanged();
    }
}

