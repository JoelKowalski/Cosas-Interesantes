package com.example.usuario.joelfernandezpractica3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Usuario on 26/07/2016.
 */
public class PageAdapter  extends FragmentStatePagerAdapter {

    //Simplemente llamo al contrstructor del padre
    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    //De forma similar al GETVIEW, este adpater también devuelve una vista
    //pero en este caso, es un Fragment! (y se llama getItem)
    @Override
    public Fragment getItem(int posicion) {

        Fragment fragment = null;

        switch (posicion)
        {
            case 0: fragment = new Catalogo();
                break;
            default: fragment = new Historico();
        }

        return  fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    //sobrrescribo este método para que se pinte el tab como parte
    //del fragtment
    @Override
    public CharSequence getPageTitle(int position) {
        return VentanaTab.getTitulo(position);
    }
}

