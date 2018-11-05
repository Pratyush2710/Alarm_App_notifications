package com.example.pratyush.alarmmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class  AlertReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationHelper notificationhelper=new NotificationHelper(context);
        NotificationCompat.Builder nb=notificationhelper.getchannelNotification("Alarm",
                "Time to close your Module:- MODULE CLOSE :-)");
        notificationhelper.getManager().notify(1,nb.build());
    }
}
