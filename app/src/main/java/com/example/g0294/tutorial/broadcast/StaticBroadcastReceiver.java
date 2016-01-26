package com.example.g0294.tutorial.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class StaticBroadcastReceiver extends BroadcastReceiver {
    public static final String Receiver = "com.example.g0294.tutorial.broadcast";
    public static final String BootCompleted = "android.intent.action.BOOT_COMPLETED";

    public StaticBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // an Intent broadcast.
        if (intent.getAction().equals(Receiver)) {
            Log.i("StaticBroadcastReceiver", "Static Broadcast Start!");
            Toast.makeText(context, "Static Broadcast Start!", Toast.LENGTH_LONG).show();
        }
        if (intent.getAction().equals(BootCompleted)) {
            Log.i("StaticBroadcastReceiver", "BOOT Broadcast Start!");
            Toast.makeText(context, "Boot Completed Broadcast!", Toast.LENGTH_LONG).show();
        }
        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
