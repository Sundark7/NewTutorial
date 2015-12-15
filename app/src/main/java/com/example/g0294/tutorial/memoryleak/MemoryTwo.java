package com.example.g0294.tutorial.memoryleak;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.g0294.tutorial.R;

public class MemoryTwo extends Activity{
    public static final String TAG = "Memory Two";

    private Object[] mObjs = new Object[10000];//快速消耗記憶體
    private Button mBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memorytwo_layout);
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                for (int i = 0; i < mObjs.length; i++) {
                    mObjs[i] = new Object();
                }

                finish();
            }
        });

        ActivityManager.instance().registActivity(this);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
//        ActivityManager.instance().unRigistActivity(this);
    }
}
