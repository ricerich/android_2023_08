package com.example.animal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        super.setTitle("애완동물 사진 보기")
        title = "애완동물 사진 보기"

//        var chk1 = findViewById<CheckBox>(R.id.ChkAgree);
//        var chk1 = findViewById<View>(R.id.ChkAgree) as CheckBox;
        var sw1 = findViewById<View>(R.id.SwAgree) as Switch;

        var tv2 = findViewById<View>(R.id.Text2) as TextView;

        var rg1 = findViewById<View>(R.id.Rgroup1) as RadioGroup;

        //코드추가
        var rdo1 = findViewById<View>(R.id.RdoDog) as RadioButton;
        var rdo2 = findViewById<View>(R.id.RdoCat) as RadioButton;
        var rdo3 = findViewById<View>(R.id.RdoRabbit) as RadioButton;

//        var btn1 = findViewById<View>(R.id.BtnOK) as Button;
        var iv1 = findViewById<View>(R.id.ImgPet) as ImageView;

        var btnFinish = findViewById<View>(R.id.btnFinish) as Button;
        var btnInit = findViewById<View>(R.id.btnInit) as Button;

        //이벤트 처리: 라디오 버튼 클릭시
        rdo1.setOnClickListener {
            iv1.setImageResource(R.drawable.dog);
        }
        rdo2.setOnClickListener {
            iv1.setImageResource(R.drawable.cat);
        }
        rdo3.setOnClickListener {
            iv1.setImageResource(R.drawable.rabbit);
        }

        //이벤트 처리
        sw1.setOnCheckedChangeListener { compoundButton, b ->

            //체크가 되었을 경우: 체크가 없어쓰는데, 체크를 한 경우
//            if(chk1.isChecked == true)
            if(sw1.isChecked)
            {
                tv2.visibility = View.VISIBLE;
                rg1.visibility = View.VISIBLE;
//                btn1.visibility = View.VISIBLE;
                iv1.visibility = View.VISIBLE;
                btnFinish.visibility = View.VISIBLE;
                btnInit.visibility = View.VISIBLE;
            }
            else//체크가 있었는데, 없앤 경우
            {
                tv2.visibility = View.INVISIBLE;
                rg1.visibility = View.INVISIBLE;
//                btn1.visibility = View.INVISIBLE;
                iv1.visibility = View.INVISIBLE;
                btnFinish.visibility = View.INVISIBLE;
                btnInit.visibility = View.INVISIBLE;
            }
        }

        btnFinish.setOnClickListener {
            finish()
        }

        btnInit.setOnClickListener {
            tv2.visibility = View.INVISIBLE;
            rg1.visibility = View.INVISIBLE;
//                btn1.visibility = View.INVISIBLE;
            iv1.visibility = View.INVISIBLE;
            btnFinish.visibility = View.INVISIBLE;
            btnInit.visibility = View.INVISIBLE;

            sw1.isChecked = false;
            rg1.clearCheck()
            iv1.setImageResource(0)
        }

//        btn1.setOnClickListener {
//            when(rg1.checkedRadioButtonId)
//            {
//                R.id.RdoDog -> iv1.setImageResource(R.drawable.dog)
//                R.id.RdoCat -> iv1.setImageResource(R.drawable.cat)
//                R.id.RdoRabbit -> iv1.setImageResource(R.drawable.rabbit)
//                else -> Toast.makeText(this,"동물 선택 부탁해요",Toast.LENGTH_SHORT).show();
//
//            }
//        }

    }
}