package ubahn.joel.ubahnproject.remote;

import android.content.Context;
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
import java.util.List;

import ubahn.joel.ubahnproject.model.Estacion;
import ubahn.joel.ubahnproject.utils.Utils;

/**
 * Created by Usuario on 05/02/2017.
 */
public class AsyncTaskDetalleLinea extends AsyncTask<Integer, Void, List<Estacion>> {
    private Context c;
    public AsyncTaskDetalleLinea(Context c){
        this.c=c;
    }


    @Override
    protected List<Estacion> doInBackground(Integer... params) {
        List<Estacion> listEstacion=null;
        InputStreamReader isr=null;
        BufferedReader br=null;
        int respuesta = -1;
        URL url = null;
        HttpURLConnection httpConn = null;

        try
        {
            url= new URL(Utils.URL_SERVER+"?nombre="+params[0]);

            httpConn = (HttpURLConnection) url.openConnection();

            respuesta = httpConn.getResponseCode();
            if (respuesta == HttpURLConnection.HTTP_OK)
            {
                InputStream is = httpConn.getInputStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
                String json_producto = br.readLine();
                Gson gson = new Gson();
                listEstacion = gson.fromJson(json_producto, new TypeToken<ArrayList<Estacion>>() {
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
        return  listEstacion;
    }


}