package com.example.usuario.joelfernandezpractica4;

/**
 * Created by Usuario on 13/09/2016.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;



import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Usuario on 22/07/2016.
 */
public class AsyncDescarga extends AsyncTask<String, Void, Bitmap> {
    private Context c;
    public AsyncDescarga(Context c){
        this.c=c;
    }
    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap bitmap = null;
        InputStream in = null;
        int respuesta = -1;
        URL url = null;
        HttpURLConnection httpConn = null;

        try {
            url = new URL(params[0]);
            httpConn = (HttpURLConnection) url.openConnection();

            respuesta = httpConn.getResponseCode();
            if (respuesta == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();

                in.close();
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            Log.d(getClass().getCanonicalName(), "ERROR descargando la imagen", e);
        }
        return bitmap;
    }

}
