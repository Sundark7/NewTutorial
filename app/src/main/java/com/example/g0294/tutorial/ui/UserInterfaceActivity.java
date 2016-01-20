package com.example.g0294.tutorial.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.g0294.tutorial.R;

public class UserInterfaceActivity extends Activity {
    private Button btn_textView, btn_editText, btn_imageView, btn_button, btn_ratoteImage, btn_imageResize,
            btn_checkBox, btn_radioButton, btn_datetimePicker, btn_progressBar, btn_seekBar, btn_toast,
            btn_alertDialog, btn_webView;

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
        btn_toast = (Button) findViewById(R.id.btn_toast);
        btn_toast.setOnClickListener(listener);
        btn_checkBox = (Button) findViewById(R.id.btn_checkBox);
        btn_checkBox.setOnClickListener(listener);
        btn_progressBar = (Button) findViewById(R.id.btn_progressBar);
        btn_progressBar.setOnClickListener(listener);
        btn_seekBar = (Button) findViewById(R.id.btn_seekBar);
        btn_seekBar.setOnClickListener(listener);
        btn_alertDialog = (Button) findViewById(R.id.btn_alertDialog);
        btn_alertDialog.setOnClickListener(listener);
        btn_radioButton = (Button) findViewById(R.id.btn_radioButton);
        btn_radioButton.setOnClickListener(listener);
        btn_webView = (Button) findViewById(R.id.btn_webView);
        btn_webView.setOnClickListener(listener);
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
                case R.id.btn_checkBox:
                    intent.setClass(getApplicationContext(), CheckBoxActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_progressBar:
                    intent.setClass(getApplicationContext(), ProgressBarActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_seekBar:
                    intent.setClass(getApplicationContext(), SeekRatingBarActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_alertDialog:
                    intent.setClass(getApplicationContext(), AlertDialogActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_radioButton:
                    intent.setClass(getApplicationContext(), RadioButtonActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_webView:
                    intent.setClass(getApplicationContext(), WebViewActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_toast:
                    LayoutInflater inflater = getLayoutInflater();
                    View customToast = inflater.inflate(R.layout.mytoast_layout, null);

                    TextView text = (TextView) customToast.findViewById(R.id.tvContent);
                    text.setText("This is a custom toast");
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setView(customToast);
                    toast.show();
                    break;
            }
        }
    }
}
