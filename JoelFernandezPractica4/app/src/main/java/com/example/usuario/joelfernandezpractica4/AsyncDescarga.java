package com.example.usuario.joelfernandezpractica4;

/**
 * Created by Usuario on 13/09/2016.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Usuario on 22/07/2016.
 */
public class AsyncDescarga extends AsyncTask<String, Void, List<Recado>> {
    private Context c;
    public AsyncDescarga(Context c){
        this.c=c;
    }
    @Override
    protected List<Recado> doInBackground(String... params) {
        List<Recado> listaRecados=null;
        InputStreamReader isr=null;
        BufferedReader br=null;
        int respuesta = -1;
        URL url = null;
        HttpURLConnection httpConn = null;

        try{
            url= new URL(params[0]);

            httpConn = (HttpURLConnection) url.openConnection();

            respuesta = httpConn.getResponseCode();
            if (respuesta == HttpURLConnection.HTTP_OK)
            {
                InputStream is = httpConn.getInputStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
                String json_producto = br.readLine();
                Gson gson = new Gson();
                listaRecados = gson.fromJson(json_producto, new TypeToken<ArrayList<Recado>>() {

                }.getType());
                Log.i("ee",listaRecados.get(1).getNombre_cliente());

            }
            httpConn.disconnect();
        } catch (Throwable t){
            Log.e(getClass().getCanonicalName(), "Ha ido mal la com con el server", t);
        }
        finally{
            httpConn.disconnect();
        }
        return  listaRecados;
    }


}
