package com.example.g0294.tutorial.services;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.g0294.tutorial.R;

public class ServiceActivity extends AppCompatActivity {
    MyBindService myBindService;
    private boolean mBound = false;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBindService = ((MyBindService.ServiceBinder) service).getService();
            myBindService.custom();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            myBindService = null;
            mBound = false;
        }

    };
    protected View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent startIntent = new Intent(ServiceActivity.this, MyStartService.class);
            Intent bindIntent = new Intent(ServiceActivity.this, MyBindService.class);
            Intent intent = new Intent(ServiceActivity.this, MyIntentService.class);
            switch (v.getId()) {
                case R.id.startSer1:
                    startService(startIntent);
                    break;
                case R.id.stopSer1:
                    stopService(startIntent);
                    break;
                case R.id.bindSer1:
                    bindService(bindIntent, serviceConnection, BIND_AUTO_CREATE);
                    break;
                case R.id.unBindSer1:
                    if (mBound) {
                        unbindService(serviceConnection);
                        mBound = false;
                    }
                    break;
                case R.id.intentService:
                    startService(intent);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        if (mBound) {
            unbindService(serviceConnection);
            mBound = false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        Button startSer1 = (Button) findViewById(R.id.startSer1);
        Button stopSer1 = (Button) findViewById(R.id.stopSer1);
        Button bindSer1 = (Button) findViewById(R.id.bindSer1);
        Button unBindSer1 = (Button) findViewById(R.id.unBindSer1);
        Button intentService = (Button) findViewById(R.id.intentService);

        startSer1.setOnClickListener(btnListener);
        stopSer1.setOnClickListener(btnListener);

        bindSer1.setOnClickListener(btnListener);
        unBindSer1.setOnClickListener(btnListener);

        intentService.setOnClickListener(btnListener);
    }
}
