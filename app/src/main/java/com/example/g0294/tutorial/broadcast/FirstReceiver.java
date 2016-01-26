package com.example.g0294.tutorial.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class FirstReceiver extends BroadcastReceiver {
    private static final String TAG = "FirstReceiver";

    public FirstReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // an Intent broadcast.
        String msg = intent.getStringExtra("msg");
        Toast.makeText(context, "First Receiver: " + msg, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "FirstReceiver: " + msg);
    }
}
