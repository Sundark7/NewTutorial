package com.example.g0294.tutorial.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.g0294.tutorial.R;

public class UserInterfaceActivity extends Activity {
    private Button btn_textView, btn_editText, btn_imageView, btn_button, btn_ratoteImage, btn_imageResize,
            btn_checkBox, btn_radioButton, btn_datetimePicker, btn_progressBar, btn_seekBar, btn_toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_interface_layout);
        SelectActivity listener = new SelectActivity();
        btn_textView = (Button) findViewById(R.id.btn_textView);
        btn_textView.setOnClickListener(listener);
        btn_editText = (Button) findViewById(R.id.btn_editText);
        btn_editText.setOnClickListener(listener);
        btn_imageView = (Button) findViewById(R.id.btn_imageView);
        btn_imageView.setOnClickListener(listener);
        btn_button = (Button) findViewById(R.id.btn_button);
        btn_button.setOnClickListener(listener);
        btn_ratoteImage = (Button) findViewById(R.id.btn_rotateImage);
        btn_ratoteImage.setOnClickListener(listener);
        btn_imageResize = (Button) findViewById(R.id.btn_imageResize);
        btn_imageResize.setOnClickListener(listener);
    }

    class SelectActivity implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            switch (view.getId()) {
                case R.id.btn_textView:
                    intent.setClass(getApplicationContext(), TextViewActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_editText:
                    intent.setClass(getApplicationContext(), EditTextActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_imageView:
                    intent.setClass(getApplicationContext(), ImageViewActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_rotateImage:
                    intent.setClass(getApplicationContext(), ImageZoomActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_imageResize:
                    intent.setClass(getApplicationContext(), ImageResizeActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_button:
                    intent.setClass(getApplicationContext(), ButtonActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}
