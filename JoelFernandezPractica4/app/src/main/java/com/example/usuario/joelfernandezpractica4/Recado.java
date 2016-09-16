package com.example.usuario.joelfernandezpractica4;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Usuario on 14/09/2016.
 */
public class Recado implements Parcelable {
    private String fecha_hora;
    private String nombre_cliente;
    private String telefono;
    private String direccion_recogida;
    private String direccion_entrega;
    private String descripcion;
    private String fecha_hora_maxima;

    public Recado(String fecha_hora, String nombre_cliente, String telefono, String descripcion, String direccion_entrega, String direccion_recogida, String fecha_hora_maxima) {
        this.fecha_hora = fecha_hora;
        this.nombre_cliente = nombre_cliente;
        this.telefono = telefono;
        this.descripcion = descripcion;
        this.direccion_entrega = direccion_entrega;
        this.direccion_recogida = direccion_recogida;
        this.fecha_hora_maxima = fecha_hora_maxima;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getFecha_hora_maxima() {
        return fecha_hora_maxima;
    }

    public void setFecha_hora_maxima(String fecha_hora_maxima) {
        this.fecha_hora_maxima = fecha_hora_maxima;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion_entrega() {
        return direccion_entrega;
    }

    public void setDireccion_entrega(String direccion_entrega) {
        this.direccion_entrega = direccion_entrega;
    }

    public String getDireccion_recogida() {
        return direccion_recogida;
    }

    public void setDireccion_recogida(String direccion_recogida) {
        this.direccion_recogida = direccion_recogida;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.fecha_hora);
        dest.writeString(this.nombre_cliente);
        dest.writeString(this.telefono);
        dest.writeString(this.descripcion);
        dest.writeString(this.direccion_entrega);
        dest.writeString(this.direccion_recogida);
        dest.writeString(this.fecha_hora_maxima);

    }

    public static final Parcelable.Creator<Recado> CREATOR = new Parcelable.Creator<Recado>() {
        public Recado createFromParcel(Parcel in) {
            return new Recado(in);
        }

        public Recado[] newArray(int size) {
            return new Recado[size];
        }
    };

    public Recado(Parcel in) {
        this.fecha_hora = in.readString();
        this.nombre_cliente = in.readString();
        this.telefono = in.readString();
        this.descripcion = in.readString();
        this.direccion_entrega = in.readString();
        this.direccion_recogida = in.readString();
        this.fecha_hora_maxima = in.readString();
    }
}

