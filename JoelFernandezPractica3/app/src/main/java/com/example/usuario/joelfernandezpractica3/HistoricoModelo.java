package com.example.usuario.joelfernandezpractica3;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.internal.ParcelableSparseArray;


/**
 * Created by Usuario on 29/07/2016.
 */
public class HistoricoModelo  implements Parcelable {
    String fecha;
    String nombre;
    //Bitmap foto;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fecha);
        dest.writeString(this.nombre);


    }

    public static final Parcelable.Creator<HistoricoModelo> CREATOR = new Parcelable.Creator<HistoricoModelo>() {
        public HistoricoModelo createFromParcel(Parcel in) {
            return new HistoricoModelo(in);
        }

        public HistoricoModelo[] newArray(int size) {
            return new HistoricoModelo[size];
        }
    };
    public HistoricoModelo (Parcel in)
    {
        this.fecha=in.readString();
        this.nombre = in.readString();//si tuviera varios string, deo leer los camps en el orden en el que fueron escritos para que la corresponsendia sea total

    }

    public HistoricoModelo(String fecha, String nombre) {
        this.fecha = fecha;
        this.nombre = nombre;
    }

    public String getFecha() {

        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
