package com.example.usuario.joelfernandezpractica1;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MuestraImagen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ViewPager viewPager;
    CustomSwipe customSwipe;
    Spinner combo;
    Imagenes imagenes =new Imagenes();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_muestra_imagen);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        customSwipe=new CustomSwipe(MuestraImagen.this,1);
        viewPager.setAdapter(customSwipe);
        combo=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> lista= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,imagenes.dameDatos());
        combo.setAdapter(lista);
        combo.setOnItemSelectedListener(this);
    }
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                customSwipe = new CustomSwipe(MuestraImagen.this,1);
                viewPager.setAdapter(customSwipe);
                break;
            case 1:
                customSwipe=new CustomSwipe(MuestraImagen.this,2);
                viewPager.setAdapter(customSwipe);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_muestra_imagen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        switch (item.getItemId()) {

            case R.id.favorites:
                Controlador controlador=new Controlador(MuestraImagen.this);
                controlador.abrirActividadFavoritos(MuestraImagen.this);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
