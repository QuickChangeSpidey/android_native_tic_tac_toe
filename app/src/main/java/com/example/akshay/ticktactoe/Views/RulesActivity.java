package com.example.akshay.ticktactoe.Views;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;


import com.example.akshay.ticktactoe.R;

import Helpers.WebViewClientHelper;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RulesActivity extends AppCompatActivity {

    @BindView(R.id.webView)
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        ButterKnife.bind(this);
        webView.setWebViewClient(new WebViewClientHelper());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://youtu.be/5SdW0_wTX5c");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
