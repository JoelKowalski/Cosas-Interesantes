package com.example.usuario.app_prueba;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Usuario on 09/06/2016.
 */
public class Ventana2 extends Activity  {
   ViewPager viewPager;
    CustomSwipe customSwipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ventana2);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        customSwipe=new CustomSwipe(this);
        viewPager.setAdapter(customSwipe);
    }
}
