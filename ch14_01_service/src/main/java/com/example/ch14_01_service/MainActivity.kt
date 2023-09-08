package com.example.ch14_01_service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "서비스 테스트 예제"

        var btnStart = findViewById<Button>(R.id.btnStart)
        var btnStop = findViewById<Button>(R.id.btnStop)

        var intent1 = Intent(this, MusicService::class.java)

        btnStart.setOnClickListener {
            startService(intent1)
            android.util.Log.i("서비스 테스트", "startService()")
        }

        btnStop.setOnClickListener {
            stopService(intent1)
            android.util.Log.i("서비스 테스트", "stopService()")
        }
    }
}

