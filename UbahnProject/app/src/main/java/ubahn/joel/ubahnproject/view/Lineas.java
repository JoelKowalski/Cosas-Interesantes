package ubahn.joel.ubahnproject.view;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ubahn.joel.ubahnproject.R;
import ubahn.joel.ubahnproject.control.RecycleLineas;

public class Lineas extends Fragment {
    RecyclerView mRecycleView;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_lineas, container, false);



        RecyclerView rv = (RecyclerView)view.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);
        mRecycleView=(RecyclerView)view.findViewById(R.id.rv_recycler_view);
        RecycleLineas adapter = new RecycleLineas(LineasyPlanos.getLista(),view.getContext(),mRecycleView);
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        rv.setLayoutManager(llm);
        return view;
    }




}
