package com.example.ch10_activity_03_both

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "메인 액티비티"
        var edt1 = findViewById<EditText>(R.id.edtNum1)
        var edt2 = findViewById<EditText>(R.id.edtNum2)

        var rg1 = findViewById<RadioGroup>(R.id.rg1)

        var btn1 = findViewById<Button>(R.id.btnNewActivity)
        btn1.setOnClickListener {
            var intent1 = Intent(this, SecondActivity::class.java)

            intent1.putExtra("Num1", edt1.text.toString().toInt())
            intent1.putExtra("Num2", edt2.text.toString().toInt())

            var op = ""
            when(rg1.checkedRadioButtonId)
            {
                R.id.rdo1 -> op = "+"
                R.id.rdo2 -> op = "-"
                R.id.rdo3 -> op = "*"
                R.id.rdo4 -> op = "/"
                else -> {
                    Toast.makeText(this, "부호를 선택해주세요", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            intent1.putExtra("Operator", op)

            startActivityForResult(intent1, 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)

        if(resultCode == RESULT_OK)
        {
            var hap = intent!!.getIntExtra("Hap", 0)
            Toast.makeText(this, "합계: $hap ," + hap, Toast.LENGTH_SHORT).show()
        }
    }
}