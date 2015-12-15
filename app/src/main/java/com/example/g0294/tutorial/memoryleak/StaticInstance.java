package com.example.g0294.tutorial.memoryleak;


import android.app.Activity;
import android.os.Bundle;

import com.example.g0294.tutorial.R;

public class StaticInstance extends Activity{
    static Demo sInstance = null;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memoryleak_layout);
        if (sInstance == null)
        {
            sInstance= new Demo();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sInstance=null;
    }

    class Demo
    {
        void doSomething()
        {
            System.out.print("dosth.");
        }
    }
}
