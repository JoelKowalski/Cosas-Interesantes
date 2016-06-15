package com.example.usuario.app_prueba;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Usuario on 09/06/2016.
 */
public class Controlator implements View.OnClickListener {
    Context c;
    EditText usuario,contrase;
    Model_User modelo=new Model_User();
    public Controlator(Context c){
        this.c=c;
    }
    public void onClick(View v) {
        int vista = v.getId();
        switch (vista){
            case R.id.botonlimpiar:
                limpiar();
            break;
            case R.id.botonok:
                 if(comprobar()){
                     abrirActividad(c);
                 }
            break;
        }
    }

    private boolean comprobar() {
        Activity a=null;

        a=(Activity)c;
        usuario = (EditText) a.findViewById(R.id.etuser);
        contrase = (EditText) a.findViewById(R.id.etpass);


        if(usuario.getText().toString().equals(modelo.getUsuario())){
            return true;
        }else{
            alertdialog();
            return false;

        }
    }

    private void limpiar() {
        Activity a=null;
        a=(Activity)c;
        usuario = (EditText) a.findViewById(R.id.etuser);
        contrase = (EditText) a.findViewById(R.id.etpass);
        usuario.setText("");
        contrase.setText("");
    }
    private void abrirActividad(Context c){
        Activity a=null;
        a=(Activity)c;
        Intent i=new Intent(c,Ventana2.class);
        a.startActivity(i);

    }public void alertdialog() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(c);
        builder1.setMessage("User or pass don´t match.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        builder1.setNegativeButton(
                "Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
