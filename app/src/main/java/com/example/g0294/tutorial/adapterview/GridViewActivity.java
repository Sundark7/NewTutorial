package com.example.g0294.tutorial.adapterview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.g0294.tutorial.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GridViewActivity extends Activity {
    private GridView gridView;
    private int[] image = {
            R.drawable.amex, R.drawable.ebay, R.drawable.maestro,
            R.drawable.mastercard, R.drawable.paypal, R.drawable.shop,
            R.drawable.visa};
    private String[] imgText = {
            "amex", "ebay", "maestro", "mastercard", "paypal", "shop", "visa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_layout);
        SimpleAdapter adapter = new SimpleAdapter(this,
                getData(), R.layout.grid_item, new String[]{"image", "text"},
                new int[]{R.id.image, R.id.text});

        gridView = (GridView) findViewById(R.id.gridview);
//        gridView.setNumColumns(3);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "選擇了： " + imgText[position],
                        Toast.LENGTH_SHORT).show();
            }

        });
    }

    private List<HashMap<String, Object>> getData() {
        List<HashMap<String, Object>> items = new ArrayList<>();
        for (int i = 0; i < image.length; i++) {
            HashMap<String, Object> item = new HashMap<>();
            item.put("image", image[i]);
            item.put("text", imgText[i]);
            items.add(item);
        }
        return items;
    }
}
