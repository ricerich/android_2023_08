package com.example.ch07_03_dialog_multi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn1 = findViewById<Button>(R.id.button1)

        var nCheck = 0;
        var checkArray = booleanArrayOf(false, false, false)
        btn1.setOnClickListener {

            //배열
            var versionArray = arrayOf("오레오", "파이", "큐")
//            var checkArray = booleanArrayOf(true, false, false)

            var dialog = AlertDialog.Builder(this)
            dialog.setTitle("제목입니다")
//            dialog.setMessage("내용")
//            dialog.setItems(versionArray) { dialog1, position ->
//                btn1.text = versionArray[position]
//            }
//            dialog.setSingleChoiceItems(versionArray,nCheck) {dialog1, position ->
//                btn1.text = versionArray[position]
//                nCheck = position
//            }

            dialog.setMultiChoiceItems(versionArray,checkArray) { dialog1, position, isChecked ->
//                btn1.text = versionArray[position]

                var str1 = "선택안됨";
                var cnt = 0;

                for(i in 0..checkArray.size-1 )
                {
                    if(checkArray[i])
                    {
                        if(cnt == 0)
                            str1 = versionArray[i]
                        else
                            str1 = str1 + "," + versionArray[i]

                        cnt++;
                    }
                }
                btn1.text = str1
            }

            dialog.setIcon(R.mipmap.ic_launcher)
            dialog.setPositiveButton("확인",null)

            dialog.show();
        }
    }
}