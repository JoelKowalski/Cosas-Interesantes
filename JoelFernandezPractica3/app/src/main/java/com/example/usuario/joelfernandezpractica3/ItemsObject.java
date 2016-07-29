package com.example.usuario.joelfernandezpractica3;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Usuario on 28/07/2016.
 */
public class ItemsObject  implements Parcelable{
    String titulo;
    int foto;

    public ItemsObject(String titulo, int foto) {
        this.titulo = titulo;
        this.foto = foto;
    }

    public String getTitulo() {

        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.titulo);
        dest.writeInt(this.foto);
    }

    public static final Parcelable.Creator<ItemsObject> CREATOR = new Parcelable.Creator<ItemsObject>() {
        public ItemsObject createFromParcel(Parcel in) {
            return new ItemsObject(in);
        }

        public ItemsObject[] newArray(int size) {
            return new ItemsObject[size];
        }
    };
    public ItemsObject (Parcel in)
    {
        this.titulo=in.readString();
        this.foto =in.readInt();

    }
}
