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
import ubahn.joel.ubahnproject.control.ReclyceRuta;
import ubahn.joel.ubahnproject.control.RecycleLineas;

public class Ruta extends AppCompatActivity {
    Bundle bundle;
    ArrayList<String> rutaa_estaciones=new ArrayList<>();
    RecyclerView mRecycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruta);
        Intent intent = this.getIntent();
        bundle = intent.getExtras();
        this.rutaa_estaciones= (ArrayList<String>) bundle.getSerializable("ruta");
        RecyclerView rv = (RecyclerView)findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);
        mRecycleView=(RecyclerView)findViewById(R.id.rv_recycler_view);
        ReclyceRuta adapter = new ReclyceRuta(rutaa_estaciones,this,mRecycleView);
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
    }
}
