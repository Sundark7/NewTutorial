package com.example.g0294.tutorial.layouts;


import android.app.Activity;
import android.os.Bundle;

import com.example.g0294.tutorial.R;

public class LinearActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout);
//        LinearLayout rootView = new LinearLayout(this);
//        rootView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        rootView.setOrientation(LinearLayout.VERTICAL);
//
//        TextView tv_acc = new TextView(this);
//        tv_acc.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        tv_acc.setPadding(5, 5, 5, 5); //unit pixel
//        tv_acc.setGravity(Gravity.CENTER);
//        tv_acc.setText(R.string.account);
//        tv_acc.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
//        rootView.addView(tv_acc);
//
//        EditText editText = new EditText(this);
//        LinearLayout.LayoutParams editParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        editParam.bottomMargin = 10;
//        rootView.addView(editText, editParam);
//
//        Button btn_login = new Button(this);
//        btn_login.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        btn_login.setText(getResources().getText(R.string.login));
//        rootView.addView(btn_login);
//
//        LinearLayout view = new LinearLayout(this);
//        LinearLayout.LayoutParams viewParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        viewParam.setMargins(25, 0, 0, 0);
//        view.setOrientation(LinearLayout.HORIZONTAL);
//
//        rootView.addView(view);
//
//        Button btn_home = new Button(this);
//        LinearLayout.LayoutParams homeParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1);
//        homeParam.setMarginEnd(8);
//        btn_home.setText(R.string.home);
//        view.addView(btn_home, homeParam);
//
//        Button btn_about = new Button(this);
//        btn_about.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 2));
//        btn_about.setText(R.string.account);
//        view.addView(btn_about);
//
//        setContentView(rootView);

    }
}
