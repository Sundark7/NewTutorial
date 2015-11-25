package com.example.g0294.tutorial.layouts;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.g0294.tutorial.R;

public class RelativeActivity extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.relative_layout);
    Log.i("Releative","Test Debuggable");
  }
}
