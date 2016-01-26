package com.example.g0294.tutorial.adapterview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.g0294.tutorial.R;

import java.util.ArrayList;

public class ExpandableListViewActivity extends AppCompatActivity {
    private String[] groupData = {"Part1", "Part2"};
    private ArrayList<ArrayList<ItemClass>> childData;
    private ArrayList<ItemClass> lData;
    private ExpandableListView expandableListView;
    private MyBaseExpandableListAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandable_listview_layout);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);

        childData = new ArrayList<>();
        lData = new ArrayList<>();
        //Part1
        lData.add(new ItemClass("amex", R.drawable.amex));
        lData.add(new ItemClass("ebay", R.drawable.ebay));
        lData.add(new ItemClass("maestro", R.drawable.maestro));
        lData.add(new ItemClass("shop", R.drawable.shop));
        childData.add(lData);

        lData = new ArrayList<>();
        //Part2
        lData.add(new ItemClass("mastercard", R.drawable.mastercard));
        lData.add(new ItemClass("visa", R.drawable.visa));
        lData.add(new ItemClass("paypal", R.drawable.paypal));
        childData.add(lData);

        myAdapter = new MyBaseExpandableListAdapter(groupData, childData, this);
        expandableListView.setAdapter(myAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), "選擇：" + childData.get(groupPosition).get(childPosition).getText(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
