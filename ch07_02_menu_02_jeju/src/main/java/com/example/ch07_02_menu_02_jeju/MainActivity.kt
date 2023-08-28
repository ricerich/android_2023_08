package com.example.ch07_02_menu_02_jeju


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    var edt1 : EditText? = null;
    var iv1 : ImageView? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "제주도 바꾸기"
        edt1 = findViewById(R.id.edt1);
        iv1 = findViewById(R.id.iv1)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        //1번 인플레이터 사용(추천방법)
        var mInflater = menuInflater
        mInflater.inflate(R.menu.menu1,menu)


        return super.onCreateOptionsMenu(menu)
    }

    var fAngle = 0f;
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.itemRotate -> {
                fAngle +=  edt1!!.text.toString().toFloat()
                iv1!!.rotation = fAngle
                return true
            }
            R.id.item1 -> {
                iv1!!.setImageResource(R.drawable.jeju4)
                return true
            }
            R.id.item2-> {
                iv1!!.setImageResource(R.drawable.jeju12)
                return true
            }

            R.id.item3 ->{
                iv1!!.setImageResource(R.drawable.jeju15)
                return true
            }

        }

        return super.onOptionsItemSelected(item)
    }
}