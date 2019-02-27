package com.eningapps.hotelisto.view;

import android.annotation.TargetApi;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {

    public interface OnPageLoadedListener {
        void onPageLoaded();
    }

    private OnPageLoadedListener listener;

    public MyWebViewClient(OnPageLoadedListener listener) {
        this.listener = listener;
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        view.loadUrl(request.getUrl().toString());
        return true;
    }

    public void onPageFinished(WebView view, String url) {
        listener.onPageLoaded();
    }

    // Для старых устройств
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}