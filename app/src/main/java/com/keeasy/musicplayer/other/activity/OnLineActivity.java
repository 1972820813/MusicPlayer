package com.keeasy.musicplayer.other.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.keeasy.musicplayer.R;

/**
 * 在线音乐
 * Created by Administrator on 2017/8/7.
 */

public class OnLineActivity  extends AppCompatActivity implements View.OnClickListener {
    private WebView webView;

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);
        webView = (WebView) findViewById(R.id.online_wb);
        imageView = (ImageView) findViewById(R.id.online_title_back);
        imageView.setOnClickListener(this);
        //防止webview调用系统浏览器
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl("http://www.baidu.com");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.online_title_back:
                finish();
                break;
        }
    }
}
