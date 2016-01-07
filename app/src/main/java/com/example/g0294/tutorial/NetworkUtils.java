package com.example.g0294.tutorial;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class NetworkUtils {

    private static String TAG = "NetworkUtils";
    private static int len = 512;

    public static String getData(String mUrl) throws IOException {

        InputStream inputStream = null;
        try {
            URL url = new URL(mUrl);
            //建立連結
//            URLConnection urlConn = url.openConnection();
//            if (!(urlConn instanceof HttpURLConnection)) {
//                throw new IOException ("URL is not an Http URL");
//            }
//            HttpURLConnection httpConn = (HttpURLConnection)urlConn;
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setReadTimeout(10 * 1000 /* milliseconds */);
            httpConn.setConnectTimeout(15 * 1000 /* milliseconds */);
            httpConn.setRequestMethod("GET");
            httpConn.setDoInput(true);

            if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStream = httpConn.getInputStream();

                return readIt(inputStream, len);
            }
        } catch (Exception e) {
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
    }

    public static String postRequest(String mUrl) {

        InputStream inputStream = null;
        try {
            URL url = new URL(mUrl);
            URLConnection urlConn = url.openConnection();

            if (!(urlConn instanceof HttpURLConnection)) {
                throw new IOException("URL is not an Http URL");
            }

            HttpURLConnection httpConn = (HttpURLConnection) urlConn;
            httpConn.setReadTimeout(10 * 1000);/* milliseconds */
            httpConn.setConnectTimeout(15 * 1000);/* milliseconds */
            httpConn.setRequestMethod("POST");

            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);
            // post请求的参数
            String param = "#q=Tom+1234";
            String postContent = URLEncoder.encode(param, "UTF-8");

            // 設定Output資料流，向伺服器傳送data
            OutputStream out = httpConn.getOutputStream();
            out.write(postContent.getBytes());
            out.flush();
            out.close();
            if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStream = httpConn.getInputStream();

                return readIt(inputStream, len);
            }
        } catch (Exception e) {
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
    }

    public static byte[] getImage(String imageUrl) {
        InputStream inputStream = null;
        byte[] photoByte;
        try {

            URL url = new URL(imageUrl);
            URLConnection urlConn = url.openConnection();
            if (!(urlConn instanceof HttpURLConnection)) {
                throw new IOException("URL is not an Http URL");
            }
            HttpURLConnection httpConn = (HttpURLConnection) urlConn;
            httpConn.setReadTimeout(10 * 1000 /* milliseconds */);
            httpConn.setConnectTimeout(15 * 1000 /* milliseconds */);
            httpConn.setRequestMethod("GET");
            httpConn.setDoInput(true); //default true

            if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStream = httpConn.getInputStream();
                photoByte = readResource(inputStream);

                return photoByte;
            }
        } catch (Exception e) {
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
    }

    public static byte[] readResource(InputStream inputStream) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            inputStream.close();
            outputStream.close();
            return outputStream.toByteArray();
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return null;
    }

    public static String readIt(InputStream stream, int len) throws IOException {
        Reader reader;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connMgr = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null) { // connected to the internet
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
            } else if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to the mobile provider's data plan
            }
            Log.d(TAG, networkInfo.getTypeName() + " : " + networkInfo.isConnected());
        }

        return (networkInfo != null && networkInfo.isConnected());
    }

}
