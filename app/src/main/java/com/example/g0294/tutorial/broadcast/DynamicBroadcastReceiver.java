package com.example.g0294.tutorial.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class DynamicBroadcastReceiver extends BroadcastReceiver {
    public DynamicBroadcastReceiver() {
    }
//
//    public static boolean isNetworkAvailable(Context context) {
//        ConnectivityManager mgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        if (mgr != null) {
//            NetworkInfo networkInfo = mgr.getActiveNetworkInfo();
//            if (networkInfo != null && networkInfo.isConnected()) {
//                return true;
//            }
//        }
//        return false;
//    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "網路狀態改變!", Toast.LENGTH_SHORT).show();
        // an Intent broadcast.
//        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
//            if (!isNetworkAvailable(context)) {
//                Toast.makeText(context, "請檢查網路狀態!", Toast.LENGTH_SHORT).show();
//            }
//        }
        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
