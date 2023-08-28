package com.example.ch07_01_menu_01_options

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    var baseLayout : LinearLayout? = null;
    var btn1 : Button? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "배경색 바꾸기"
        baseLayout = findViewById<LinearLayout>(R.id.baseLayout);
        btn1 = findViewById(R.id.button1)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        //1번 인플레이터 사용(추천방법)
//        var mInflater = menuInflater
//        mInflater.inflate(R.menu.menu1,menu)

        //2번 방법, only 코드로만 디자인 넣기
        menu!!.add(0,1,0,"배경색 (빨강)")
        menu!!.add(0,2,0,"배경색 (초록)")
        menu!!.add(0,3,0,"배경색 (파랑)")

        var sub = menu.addSubMenu("버튼 변경>>")

        sub!!.add(0,4,0,"회전 45도")
        sub!!.add(0,5,0,"확대 2배")

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
//            R.id.itemRed -> {
            1 -> {
                baseLayout!!.setBackgroundColor(Color.RED)
                return true
            }
//            R.id.itemGreen -> {
            2 -> {
                baseLayout!!.setBackgroundColor(Color.GREEN)
                return true
            }
//            R.id.itemBlue-> {
            3 -> {
                baseLayout!!.setBackgroundColor(Color.BLUE)
                return true
            }

//            R.id.subRotate ->{
            4 -> {
                btn1!!.rotation = 45f
                return true
            }
//            R.id.subSize ->{
            5 -> {
                btn1!!.scaleX = 2f
                return true
            }

        }

        return super.onOptionsItemSelected(item)
    }
}









