package com.example.g0294.tutorial.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.g0294.tutorial.R;

public class CheckBoxActivity extends Activity implements View.OnClickListener {
    private CheckBox basketball, tennis, baseball, table_tennis;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbox_layout);
        basketball = (CheckBox) findViewById(R.id.basketball);
        basketball.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String checked = isChecked ? "選擇" : "取消選擇";
                Toast.makeText(CheckBoxActivity.this, buttonView.getText() + checked, Toast.LENGTH_SHORT).show();
            }
        });
        baseball = (CheckBox) findViewById(R.id.baseball);
        tennis = (CheckBox) findViewById(R.id.tennis);
        table_tennis = (CheckBox) findViewById(R.id.table_tennis);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String s = "";
        boolean flag = false;
        if (basketball.isChecked()) {
            s += basketball.getText().toString() + ",";
            flag = true;
        }
        if (baseball.isChecked()) {
            s += baseball.getText().toString() + ",";
            flag = true;
        }
        if (tennis.isChecked()) {
            s += tennis.getText().toString() + ",";
            flag = true;
        }
        if (table_tennis.isChecked()) {
            s += table_tennis.getText().toString() + ",";
            flag = true;
        }
        if (!flag) {
            Toast.makeText(this, "沒有選擇任何項目", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, s.substring(0, s.length() - 1), Toast.LENGTH_SHORT).show();
        }
    }
}
