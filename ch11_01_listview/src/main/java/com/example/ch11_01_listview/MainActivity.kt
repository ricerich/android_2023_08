package com.example.ch11_01_listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var array1 = arrayOf("히어로즈", "24시", "로스트", "로스트룸", "스몰빌",
//                             "탐정몽크", "빅뱅이론", "프렌즈", "덱스터", "글리",
//                             "가쉽걸", "테이큰", "슈퍼내추럴", "브이")

        //가변길이 배열을 ArrayList로 만든다. 왜냐하면 갯수를 모르니까
        var array2 = ArrayList<String>()

        //1.어댑터뷰(리스트뷰)
        var listview1 = findViewById<ListView>(R.id.listView1)

        //2.어댑터 객체 생성
//        var adapter1 = ArrayAdapter(this,
//                                    android.R.layout.simple_list_item_multiple_choice,
//                                    array1)
        //2.어댑터 객체 생성
        var adapter1 = ArrayAdapter(this,
                                    android.R.layout.simple_list_item_multiple_choice,
                                    array2)

        listview1.choiceMode = ListView.CHOICE_MODE_MULTIPLE

        //3.어댑터를 어댑터뷰(리스트뷰)에 장착
        listview1.adapter = adapter1

        //4.이벤트 처리: 어댑터뷰의 1개의 item을 선택했을때
//        listview1.setOnItemClickListener { adapterView, view, position, id ->
//            Toast.makeText(this, array1[position], Toast.LENGTH_SHORT).show()
//
//        }

        var edt1 = findViewById<EditText>(R.id.edtItem)
        var btn1 = findViewById<Button>(R.id.btnAdd)
        btn1.setOnClickListener {
            //리스트에 추가-> 리스뷰를 구성하는 데이터(3번) ArrayList에 추가
            array2.add(edt1.text.toString())
            adapter1.notifyDataSetChanged()
        }
        listview1.setOnItemLongClickListener { adapterView, view, postion, l ->
            array2.removeAt(postion)
            adapter1.notifyDataSetChanged()
            false
        }
    }
}










