package com.example.usuario.joelfernandezpractica1;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Usuario on 16/06/2016.
 */
public class CustomSwipe extends PagerAdapter {
    private Context ctx;
    private int caragador;
    OnSwipeTouchListener onSwipeTouchListener=new OnSwipeTouchListener(ctx);
    Imagenes modelArrays =new Imagenes();
    private LayoutInflater li;

    public CustomSwipe(Context ctx,int cargador) {
        this.ctx = ctx;
        this.caragador=cargador;
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
    public Object instantiateItem(ViewGroup container, int position) {
        li=(LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview=li.inflate(R.layout.swipe_layout,container,false);
        ImageView imageview= (ImageView) itemview.findViewById(R.id.imageView);
        if(caragador==1) {
            imageview.setImageResource(modelArrays.dameEstaMoto(position));
        }else{
            imageview.setImageResource(modelArrays.dameEsteCoche(position));
        }

        container.addView(itemview);
        return itemview;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }

}
