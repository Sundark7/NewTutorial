package com.example.g0294.tutorial.layouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.example.g0294.tutorial.R;

public class InflateActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* Root is null, return view with Window param*/
//        View view = getLayoutInflater().inflate(R.layout.inflate_view_layout, null);
        /* Root not null and attach false, return view with Window param*/
        View rootView = getLayoutInflater().inflate(R.layout.inflate_root_layout, null);
        View view = getLayoutInflater().inflate(R.layout.inflate_view_layout, (ViewGroup)rootView,false);
        /* Root not null and attach true, return root with Window param*/
//        View rootView = getLayoutInflater().inflate(R.layout.inflate_root_layout, null);
//        View view = getLayoutInflater().inflate(R.layout.inflate_view_layout,(ViewGroup)rootView,true);
        setContentView(view);
//        setContentView(R.layout.inflate_root_layout);
//        LinearLayout layout = (LinearLayout)findViewById(R.id.inflateRoot);
        /* Root is null, return view ignore param */
//        View view = getLayoutInflater().inflate(R.layout.inflate_view_layout, null);
//        layout.addView(view);
//        layout.addView(view, 200, 200);
        /* Root not null and attach false, return view with param*/
//        View rootView = getLayoutInflater().inflate(R.layout.inflate_root_layout, null);
//        View view = getLayoutInflater().inflate(R.layout.inflate_view_layout,layout,false);
//        layout.addView(view);
        /* Root not null and attach false, return root with param */
//        View rootView = getLayoutInflater().inflate(R.layout.inflate_root_layout, null);
//        View view = getLayoutInflater().inflate(R.layout.inflate_view_layout,(ViewGroup)rootView,true);
//        layout.addView(view);
    }
}
