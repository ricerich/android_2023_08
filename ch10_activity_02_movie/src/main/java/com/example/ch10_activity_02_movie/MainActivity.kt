package com.example.ch10_activity_02_movie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var imageNameArray = arrayOf("독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
                                     "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매",
                                     "피아노 레슨", "피아노 앞의 소녀들", "해변에서")

        var voteCountArray = IntArray(9)
        for(i in 0..voteCountArray.size-1)
            voteCountArray[i] = 0

        //1번 방법: 전부 객체로
//        var iv1 = findViewById<ImageView>(R.id.iv1)
//        var iv2 = findViewById<ImageView>(R.id.iv2)
//        var iv3 = findViewById<ImageView>(R.id.iv3)

        var iv = arrayOfNulls<ImageView>(9)

        //2번 방법: 객체 배열이지만, 바인딩은 여러번
//        iv[0] = findViewById<ImageView>(R.id.iv1)
//        iv[1] = findViewById<ImageView>(R.id.iv2)
//        iv[2] = findViewById<ImageView>(R.id.iv3)

        var ivID_Array = arrayOf(R.id.iv1, R.id.iv2, R.id.iv3,
                                 R.id.iv4, R.id.iv5, R.id.iv6,
                                 R.id.iv7, R.id.iv8, R.id.iv9)

        for(i in 0..ivID_Array.size-1)
            iv[i] = findViewById<ImageView>(ivID_Array[i])

        //이미지뷰 객체를 눌렀을 때, 이벤트 처리(득표 올리기)

        for(i in 0..iv.size-1) {
            iv[i]!!.setOnClickListener {
                voteCountArray[i]++
                Toast.makeText(this,imageNameArray[i]+": 총 "+voteCountArray[i]+" 표", Toast.LENGTH_SHORT).show()
            }
        }

        var btnResult = findViewById<Button>(R.id.btnResult)
        btnResult.setOnClickListener {

            var intent1 = Intent(this, ResultActivity::class.java)

            //extras로 배열 2개를 들고 가야함
            intent1.putExtra("ImageName", imageNameArray);
            intent1.putExtra("VoteCount", voteCountArray);

            startActivity(intent1)

        }
    }
}