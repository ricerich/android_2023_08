package com.example.ch11_04_spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var movie = arrayOf("쿵푸팬더", "짱구는 못말려", "아저씨",
                            "아바타", "대부", "국가대표",
                            "토이스토리3","마당을 나온 암탉", "죽은 시인의 사회",
                            "서유기")



        var spinner1 = findViewById<Spinner>(R.id.spinner1)
        var adapter1 = ArrayAdapter<String>(this,
                                            android.R.layout.simple_spinner_item,
                                            movie)

        spinner1.adapter = adapter1

//        var iv1 = findViewById<ImageView>(R.id.iv1)

//        spinner1.onItemSelectedListener = 객체
//
//        spinner1.onItemSelectedListener = new A(){
//                                               void onClick(){
//
//                                                }
//                                            }
        var listener1 = object : OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                var posterID = arrayOf(R.drawable.mov21, R.drawable.mov22, R.drawable.mov23,
                    R.drawable.mov24, R.drawable.mov25, R.drawable.mov26,
                    R.drawable.mov27, R.drawable.mov28, R.drawable.mov29,
                    R.drawable.mov30)

                var iv1 = findViewById<ImageView>(R.id.iv1)
                iv1.setImageResource(posterID[p2])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) { }

        }

        spinner1.onItemSelectedListener = listener1






    }
}