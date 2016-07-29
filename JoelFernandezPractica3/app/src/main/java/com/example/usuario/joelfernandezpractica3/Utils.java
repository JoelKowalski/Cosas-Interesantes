package com.example.usuario.joelfernandezpractica3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 22/07/2016.
 */
public class Utils {
    public static final String URL_SERVER = "http://192.168.1.130:8081/ServerPractica3/Servidor";

    public static Bitmap codificarImagen (Bitmap imagen) {
        Bitmap bitmap = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            imagen.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] imageBytes = baos.toByteArray();
            bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        } catch (Throwable t) {
            Log.d("Error de la morton","ha petao", t);
        }
        return bitmap;
    }
    public static List<ItemsObject> getListItemData(){
        List<ItemsObject> listViewItems = new ArrayList<ItemsObject>();
        listViewItems.add(new ItemsObject("Mesas De Mezclas", R.drawable.mesainicial));
        listViewItems.add(new ItemsObject("Controladoras", R.drawable.controladorinicial));
        listViewItems.add(new ItemsObject("Cascos", R.drawable.cascosinicial));
        listViewItems.add(new ItemsObject("Software", R.drawable.softwareinicial));
        listViewItems.add(new ItemsObject("Accesorios", R.drawable.accesoriosinicial));
        listViewItems.add(new ItemsObject("Monitores", R.drawable.monitorinicial));
        listViewItems.add(new ItemsObject("Ver todo", R.drawable.vertodo));
        return listViewItems;
    }

}
