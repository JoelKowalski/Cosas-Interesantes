package com.example.usuario.joelfernandezpractica3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 22/07/2016.
 */
public class AsyncTaskDescargaDatos extends AsyncTask<String, Void, List<Producto>> {
    private Context c;
    public AsyncTaskDescargaDatos(Context c){
        this.c=c;
    }


    @Override
    protected List<Producto> doInBackground(String... params) {
        List<Producto> listProducto=null;
        InputStreamReader isr=null;
        BufferedReader br=null;
        int respuesta = -1;
        URL url = null;
        HttpURLConnection httpConn = null;

        try
        {
            url= new URL(Utils.URL_SERVER+"?"+params[0]);

            httpConn = (HttpURLConnection) url.openConnection();

            respuesta = httpConn.getResponseCode();
            if (respuesta == HttpURLConnection.HTTP_OK)
            {
                InputStream is = httpConn.getInputStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
                String json_producto = br.readLine();
                Gson gson = new Gson();
                listProducto = gson.fromJson(json_producto, new TypeToken<ArrayList<Producto>>() {
                }.getType());
            }
            httpConn.disconnect();
        } catch (Throwable t)
        {
            Log.e(getClass().getCanonicalName(), "Ha ido mal la com con el server", t);
        }

        finally{
            httpConn.disconnect();
        }
        return  listProducto;
    }
    protected void onPostExecute(List<Producto> personas) {

        Controlador.mostrarListaPersonas(personas);
    }


}
