package edu.jmramirez.nerdfeed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        WebView wb = (WebView) findViewById(R.id.webView);
        wb.loadUrl("http://www.google.com");
//        wb.getSettings().setJavaScriptEnabled(true);
    }

}
