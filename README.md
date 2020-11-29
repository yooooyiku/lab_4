### 实验四 intent的使用

```
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
```

[![Dghf8e.png](https://s3.ax1x.com/2020/11/30/Dghf8e.png)](https://imgchr.com/i/Dghf8e)

[![DghhgH.png](https://s3.ax1x.com/2020/11/30/DghhgH.png)](https://imgchr.com/i/DghhgH)