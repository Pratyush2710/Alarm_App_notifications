package com.example.pratyush.alarmmanager;


import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

public class NotificationHelper extends ContextWrapper {

        public static final String channelid="channelid";
        public static final String channelname = "channel";
        private NotificationManager mmanager;
        public NotificationHelper(Context base) {
            super(base);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                createchannels();
            }
        }

        private void createchannels() {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                NotificationChannel notificationChannel=new NotificationChannel(channelid,channelname, NotificationManager.IMPORTANCE_DEFAULT);
                notificationChannel.enableLights(true);
                notificationChannel.enableVibration(true);
                notificationChannel.setLightColor(R.color.colorPrimary);
                notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
            }
        }
        public NotificationManager getManager(){
            if(mmanager==null){
                mmanager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
            }
            return mmanager;
        }
        public android.support.v4.app.NotificationCompat.Builder getchannelNotification(String title,String message){
            return new android.support.v4.app.NotificationCompat.Builder(getApplicationContext(),channelid)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setSmallIcon(R.drawable.ic_one);
        }
    }


