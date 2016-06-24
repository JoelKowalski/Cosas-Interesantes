package com.example.usuario.joelfernandezpractica1;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Usuario on 10/06/2016.
 */
public class Utils {
     static  final int NUMERO_DE_TABS = 2;
     public static void MostrarToast(Context ctx,String mensaje) {
          Toast.makeText(ctx, mensaje, Toast.LENGTH_LONG).show();
     }
     public static String usuario;

     public static String getUsuario() {
          return usuario;
     }

     public static void setUsuario(String usuario) {
          Utils.usuario = usuario;
     }
}
