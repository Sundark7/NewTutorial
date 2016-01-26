package com.example.g0294.tutorial.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.g0294.tutorial.R;

public class ButtonActivity extends AppCompatActivity implements View.OnClickListener {
    private Button imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_layout);
        Button btn_listener = (Button) findViewById(R.id.btn_listener);

        SharedPreferences settings = getSharedPreferences("settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("name", "Google");
        editor.putString("URL", "www.google.com");
        editor.apply();

        SharedPreferences readSettings = getSharedPreferences("settings", MODE_PRIVATE);
        String name = readSettings.getString("name", "default");
        String url = readSettings.getString("URL", "default");

        btn_listener.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "嵌入Listener方式!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        ImageButton btn_imgButton = (ImageButton) findViewById(R.id.btn_imgButton);
        btn_imgButton.setOnClickListener(this);

        //Button Event
        imageButton = (Button) this.findViewById(R.id.imagebutton);
        imageButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    v.setBackgroundResource(R.drawable.button1);
                } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setBackgroundResource(R.drawable.button2);
                }
                return false;
            }
        });
        imageButton.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    v.setBackgroundResource(R.drawable.button2);
                } else {
                    v.setBackgroundResource(R.drawable.button1);
                }
            }
        });
        imageButton.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (KeyEvent.ACTION_DOWN == event.getAction()) {
                    v.setBackgroundResource(R.drawable.button3);
                } else if (KeyEvent.ACTION_UP == event.getAction()) {
                    v.setBackgroundResource(R.drawable.button2);
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        Toast toast = Toast.makeText(this,
                "Activity實作Listener方式!", Toast.LENGTH_SHORT);
        toast.show();
        //Button button = (Button) v;
    }

    // 須為public方法
    public void btnClick(View view) {
        Toast toast = Toast.makeText(this,
                "Attribute指定OnClick方法!", Toast.LENGTH_SHORT);
        toast.show();
    }

}
