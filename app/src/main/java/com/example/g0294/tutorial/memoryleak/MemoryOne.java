package com.example.g0294.tutorial.memoryleak;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.g0294.tutorial.R;

public class MemoryOne extends Activity{
    public static final String TAG = "Memory One";

    private Button mBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memoryone_layout);
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MemoryOne.this, MemoryTwo.class);
                startActivity(intent);
            }
        });

        ActivityManager.instance().registActivity(this);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.instance().unRigistActivity(this);
    }
}
