package com.example.ch10_activity_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {

//    var rdoSecond : RadioButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var rg1 = findViewById<RadioGroup>(R.id.rg1)
//        var rdoSecond = findViewById<RadioButton>(R.id.rdoSecond)
//        var rdoThird = findViewById<RadioButton>(R.id.rdoThird)
//        var rdoForth = findViewById<RadioButton>(R.id.rdoForth)


        var btn1 = findViewById<Button>(R.id.btn1)
        btn1.setOnClickListener {

            var intent1 : Intent? = null

            when(rg1.checkedRadioButtonId)
            {
                R.id.rdoSecond -> intent1 = Intent(this, SecondActivity::class.java)
                R.id.rdoThird  -> intent1 = Intent(this, ThirdActivity::class.java)
                R.id.rdoForth  -> intent1 = Intent(this, ForthActivity::class.java)
                else -> {
                    Toast.makeText(this, "라디오버튼을 선택해주세요", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

//            if(rdoSecond.isChecked)
//                intent1 = Intent(this, SecondActivity::class.java)
//            else if(rdoThird.isChecked)
//                intent1 = Intent(this, ThirdActivity::class.java)
//            else if(rdoForth.isChecked)
//                intent1 = Intent(this, ForthActivity::class.java)
//            else
//                Toast.makeText(this, "라디오버튼을 선택해주세요", Toast.LENGTH_SHORT).show()

            startActivity(intent1)
        }
    }
}