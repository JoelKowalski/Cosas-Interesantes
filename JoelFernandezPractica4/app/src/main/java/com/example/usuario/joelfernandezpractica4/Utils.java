package com.example.usuario.joelfernandezpractica4;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Usuario on 13/09/2016.
 */
public class Utils {

    public static final String URL_DESCARGA="";

    public static boolean isNetworkAvailable(Context context) {

        boolean br = false;

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        br = (activeNetworkInfo != null && activeNetworkInfo.isConnected());

        return br;
    }
}
