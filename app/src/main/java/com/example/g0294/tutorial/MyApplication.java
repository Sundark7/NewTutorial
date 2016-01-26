package com.example.g0294.tutorial;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

public class MyApplication extends Application {
//    protected RefWatcher refWatcher;
    int myNum = 10;
    private String myState;

    public String getState() {
        return myState;
    }

    public void setState(String s) {
        myState = s;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("Application", "onCreate");
        myState = "From Application";
//        refWatcher = LeakCanary.install(this);
    }

    @Override
    public void onTerminate() {
        Log.i("Application", "onTerminate");
        super.onTerminate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i("Application", "onConfigurationChanged");
    }
}
