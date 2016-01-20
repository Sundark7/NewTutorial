package com.example.g0294.tutorial.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient{
    private Activity mActivity;
    public ProgressDialog myDialog;

    public MyWebViewClient(Activity act) {
        super();
        mActivity = act;
        myDialog = new ProgressDialog(mActivity);
        myDialog.setTitle("載入中");
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url.indexOf("yahoo.com") >= 0) {
            return false;
        }
        //外部網站會觸發
        Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        mActivity.startActivity(it);
        return true;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        myDialog.show();
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        myDialog.dismiss();
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
        myDialog.dismiss();
    }
}
