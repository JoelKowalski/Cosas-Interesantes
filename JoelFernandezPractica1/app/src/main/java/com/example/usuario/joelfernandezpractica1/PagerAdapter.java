package com.example.usuario.joelfernandezpractica1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Locale;

/**
 * Created by Usuario on 10/06/2016.
 */
public class PagerAdapter extends FragmentPagerAdapter {


    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }



    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0:
                Login login = new Login();
                return login;
            case 1:
                Register register = new Register();
                return register;


        }
        return null;
    }

    @Override
    public int getCount() {
        return Utils.NUMERO_DE_TABS;
    }//set the number of tabs

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return "Login";
            case 1:
                return "Register";
        }
        return null;
    }



}