package com.example.ch06_02_viewflipper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ViewFlipper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1.핸들(메뉴)
        var btnPrevious = findViewById<Button>(R.id.btnPrev)
        var btnNext = findViewById<Button>(R.id.btnNext)

        //2.콘텐츠
        var viewFlipper = findViewById<ViewFlipper>(R.id.viewFlipper1)

        viewFlipper.flipInterval = 500

        btnPrevious.setOnClickListener {
            //viewFlipper.showPrevious()
            viewFlipper.startFlipping()
        }

        btnNext.setOnClickListener {
//            viewFlipper.showNext()
            viewFlipper.stopFlipping()
        }
    }
}