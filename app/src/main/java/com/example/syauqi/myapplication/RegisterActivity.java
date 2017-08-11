package com.example.syauqi.myapplication;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {
    Button btnRegister,btnPlay;
    Drawable iconPhone;
    EditText user;
    int i=0,j=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);;
        iconPhone = getResources().getDrawable( R.drawable.phone);
        ColorFilter filter = new LightingColorFilter( Color.WHITE, Color.WHITE );
        iconPhone.setColorFilter(filter);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnPlay = (Button) findViewById(R.id.btnPlay);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                sendBroadcast(new Intent("NOTIFICATION_REGISTER"));
                if(i%2!=0) {
                    startAlarm(true);
                }else{
                    startAlarm(false);
                }
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j++;
                if(j%2!=0) {
                    startService();
                    btnPlay.setText("Stop");
                }else{
                    stopService();
                    btnPlay.setText("Play");
                }
            }
        });
    }

    public void startAlarm(Boolean x){
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        //Intent myIntent;
        PendingIntent pendingIntent;
        //myIntent = new Intent(RegisterActivity.this,NotificationReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this,0,new Intent("MANTAP_JIWA"),0);
        if(x){
        //alarmManager.set(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime()+10000,pendingIntent);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime()+5000,15000,pendingIntent);
        }else{
            alarmManager.cancel(pendingIntent);
        }
    }

    public void startService(){
        Intent intent = new Intent(this, IntentServiceMe.class);
        startService(intent);
    }

    public void stopService(){
        Intent intent = new Intent(this,IntentServiceMe.class);
        stopService(intent);
    }
}
