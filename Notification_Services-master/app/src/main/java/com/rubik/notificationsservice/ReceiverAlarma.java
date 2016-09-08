package com.rubik.notificationsservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ReceiverAlarma extends BroadcastReceiver {
    public ReceiverAlarma() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent intent_serv = new Intent(context, MyService.class);
        context.startService(intent_serv);

    }
}
