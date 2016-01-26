package com.example.g0294.tutorial.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ThirdReceiver extends BroadcastReceiver {
    private static final String TAG = "ThirdReceiver";

    public ThirdReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // an Intent broadcast.
        String msg = intent.getStringExtra("msg");
        Log.i(TAG, "ThirdReceiver: " + msg);

        //Order Broadcast 才能中斷
        //abortBroadcast();
    }
}
