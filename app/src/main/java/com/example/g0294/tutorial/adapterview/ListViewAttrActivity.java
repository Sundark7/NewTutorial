package com.example.g0294.tutorial.adapterview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.g0294.tutorial.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ListViewAttrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_arr_layout);
        ListView listView = (ListView) findViewById(R.id.listView);
        final List<String> adapterData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            adapterData.add("ListItem" + i);
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, adapterData);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "選擇Position: " + position + ", id:" + id, Toast.LENGTH_SHORT).show();
            }
        });
        //choiceMode支持選擇的佈局才有用
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_checked, adapterData);
//        listView.setAdapter(adapter);

        //新增item
        final Handler handler = new Handler();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                adapterData.add("New ListItem");
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }, 1800, 1800);
    }
}
