package com.example.g0294.tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.g0294.tutorial.activitylifecycle.ActivityA;
import com.example.g0294.tutorial.adapterview.ContainerSelectActivity;
import com.example.g0294.tutorial.broadcast.BroadcastReceiverActivity;
import com.example.g0294.tutorial.customstyle.CustomStyleActivity;
import com.example.g0294.tutorial.datastorage.StorageChoseActivity;
import com.example.g0294.tutorial.fragments.FragmentExActivity;
import com.example.g0294.tutorial.gcm.GCMActivity;
import com.example.g0294.tutorial.gmap.gMapMenu;
import com.example.g0294.tutorial.layouts.LayoutsActivity;
import com.example.g0294.tutorial.memoryleak.MemoryOne;
import com.example.g0294.tutorial.multithread.ThreadMenuActivity;
import com.example.g0294.tutorial.notification.NotificationActivity;
import com.example.g0294.tutorial.services.ServiceActivity;
import com.example.g0294.tutorial.ui.UserInterfaceActivity;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    String TAG = "MainActivity";
    // protected Button layouts, inputControl, lifeCycle, customStyle, memoryLeak;
    @Bind(R.id.layouts)
    Button layouts;
    @Bind(R.id.lifeCycle)
    Button lifeCycle;
    @Bind(R.id.inputControl)
    Button inputControl;
    @Bind(R.id.customStyle)
    Button customStyle;
    @Bind(R.id.memoryLeak)
    Button memoryLeak;
    @Bind(R.id.container)
    Button container;
    @Bind(R.id.fragment)
    Button fragment;
    @Bind(R.id.multiThread)
    Button multiThread;
    @Bind(R.id.dataStorage)
    Button dataStorage;
    @Bind(R.id.gMap)
    Button gMap;
    @Bind(R.id.btn_notification)
    Button btnNotification;
    @Bind(R.id.btn_broadcast)
    Button btnBroadcast;
    @Bind(R.id.btn_service)
    Button btnService;
    @Bind(R.id.btn_gcm)
    Button btnGcm;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
        // Applcation 實際未完全關閉
        // System.exit(0);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    /* Applicaiton Variable */
        // MyApplication app = ((MyApplication) getApplicationContext());
        // String state = app.getState();
        // int num = app.myNum;
        // Log.i(TAG, state);
        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        int orientation = display.getRotation();

        if (orientation == Surface.ROTATION_90 || orientation == Surface.ROTATION_270) {
            Log.i(TAG, "OnCreate: Screen is LandScape.");
        } else
            Log.i(TAG, "OnCreate: Screen is Portrait.");

        // layouts = (Button) findViewById(R.id.layouts);
        // inputControl = (Button) findViewById(R.id.inputControl);
        // lifeCycle = (Button) findViewById(R.id.lifeCycle);
        // customStyle = (Button) findViewById(R.id.customStyle);
        // memoryLeak = (Button) findViewById(R.id.memoryLeak);

        MainClickListener listener = new MainClickListener();
        layouts.setOnClickListener(listener);
        inputControl.setOnClickListener(listener);
        lifeCycle.setOnClickListener(listener);
        customStyle.setOnClickListener(listener);
        container.setOnClickListener(listener);
        memoryLeak.setOnClickListener(listener);
        fragment.setOnClickListener(listener);
        multiThread.setOnClickListener(listener);
        dataStorage.setOnClickListener(listener);
        gMap.setOnClickListener(listener);
        btnNotification.setOnClickListener(listener);
        btnBroadcast.setOnClickListener(listener);
        btnService.setOnClickListener(listener);
        btnGcm.setOnClickListener(listener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        int dens = dm.densityDpi;
        double wi = (double) width / (double) dens;
        double hi = (double) height / (double) dens;
        double x = Math.pow(wi, 2);
        double y = Math.pow(hi, 2);
        double screenInches = Math.sqrt(x + y);
        Log.i("MainActivity", "Device Width:" + width + ", Height:" + height + ", DensityDpi" + dens
                + ", Screen Size:" + screenInches);
    }

    class MainClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            switch (v.getId()) {
                case R.id.layouts:
                    intent.setClass(getApplicationContext(), LayoutsActivity.class);
                    startActivity(intent);
                    break;
                case R.id.inputControl:
                    intent.setClass(MainActivity.this, UserInterfaceActivity.class);
                    startActivity(intent);
                    break;
                case R.id.lifeCycle:
                    if (BuildConfig.life_cycle) {
                        Toast.makeText(getApplicationContext(), "這是專業版功能!", Toast.LENGTH_SHORT).show();
                    } else {
                        intent.setClass(MainActivity.this, ActivityA.class);
                        startActivity(intent);
                    }
                    break;
                case R.id.customStyle:
                    intent.setClass(MainActivity.this, CustomStyleActivity.class);
                    startActivity(intent);
                    break;
                case R.id.container:
                    intent.setClass(MainActivity.this, ContainerSelectActivity.class);
                    startActivity(intent);
                    break;
                case R.id.memoryLeak:
                    intent.setClass(MainActivity.this, MemoryOne.class);
                    startActivity(intent);
                    break;
                case R.id.fragment:
                    intent.setClass(MainActivity.this, FragmentExActivity.class);

                    startActivity(intent);
                    break;
                case R.id.multiThread:
                    intent.setClass(MainActivity.this, ThreadMenuActivity.class);
                    startActivity(intent);
                    break;
                case R.id.dataStorage:
                    intent.setClass(MainActivity.this, StorageChoseActivity.class);
                    startActivity(intent);
                    break;
                case R.id.gMap:
                    intent.setClass(MainActivity.this, gMapMenu.class);
                    startActivity(intent);
                    break;
                case R.id.btn_notification:
                    intent.setClass(MainActivity.this, NotificationActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_broadcast:
                    intent.setClass(MainActivity.this, BroadcastReceiverActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_service:
                    intent.setClass(MainActivity.this, ServiceActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_gcm:
                    intent.setClass(MainActivity.this, GCMActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}
