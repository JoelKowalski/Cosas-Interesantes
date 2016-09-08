package com.rubik.notificationsservice;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Usuario on 08/09/2016.
 */
public class Utils {
    public final static String PREFERENCES_TIEMPO = "tiempo";
    public final static String PREFERENCES_CONTADOR = "contador";

    public static void setTiempo (long tiempo, Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES_TIEMPO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(String.valueOf(getContador(context)), tiempo);
        setContador(getContador(context)+1,context);
        editor.commit();

    }
    public static long getTiempo(Context context,int clave){
        long tiempo = 0;
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES_TIEMPO, Context.MODE_PRIVATE);
        tiempo = sharedPreferences.getLong(String.valueOf(clave), 0);
        return tiempo;
    }
    public static void setContador(int contador,Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES_CONTADOR, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("clave", contador);
        editor.commit();

    }
    public static int getContador(Context context){
        int contador = 0;
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES_CONTADOR, Context.MODE_PRIVATE);
        contador = sharedPreferences.getInt("clave", 0);
        return contador;
    }
}
