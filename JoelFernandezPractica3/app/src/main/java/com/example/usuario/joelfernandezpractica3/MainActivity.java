package com.example.usuario.joelfernandezpractica3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button botonMesa,botonControlador,botonSoftware,botonAcces,botonCascos,botonMonitor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonMesa=(Button)findViewById(R.id.btnmesas);
        botonAcces=(Button)findViewById(R.id.btnacces);
        botonCascos=(Button)findViewById(R.id.btncascos);
        botonControlador=(Button)findViewById(R.id.btncontrolador);
        botonSoftware=(Button)findViewById(R.id.btnsoftware);
        botonMonitor=(Button)findViewById(R.id.btnmonitor);
        Controlador control = new Controlador(this);

        botonSoftware.setOnClickListener(control);
        botonControlador.setOnClickListener(control);
        botonCascos.setOnClickListener(control);
        botonAcces.setOnClickListener(control);
        botonMesa.setOnClickListener(control);
        botonMonitor.setOnClickListener(control);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
