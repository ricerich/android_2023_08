package com.example.ch07_04_dialog_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "사용자 정보 입력"

//        var tvName = findViewById<TextView>(R.id.tvName)
//        var tvEmail = findViewById<TextView>(R.id.tvEmail)

        var edtName = findViewById<TextView>(R.id.edtName)
        var edtEmail = findViewById<TextView>(R.id.edtEmail)

        var btn1 = findViewById<Button>(R.id.button1)

        btn1.setOnClickListener {

            var dlgView1 : View = View.inflate(this,R.layout.dialog1,null);

            var dlgEdt1 = dlgView1.findViewById<EditText>(R.id.dlgEdt1)
            var dlgEdt2 = dlgView1.findViewById<EditText>(R.id.dlgEdt2)



            var dlg1 = AlertDialog.Builder(this)
            dlg1.setTitle("사용자 정보 입력")
            dlg1.setIcon(R.drawable.ic_menu_allfriends)
            dlg1.setView(dlgView1)

            //다이얼로그로 올려 보내는 거 추가
            var strName = edtName.text.toString();
            var strEmail = edtEmail.text.toString();

            dlgEdt1.setText(strName)
            dlgEdt2.setText(strEmail)

            dlg1.setPositiveButton("확인"){ dialog, position ->

                //아래로 보내는거
//                var dlgEdt1 = dlgView1.findViewById<EditText>(R.id.dlgEdt1)
//                var dlgEdt2 = dlgView1.findViewById<EditText>(R.id.dlgEdt2)

                edtName.setText(dlgEdt1.text.toString())
                edtEmail.setText(dlgEdt2.text.toString())

            }
            dlg1.setNegativeButton("취소") { dialog, position ->

                var toastView = View.inflate(this,R.layout.toast1,null)
                var toast1 = Toast(this)
                var tvToast = toastView.findViewById<TextView>(R.id.toastText1)
                tvToast.text = "취소했습니다"
                toast1.view = toastView
                toast1.show();
            }
            dlg1.show()
        }
    }
}








