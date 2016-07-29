package com.example.usuario.joelfernandezpractica3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleCatalogo extends AppCompatActivity {
   TextView nombredetalle,preciodetalle,unidadesdetalle,descripciondetalle;
    ImageView imagenproducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detalle_catalogo);
        imagenproducto = (ImageView) findViewById(R.id.imagedetalle);
        nombredetalle = (TextView) findViewById(R.id.tv_nombredetalle);
        preciodetalle = (TextView) findViewById(R.id.tv_precio);
        unidadesdetalle = (TextView) findViewById(R.id.tv_unidades);
        descripciondetalle = (TextView) findViewById(R.id.tv_descripcion);
        Bundle b = getIntent().getExtras();
        Producto producto = b.getParcelable("clave");
        nombredetalle.setText(producto.getNombre());
        unidadesdetalle.setText(String.valueOf(producto.getUnidades()));
        // imagenproducto.setImageResource(R.drawable.imagendetalle);
        Bitmap mbitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.imagendetalle)).getBitmap();
        Bitmap imageRounded = Bitmap.createBitmap(mbitmap.getWidth(), mbitmap.getHeight(), mbitmap.getConfig());
        Canvas canvas = new Canvas(imageRounded);
        Paint mpaint = new Paint();
        mpaint.setAntiAlias(true);
        mpaint.setShader(new BitmapShader(mbitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawRoundRect((new RectF(0, 0, mbitmap.getWidth(), mbitmap.getHeight())),  mbitmap.getWidth()/4, mbitmap.getHeight()/4, mpaint);// Round Image Corner 100 100 100 100
        imagenproducto.setImageBitmap(imageRounded);

        if (producto.getUnidades() == 0) {
            unidadesdetalle.setText("No Disponible");
            unidadesdetalle.setTextColor(Color.WHITE);
        } else if (producto.getUnidades() > 0 && producto.getUnidades() < 10) {
            unidadesdetalle.setText(String.valueOf(producto.getUnidades())+" Unidades");
            unidadesdetalle.setTextColor(Color.RED);
        } else if (producto.getUnidades() > 10 && producto.getUnidades() < 50) {
            unidadesdetalle.setText(String.valueOf(producto.getUnidades())+" Unidades");
            unidadesdetalle.setTextColor(Color.YELLOW);
        } else {
            unidadesdetalle.setText(String.valueOf(producto.getUnidades())+" Unidades");
            unidadesdetalle.setTextColor(Color.GREEN);
        }
        preciodetalle.setText(String.valueOf(producto.getPrecio() + " €"));
        preciodetalle.setTextColor(Color.WHITE);
        descripciondetalle.setText(producto.getDescripcion());
        descripciondetalle.setTextColor(Color.WHITE);
        nombredetalle.setTextColor(Color.WHITE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalle_catalogo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
