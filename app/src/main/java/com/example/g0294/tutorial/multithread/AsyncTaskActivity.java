package com.example.g0294.tutorial.multithread;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.g0294.tutorial.NetworkUtils;
import com.example.g0294.tutorial.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class AsyncTaskActivity extends Activity {

    private final String IMAGE_PATH =
            "http://developer.android.com/images/home/devices-hero_620px_2x.png";
    private ImageView imageView;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        Button button = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.imageView);

        // 彈出進度條
        progressDialog = new ProgressDialog(AsyncTaskActivity.this);
        progressDialog.setTitle("提示信息");
        progressDialog.setMessage("正在下载中，請稍後......");
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NetworkUtils.isNetworkAvailable(getApplicationContext())) {
                    new MyAsyncTask().execute(IMAGE_PATH);
                }
            }
        });

    }

    public class MyAsyncTask extends AsyncTask<String, Integer, byte[]> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // 彈出進度條對話框
            progressDialog.show();
        }

        @Override
        protected byte[] doInBackground(String... params) {
//        protected String doInBackground(String... params) {
            InputStream inputStream = null;
            // 下載圖片
            try {
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

                    float file_length = httpConn.getContentLength();// 取得文件大小
                    float total_length = 0; // 目前累加下載大小
                    byte[] buffer = new byte[1024]; // 每次讀取1024 byte
                    int len;
                    inputStream = httpConn.getInputStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

                    while ((len = inputStream.read(buffer)) != -1) {
                        total_length += len; // 每讀一次累加起來
                        outputStream.write(buffer, 0, len);
                        int progress = (int) (total_length / file_length * 100); // 計算目前下載百分比
                        publishProgress(progress);// 將進度給
                    }
                    inputStream.close();
                    outputStream.close();
                    return outputStream.toByteArray();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
//            return NetworkUtils.postRequest("http://httpbin.org/post");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            // 更新進度
            progressDialog.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(byte[] result) {
            super.onPostExecute(result);
            if (result != null) {
                // 將Byte[]轉成Bitmap
                Bitmap bitmap = BitmapFactory.decodeByteArray(result, 0, result.length);
                // 將下載的圖片設定到ImageView
                imageView.setImageBitmap(bitmap);
//                Log.i("AsyncTask", result);
            }
            // 關閉進度對話框
            progressDialog.dismiss();
        }
    }

}
