package com.example.ch05_01

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //0.레이아웃의 "옵션(PARAM)"을 코틀린객체로 만들기
        var option = LayoutParams(LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT)

        //1.레이아웃(예:리니어레이아웃)을 코트린객체로 만들기
        var linearLayout1 = LinearLayout(this)
        linearLayout1.orientation = LinearLayout.VERTICAL

        //2.레이아웃을 뷰로 셋한다.
        setContentView(linearLayout1, option)

        //1.에디트 추가
        var edt1 = EditText(this)
        edt1.hint = "값을 넣어주세요"
        linearLayout1.addView(edt1)

        //2.버튼 추가
        var btn1 = Button(this)
        btn1.text = "버튼입니다"
        btn1.setBackgroundColor(Color.MAGENTA)
        linearLayout1.addView(btn1)

        //3.텍스트 뷰 추가
        var tv1 = TextView(this)
        tv1.text = "결과출력 여기에..."
        tv1.setTextColor(Color.MAGENTA)
        tv1.setTextSize(30f)
        linearLayout1.addView(tv1)


        btn1.setOnClickListener {
            tv1.setText(edt1.text)
        }
//////////////////////////////////////////////////////////////////////////////////////////////////

//        //setContentView(R.layout.activity_main) //XML을 사용하지 않겠다.
//
//        //0.레이아웃의 "옵션(PARAM)"을 코틀린객체로 만들기
//        //1.레이아웃(예:리니어레이아웃)을 코트린객체로 만들기
//        //2.레이아웃을 뷰로 셋한다.
//        //3.뷰(예:버튼)를 코틀린객체로 만들기
//        //4.버튼을 레이아웃에 꽂는다
//
//        //0.레이아웃의 "옵션(PARAM)"을 코틀린객체로 만들기
//        var option = LayoutParams(LayoutParams.MATCH_PARENT,
//                                  LayoutParams.MATCH_PARENT)
//
//        //1.레이아웃(예:리니어레이아웃)을 코트린객체로 만들기
//        var linearLayout1 = LinearLayout(this)
//        linearLayout1.orientation = LinearLayout.VERTICAL
//        linearLayout1.setBackgroundColor(Color.rgb(0, 255, 0))
//
//        //2.레이아웃을 뷰로 셋한다.
//        setContentView(linearLayout1, option)
//
//        //3.뷰(예:버튼)를 코틀린객체로 만들기
//        var btn1 = Button(this)
//        btn1.text = "버튼입니다"
//        btn1.setBackgroundColor(Color.MAGENTA)
//
//        //4.버튼을 레이아웃에 꽂는다
//        linearLayout1.addView(btn1)
//
//        btn1.setOnClickListener {
//            Toast.makeText(this,"코드로 생성한 버튼이예요",Toast.LENGTH_SHORT).show()
//        }


    }
}