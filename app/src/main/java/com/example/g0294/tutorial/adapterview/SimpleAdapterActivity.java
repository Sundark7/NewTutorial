package com.example.g0294.tutorial.adapterview;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.g0294.tutorial.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapterActivity extends Activity {
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
    protected int[] images = {R.drawable.ic_taiwan, R.drawable.ic_japan, R.drawable.ic_china, R.drawable.ic_brazil, R.drawable.ic_canada,
            R.drawable.ic_france, R.drawable.ic_korea, R.drawable.ic_america, R.drawable.ic_britain, R.drawable.ic_germany, R.drawable.ic_australia};
    private ListView arrayListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        arrayListView = (ListView) findViewById(R.id.arrayListView);

        //Simple Adapter
        // 先建立List MAP資料對應
        List<Map<String, Object>> items = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("image", images[i]);
            item.put("country", countries[i]);
            items.add(item);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                items, R.layout.custom_listview, new String[]{"image", "country"},
                new int[]{R.id.icon, R.id.country_name});

        arrayListView.setAdapter(simpleAdapter);
    }
}
