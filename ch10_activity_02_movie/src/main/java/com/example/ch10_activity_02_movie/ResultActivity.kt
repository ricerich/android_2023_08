package com.example.ch10_activity_02_movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)

        var intent1 = intent
        var imageNameArray = intent1.getStringArrayExtra("ImageName")
        var voteCountArray = intent1.getIntArrayExtra("VoteCount")

        //텍스뷰 9개짜리 배열 생성, 레이팅바 9개짜리 배열 생성
        var tvArr = arrayOfNulls<TextView>(9)
        var rbArr = arrayOfNulls<RatingBar>(9)

        //id를 배열로 만들어 놓기
        var tvID_Arr = arrayOf(R.id.tv1, R.id.tv2, R.id.tv3,
                               R.id.tv4, R.id.tv5, R.id.tv6,
                               R.id.tv7, R.id.tv8, R.id.tv9)
        var rbId_Arr = arrayOf(R.id.rbar1, R.id.rbar2, R.id.rbar3,
                               R.id.rbar4, R.id.rbar5, R.id.rbar6,
                               R.id.rbar7, R.id.rbar8, R.id.rbar9)

        //바인딩
        for(i in tvArr!!.indices)
        {
            tvArr[i] = findViewById(tvID_Arr[i])
            rbArr[i] = findViewById(rbId_Arr[i])
        }

        for (i in imageNameArray!!.indices)
        {
//            tvArr[i] = imageNameArray[i]
            tvArr[i]!!.setText(imageNameArray[i])
            rbArr[i]!!.rating = voteCountArray!![i].toFloat()
        }

        var btnFinish = findViewById<Button>(R.id.btnReturn)

        btnFinish.setOnClickListener {
            finish()
        }
    }
}