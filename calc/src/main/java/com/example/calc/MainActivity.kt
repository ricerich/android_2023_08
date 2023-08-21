package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    //멤버변수 자리
    //var edt1 = findViewById<EditText>(R.id.Edit1);

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //onCreate()메소드의 지역변수 자리

        //1.kotlin 객체 만들기 +  2.xml객체를 가져와서, kotlin 객체에 연결(바인딩)
        var edt1 = findViewById<EditText>(R.id.Edit1);
        var edt2 = findViewById<EditText>(R.id.Edit2);

        var btn1 = findViewById<Button>(R.id.BtnAdd);
        var btn2 = findViewById<Button>(R.id.BtnSub);
        var btn3 = findViewById<Button>(R.id.BtnMul);
        var btn4 = findViewById<Button>(R.id.BtnDiv);

        var btn5 = findViewById<Button>(R.id.BtnMod);

        var tv1 = findViewById<TextView>(R.id.TextResult);

        //2.xml객체를 가져와서, kotlin 객체에 연결(바인딩)
//        edt1 = findViewById<EditText>(R.id.Edit1);

        //3.이벤트 처리
//        btn1.setOnClickListener {
//            var n1 = edt1.text.toString()
//            var n2 = edt2.text.toString()
//
//            var n3 = n1.toInt() + n2.toInt()
//
//            tv1.text = "결과값: "+n3
//        }
        
        btn1.setOnTouchListener { view, motionEvent ->
            var n1 = edt1.text.toString()
            var n2 = edt2.text.toString()

//            if(n1.equals("") || n2.equals(""))
            if(n1 == "" || n2 == "")
            {
                Toast.makeText(this, "빈값입니다", Toast.LENGTH_SHORT).show()
            }
            else
            {
                var n3 = n1.toDouble()+ n2.toDouble()
                n3 = (n3*1000).toInt()/1000.0

                tv1.text = "결과값: "+n3
            }

//            return false
            false
        }

        btn2.setOnClickListener {
            var n1 = edt1.text.toString()
            var n2 = edt2.text.toString()

            var n3 = n1.toInt() - n2.toInt()

            tv1.text = "결과값: "+n3
        }
        btn3.setOnClickListener {
            var n1 = edt1.text.toString()
            var n2 = edt2.text.toString()

            var n3 = n1.toInt() * n2.toInt()

            tv1.text = "결과값: "+n3
        }

        btn4.setOnClickListener {
            var n1 = edt1.text.toString()
            var n2 = edt2.text.toString()

//            if(n1.equals("") || n2.equals(""))
            if(n1 == "" || n2 == "")
            {
                Toast.makeText(this, "빈값입니다", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(n2 == "0") {
                Toast.makeText(this, "0으로 나눌수 없어요!!!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var n3 = n1.toDouble() / n2.toDouble()
            n3 = (n3 * 1000).toInt() / 1000.0

            tv1.text = "결과값: " + n3

//            return false
            false
        }

        btn5.setOnClickListener {
            var n1 = edt1.text.toString()
            var n2 = edt2.text.toString()

            var n3 = n1.toInt() % n2.toInt()

            tv1.text = "결과값: "+n3
        }
//        btn2.setOnClickListener {
//            tv1.text = "결과값: "+ edt1.text.toString().toInt()
//                                + edt2.text.toString().toInt()
//        }
    }
}