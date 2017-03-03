package ubahn.joel.ubahnproject.view;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import ubahn.joel.ubahnproject.R;
import ubahn.joel.ubahnproject.control.PagerAdapter;
import ubahn.joel.ubahnproject.control.RecycleLineas;

public class LineasyPlanos  extends FragmentActivity {

    ViewPager pager;
    PagerTabStrip tab_strp;
    Bundle bundle;
    static ArrayList<String> listaestaciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lineasy_planos);

        Intent intent = this.getIntent();
        bundle = intent.getExtras();
        this.listaestaciones= (ArrayList<String>) bundle.getSerializable("cabeceras");
        android.support.v4.view.PagerAdapter mapager=new PagerAdapter(getSupportFragmentManager(),this);

        pager=(ViewPager)findViewById(R.id.pager);
        pager.setAdapter(mapager);
        tab_strp=(PagerTabStrip)findViewById(R.id.tab_strip);
        tab_strp.setTextColor(Color.WHITE);
        tab_strp.setTextSpacing(1);


    }

   public static ArrayList<String> getLista(){
       return listaestaciones;
   }
}
