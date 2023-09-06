package com.example.ch08_01_diary

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import java.io.FileInputStream
import java.io.IOException
import java.lang.Exception
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    lateinit var edtDiary : EditText
    lateinit var btnWrite : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dp = findViewById<DatePicker>(R.id.datePicker1)
        edtDiary = findViewById<EditText>(R.id.edtDiary)
        btnWrite = findViewById<Button>(R.id.btnWrite)

        var cal = Calendar.getInstance()
        var cYear = cal.get(Calendar.YEAR)
        var cMonth = cal.get(Calendar.MONTH)
        var cDay = cal.get(Calendar.DAY_OF_MONTH)

        var fileName = ""

        fileName = cYear.toString() + "_" + (cMonth+1).toString() + "_" + cDay.toString() + ".txt"

        var contents = readDiary(fileName)
        edtDiary.setText(contents)

        dp.init(cYear, cMonth, cDay) { view, year, month, day ->
            var yyyy = year.toString()
            var mm = (month+1).toString()
            var dd = day.toString()
            fileName = yyyy + "_" + mm + "_" + dd + ".txt"

            var contents = readDiary(fileName)
            edtDiary.setText(contents)
            btnWrite.isEnabled = true
        }

        btnWrite.setOnClickListener {
            var ofo1 = openFileOutput(fileName, Context.MODE_PRIVATE)
            var str1 = edtDiary.text.toString()
            ofo1.write(str1.toByteArray())
            ofo1.close()

            Toast.makeText(this, fileName+"이 저장됨", Toast.LENGTH_SHORT).show()
        }
    }

    fun readDiary(fileName: String) : String {

        var contents = ""

        var fis1 : FileInputStream
        try {
            fis1 = openFileInput(fileName)//파일 객체
            var txt = ByteArray(30)
            fis1.read(txt)
            fis1.close()
            contents = txt.toString(Charsets.UTF_8).trim()
            btnWrite.setText("수정 하기")
            btnWrite.isEnabled = true

        }
        catch (e : IOException)
        {
//            e.toString();
            edtDiary.setText("일기없음")
            btnWrite.text = "새로 저장"
        }


        return contents
    }


}








