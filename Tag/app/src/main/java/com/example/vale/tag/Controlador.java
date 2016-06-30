package com.example.vale.tag;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

/**
 * Created by Usuario on 29/06/2016.
 */
public class Controlador  implements View.OnClickListener {
    Context c;
    Estado estado=new Estado();

    public Controlador(Context c) {
        this.c = c;
    }
    @Override
    public void onClick(View v) {
        //inicializar();
        int vista = v.getId();
        switch (vista) {
            case R.id.LstOpciones:
                if(!estado.isCaps(v.getVerticalScrollbarPosition())){
                    estado.setCaps(v.getVerticalScrollbarPosition(),true);
                    v.setBackgroundColor(Color.BLUE);
                }else{
                    v.setBackgroundColor(Color.WHITE);
                    estado.setCaps(v.getVerticalScrollbarPosition(),false);
                }
                break;
        }
    }


}