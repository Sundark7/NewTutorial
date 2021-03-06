package com.example.g0294.tutorial.adapterview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.g0294.tutorial.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ContainerSelectActivity extends AppCompatActivity {
  @Bind(R.id.btn_listView)
  Button btnListView;
  @Bind(R.id.btn_arrayList)
  Button btnArrayList;
  @Bind(R.id.btn_simpleList)
  Button btnSimpleList;
  @Bind(R.id.btn_baseList)
  Button btnBaseList;
  @Bind(R.id.btn_gridView)
  Button btnGridView;
  @Bind(R.id.btn_expandable)
  Button btnExpandable;
  @Bind(R.id.btn_autoComplete)
  Button btnAutoComplete;
  @Bind(R.id.btn_spanner)
  Button btnSpanner;

  // private Button btn_listView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.containers_layout);
    ButterKnife.bind(this);
    SelectActivity listener = new SelectActivity();
    // btn_listView = (Button) findViewById(R.id.btn_listView);
    btnListView.setOnClickListener(listener);
    btnArrayList.setOnClickListener(listener);
    btnSimpleList.setOnClickListener(listener);
    btnBaseList.setOnClickListener(listener);
    btnGridView.setOnClickListener(listener);
    btnExpandable.setOnClickListener(listener);
    btnAutoComplete.setOnClickListener(listener);
    btnSpanner.setOnClickListener(listener);
  }

  class SelectActivity implements View.OnClickListener {
    @Override
    public void onClick(View view) {
      Intent intent = new Intent();
      switch (view.getId()) {
        case R.id.btn_listView:
          intent.setClass(getApplicationContext(), ListViewAttrActivity.class);
          startActivity(intent);
          break;
        case R.id.btn_arrayList:
          intent.setClass(getApplicationContext(), ArrayAdapterActivity.class);
          startActivity(intent);
          break;
        case R.id.btn_simpleList:
          intent.setClass(getApplicationContext(), SimpleAdapterActivity.class);
          startActivity(intent);
          break;
        case R.id.btn_baseList:
          intent.setClass(getApplicationContext(), BaseAdapterActivity.class);
          startActivity(intent);
          break;
        case R.id.btn_gridView:
          intent.setClass(getApplicationContext(), GridViewActivity.class);
          startActivity(intent);
          break;
        case R.id.btn_expandable:
          intent.setClass(getApplicationContext(), ExpandableListViewActivity.class);
          startActivity(intent);
          break;
        case R.id.btn_autoComplete:
          intent.setClass(getApplicationContext(), AutoCompleteActivity.class);
          startActivity(intent);
          break;
        case R.id.btn_spanner:
          intent.setClass(getApplicationContext(), SpinnerActivity.class);
          startActivity(intent);
          break;
      }
        }
    }
}
