package com.example.g0294.tutorial.layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.g0294.tutorial.R;

public class LayoutsActivity extends AppCompatActivity {

    private Button btn_linear, btn_relative, btn_table, btn_inflate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layouts);

        btn_linear = (Button) findViewById(R.id.linearLayout);
        btn_relative = (Button) findViewById(R.id.relativeLayout);
        btn_table = (Button) findViewById(R.id.tableLayout);
        btn_inflate = (Button) findViewById(R.id.inflateLayout);

        ButtonListener buttonListener = new ButtonListener();
        btn_linear.setOnClickListener(buttonListener);
        btn_relative.setOnClickListener(buttonListener);
        btn_table.setOnClickListener(buttonListener);
        btn_inflate.setOnClickListener(buttonListener);
    }


    class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            switch (v.getId()) {
                case R.id.linearLayout:
                    intent.setClass(getApplicationContext(), LinearActivity.class);
                    startActivity(intent);
                    break;
                case R.id.relativeLayout:
                    intent.setClass(getApplicationContext(), RelativeActivity.class);
                    startActivity(intent);
                    break;
                case R.id.tableLayout:
                    intent.setClass(getApplicationContext(), TableActivity.class);
                    startActivity(intent);
                    break;
                case R.id.inflateLayout:
                    intent.setClass(getApplicationContext(), InflateActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}
