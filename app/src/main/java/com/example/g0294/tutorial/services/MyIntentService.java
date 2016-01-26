package com.example.g0294.tutorial.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MyIntentService extends IntentService {
    private String TAG = "MyIntentService";
    private int i = 0;

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        DateFormat format = DateFormat.getTimeInstance();
        Log.i(TAG, "onHandleIntent() start: " + format.format(new Date()));

        Log.i(TAG, "print start, init i = " + i);
        for (; i < 5; i++) {
            Log.d(TAG, "i = " + i);
        }
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            Log.e(TAG, "Error:", e);
        }

        Log.i(TAG, "onHandleIntent() end: " + format.format(new Date()));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }
}
