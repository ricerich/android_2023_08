package com.example.ch11_03_gallery

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Gallery
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MyAdapter(var act: AppCompatActivity) : BaseAdapter(){

//    var context1 = context

    var posterID = arrayOf(R.drawable.mov11, R.drawable.mov12, R.drawable.mov13,
        R.drawable.mov14, R.drawable.mov15, R.drawable.mov16,
        R.drawable.mov17, R.drawable.mov18, R.drawable.mov19,
        R.drawable.mov20)

    override fun getView(pos: Int, p1: View?, p2: ViewGroup?): View {
        var iv1 = ImageView(act)
        iv1.layoutParams = Gallery.LayoutParams(200, 300)
        iv1.scaleType = ImageView.ScaleType.FIT_CENTER
        iv1.setPadding(5,5,5,5)
        iv1.setImageResource(posterID[pos])

//            iv1.setOnClickListener {//클릭은 안됨~! 왜냐하면 갤러리 스와이프 이벤트 중복
//                var ivPoster = findViewById<ImageView>(R.id.ivPoster)
//                ivPoster.scaleType = ImageView.ScaleType.FIT_CENTER
//                ivPoster.setImageResource(posterID[pos])
//
//            }

        iv1.setOnTouchListener { view, motionEvent ->

            var posterTitle = arrayOf("여인의 향기", "쥬라기 공원", "포레스트 검프", "사랑의 블랙홀", "혹성탈출",
                                      "아름다운비행", "내이름은 칸", "해리포터", "마더", "킹콩을 들다")

            var ivPoster = act.findViewById<ImageView>(R.id.ivPoster)
            ivPoster.scaleType = ImageView.ScaleType.FIT_CENTER
            ivPoster.setImageResource(posterID[pos])

            var toastView = View.inflate(act, R.layout.toast1, null)

            var toast1 = Toast(act)
            var tv1 = toastView.findViewById<TextView>(R.id.textView1)
            tv1.text = posterTitle[pos]

            toast1.view = toastView
            toast1.show()

            false
        }

        return iv1;
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