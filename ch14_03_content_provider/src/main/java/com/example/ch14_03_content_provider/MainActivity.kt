package com.example.ch14_03_content_provider

import android.Manifest
import android.content.Context
import android.os.Bundle
import android.provider.CallLog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import android.widget.Button
import android.widget.EditText

import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {
    lateinit var btnCall: Button
    lateinit var edtCall: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CALL_LOG), Context.MODE_PRIVATE)

        btnCall = findViewById<Button>(R.id.btnCall)
        edtCall = findViewById<EditText>(R.id.edtCall)
        btnCall.setOnClickListener {
            edtCall.setText(findCallHistory())
        }
    }

    fun findCallHistory(): String {
        var callSet = arrayOf(CallLog.Calls.DATE, CallLog.Calls.TYPE,
                              CallLog.Calls.NUMBER, CallLog.Calls.DURATION)

        var cursor = contentResolver.query(CallLog.Calls.CONTENT_URI,
                                        callSet, null,
                                        null, null)

        if ( cursor!!.count == 0 )
            return "통화기록 없음"

        var callBuff = StringBuffer() // 최대 100 통화 저장
        callBuff.append("\n날짜 : 구분 : 전화번호 : 통화시간\n\n")
        cursor.moveToFirst()
        do {
            var callDate = cursor.getLong(0)
            var datePattern = SimpleDateFormat("yyyy-MM-dd")
            var date_str = datePattern.format(Date(callDate))
            callBuff.append("$date_str:")
            if (cursor.getInt(1) == CallLog.Calls.INCOMING_TYPE)
                callBuff.append("착신 :")
            else
                callBuff.append("발신 :")
            callBuff.append(cursor.getString(2) + ":")
            callBuff.append(cursor.getString(3) + "초\n")
        } while (cursor.moveToNext())

        cursor.close()
        return callBuff.toString()
    }
}