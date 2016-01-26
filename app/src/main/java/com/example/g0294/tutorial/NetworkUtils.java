package com.example.g0294.tutorial;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class NetworkUtils {

    private static String TAG = "NetworkUtils";

    public static String getData(String mUrl) throws IOException {

        InputStream inputStream = null;
        try {
            URL url = new URL(mUrl);
            //建立連結
            URLConnection urlConn = url.openConnection();
            if (!(urlConn instanceof HttpURLConnection)) {
                throw new IOException("URL is not an Http URL");
            }
            HttpURLConnection httpConn = (HttpURLConnection) urlConn;
            // HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setReadTimeout(10 * 1000 /* milliseconds */);
            httpConn.setConnectTimeout(15 * 1000 /* milliseconds */);
            httpConn.setRequestMethod("GET");
            httpConn.setDoInput(true);

            if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStream = httpConn.getInputStream();

                return readIt(inputStream);
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

                return readIt(inputStream);
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

    public static String readIt(InputStream stream) throws IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        return builder.toString();
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

    public static void XMLParser(String mContent) {

        try {
//            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
//            factory.setNamespaceAware(true); //default false; 可省略
//            XmlPullParser parser = factory.newPullParser();
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(new StringReader(mContent));

            int event = parser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {
                switch (event) {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
//                        Log.d("XMLParser", "The Start TAG: " + parser.getName());
//                        if ("SiteName".equals(parser.getName())) {
//                            Log.d("XMLParser", "SiteName: " + parser.nextText());
//                        } else if ("County".equals(parser.getName())) {
//                            Log.d("XMLParser", "County: " + parser.nextText());
//                        } else if ("PM2.5".equals(parser.getName())) {
//                            Log.d("XMLParser", "PM2.5: " + parser.nextText());
//                        } else if ("PublishTime".equals(parser.getName())) {
//                            Log.d("XMLParser", "PublishTime: " + parser.nextText());
//                        }

                        if ("EstimateTime".equals(parser.getName())) {
                            Log.d("XMLParser", "StopID: " + parser.getAttributeValue(null, "StopID"));
                            Log.d("XMLParser", "SID: " + parser.getAttributeValue(null, "SID"));
                            Log.d("XMLParser", "StopName: " + parser.getAttributeValue(2));
                        }
                        break;
                    case XmlPullParser.TEXT:
//                        Log.d("XMLParser", "The TEXT: " + parser.getText());
                        break;
                    case XmlPullParser.END_TAG:
                        Log.d("XMLParser", "The END TAG: " + parser.getName());
                        break;
                }
                event = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
