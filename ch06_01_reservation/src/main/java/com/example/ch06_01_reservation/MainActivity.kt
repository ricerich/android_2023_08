package com.example.ch06_01_reservation

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.Chronometer
import android.widget.DatePicker
import android.widget.RadioButton
import android.widget.TextView
import android.widget.TimePicker

class MainActivity : AppCompatActivity() {

    //멤버변수로!!
//    var year1 = 0;
//    var month1 = 0;
//    var day1 = 0;

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var chrono1 = findViewById<View>(R.id.chrono1) as Chronometer
//        var btnStart = findViewById<View>(R.id.btnStart) as Button

        var rdo1 = findViewById<View>(R.id.rdo1) as RadioButton
        var rdo2 = findViewById<View>(R.id.rdo2) as RadioButton

//        var cv1 = findViewById<View>(R.id.cv1) as CalendarView
        var dp1 = findViewById<View>(R.id.dp1) as DatePicker
        var tp1 = findViewById<View>(R.id.tp1) as TimePicker

//        var btnFinish = findViewById<View>(R.id.btnFinish) as Button

        var tvYear = findViewById<View>(R.id.tvYear) as TextView
        var tvMonth = findViewById<View>(R.id.tvMonth) as TextView
        var tvDay = findViewById<View>(R.id.tvDay) as TextView
        var tvHour = findViewById<View>(R.id.tvHour) as TextView
        var tvMinute = findViewById<View>(R.id.tvMinute) as TextView

        rdo1.visibility = View.INVISIBLE
        rdo2.visibility = View.INVISIBLE

//        cv1.visibility = View.INVISIBLE
        dp1.visibility = View.INVISIBLE
        tp1.visibility = View.INVISIBLE

//        btnStart.setOnClickListener {
//            chrono1.base = SystemClock.elapsedRealtime()
//            chrono1.start()
//            chrono1.setTextColor(Color.RED)
//        }

        chrono1.setOnClickListener {
            chrono1.base = SystemClock.elapsedRealtime()
            chrono1.start()
            chrono1.setTextColor(Color.RED)

            rdo1.visibility = View.VISIBLE
            rdo2.visibility = View.VISIBLE
        }



        rdo1.setOnClickListener {
//            cv1.visibility = View.VISIBLE
            dp1.visibility = View.VISIBLE
            tp1.visibility = View.INVISIBLE
        }

        rdo2.setOnClickListener {
//            cv1.visibility = View.INVISIBLE
            dp1.visibility = View.INVISIBLE
            tp1.visibility = View.VISIBLE
        }

//        btnFinish.setOnClickListener {
//            chrono1.stop()
//            chrono1.setTextColor(Color.BLUE)
//
//            //1.캘린더뷰 cv1으로 부터, 년, 월, 일 이벤트처리된거 가져온다
////            tvYear.text = year1.toString()
////            tvMonth.text = month1.toString()
////            tvDay.text = day1.toString()
//
//            tvYear.text = dp1.year.toString()
//            tvMonth.text = dp1.month.toString()
//            tvDay.text = dp1.dayOfMonth.toString()
//
//            //2.타임피커로 부터 "직접" 시, 분을 가져온다
//            tvHour.text = tp1.currentHour.toString()
//            tvMinute.text = tp1.currentMinute.toString()
//        }


        tvYear.setOnClickListener {
            chrono1.stop()
            chrono1.setTextColor(Color.BLUE)

            //1.캘린더뷰 cv1으로 부터, 년, 월, 일 이벤트처리된거 가져온다
//            tvYear.text = year1.toString()
//            tvMonth.text = month1.toString()
//            tvDay.text = day1.toString()

            tvYear.text = dp1.year.toString()
            tvMonth.text = dp1.month.toString()
            tvDay.text = dp1.dayOfMonth.toString()

            //2.타임피커로 부터 "직접" 시, 분을 가져온다
            tvHour.text = tp1.currentHour.toString()
            tvMinute.text = tp1.currentMinute.toString()

            rdo1.visibility = View.INVISIBLE
            rdo2.visibility = View.INVISIBLE
            dp1.visibility = View.INVISIBLE
            tp1.visibility = View.INVISIBLE
        }

//        var year1 : Int = 0; //여기는 안됨!
//        var month1 : Int = 0;
//        var day1 : Int = 0;

//        cv1.setOnDateChangeListener { calendarView, year, month, day ->
//
//            year1 = year
//            month1 = month + 1
//            day1 = day
//
//        }


    }
}






