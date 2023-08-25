package com.example.ch06_05_webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var edt1 = findViewById<EditText>(R.id.edtUrl)
        var btn1 = findViewById<Button>(R.id.btnGo)
        var btn2 = findViewById<Button>(R.id.btnBack)
        var webView = findViewById<WebView>(R.id.webView1)//웹뷰

        //웹뷰에 웹뷰클라이언트 객체를 생성해서 연결
        webView.webViewClient = MyWebViewClient()

        var webSet = webView.settings
        webSet.builtInZoomControls = true

        btn1.setOnClickListener {
            webView.loadUrl(edt1.text.toString())
        }

        btn2.setOnClickListener {
            webView.goBack()
        }



    }

    class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            return super.shouldOverrideUrlLoading(view, url)
        }
    }
}






