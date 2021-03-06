package com.example.vale.seleccioncontacto;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


/**
 * TODO Dividir el siguiente código en funciones/métodos en el máximo número de funciones con entidad o logica
 * haciendo el código más lógico y entendible
 */
public class MainActivity extends AppCompatActivity {

    private TextView textView1,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializador();
        llamada_al_intent();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Cursor cursor = null;
        String phoneNo = null ;
        String name = null;
        Uri uri = null;

        if (resultCode == RESULT_OK) {
            try {

                uri = data.getData();
                Log.d(getClass().getCanonicalName(), "Selecciono los detalles de la base datos/ registro : (uri) = " + uri.toString());

                cursor = getContentResolver().query(uri, null, null, null, null);
                cursor.moveToFirst();
                int  phoneIndex =cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                int  nameIndex =cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);

                phoneNo = cursor.getString(phoneIndex);
                name = cursor.getString(nameIndex);
                mostrar(name,phoneNo);

            } catch (Exception e)
            {
                logizador(getClass().getCanonicalName(),"ERROR procesando el intent del Contacto");
            }
        } else {
            logizador(getClass().getCanonicalName(),"Error seleccionando contacto");
        }
    }
    private void llamada_al_intent(){
        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
        startActivityForResult(intent, 100);
    }
    private void inicializador(){
        textView1 = (TextView) findViewById(R.id.telfcontacto);
        textView2 = (TextView) findViewById(R.id.nomcontacto);
    }
    private void logizador(String tag,String mensaje){
        Log.e(tag, mensaje);
    }
    private void mostrar(String name,String phoneNo){
        textView1.setText(name);
        textView2.setText(phoneNo);
    }


}
