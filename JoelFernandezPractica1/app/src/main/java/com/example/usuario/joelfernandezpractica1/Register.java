package com.example.usuario.joelfernandezpractica1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Usuario on 10/06/2016.
 */
public class Register extends Fragment {
    Button buttonregister,buttoncancel;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register, container, false);
        buttonregister=(Button)view.findViewById(R.id.buttonregister);
        buttoncancel=(Button)view.findViewById(R.id.buttoncancel);
        View.OnClickListener control = new Controlador(this.getContext());
        buttonregister.setOnClickListener(control);
        buttoncancel.setOnClickListener(control);
        return view;
    }
}
