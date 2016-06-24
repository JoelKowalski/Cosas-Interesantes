package com.example.usuario.joelfernandezpractica1;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Usuario on 16/06/2016.
 */
public class CustomSwipe extends PagerAdapter {
    private Context ctx;
    private int caragador;
    private DataBase dataBase;
    private String usuario;
    //OnSwipeTouchListener onSwipeTouchListener=new OnSwipeTouchListener(ctx);
    Imagenes modelArrays =new Imagenes();
    private LayoutInflater li;

    public CustomSwipe(Context ctx,int cargador,String usuario) {
        this.ctx = ctx;
        this.caragador=cargador;
        this.usuario=usuario;
    }


    @Override
    public int getCount() {
        return modelArrays.longitud();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        dataBase=new DataBase(ctx, "MiDB", null, 1);
        li=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview=li.inflate(R.layout.swipe_layout,container,false);
        final ImageView imageview= (ImageView) itemview.findViewById(R.id.imageView);
        if(caragador==1) {
            imageview.setImageResource(modelArrays.dameEstaMoto(position));
        }else{
            imageview.setImageResource(modelArrays.dameEsteCoche(position));
        }
        imageview.setOnTouchListener(new OnSwipeTouchListener(ctx){
            public void onSwipeTop(){
                Toast.makeText(ctx, "Like", Toast.LENGTH_SHORT).show();
                if(caragador==1) {
                    dataBase.insertarFav(usuario,modelArrays.dameEstaMoto(position));
                }else{
                    dataBase.insertarFav(usuario,modelArrays.dameEsteCoche(position));
                }
            }
            public void onSwipeBottom(){
                Toast.makeText(ctx, "Dislike", Toast.LENGTH_SHORT).show();
                if(caragador==1) {
                    dataBase.eliminarFav(usuario,modelArrays.dameEstaMoto(position));
                }else{
                    dataBase.eliminarFav(usuario,modelArrays.dameEsteCoche(position));
                }
            }
         });
        container.addView(itemview);
        return itemview;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }

}
