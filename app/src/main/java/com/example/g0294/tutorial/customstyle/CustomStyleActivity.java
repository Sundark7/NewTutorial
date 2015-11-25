package com.example.g0294.tutorial.customstyle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.g0294.tutorial.R;

public class CustomStyleActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_back, ninePatch, drawable_shape;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_style_layout);

        ninePatch = (Button)findViewById(R.id.nine_patch);
        ninePatch.setOnClickListener(this);

        drawable_shape = (Button)findViewById(R.id.drawable_shape);
        drawable_shape.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.nine_patch:
                setContentView(R.layout.nine_patch_layout);
                btn_back = (Button)findViewById(R.id.btn_back);
                if (btn_back!=null)
                    btn_back.setOnClickListener(this);
                break;
            case R.id.drawable_shape:
                setContentView(R.layout.shape_demo_layout);
                btn_back = (Button)findViewById(R.id.btn_back);
                if (btn_back!=null)
                    btn_back.setOnClickListener(this);
                break;
            case R.id.btn_back:
                setContentView(R.layout.custom_style_layout);
                break;

        }
    }
}
