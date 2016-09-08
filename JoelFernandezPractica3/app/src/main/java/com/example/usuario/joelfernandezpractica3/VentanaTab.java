package com.example.usuario.joelfernandezpractica3;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Usuario on 26/07/2016.
 */
public class VentanaTab  extends AppCompatActivity {

    /**
     * ViewPager se encarga de la animación y permite la transción entre elmementos (swipe)
     */
    private ViewPager viewPager;

    /**
     * El PagerAdapter, suministra las vistas al ViewPager
     */
    private PagerAdapter pagerAdapter;


    //Este será el título visible por cada fragment
    private static String[] titulo_tab = {"Catalogo" , "Historico"};


    public static String getTitulo (int posicion)
    {
        return titulo_tab[posicion];
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ventanastab);


        viewPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new PageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

             TabLayout tabLayout = (TabLayout) findViewById(R.id.tablay);

              tabLayout.addTab(tabLayout.newTab());
              tabLayout.addTab(tabLayout.newTab());


        tabLayout.setupWithViewPager(viewPager);


    }

    //Sobreescribo este método para darle un comportamiento especial al hecho de que
    //el usuario presione el botón hacia atrás
    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            //Si estoy en el primer elemento, salgo de la app, aplicando el comportamiento por defecto
            super.onBackPressed();
        } else {
            // Si no, cambio la pantalla
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

}