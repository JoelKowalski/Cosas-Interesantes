package com.example.vale.tag;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ListView lstOpciones;  
    private Lista_elementos[] datos =
            new Lista_elementos[]{
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 2"),
                    new Lista_elementos("Elemento 3"),
                    new Lista_elementos("Elemento 4"),
                    new Lista_elementos("Elemento 5"),
                    new Lista_elementos("Elemento 6"),
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 1"),
                    new Lista_elementos("Elemento 1")
                   };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstOpciones = (ListView) findViewById(R.id.LstOpciones);
        AdaptadorTitulares adaptador = new AdaptadorTitulares(MainActivity.this, datos);
        lstOpciones.setAdapter(adaptador);
        Controlador control = new Controlador(this);

        lstOpciones.setOnItemClickListener(control);
    }





}