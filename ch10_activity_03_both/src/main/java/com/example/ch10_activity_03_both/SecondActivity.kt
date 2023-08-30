package com.example.ch10_activity_03_both

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)

        var intent1 = intent

        var num1 = intent1.getIntExtra("Num1", 0)
        var num2 = intent1.getIntExtra("Num2", 0)

        var hap = num1 + num2

        var btn1 = findViewById<Button>(R.id.btnReturn)
        btn1.setOnClickListener {
            var intent2 = Intent(this, MainActivity::class.java)
            intent2.putExtra("Hap", hap)
            setResult(RESULT_OK, intent2)
            finish()
        }
    }
}










