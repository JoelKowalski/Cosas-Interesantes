package com.example.usuario.app_prueba;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Usuario on 09/06/2016.
 */
public class CustomSwipe extends PagerAdapter {
    private Context ctx;
    Model_Arrays modelArrays =new Model_Arrays();
private LayoutInflater li;
    public CustomSwipe(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return modelArrays.getCountrandom();
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
        imageview.setImageResource(modelArrays.getArrayimagenesrandom(position));

        imageview.setOnTouchListener(new OnSwipeTouchListener(ctx) {
            public void onSwipeTop() {
                Toast.makeText(ctx, "Like", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeBottom() {
                Toast.makeText(ctx, "Dislike", Toast.LENGTH_SHORT).show();
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
