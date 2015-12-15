package com.example.g0294.tutorial.layouts;


import android.app.Activity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.g0294.tutorial.R;

public class RelativeActivity extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
//    setContentView(R.layout.relative_layout);
    RelativeLayout rootView = new RelativeLayout(this);
    rootView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

    TextView tv_acc = new TextView(this);
    tv_acc.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    tv_acc.setGravity(Gravity.CENTER);
    tv_acc.setText(R.string.account);
    tv_acc.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
    tv_acc.setId(R.id.rl_account);
    rootView.addView(tv_acc);

    EditText editText = new EditText(this);
    RelativeLayout.LayoutParams editParam = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    editParam.addRule(RelativeLayout.BELOW, R.id.rl_account);
    editText.setHint(R.string.your_name);
    editText.setId(View.generateViewId());
    rootView.addView(editText, editParam);

    Button btn_login = new Button(this);
    RelativeLayout.LayoutParams loginParam = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    loginParam.addRule(RelativeLayout.BELOW, editText.getId());
    btn_login.setText(getResources().getText(R.string.login));
    btn_login.setLayoutParams(loginParam);
    rootView.addView(btn_login);

    LinearLayout view = new LinearLayout(this);
    RelativeLayout.LayoutParams viewParam = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    viewParam.addRule(RelativeLayout.CENTER_IN_PARENT);
    view.setOrientation(LinearLayout.HORIZONTAL);

    rootView.addView(view, viewParam);

    Button btn_home = new Button(this);
    LinearLayout.LayoutParams homeParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1);
    btn_home.setText(R.string.home);
    view.addView(btn_home, homeParam);

    Button btn_about = new Button(this);
    btn_about.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 2));
    btn_about.setText(R.string.account);
    view.addView(btn_about);

    setContentView(rootView);
  }
}
