package com.example.g0294.tutorial.adapterview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.g0294.tutorial.R;

public class SpinnerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_layout);
        //設定string array
        String[] mItems = getResources().getStringArray(R.array.languages);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

        spinner1.setOnItemSelectedListener(new myOnItemSelectedListener());
        // 建立Adapter并且載入array，android.R.layout.simple_spinner_item內建的資源檔
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        /**simple_spinner_item和simple_spinner_dropdown_item。一個應用於下拉一個應用於Spinner本身。*/
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new myOnItemSelectedListener());
    }

    //監聽當有Item選擇
    class myOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String[] languages = getResources().getStringArray(R.array.languages);
            Toast.makeText(SpinnerActivity.this, "選擇的是:" + languages[position], Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
