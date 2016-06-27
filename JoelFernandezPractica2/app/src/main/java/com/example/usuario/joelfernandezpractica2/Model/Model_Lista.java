package com.example.usuario.joelfernandezpractica2.Model;

/**
 * Created by Usuario on 27/06/2016.
 */
public class Model_Lista {
    String titulo;
    String fecha;
    int cantidad;

    public  Model_Lista(){

    }
    public Model_Lista(String titulo, String fecha, int cantidad) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
