package ubahn.joel.ubahnproject.view;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ExecutionException;
import ubahn.joel.ubahnproject.R;
import ubahn.joel.ubahnproject.control.Controlador;
import ubahn.joel.ubahnproject.control.NavigationMenuListener;
import ubahn.joel.ubahnproject.model.Estacion;
import ubahn.joel.ubahnproject.remote.AsyncTaskDameRuta;
import ubahn.joel.ubahnproject.utils.DialogFragmentView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private boolean menu_visible;

    private EditText origen,destino;
    public Controlador control;
    NavigationView navigationView;
    Button datebutton,dijkstra;
    Calendar c=Calendar.getInstance();
    ArrayList<String> rutaa_estaciones=new ArrayList<String>();
    int cdate,cmonth,cyear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu_visible = true;
        inicializar();
        View.OnClickListener control = new Controlador(this);
        origen.setOnClickListener(control);
        destino.setOnClickListener(control);
        navigationView.setNavigationItemSelectedListener(new NavigationMenuListener(this));

        drawerLayout.openDrawer(Gravity.LEFT);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.menuicon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);






    }


    private void inicializar(){
        navigationView = (NavigationView) findViewById(R.id.navview);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        origen=(EditText)findViewById(R.id.editTextorigen);
        destino=(EditText)findViewById(R.id.editTextdestino);
        dijkstra=(Button)findViewById(R.id.button4);
    }

    public void vertrenes(View v){
        String esOrigen=origen.getText().toString();
        String esDestino=destino.getText().toString();
        int codigoOrigen=0;
        int codigoDestino=0;
        if(!origen.getText().toString().trim().isEmpty() && !destino.getText().toString().trim().isEmpty()){
            ArrayList<Estacion> estaciones= (ArrayList<Estacion>) Estaciones.getListaestaciones();

            for(int i=0;i<estaciones.size();i++){
                if(esOrigen.equals(estaciones.get(i).getNombre())){
                    codigoOrigen=estaciones.get(i).getId();

                }
                if(esDestino.equals(estaciones.get(i).getNombre())){
                    codigoDestino=estaciones.get(i).getId();

                }
            }
            try {
                rutaa_estaciones= (ArrayList<String>) new AsyncTaskDameRuta(this).execute("nombre=" + codigoOrigen + "-" + codigoDestino).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            Intent intent =new Intent(this,Ruta.class);
            intent.putExtra("ruta",rutaa_estaciones);
            startActivity(intent);
        }else{
            DialogFragment newFragment = new DialogFragmentView();
            newFragment.show(getFragmentManager(), "dialog");
        }


    }
    public void cambiar(View v){
        String aux="";
        aux=origen.getText().toString();
        origen.setText(destino.getText().toString());
        destino.setText(aux);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case android.R.id.home:
                if (menu_visible)
                {
                    drawerLayout.closeDrawers();
                    menu_visible = false;
                } else
                {
                    drawerLayout.openDrawer(GravityCompat.START);
                    menu_visible = true;
                }
        }

        return super.onOptionsItemSelected(item);
    }

    public void cierramenu() {
        drawerLayout.closeDrawers();
        menu_visible = false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

            if(resultCode == this.RESULT_OK){
                String result=data.getStringExtra("result");
                int resultadoquien=data.getIntExtra("quienes",0);
                if(resultadoquien==1) {
                    origen.setText(result);
                }
                if(resultadoquien==2){
                    destino.setText(result);
                }
            }
            if (resultCode == this.RESULT_CANCELED) {
                //Write your code if there's no result
            }
    }
}
