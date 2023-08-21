package com.example.test2

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.ex04_17)

        var tv1 = findViewById<TextView>(R.id.tv1);
        var tv2 = findViewById<TextView>(R.id.tv2);
        var tv3 = findViewById<TextView>(R.id.tv3);

        tv1.setText("안녕하세요?")
        tv1.setTextColor(Color.RED)
        
        tv2.setTextSize(30.0f)
        tv2.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC)
        
        tv3.setText("가나다라마바사아자차카타파하가나다라마바사아자차카타파하가나다라마바사아자차카타파하")
        tv3.setSingleLine()




        //1.코틀린 객체 만들기
//        EditTExt edt1;//자바 스타일
        //var edt1 = null;
        //var btn1 = null;
        //var tv1 = null;

        //2.XML 에서 객체 가져와서 코틀린 객체에 연결하기
        //edt1 = findViewById<EditText>(R.id.edt1);

//        var edt1 = findViewById<EditText>(R.id.edt1)
//        var btn1 = findViewById<Button>(R.id.btn1)
//        var tv1 = findViewById<TextView>(R.id.tv1)
//
//        btn1.setOnClickListener {
//            var str1 = edt1.text
//            tv1.setText(str1)
//        }

    }
}