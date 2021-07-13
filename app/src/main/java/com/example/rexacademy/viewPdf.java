package com.example.rexacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URLEncoder;

public class viewPdf extends AppCompatActivity {

    WebView pdfview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pdf);

        pdfview = (WebView) findViewById(R.id.viewpdfactivity);
        pdfview.getSettings().setJavaScriptEnabled(true);

        String filename = getIntent().getStringExtra("filename");
        String fileurl = getIntent().getStringExtra("fileurl");
        String writer = getIntent().getStringExtra("writer");
        String image = getIntent().getStringExtra("image");
        String description = getIntent().getStringExtra("description");


        final ProgressDialog pd = new ProgressDialog(this);

        pd.setTitle(filename);
        pd.setMessage("Opening...");


        pdfview.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pd.show();
            }


            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pd.dismiss();
            }
        });

                    String url = "";
                    try{
                        url = URLEncoder.encode(fileurl, "UTF-8");
                    }catch (Exception ex)
                    {}

                   pdfview.loadUrl("https://docs.google.com/viewer?url=" + url);
    }

}