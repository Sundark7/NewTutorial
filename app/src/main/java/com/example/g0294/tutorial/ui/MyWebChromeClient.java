package com.example.g0294.tutorial.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class MyWebChromeClient extends WebChromeClient {
    private Activity mAct;
    public MyWebChromeClient(Activity activity) {
        super();
        this.mAct = activity;
    }

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);
            mAct.setProgress(newProgress * 100);
    }
    @Override
    public boolean onJsAlert(WebView view, String url, String message,
                             final JsResult result) {
        Log.i("WebChromeClient", "onJsAlert url=" + url + ";message=" + message);
        AlertDialog.Builder builder = new AlertDialog.Builder(mAct);
        builder.setTitle("AlertDialog");
        builder.setMessage(message);
        builder.setPositiveButton(android.R.string.ok,
                new AlertDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        result.confirm();
                    }
                });
        builder.setCancelable(false);
        builder.create();
        builder.show();
        return true;
    }
}

