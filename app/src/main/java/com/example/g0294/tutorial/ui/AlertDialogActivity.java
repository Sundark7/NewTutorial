package com.example.g0294.tutorial.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.g0294.tutorial.R;

public class AlertDialogActivity extends Activity implements View.OnClickListener {
    private Button btn_alertDialog_basic, btn_alertDialog_button, btn_alertDialog_list, btn_alertDialog_custom, btn_progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_layout);
        btn_alertDialog_basic = (Button) findViewById(R.id.btn_alertDialog_basic);
        btn_alertDialog_basic.setOnClickListener(this);
        btn_alertDialog_button = (Button) findViewById(R.id.btn_alertDialog_button);
        btn_alertDialog_button.setOnClickListener(this);
        btn_alertDialog_list = (Button) findViewById(R.id.btn_alertDialog_list);
        btn_alertDialog_list.setOnClickListener(this);
        btn_alertDialog_custom = (Button) findViewById(R.id.btn_alertDialog_custom);
        btn_alertDialog_custom.setOnClickListener(this);
        btn_progressDialog = (Button) findViewById(R.id.btn_progressDialog);
        btn_progressDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_alertDialog_basic:
                Dialog alertDialog = new AlertDialog.Builder(this)
                        .setTitle("基本對話框") // 設置標題
                        .setMessage("内容") // 設置提示訊息
                        .setIcon(R.drawable.ic_info) // 設置標題圖示
                        .create();
                alertDialog.show();
                break;

            case R.id.btn_alertDialog_button:
                Dialog alertDialog_button = new AlertDialog.Builder(this)
                        .setTitle("是否確定？")
                        .setMessage("了解內容了嗎？")
                        .setIcon(R.drawable.ic_info)
                        .setPositiveButton("確定", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setNeutralButton("查看詳情", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .create();
                alertDialog_button.show();
                break;

            case R.id.btn_alertDialog_list:
                final String[] arrayFruit = new String[]{"台北", "新竹", "台中", "高雄"};

                Dialog alertDialog_list = new AlertDialog.Builder(this).
                        setTitle("你所居住的城市？").
                        setIcon(R.drawable.ic_info)
                        .setItems(arrayFruit, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), arrayFruit[which], Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .create();
                alertDialog_list.show();
                break;

            case R.id.btn_alertDialog_custom:
                LayoutInflater layoutInflater = LayoutInflater.from(this);
                final View myCustomView = layoutInflater.inflate(R.layout.custom_alertdialog, null);
                final EditText myName = (EditText) myCustomView.findViewById(R.id.input_name);
                Dialog alertDialog_custom = new AlertDialog.Builder(this)
                        .setTitle("使用者?")
                        .setIcon(R.drawable.ic_info)
                        .setView(myCustomView)
                        .setPositiveButton("確定", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "輸入名字：" + myName.getText(), Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .create();
                alertDialog_custom.show();
                break;

            case R.id.btn_progressDialog:
                ProgressDialog myDialog = new ProgressDialog(this);
                myDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                myDialog.setTitle("進度對話框");
                myDialog.setMessage("提示訊息");
                myDialog.setIcon(R.drawable.ic_info);
                myDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "取消",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                myDialog.setIndeterminate(true); // 設置的進度條是否不定
                myDialog.setCancelable(false); // 設置是否可以按退回按鍵取消
                myDialog.show();
                break;
        }

    }
}
