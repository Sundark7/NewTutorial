package com.example.g0294.tutorial.adapterview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.g0294.tutorial.R;

public class ArrayAdapterActivity extends AppCompatActivity {
    protected String[] countries = {
            "台灣",
            "日本",
            "中國大陸",
            "巴西",
            "加拿大",
            "法國",
            "南韓",
            "美國",
            "英國",
            "德國",
            "澳大利亞"
    };
    private ListView arrayListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        arrayListView = (ListView) findViewById(R.id.arrayListView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.custom_listview,  R.id.country_name,countries);
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, countries);

        arrayListView.setAdapter(arrayAdapter);
        arrayListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("AdapterArray", "item: "+i+", "+countries[i]);
                Toast.makeText(getApplicationContext(), "選擇的是:" + countries[i], Toast.LENGTH_SHORT).show();
            }
        });

    }
}
