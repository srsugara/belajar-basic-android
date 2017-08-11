package com.example.syauqi.myapplication;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by syauqi on 11/08/17.
 */

public class IntentServiceMe extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * parameter name Used to name the worker thread, important only for debugging.
     */
    private MediaPlayer player;

    public IntentServiceMe() {
        super("My Working Thread");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(),"Start Service", Toast.LENGTH_LONG).show();
        player= MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        player.setLooping(true);
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int i = 0;
        synchronized (this){
            while(i<10){
                try {
                    wait(1500);
                    i++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        Toast.makeText(getApplicationContext(),"Stop Service", Toast.LENGTH_LONG).show();
    }
}
