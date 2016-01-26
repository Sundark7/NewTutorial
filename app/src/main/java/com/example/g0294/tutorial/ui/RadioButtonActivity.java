package com.example.g0294.tutorial.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.g0294.tutorial.R;

public class RadioButtonActivity extends AppCompatActivity {
    private TextView textView;
    private RadioGroup radioGroup;
    private RadioButton radioButton_boy, radioButton_girl;
    private Button radio_clear, child;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiobutton_layout);
        textView = (TextView) findViewById(R.id.radiogroup_info_id);

        //radioGroup
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_sex);
        radioButton_boy = (RadioButton) findViewById(R.id.boy);
        radioButton_girl = (RadioButton) findViewById(R.id.girl);
        child = (Button) findViewById(R.id.radio_add_child);
        //---
        radioGroup.setOnCheckedChangeListener(new myOnCheckedChangeListener());
        radio_clear = (Button) findViewById(R.id.radio_clear);
        radio_clear.setOnClickListener(new myOnClickListener());
        child.setOnClickListener(new myOnClickListener());
    }

    class myOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            int id = radioGroup.getCheckedRadioButtonId();
            switch (id) {
                case R.id.girl:
                    textView.setText("選擇的是:" + radioButton_girl.getText());
                    break;
                case R.id.boy:
                    textView.setText("選擇的是:" + radioButton_boy.getText());
                    break;
                default:
                    textView.setText("選擇了新增的選項");
                    break;
            }
        }
    }

    class myOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            radio_clear = (Button) view;
            switch (radio_clear.getId()) {
                case R.id.radio_clear:
                    radioGroup.check(-1);
                    textView.setText("請選擇的性別?");
                    break;
                case R.id.radio_add_child:
                    RadioButton newRadio = new RadioButton(getApplicationContext());
                    newRadio.setText("新增");
                    newRadio.setTextColor(Color.BLACK);
                    radioGroup.addView(newRadio, radioGroup.getChildCount());
                    break;
                default:
                    break;
            }
        }
    }
}
