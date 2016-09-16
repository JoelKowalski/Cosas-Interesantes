package com.example.usuario.joelfernandezpractica4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class BroadcastDescarga extends BroadcastReceiver {



    public BroadcastDescarga() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
