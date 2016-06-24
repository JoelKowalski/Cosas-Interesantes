package com.example.usuario.joelfernandezpractica1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Usuario on 21/06/2016.
 */
public class FavoritosAdapter extends BaseAdapter {
    private Context mContext;
    private DataBase dataBase;
    private String usuario;
    private int[]  mThumbIds;
    public FavoritosAdapter(Context c,String usuario) {
        mContext = c;
        this.usuario=usuario;
        dataBase=new DataBase(mContext, "MiDB", null, 1);
    }

    public int getCount() {
        return dataBase.DameLongitud(usuario);
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        mThumbIds=new int[dataBase.DameFavs(usuario).length];
        ImageView imageView;
        cargarFavs();
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(180, 180));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5, 5, 5, 5);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    public int[] cargarFavs(){
        dataBase=new DataBase(mContext, "MiDB", null, 1);

        mThumbIds=dataBase.DameFavs(usuario);

       return mThumbIds;

    }

}
