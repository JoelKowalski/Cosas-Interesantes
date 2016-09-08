package com.rubik.notificationsservice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Recibimos los datos del intent
        Intent i=getIntent();

        byte [] img_zip = i.getExtras().getByteArray("BITMAP");
        Long time = i.getLongExtra("TIME",0);

        Bitmap bitmap = BitmapFactory.decodeByteArray(img_zip,0,img_zip.length);

        //Referencias a los objetos
        TextView tiempoLBL = (TextView) findViewById(R.id.textView);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        //Asignamos valor a los objetos
        tiempoLBL.setText(time.toString());
        imageView.setImageBitmap(bitmap);
        iniciarAlarma(60000,this);

    }
    private static void iniciarAlarma (long tiempo, Context context)
    {
        Intent intentAlarm = new Intent(context, ReceiverAlarma.class);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pi = PendingIntent.getBroadcast(context, 1, intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT);
        long saltar_en;
        Calendar tiempoactual = Calendar.getInstance();

        saltar_en=tiempo+tiempoactual.getTimeInMillis();
        alarmManager.set(AlarmManager.RTC_WAKEUP, saltar_en, pi);//TIempo, No es el tiempo que falta. Es el tiempo expresado en milisegundos equivalente a la fecha y hora del omento en que se quiere ejecutar

    }

}
