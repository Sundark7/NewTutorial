package com.example.g0294.tutorial.adapterview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.g0294.tutorial.R;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private static int counter = 0;
    private Context context;
    private List<CountryItem> mList;

    public MyAdapter(Context context, List<CountryItem> mList) {
        this.context = context;
        this.mList = mList;
    }

    public void updateData(List<CountryItem> items) {
        mList = items;
        //Triggers update
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = new ViewHolder();
        if (convertView == null) {
            counter++;
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_listview, parent, false);
            holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
            holder.textView2 = (TextView) convertView.findViewById(R.id.country_name);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.imageView.setImageResource(mList.get(position).getImage_id());
        holder.textView2.setText(mList.get(position).getCountry());
        Log.i("-getView-", String.valueOf(counter));
        return convertView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView textView2;
    }
    /*
    * 不使用Holder做法
    * */
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        counter++;
//        convertView = LayoutInflater.from(context).inflate(R.layout.custom_listview, parent, false);
//        ImageView imageView = (ImageView) convertView.findViewById(R.id.icon);
//        TextView textView1 = (TextView) convertView.findViewById(R.id.country_name);
//
//        imageView.setImageResource(mList.get(position).getImage_id());
//        textView1.setText(mList.get(position).getCountry());
//        Log.i("-getView-", String.valueOf(counter));
//        return convertView;
//    }
}
