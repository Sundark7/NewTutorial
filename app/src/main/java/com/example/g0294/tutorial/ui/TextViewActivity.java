package com.example.g0294.tutorial.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;

import com.example.g0294.tutorial.MainActivity;
import com.example.g0294.tutorial.R;

public class TextViewActivity extends Activity {
    protected String str;
    private TextView textView, tvHtml, tvLink, tvSpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_view_layout);
        textView = (TextView) findViewById(R.id.tv_marquee);
        TextView tvAge = (TextView) findViewById(R.id.tvAge);
        tvHtml = (TextView)findViewById(R.id.tvHtml);
        tvLink = (TextView)findViewById(R.id.tvLink);
        tvSpan = (TextView)findViewById(R.id.tvSpan);

        str = getResources().getString(R.string.your_age);
        tvAge.setText(String.format(str, "王曉明", 1990, (2015 - 1990)));

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setClass(TextViewActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //鏈結方法
        String text = "首頁URL: http://tw.yahoo.com \n";
        text += "電子郵件：g0294@edaworld.com.tw \n";
        text += "電話：0912345678";
        tvLink.setText(text);
        tvLink.setMovementMethod(LinkMovementMethod.getInstance());

        //HTML tag
        String html = "<font color='red'>顏色紅色</font><br>" +
                "<big><i>大字斜體</i></big>" +
                "<p><a href='http://www.google.com'>GOOGLE</a>";
        CharSequence charSequence = Html.fromHtml(html);
        tvHtml.setText(charSequence);
        tvHtml.setMovementMethod(LinkMovementMethod.getInstance()); //點擊時產生動作


        //Spannable Object
        SpannableString ss = new SpannableString("Text: Bold, Click here to Dial");
        ss.setSpan(new StyleSpan(Typeface.BOLD),6,10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new URLSpan("web:0912345678"),18,22,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvSpan.setText(ss);
        tvSpan.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
