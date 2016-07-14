package com.example.usuario.http;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Usuario on 14/07/2016.
 */
public class SubirPersona extends AsyncTask<Persona,Void,String> {

    private Context context;
    HttpURLConnection httpCon = null;
    URL serverUrl = null;
    ObjectOutputStream oos = null;
    public SubirPersona(Context c){
        this.context=c;
    }


    @Override
    protected String doInBackground(Persona... params) {
        String mensaje="KO";
        Persona p=null;
        try {
            p = params[0];
            serverUrl=new URL("http://192.168.2.31:8081/CiceRemote/SubirPersona");
            httpCon = (HttpURLConnection) serverUrl.openConnection();
            httpCon.setRequestMethod("POST");
            OutputStream os=httpCon.getOutputStream();
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(os);
            Gson gson=new Gson();
            String mensaje_json=gson.toJson(p);
            outputStreamWriter.write(mensaje_json);
            outputStreamWriter.close();

            int resp_code = httpCon.getResponseCode();

            if (resp_code == HttpURLConnection.HTTP_CREATED) //Sólo si en alta en el servidor ha sido correcta
                mensaje = "REGISTRO_OK"; //actualiza el valor de la respuesta

            httpCon.disconnect();
        }catch(Throwable t){
            Log.e("Culo","Ha ido mal",t);
        }
        finally {
            httpCon.disconnect();
        }
        return mensaje;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
