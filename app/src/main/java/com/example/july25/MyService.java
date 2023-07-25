package com.example.july25;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();


        Toast.makeText(this, "On Create Triggered", Toast.LENGTH_SHORT).show();
        Log.e("Service", "On Create Triggered");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "On Start Command Triggered", Toast.LENGTH_SHORT).show();
        Log.e("Service", "On Start Command Triggered");

        for (int i = 0; i < 10; i++) {
            Log.e("number", "count"+i);

        }

        return START_STICKY;
//        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {

        Toast.makeText(this, "On Destroy Triggered", Toast.LENGTH_SHORT).show();
        Log.e("Service", "On Destroy Triggered");

        super.onDestroy();
    }
}