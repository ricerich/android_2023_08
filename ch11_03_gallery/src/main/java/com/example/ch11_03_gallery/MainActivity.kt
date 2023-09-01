package com.example.ch11_03_gallery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.Gallery
import android.widget.ImageView
import android.widget.LinearLayout

@Suppress("deprecation")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var gallery1 = findViewById<Gallery>(R.id.gallery1)
        var adapter1 = MyAdapter(this)
        gallery1.adapter = adapter1
    }
}

//class MyAdapter(var act: AppCompatActivity) : BaseAdapter(){
//
////    var context1 = context
//
//    var posterID = arrayOf(R.drawable.mov11, R.drawable.mov12, R.drawable.mov13,
//        R.drawable.mov14, R.drawable.mov15, R.drawable.mov16,
//        R.drawable.mov17, R.drawable.mov18, R.drawable.mov19,
//        R.drawable.mov20)
//
//    override fun getView(pos: Int, p1: View?, p2: ViewGroup?): View {
//        var iv1 = ImageView(act)
//        iv1.layoutParams = Gallery.LayoutParams(200, 300)
//        iv1.scaleType = ImageView.ScaleType.FIT_CENTER
//        iv1.setPadding(5,5,5,5)
//        iv1.setImageResource(posterID[pos])
//
////            iv1.setOnClickListener {//클릭은 완됨~! 왜냐하면 갤러리 스와이프 이벤트 중복
////                var ivPoster = findViewById<ImageView>(R.id.ivPoster)
////                ivPoster.scaleType = ImageView.ScaleType.FIT_CENTER
////                ivPoster.setImageResource(posterID[pos])
////
////            }
//
//        iv1.setOnTouchListener { view, motionEvent ->
//            var ivPoster = act.findViewById<ImageView>(R.id.ivPoster)
//            ivPoster.scaleType = ImageView.ScaleType.FIT_CENTER
//            ivPoster.setImageResource(posterID[pos])
//            false
//        }
//
//        return iv1;
//    }
//    override fun getCount(): Int {
//        return posterID.size
//    }
//
//    override fun getItem(p0: Int): Any {
//        return 0
//    }
//
//    override fun getItemId(p0: Int): Long {
//        return 0
//    }
//}





















