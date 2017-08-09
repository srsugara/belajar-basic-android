package com.example.syauqi.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

/**
 * Created by syauqi on 09/08/17.
 */

    public class ServiceMe extends Service {
    private MediaPlayer player;


    final class ThreadMe implements Runnable{
        int serviceId;
        ThreadMe(int serviceId){
            this.serviceId = serviceId;
        }

        @Override
        public void run() {
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
                stopSelf(serviceId);
            }

        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        player= MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        player.setLooping(true);
        player.start();

        Thread thread = new Thread(new ThreadMe(startId));
        thread.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        player.stop();
    }
}
