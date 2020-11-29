package com.example.lab_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class WebViewActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        //获得浏览器webView控件
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowContentAccess(true);
        //鼠标点击之后的intent
        Intent intent = getIntent();
        Uri uri = intent.getData();//获取data属性
        String urlString = null;
        try {
            urlString = new URL(uri.getScheme(), uri.getHost(), uri.getPath()).toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        webView.loadUrl(urlString);//加载
        //网络连接失败
        webView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
            {
                Toast.makeText(getApplicationContext(), "网络连接失败 ,请连接网络。",
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("http:") || url.startsWith("https:")) {
                    view.loadUrl(url);
                    return false;
                }
                view.loadUrl(url);
                return true;
            }
        });
    }
}