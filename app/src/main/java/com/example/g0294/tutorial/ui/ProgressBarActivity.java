package com.example.g0294.tutorial.ui;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.g0294.tutorial.R;

public class ProgressBarActivity extends AppCompatActivity implements View.OnClickListener {
    private ProgressBar progressBar1, progressBar2;
    private Button btn_sub, btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar_layout);
        progressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        btn_sub = (Button) findViewById(R.id.btn_sub);
        btn_add = (Button) findViewById(R.id.btn_add);

        progressBar1.getIndeterminateDrawable().setColorFilter(0xF0FF6536, PorterDuff.Mode.MULTIPLY);
        btn_sub.setOnClickListener(this);
        btn_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sub:
                progressBar2.incrementProgressBy(-5);
                break;
            case R.id.btn_add:
                progressBar2.incrementProgressBy(5);
                break;
        }
    }
}
