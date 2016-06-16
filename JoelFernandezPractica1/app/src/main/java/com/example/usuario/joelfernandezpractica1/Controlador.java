package com.example.usuario.joelfernandezpractica1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Usuario on 10/06/2016.
 */
public class Controlador implements View.OnClickListener {
    Context c;
    EditText usuariologin, passlogin, userregister, passregister ,passregister2;
    DataBase baseDatos;

    public Controlador(Context c) {
        this.c = c;
    }

    public void onClick(View v) {
        inicializar();
        int vista = v.getId();
        switch (vista) {
            case R.id.buttoncancel:
                limpiar();
                break;

            case R.id.buttonlogin:
                if(!usuariologin.getText().toString().isEmpty()) {
                    if(!passlogin.getText().toString().isEmpty()) {
                        if (baseDatos.ComprobarExistente(usuariologin.getText().toString())==0) {
                            if(baseDatos.ComprobarPass(usuariologin.getText().toString(),passlogin.getText().toString())==0) {
                                limpiar();
                                abrirActividad(c);
                            }else{
                                Utils.MostrarToast(c, "Incorrect password");
                            }
                        } else if(baseDatos.ComprobarExistente(usuariologin.getText().toString())==1){
                            Utils.MostrarToast(c, "There aren´t matches in the data base with this user name");
                        }else{
                            Utils.MostrarToast(c, "DataBase is empty");
                        }
                    }else {
                        Utils.MostrarToast(c, "Password field is empty, please fill it");
                    }
                }else {
                    Utils.MostrarToast(c, "User field is empty, please fill it");
                }
                break;

            case R.id.buttonregister:
                if(!userregister.getText().toString().isEmpty()) {
                    if(!passregister.getText().toString().isEmpty() || !passregister2.getText().toString().isEmpty() ) {
                        if(passregister.getText().toString().equals(passregister2.getText().toString())) {
                            if (baseDatos.ComprobarExistente(userregister.getText().toString())==0) {
                                Utils.MostrarToast(c, "There are matches in the data base with this user name");
                            }else if(baseDatos.ComprobarExistente(userregister.getText().toString())==1){
                                Usuario usuario = new Usuario(userregister.getText().toString(), passregister.getText().toString(), 0);
                                baseDatos.insertarusuario(usuario);
                                limpiar();
                                abrirActividad(c);
                            }else{
                                Usuario usuario = new Usuario(userregister.getText().toString(), passregister.getText().toString(), 0);
                                baseDatos.insertarusuario(usuario);
                                Utils.MostrarToast(c, "Insert successfully");
                                abrirActividad(c);
                            }
                        }else{
                            Utils.MostrarToast(c, "Passwords fields don`t match");
                        }
                    }else {
                        Utils.MostrarToast(c, "Password field is empty, please fill it");
                    }
                }else {
                    Utils.MostrarToast(c, "User field is empty, please fill it");
                }
                break;

        }
    }

    private void inicializar() {
        Activity a = null;
        a = (Activity) c;
        baseDatos = new DataBase(c, "MiDB", null, 1);
        usuariologin = (EditText) a.findViewById(R.id.etuserlogin);
        userregister = (EditText) a.findViewById(R.id.etuserregister);
        passregister = (EditText) a.findViewById(R.id.etpassregister);
        passregister2 = (EditText) a.findViewById(R.id.etpassregister2);
        passlogin = (EditText) a.findViewById(R.id.etpasslogin);
    }

    private void limpiar() {
        usuariologin.setText("");
        userregister.setText("");
        passregister.setText("");
        passlogin.setText("");
    }

    private void abrirActividad(Context c) {

        Activity a = null;
        a = (Activity) c;
        Intent i = new Intent(c, MuestraImagen.class);
        a.startActivity(i);

    }







}
