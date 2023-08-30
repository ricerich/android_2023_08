package com.example.ch10_activity_04_implicit


import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "암시적 인텐트 예제"

        Log.i("액티비티", "11111111111111")

        var btnDial = findViewById<Button>(R.id.btnDial)
        var btnWeb = findViewById<Button>(R.id.btnWeb)
        var btnGoogle = findViewById<Button>(R.id.btnGoogle)
        var btnSearch = findViewById<Button>(R.id.btnSearch)
        var btnSms = findViewById<Button>(R.id.btnSms)
        var btnPhoto = findViewById<Button>(R.id.btnPhoto)


        btnDial.setOnClickListener {
            Log.i("액티비티", "2222222222222")
            var uri = Uri.parse("tel:010-1234-5678")
            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }

        btnWeb.setOnClickListener {
            Log.i("액티비티", "3333333333333333")
            var uri = Uri.parse("http://m.naver.com")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnGoogle.setOnClickListener {
            Log.i("액티비티", "444444444444")
            var uri = Uri.parse("https://maps.google.com/maps?q="
                    + 37.559133 + "," + 126.927824)
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnSearch.setOnClickListener {
            var intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY, "안드로이드")
            startActivity(intent)
        }

        btnSms.setOnClickListener {
            var intent = Intent(Intent.ACTION_SENDTO)
            intent.putExtra("sms_body", "안녕하세요?")
            intent.data = Uri.parse("smsto:" + Uri.encode("010-1234-4567"))
            startActivity(intent)
        }

        btnPhoto!!.setOnClickListener {
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
    }

}