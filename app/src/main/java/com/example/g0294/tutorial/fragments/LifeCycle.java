package com.example.g0294.tutorial.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.g0294.tutorial.R;

public class LifeCycle extends AppCompatActivity implements View.OnClickListener {
    String TAG = "Fragment Activity";
    Fragment3 fragment3 = new Fragment3();
    Fragment4 fragment4 = new Fragment4();
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Button button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        Log.i(TAG, "onCreate()");
        manager = getFragmentManager();

        if (savedInstanceState == null) {
            manager.beginTransaction()
                    .add(R.id.right, new Fragment1(), "fragment1")
                    .commit();
            manager.beginTransaction().add(R.id.right, new Fragment2(), "fragment2").commit();
        }
        button1 = (Button) this.findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = (Button) this.findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = (Button) this.findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = (Button) this.findViewById(R.id.button4);
        button4.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

    @Override
    public void onClick(View v) {
        transaction = manager.beginTransaction();
        switch (v.getId()) {
            case R.id.button1:
                Fragment1 fragment1 = new Fragment1();
                transaction.replace(R.id.right, fragment1, "fragment1");
                transaction.addToBackStack(null);
                break;
            case R.id.button2:
                Fragment2 fragment2 = new Fragment2();
                transaction.replace(R.id.right, fragment2, "fragment2");
                transaction.addToBackStack(null);
                break;
            case R.id.button3:
                if (fragment4.isAdded()) {
                    transaction.detach(fragment4);
                    transaction.attach(fragment3);
                } else
                    transaction.replace(R.id.right, fragment3, "fragment3");
                break;
            case R.id.button4:
                if (fragment3.isAdded()) {
                    transaction.detach(fragment3);
                }
                transaction.replace(R.id.right, fragment4, "fragment4");
                break;
        }
        transaction.commit();
    }
}

