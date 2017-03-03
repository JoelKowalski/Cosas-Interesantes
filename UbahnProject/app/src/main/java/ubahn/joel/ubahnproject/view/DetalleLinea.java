package ubahn.joel.ubahnproject.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import ubahn.joel.ubahnproject.R;
import ubahn.joel.ubahnproject.control.RecycleDetalleLinea;
import ubahn.joel.ubahnproject.control.RecycleLineas;
import ubahn.joel.ubahnproject.model.Estacion;

public class DetalleLinea extends AppCompatActivity {


    Bundle bundle;
    RecyclerView mRecycleView;
    ArrayList<Estacion>listaestaciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_linea);
        Intent intent = this.getIntent();
        bundle = intent.getExtras();
        this.listaestaciones= (ArrayList<Estacion>) bundle.getSerializable("estaciones");

        RecyclerView rv = (RecyclerView)findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);
        mRecycleView=(RecyclerView)findViewById(R.id.rv_recycler_view);
        RecycleDetalleLinea adapter = new RecycleDetalleLinea(listaestaciones,this,mRecycleView);
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
    }


}
