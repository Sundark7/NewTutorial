package com.example.g0294.tutorial.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.g0294.tutorial.R;

public class EditTextActivity extends Activity {
    private EditText editText, edit_digits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_text_layout);

        edit_digits = (EditText)findViewById(R.id.edit_digits);
        edit_digits.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("EditTextActivity", "Touch Count!");
                        edit_digits.setFocusableInTouchMode(true);
                    }
                }
        );

        editText = (EditText) findViewById(R.id.edit_text);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Toast.makeText(EditTextActivity.this, String.valueOf(actionId), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        Button getValue = (Button) findViewById(R.id.btn_get_value);
        getValue.setOnFocusChangeListener(
                new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        Log.d("EditTextActivity", "Touch is " + getWindow().getCurrentFocus());
                    }
                }
        );
        getValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditTextActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        Button all = (Button) findViewById(R.id.btn_all);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.selectAll();
            }
        });

        Button getSelect = (Button) findViewById(R.id.btn_get_select);
        getSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int start = editText.getSelectionStart();
                int end = editText.getSelectionEnd();
                CharSequence selectText = editText.getText().subSequence(start, end);
                Toast.makeText(EditTextActivity.this, selectText, Toast.LENGTH_SHORT).show();
            }
        });

    }

}
