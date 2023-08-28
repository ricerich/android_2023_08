package com.example.ch06_05_webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var edt1 : EditText? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById<EditText>(R.id.edtUrl)
        var btn1 = findViewById<Button>(R.id.btnGo)
        var btn2 = findViewById<Button>(R.id.btnBack)
        var webView = findViewById<WebView>(R.id.webView1)//웹뷰

        //웹뷰에 웹뷰클라이언트 객체를 생성해서 연결
        webView.webViewClient = MyWebViewClient()

        var webSet = webView.settings
        webSet.builtInZoomControls = true

        btn1.setOnClickListener {
            webView.loadUrl(edt1?.text.toString())
        }

        btn2.setOnClickListener {
            webView.goBack()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        var m = menuInflater
        m.inflate(R.menu.menu1,menu)

        return super.onCreateOptionsMenu(menu)
    }

    //메뉴 이벤트 처리
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.item1 -> {
                Toast.makeText(this, "111", Toast.LENGTH_SHORT).show()
            }

            R.id.item2 -> {
                edt1?.setText("http://m.naver.com")
            }
        }

        return super.onOptionsItemSelected(item)
    }

    class MyWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            return super.shouldOverrideUrlLoading(view, url)
        }
    }
}






