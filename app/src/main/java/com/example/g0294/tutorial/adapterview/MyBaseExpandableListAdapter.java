package com.example.g0294.tutorial.adapterview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.g0294.tutorial.R;

import java.util.ArrayList;

public class MyBaseExpandableListAdapter extends BaseExpandableListAdapter {
    private String[] groupData;
    private ArrayList<ArrayList<ItemClass>> childData;
    private Context mContext;

    public MyBaseExpandableListAdapter(String[] groupData, ArrayList<ArrayList<ItemClass>> childData, Context mContext) {
        this.groupData = groupData;
        this.childData = childData;
        this.mContext = mContext;
    }

    @Override
    public Object getGroup(int i) {
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        return null;
    }

    @Override
    public int getGroupCount() {
        return groupData.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childData.get(groupPosition).size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    //取得用於顯示給定分組的視圖. 這個方法僅返回分組的視圖物件
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        ViewHolderGroup groupHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.item_group, parent, false);
            groupHolder = new ViewHolderGroup();
            groupHolder.tv_group_name = (TextView) convertView.findViewById(R.id.tv_group_name);
            convertView.setTag(groupHolder);
        } else {
            groupHolder = (ViewHolderGroup) convertView.getTag();
        }
        groupHolder.tv_group_name.setText(groupData[groupPosition]);
        return convertView;
    }

    //取得顯示給定分組給定子位置的資料用的視圖
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolderItem itemHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.item_child, parent, false);
            itemHolder = new ViewHolderItem();
            itemHolder.img_icon = (ImageView) convertView.findViewById(R.id.icon);
            itemHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(itemHolder);
        } else {
            itemHolder = (ViewHolderItem) convertView.getTag();
        }
        itemHolder.img_icon.setImageResource(childData.get(groupPosition).get(childPosition).getImage());
        itemHolder.tv_name.setText(childData.get(groupPosition).get(childPosition).getText());
        return convertView;
    }

    //設置子列表是否可選中
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private static class ViewHolderGroup {
        private TextView tv_group_name;
    }

    private static class ViewHolderItem {
        private ImageView img_icon;
        private TextView tv_name;
    }

}
