package com.example.inspiron.eventbook1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class user_area5 extends AppCompatActivity {
private WebView wb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area5);

        wb=(WebView)findViewById(R.id.wb1);
        WebSettings ws=wb.getSettings();
        ws.setJavaScriptEnabled(true);
      wb.loadUrl("http://cufest.cuchd.in///");
        wb.setWebViewClient(new WebViewClient());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();

        if(wb.canGoBack())
        {
            wb.goBack();
        }
else
        {
            super.onBackPressed();

        }

    }
}
