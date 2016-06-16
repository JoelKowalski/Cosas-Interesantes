package com.example.usuario.joelfernandezpractica1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Created by Usuario on 10/06/2016.
 */
public class Login extends Fragment {
    Button buttonlogin,buttoncancel;
    CheckBox checkBox;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login, container, false);
        buttonlogin=(Button)view.findViewById(R.id.buttonlogin);
        buttoncancel=(Button)view.findViewById(R.id.buttoncancel);
        checkBox=(CheckBox)view.findViewById(R.id.checkBox);
        View.OnClickListener control = new Controlador(this.getContext());
        buttonlogin.setOnClickListener(control);
        buttoncancel.setOnClickListener(control);
        checkBox.setOnClickListener(control);
        return view;
    }




}
