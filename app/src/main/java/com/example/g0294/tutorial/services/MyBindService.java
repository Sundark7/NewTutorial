package com.example.g0294.tutorial.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Date;

public class MyBindService extends Service {
    private final IBinder mBinder = new ServiceBinder();
    private String TAG = "MyBindService";
    private Handler handler = new Handler();
    private Runnable showTime = new Runnable() {
        public void run() {
            Log.i("time:", new Date().toString());
            handler.postDelayed(this, 1000);
        }
    };

    public void custom() {
        handler.postDelayed(showTime, 1000);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind()");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
        handler.removeCallbacks(showTime);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate()");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind()");
        return mBinder;
    }

    public class ServiceBinder extends Binder {
        MyBindService getService() {
            return MyBindService.this;
        }
    }
}
