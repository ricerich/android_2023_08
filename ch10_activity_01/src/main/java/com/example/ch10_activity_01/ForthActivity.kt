package com.example.ch10_activity_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ForthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forth)

        var btn1 = findViewById<Button>(R.id.btn1)
        btn1.setOnClickListener {
            finish()
        }
    }
}