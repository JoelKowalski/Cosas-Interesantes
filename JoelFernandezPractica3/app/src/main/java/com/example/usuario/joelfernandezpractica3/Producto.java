package com.example.usuario.joelfernandezpractica3;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Usuario on 22/07/2016.
 */
public class Producto implements Parcelable{
    String intro;
    String imagenurl;
    String nombre;
    double precio;
    int unidades;
    String descripcion;
    String categoria;

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getImagenurl() {
        return imagenurl;
    }

    public void setImagenurl(String imagenurl) {
        this.imagenurl = imagenurl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Producto(String intro, String imagenurl, String nombre, double precio, int unidades, String descripcion,
                    String categoria) {
        super();
        this.intro = intro;
        this.imagenurl = imagenurl;
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.intro);
        dest.writeString(this.imagenurl);
        dest.writeString(this.nombre);
        dest.writeDouble(this.precio);
        dest.writeInt(this.unidades);
        dest.writeString(this.descripcion);
        dest.writeString(this.categoria);
    }

    public static final Parcelable.Creator<Producto> CREATOR = new Parcelable.Creator<Producto>() {
        public Producto createFromParcel(Parcel in) {
            return new Producto(in);
        }

        public Producto[] newArray(int size) {
            return new Producto[size];
        }
    };
    public Producto (Parcel in)
    {
        this.intro=in.readString();
        this.imagenurl=in.readString();
        this.nombre = in.readString();//si tuviera varios string, deo leer los camps en el orden en el que fueron escritos para que la corresponsendia sea total
        this.precio=in.readDouble();
        this.unidades = in.readInt();
        this.descripcion=in.readString();
        this.categoria=in.readString();
    }
}
