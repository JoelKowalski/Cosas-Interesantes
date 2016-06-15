package com.example.usuario.app_prueba;


import java.util.ArrayList;

/**
 * Created by Usuario on 09/06/2016.
 */
public class Model_User {
    String usuario;
    String pass;



    public  String getUsuario() {
        return "usuario";
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return "pass";
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    public Model_User(){

    }
    public Model_User(String usuario, String pass) {

        this.usuario = usuario;
        this.pass = pass;

    }



}
