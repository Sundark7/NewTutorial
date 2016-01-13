package com.example.g0294.tutorial.datastorage;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.g0294.tutorial.R;

public class SharedPreferencesActivity extends Activity {
    private static final String data = "DATA";
    private static final String nameField = "NAME";
    private static final String phoneField = "PHONE";
    private static final String sexField = "SEX";
    private EditText name;
    private EditText phone;
    private EditText sex;
    private Button save;
    private Button read;
    private Button clear;
    private SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_pref_layout);
        initComponent();
        setEventListener();
    }

    public void initComponent() {
        name = (EditText) findViewById(R.id.nameField);
        phone = (EditText) findViewById(R.id.phoneField);
        sex = (EditText) findViewById(R.id.sexField);
        save = (Button) findViewById(R.id.saveButton);
        read = (Button) findViewById(R.id.readButton);
        clear = (Button) findViewById(R.id.clearButton);
    }

    public void readData() {
        settings = getSharedPreferences(data, Context.MODE_PRIVATE);
        name.setText(settings.getString(nameField, ""));
        phone.setText(settings.getString(phoneField, ""));
        sex.setText(settings.getString(sexField, ""));
    }

    public void saveData() {
        settings = getSharedPreferences(data, Context.MODE_PRIVATE);
        settings.edit()
                .putString(nameField, name.getText().toString())
                .putString(phoneField, phone.getText().toString())
                .putString(sexField, sex.getText().toString())
                .apply();
    }

    public void setEventListener() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                saveData();
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                readData();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                name.setText("");
                phone.setText("");
                sex.setText("");
            }
        });
    }
}
