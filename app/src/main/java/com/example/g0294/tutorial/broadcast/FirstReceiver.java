package com.example.g0294.tutorial.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class FirstReceiver extends BroadcastReceiver {
    private static final String TAG = "FirstReceiver";

    public FirstReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // an Intent broadcast.
        String msg = intent.getStringExtra("msg");
        Log.i(TAG, "FirstReceiver: " + msg);
    }
}
