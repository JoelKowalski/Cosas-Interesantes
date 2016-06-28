package com.example.vale.textinputlayout;

import android.app.Activity;
import android.support.design.widget.TextInputLayout;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by vale on 6/06/16.
 */
public class FocusListener implements View.OnFocusChangeListener {

    private Activity actividad;

    public FocusListener (Activity activity)
    {
        this.actividad = activity;
    }

    /**
     * Idealmente, este método debería ir en un clase Util Validar o algo parecido
     */
    private boolean emailValido (String email)
    {
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
    private boolean telefonoValido(String telefono){
        return (Patterns.PHONE.matcher(telefono).matches());
    }
    private boolean esdivisible(String telefono){
        int numero=0;
        for(int i=0;i<telefono.length();i++){
           numero+=telefono.charAt(i);
        }
        if(numero%2==0){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus && v==v.findViewById(R.id.cajamail)) {

            EditText cajatextomail = (EditText)v;
            String mailintroducido = cajatextomail.getText().toString();

            if (!emailValido (mailintroducido))
            {
                TextInputLayout wrapmail = (TextInputLayout)actividad.findViewById(R.id.tilcajamail);
                wrapmail.setError("Mail Incorrecto");
            }
        }
        else if (!hasFocus && v==v.findViewById(R.id.cajatelf)) {
                EditText cajatelefono = (EditText) v;
                String telefonointroducido = cajatelefono.getText().toString();
            if(esdivisible(telefonointroducido)) {
                if (!telefonoValido(telefonointroducido)) {
                    TextInputLayout wraptelef = (TextInputLayout) actividad.findViewById(R.id.tilcajatelf);
                    wraptelef.setError("Telefono Incorrecto");
                }
            }
        }

    }
}
