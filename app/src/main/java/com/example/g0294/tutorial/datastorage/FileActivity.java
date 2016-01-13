package com.example.g0294.tutorial.datastorage;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.example.g0294.tutorial.R;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class FileActivity extends AppCompatActivity {
    private String filename = "SampleFile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        BtnOnClickListener btnOnClickListener = new BtnOnClickListener();

        Button saveToInternalStorage = (Button) findViewById(R.id.saveInternalStorage);
        saveToInternalStorage.setOnClickListener(btnOnClickListener);

        Button readFromInternalStorage = (Button) findViewById(R.id.getInternalStorage);
        readFromInternalStorage.setOnClickListener(btnOnClickListener);

        Button saveTempFromInternalStorage = (Button) findViewById(R.id.tempInternalStorage);
        saveTempFromInternalStorage.setOnClickListener(btnOnClickListener);

        Button deleteFromInternalStorage = (Button) findViewById(R.id.deleteInternalStorage);
        deleteFromInternalStorage.setOnClickListener(btnOnClickListener);

        Button saveToExternalStorage = (Button) findViewById(R.id.saveExternalStorage);
        saveToExternalStorage.setOnClickListener(btnOnClickListener);

        Button readFromExternalStorage = (Button) findViewById(R.id.getExternalStorage);
        readFromExternalStorage.setOnClickListener(btnOnClickListener);

        // 檢查外部空間是否可用或唯讀
        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            saveToExternalStorage.setEnabled(false);
        }


    }

    private boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState);
    }

    private boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(extStorageState);
    }

    //取得存放公開圖片目錄，並在該目錄下建立 subDir 子目錄
    public File getExtPubPicDir(String subDir) {
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), subDir);
        //若目錄不存在則建立目錄
        if (!file.mkdirs()) {
            Log.e("FileActivity", "無法建立目錄");
        }
        return file;
    }

    // 寫檔
    private void writeToFile(File fout, String data) {
        FileOutputStream osw = null;
        try {
            osw = new FileOutputStream(fout);
            //方法二
//            osw = openFileOutput(filename, Context.MODE_PRIVATE);
            osw.write(data.getBytes());
            osw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (osw != null)
                    osw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 讀檔
    private String readFromFile(File fin) {
        StringBuilder data = new StringBuilder();
        BufferedReader reader = null;
        try {
            FileInputStream in = null;
            in = new FileInputStream(fin);
            /*方法二*/
            //開啟 getFilesDir() 目錄底下名稱為xxx檔案
//            in = openFileInput(filename);
            reader = new BufferedReader(new InputStreamReader(in, "utf-8"));

            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data.toString();
    }

    class BtnOnClickListener implements View.OnClickListener {

        File dir;
        File outFile;


        @Override
        public void onClick(View v) {
            EditText inputText = (EditText) findViewById(R.id.myInputText);
            TextView responseText = (TextView) findViewById(R.id.responseText);
            String content;

            switch (v.getId()) {
                case R.id.saveInternalStorage:
                    /* 方法一*/
                    dir = getApplication().getFilesDir(); // 取得內部儲存目錄，預設擺放路徑為 /data/data/[package.name]/files/
                    outFile = new File(dir, filename); // 在該目錄底下開啟或建立filename
                    writeToFile(outFile, inputText.getText().toString());
                    inputText.setText("");
                    responseText.setText("SampleFile.txt 儲存到內部儲存空間...");

//                                 /* save Image */
//                    RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());
//                    ImageRequest imageRequest = new ImageRequest(
//                            "http://developer.android.com/images/home/aw_dac.png",
//                            new Response.Listener<Bitmap>() {
//                                @Override
//                                public void onResponse(Bitmap response) {
//                                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
//                                    response.compress(Bitmap.CompressFormat.PNG, 100, stream);
//                                    byte[] byteArray = stream.toByteArray();
//                                    FileOutputStream osw = null;
//                                    try {
//                                        osw = openFileOutput("aw_dac.png", Context.MODE_PRIVATE);
//                                        osw.write(byteArray);
//                                        osw.flush();
//                                    } catch (Exception e) {
//                                        e.printStackTrace();
//                                    } finally {
//                                        try {
//                                            if (osw != null)
//                                                osw.close();
//                                        } catch (Exception e) {
//                                            e.printStackTrace();
//                                        }
//                                    }
//                                }
//                            }, 0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.RGB_565,
//                            new Response.ErrorListener() {
//                                @Override
//                                public void onErrorResponse(VolleyError error) {
//                                    Toast.makeText(getApplicationContext(), "Fail! Load Image.", Toast.LENGTH_SHORT).show();
//                                }
//                            });
//                    mQueue.add(imageRequest);
                    break;

                case R.id.getInternalStorage:

                    dir = getApplication().getFilesDir(); // 取得內部儲存體檔案目錄
                    outFile = new File(dir, filename); // 在該目錄底下開啟或建立filename
                    content = readFromFile(outFile);
                    inputText.setText(content);
                    responseText.setText("從內部儲存空間讀取SampleFile.txt內容...");
                    break;

                case R.id.tempInternalStorage:
                    try {
                        dir = getApplication().getCacheDir();
                        File outFile = new File(dir, filename);
//                        File outFile = File.createTempFile("SampleFile", ".txt", dir);
//                        File outFile = File.createTempFile("SampleFile", ".txt");
                        writeToFile(outFile, inputText.getText().toString());
                        responseText.setText("寫入SampleFile.txt到內部暫存空間...");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;

                case R.id.deleteInternalStorage:
                    dir = getApplication().getFilesDir(); // 取得內部儲存體檔案目錄
                    outFile = new File(dir, filename); // 在該目錄底下開啟或建立filename
                    outFile.delete();
//                    getApplicationContext().deleteFile(filename);//刪除 getFilesDir() 目錄底下檔案
                    responseText.setText("從儲存空間刪除SampleFile.txt...");
                    break;

                case R.id.saveExternalStorage:

//                    dir = getExtPubPicDir("test"); // 取得外部儲存體檔案目錄，null返回的目錄型態，DIRECTORY_MUSIC....
//                    outFile = new File(dir, filename);
//                    writeToFile(outFile, inputText.getText().toString());
//                    inputText.setText("");
//                    responseText.setText("SampleFile.txt 儲存到外部儲存空間...");
                    /* save Image */
                    RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());
                    ImageRequest imageRequest = new ImageRequest(
                            "http://developer.android.com/images/home/aw_dac.png",
                            new Response.Listener<Bitmap>() {
                                @Override
                                public void onResponse(Bitmap response) {
                                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                    response.compress(Bitmap.CompressFormat.PNG, 100, stream);
                                    byte[] byteArray = stream.toByteArray();
                                    FileOutputStream osw = null;
                                    try {
//                                        dir = getApplicationContext().getExternalFilesDir(null);
                                        dir = getExtPubPicDir("PIC"); // 取得外部儲存體檔案目錄，null返回的目錄型態，DIRECTORY_MUSIC....
                                        outFile = new File(dir, "aw_dac.png");
                                        osw = new FileOutputStream(outFile);
                                        osw.write(byteArray);
                                        osw.flush();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    } finally {
                                        try {
                                            if (osw != null)
                                                osw.close();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }, 0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.RGB_565,
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(getApplicationContext(), "Fail! Load Image.", Toast.LENGTH_SHORT).show();
                                }
                            });
                    mQueue.add(imageRequest);
                    break;

                case R.id.getExternalStorage:
                    dir = getApplication().getExternalFilesDir(null); // 取得外部儲存體檔案目錄，null返回的目錄型態，DIRECTORY_MUSIC....
                    outFile = new File(dir, filename);
                    content = readFromFile(outFile);
                    inputText.setText(content);
                    responseText.setText("從外部儲存空間讀取SampleFile.txt內容...");
                    break;
            }
        }
    }
}
