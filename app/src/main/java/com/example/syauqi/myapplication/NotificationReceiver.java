package com.example.syauqi.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by syauqi on 10/08/17.
 */

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction()=="NOTIFICATION_REGISTER"){
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

            builder.setAutoCancel(true)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Register Success")
                    .setContentText("Your account has been registered")
                    .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND)
                    .setContentInfo("Info");

            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(1,builder.build());
        }else if(intent.getAction()=="android.intent.action.ACTION_POWER_DISCONNECTED"){
            Toast.makeText(context,"Charger Batere mu dicabut", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context,"ntaps soul brader !", Toast.LENGTH_LONG).show();
        }
    }
}
