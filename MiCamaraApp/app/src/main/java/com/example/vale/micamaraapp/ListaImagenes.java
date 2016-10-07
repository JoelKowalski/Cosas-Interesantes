package com.example.vale.micamaraapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.List;

/**
 * Created by Usuario on 22/09/2016.
 */
public class ListaImagenes extends BaseAdapter {
    private Context context;
    private Uri uriphoto;
    private List<Bitmap> imagenes;

    public ListaImagenes(Context c,List<Bitmap> imagenes,Uri uriphoto) {
        context = c;
        this.imagenes=imagenes;
        this.uriphoto=uriphoto;

    }

    public int getCount() {
        return imagenes.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;

        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_item, parent, false);
        }

        // Set data into the view.
        ImageView imagen = (ImageView) rowView.findViewById(R.id.imageView);
        imagen.setImageBitmap(imagenes.get(position));
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);

                Uri uri = Uri.fromFile(new File(String.valueOf(uriphoto)));
                shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                shareIntent.setType("image/jpeg");
                context.startActivity(Intent.createChooser(shareIntent, "ENVIAR FOTO ... "));

            }
        });

        return rowView;
    }
}