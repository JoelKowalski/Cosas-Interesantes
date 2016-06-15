package com.example.usuario.joelfernandezpractica1;

/**
 * Created by Usuario on 10/06/2016.
 */
public class Usuario {

    String user;
    String pass;
    int fav;


    public Usuario(){}

    public Usuario(String user, String pass, int fav) {

        this.user = user;
        this.pass = pass;
        this.fav = fav;
    }




    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getFav() {
        return fav;
    }

    public void setFav(int fav) {
        this.fav = fav;
    }



}
