package com.example.g0294.tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.g0294.tutorial.activitylifecycle.ActivityA;
import com.example.g0294.tutorial.customstyle.CustomStyleActivity;
import com.example.g0294.tutorial.layouts.LayoutsActivity;
import com.example.g0294.tutorial.memoryleak.MemoryOne;
import com.example.g0294.tutorial.ui.UserInterfaceActivity;


public class MainActivity extends AppCompatActivity {
    protected Button layouts, inputControl, lifeCycle, customStyle, memoryLeak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layouts = (Button) findViewById(R.id.layouts);
        inputControl = (Button) findViewById(R.id.inputControl);
        lifeCycle = (Button) findViewById(R.id.lifeCycle);
        customStyle = (Button)findViewById(R.id.customStyle);
        memoryLeak = (Button)findViewById(R.id.memoryLeak);

        MainClickListener listener = new MainClickListener();
        layouts.setOnClickListener(listener);
        inputControl.setOnClickListener(listener);
        lifeCycle.setOnClickListener(listener);
        customStyle.setOnClickListener(listener);
        memoryLeak.setOnClickListener(listener);
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
                    } else{
                        intent.setClass(MainActivity.this, ActivityA.class);
                        startActivity(intent);
                    }
                    break;
                case R.id.customStyle:
                    intent.setClass(MainActivity.this, CustomStyleActivity.class);
                    startActivity(intent);
                    break;
                case R.id.memoryLeak:
                    intent.setClass(MainActivity.this, MemoryOne.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}
