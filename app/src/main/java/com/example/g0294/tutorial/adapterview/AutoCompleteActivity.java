package com.example.g0294.tutorial.adapterview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.example.g0294.tutorial.R;

public class AutoCompleteActivity extends AppCompatActivity {
    private static final String[] countries = {"China", "Russia", "Germany",
            "Ukraine", "Belarus", "USA", "China1", "China2", "USA1"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autocompletetext_layout);
        AutoCompleteTextView autoComplete = (AutoCompleteTextView) findViewById(R.id.autoComplete);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, countries);
        autoComplete.setAdapter(adapter);
        //設置AutoCompleteTextView輸入1個字符就進行提示
        autoComplete.setThreshold(2);
    }
}
