package com.example.g0294.tutorial.ui;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.g0294.tutorial.R;

public class AndroidViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_layout);
        WebView browser;
        browser=(WebView)findViewById(R.id.webView);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.loadUrl("http://ycnas.myds.me/androidweb.html");
        browser.setWebChromeClient(new MyWebChromeClient(this));

    }
}
