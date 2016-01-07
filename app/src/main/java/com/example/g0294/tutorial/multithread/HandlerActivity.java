package com.example.g0294.tutorial.multithread;


import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.g0294.tutorial.NetworkUtils;
import com.example.g0294.tutorial.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HandlerActivity extends Activity {

    private ImageView imageView;
    private ProgressDialog progressDialog;
    private static final int DOWNLOAD_IMG = 1;
    private MyHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        Button button = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.imageView);
        handler = new MyHandler();

        // 彈出進度條
        progressDialog = new ProgressDialog(HandlerActivity.this);
        progressDialog.setTitle("提示信息");
        progressDialog.setMessage("正在下载中，請稍後......");
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (NetworkUtils.isNetworkAvailable(getApplicationContext())) {
                    new Thread(new MyThread()).start();
                    progressDialog.show();
                }
            }
        });
    }

    private class MyHandler extends Handler {
        public MyHandler() {
            super();
        }

        public MyHandler(Looper looper) {
            super(looper);
        }

        // 處理Thread傳來的訊息。
        @Override
        public void handleMessage(Message msg) {
            byte[] data = (byte[]) msg.obj;
            Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
            imageView.setImageBitmap(bitmap);
            if (msg.what == DOWNLOAD_IMG) {
                progressDialog.dismiss();
            }
        }
    }

    // 使用Handler Message 訪問網路資源的時候，我們必須要開啟一個子執行緒
    public class MyThread implements Runnable {

        // 在run方法中完成網路耗時的操作
        @Override
        public void run() {
            InputStream inputStream;
            try {
                String IMAGE_PATH =
                        "http://developer.android.com/images/home/devices-hero_620px_2x.png";
                URL url = new URL(IMAGE_PATH);
                URLConnection urlConn = url.openConnection();
                // 檢查路徑是否為網際網路路徑
                if (!(urlConn instanceof HttpURLConnection)) {
                    throw new IOException("URL is not an Http URL");
                }
                HttpURLConnection httpConn = (HttpURLConnection) urlConn;
                httpConn.setConnectTimeout(3 * 1000); // 設定time out
                httpConn.setRequestMethod("GET");

                if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    inputStream = httpConn.getInputStream();
                    byte[] photoByte = NetworkUtils.readResource(inputStream);
                    // 通過Message的方式，將PhotoByte發送給UI Thread。
                    Message message = Message.obtain();
                    message.obj = photoByte;
                    message.what = DOWNLOAD_IMG;
                    handler.sendMessage(message);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }

}
