package ubahn.joel.ubahnproject.control;

import android.app.Activity;
import android.app.DialogFragment;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import android.widget.EditText;
import android.widget.RadioButton;

import android.widget.TextView;


import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import ubahn.joel.ubahnproject.R;
import ubahn.joel.ubahnproject.utils.DialogFragmentView;
import ubahn.joel.ubahnproject.utils.Utils;
import ubahn.joel.ubahnproject.mailsender.RetreiveFeedTask;
import ubahn.joel.ubahnproject.model.Estacion;
import ubahn.joel.ubahnproject.remote.AsyncTaskDescargaEstaciones;
import ubahn.joel.ubahnproject.view.AttCliente;
import ubahn.joel.ubahnproject.view.Estaciones;

/**
 * Created by Usuario on 09/01/2017.
 */
public class Controlador implements View.OnClickListener {


    private RadioButton info,queja;
    private static EditText nombre,apellido1,apellido2,correo,telefono,comentarios,origen,destino,documento;
    private TextView TVnombre,TVapellido1,TVapellido2,TVcorreo,TVTelefono,TVcomentarios,Tvdocumento;

    Context c;
    AttCliente attCliente;
    public Controlador(Context c) {
        this.c = c;
    }
    @Override
    public void onClick(View v) {
        inicializar();
        int vista = v.getId();
        switch (vista) {
            case R.id.radio0:
                if(info.isChecked()){
                    TVnombre.setVisibility(View.VISIBLE);
                    nombre.setVisibility(View.VISIBLE);
                    TVapellido1.setVisibility(View.VISIBLE);
                    apellido1.setVisibility(View.VISIBLE);
                    TVapellido2.setVisibility(View.VISIBLE);
                    apellido2.setVisibility(View.VISIBLE);
                    TVcorreo.setVisibility(View.VISIBLE);
                    correo.setVisibility(View.VISIBLE);
                    TVTelefono.setVisibility(View.VISIBLE);
                    telefono.setVisibility(View.VISIBLE);
                    TVcomentarios.setVisibility(View.VISIBLE);
                    comentarios.setVisibility(View.VISIBLE);
                    documento.setVisibility(View.INVISIBLE);

                }
                break;
            case R.id.radio1:
                if(queja.isChecked()){
                    TVnombre.setVisibility(View.VISIBLE);
                    nombre.setVisibility(View.VISIBLE);
                    TVapellido1.setVisibility(View.VISIBLE);
                    apellido1.setVisibility(View.VISIBLE);
                    TVapellido2.setVisibility(View.VISIBLE);
                    apellido2.setVisibility(View.VISIBLE);
                    TVcorreo.setVisibility(View.VISIBLE);
                    correo.setVisibility(View.VISIBLE);
                    TVTelefono.setVisibility(View.VISIBLE);
                    telefono.setVisibility(View.VISIBLE);
                    TVcomentarios.setVisibility(View.VISIBLE);
                    comentarios.setVisibility(View.VISIBLE);
                    documento.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.enviarcorreo:

                if(!nombre.getText().toString().isEmpty() && !apellido1.getText().toString().isEmpty()
                        && !telefono.getText().toString().isEmpty()&& !correo.getText().toString().isEmpty() && !comentarios.getText().toString().isEmpty()){


                    Session session = null;


                    Properties props = new Properties();
                    props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.socketFactory.port", "465");
                    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.port", "465");

                    session = Session.getDefaultInstance(props, new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                          return new PasswordAuthentication(Utils.CORREO, Utils.KEY);
                        }
                    });

                    RetreiveFeedTask task = new RetreiveFeedTask();
                    task.execute(session);
                    attCliente = (AttCliente) c;
                    attCliente.acabar();
                }else{
                    attCliente = (AttCliente) c;
                    DialogFragment newFragment = new DialogFragmentView();
                    newFragment.show(attCliente.getFragmentManager(),"");
                }
                break;
            case R.id.editTextorigen:
                AbrirActivity(Utils.ORIGEN);
                break;
            case R.id.editTextdestino:
                AbrirActivity(Utils.DESTINO);
                break;
        }

    }

    private void AbrirActivity(int quien) {
        Activity a = null;
        a = (Activity) c;
        Intent i=new Intent(c, Estaciones.class);
        i.putExtra("quien",quien);
        a.startActivityForResult(i, quien);
    }
    public List<Estacion> descargarEstaciones() throws ExecutionException, InterruptedException {
        List<Estacion>lista;
        lista = new AsyncTaskDescargaEstaciones(c).execute().get();
        return lista;
    }
    private void inicializar(){
        Activity a = null;
        a = (Activity) c;
        info = (RadioButton) a.findViewById(R.id.radio0);
        queja= (RadioButton) a.findViewById(R.id.radio1);
        nombre=(EditText)a.findViewById(R.id.editText3);
        apellido1=(EditText)a.findViewById(R.id.editText4);
        apellido2=(EditText)a.findViewById(R.id.editText5);
        correo=(EditText)a.findViewById(R.id.editText6);
        telefono=(EditText)a.findViewById(R.id.editText7);
        comentarios=(EditText)a.findViewById(R.id.editText8);
        TVnombre=(TextView)a.findViewById(R.id.textView11);
        TVapellido1=(TextView)a.findViewById(R.id.textView12);
        TVapellido2=(TextView)a.findViewById(R.id.textView13);
        TVcorreo=(TextView)a.findViewById(R.id.textView14);
        TVTelefono=(TextView)a.findViewById(R.id.textView15);
        TVcomentarios=(TextView)a.findViewById(R.id.textView16);
        origen=(EditText)a.findViewById(R.id.editTextorigen);
        destino=(EditText)a.findViewById(R.id.editTextdestino);
        Tvdocumento=(TextView)a.findViewById(R.id.textView23);
        documento=(EditText)a.findViewById(R.id.editText9);
    }
    public static String dameContenido(){
        String contenido="";
        contenido += "Nombre: "+nombre.getText().toString();
        contenido += "Apellido: "+apellido1.getText().toString();
        contenido += "Correo: "+correo.getText().toString();
        contenido += "Telefono: "+telefono.getText().toString();
        contenido += "Comentarios: "+comentarios.getText().toString();
        return contenido;
    }
}
