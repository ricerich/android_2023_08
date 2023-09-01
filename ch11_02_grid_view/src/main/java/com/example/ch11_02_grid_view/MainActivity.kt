package com.example.ch11_02_grid_view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.core.view.updateLayoutParams

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1.어댑터뷰 비인딩
        //2.어댑터 만들기 -> 두번째 방법(복잡) : BaseAdapter(커스터마이징)
        //3.어댑터를 어댑터뷰(=그리드뷰)에 꽂기
        //4.어댑터뷰(그리드뷰)의 1개의 아이템 선택시 이벤트 처리

        //1.어댑터뷰 비인딩
        var gv1 = findViewById<GridView>(R.id.gridView1)

        //2.어댑터 만들기 -> 두번째 방법(복잡) : BaseAdapter(커스터마이징)
        var adapter1 = MyGridAdapter(this)
        //3.어댑터를 어댑터뷰(=그리드뷰)에 꽂기
        gv1.adapter = adapter1
        //4.어댑터뷰(그리드뷰)의 1개의 아이템 선택시 이벤트 처리
//        gv1.setOnItemClickListener { adapterView, view, postion, l ->
//
//        }
    }

    inner class MyGridAdapter (var context: Context) : BaseAdapter(){

        var posterID = arrayOf(
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
            R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
            R.drawable.mov09, R.drawable.mov10,
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
            R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
            R.drawable.mov09, R.drawable.mov10,
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
            R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
            R.drawable.mov09, R.drawable.mov10
        )

        override fun getView(position: Int, p1: View?, p2: ViewGroup?): View
        {
            var iv1 = ImageView(context)//생성자 매개변수로 넘어온 액티비티를 포함하는 context로 위치를 설정
            iv1.layoutParams = ViewGroup.LayoutParams(200,300)
            iv1.scaleType = ImageView.ScaleType.FIT_CENTER
            iv1.setPadding(5,5,5,5)
//            iv1.setImageResource(R.drawable.mov01)
            iv1.setImageResource(posterID[position])

            iv1.setOnClickListener {

                var posterTitle = arrayOf("써니", "완득이", "괴물", "라디오스타", "비열한거리",
                                          "왕의남자", "아일랜드", "웰컴투동막골", "헬보이", "빽투더퓨처",
                                          "써니", "완득이", "괴물", "라디오스타", "비열한거리",
                                          "왕의남자", "아일랜드", "웰컴투동막골", "헬보이", "빽투더퓨처",
                                          "써니", "완득이", "괴물", "라디오스타", "비열한거리",
                                          "왕의남자", "아일랜드", "웰컴투동막골", "헬보이", "빽투더퓨처",
                                          "써니", "완득이", "괴물", "라디오스타", "비열한거리",
                                          "왕의남자", "아일랜드", "웰컴투동막골", "헬보이", "빽투더퓨처")

                var dialog_view = View.inflate(this@MainActivity, R.layout.dialog1, null)

                var ivPoster = dialog_view.findViewById<ImageView>(R.id.ivPoster)
                ivPoster.setImageResource(posterID[position])

                var dlg = AlertDialog.Builder(this@MainActivity)
                dlg.setTitle(posterTitle[position])
                dlg.setIcon(R.drawable.movie_icon)
                dlg.setView(dialog_view)
                dlg.setNegativeButton("닫기", null)
                dlg.show()

            }

            return iv1
        }

        override fun getCount(): Int {
            return posterID.size
        }

        override fun getItem(p0: Int): Any {
            return 0
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }



    }
}











