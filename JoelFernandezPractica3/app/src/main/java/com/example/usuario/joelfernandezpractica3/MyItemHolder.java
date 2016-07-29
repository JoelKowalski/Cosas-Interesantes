package com.example.usuario.joelfernandezpractica3;

/**
 * Created by Usuario on 28/07/2016.
 */
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView countryName;
    public ImageView countryPhoto;

    public MyItemHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        countryName = (TextView) itemView.findViewById(R.id.country_name);
        countryPhoto = (ImageView) itemView.findViewById(R.id.country_photo);
    }

    @Override
    public void onClick(View view) {
       Log.i("PUlso", String.valueOf(getPosition()));
        switch (getPosition()){
            case 0: Controlador.llamarAsync("Mesa");
                break;
            case 1: Controlador.llamarAsync("Controladora");
                break;
            case 2: Controlador.llamarAsync("Cascos");
                break;
            case 3: Controlador.llamarAsync("Software");
                break;
            case 4: Controlador.llamarAsync("Acces");
                break;
            case 5: Controlador.llamarAsync("Monitor");
                break;
            case 6: Controlador.llamarAsync("Todo");
                break;
        }
    }
}
