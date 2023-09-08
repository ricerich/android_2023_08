package com.example.ch13_01_media_player

import android.content.Context
import java.io.File
import java.io.IOException
import java.util.ArrayList

import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import android.media.MediaPlayer
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.TextView
import java.text.SimpleDateFormat

@Suppress("deprecation")
class MainActivity : AppCompatActivity() {

    var listViewMP3: ListView? = null
    lateinit var btnPlay: Button
    lateinit var btnPause: Button
    lateinit var btnStop: Button
    lateinit var tvMP3: TextView
    lateinit var pbMP3: ProgressBar

    lateinit var sb1: SeekBar
    lateinit var tv1: TextView

    lateinit var mp3List: ArrayList<String>
    lateinit var selectedMP3: String

    var mp3Path = Environment.getExternalStorageDirectory().path + "/Download/"
    lateinit var mPlayer: MediaPlayer
    var PAUSED = false // 음악이 일시정지 중인지 체크.

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "간단 MP3 플레이어(개선)"
//        supportActionBar!!.setDisplayShowHomeEnabled(true)
//        supportActionBar!!.setIcon(R.drawable.music)
        ActivityCompat.requestPermissions(this,
            arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
            Context.MODE_PRIVATE)

        // SDCard의 파일을 읽어서 리스트뷰에 출력
        mp3List = ArrayList() // 가변적 문자열

        var listFiles = File(mp3Path).listFiles()
        var fileName: String
        var extName: String
        for (file in listFiles!!) {
            fileName = file.name
            extName = fileName.substring(fileName.length - 3)
            if (extName == "mp3")
            // 확장명이 mp3일 때만 추가함.
                mp3List.add(fileName)
        }

        var listViewMP3 = findViewById<View>(R.id.listViewMP3) as ListView
        var adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_single_choice, mp3List)
        listViewMP3.choiceMode = ListView.CHOICE_MODE_SINGLE
        listViewMP3.adapter = adapter
        listViewMP3.setItemChecked(0, true)

        listViewMP3.onItemClickListener = AdapterView.OnItemClickListener { arg0, arg1, arg2, arg3 -> selectedMP3 = mp3List[arg2] }
        selectedMP3 = mp3List[0]

        btnPlay = findViewById<View>(R.id.btnPlay) as Button
        btnPause = findViewById<View>(R.id.btnPause) as Button
        btnStop = findViewById<View>(R.id.btnStop) as Button
        tvMP3 = findViewById<View>(R.id.tvMP3) as TextView
        pbMP3 = findViewById<View>(R.id.pbMP3) as ProgressBar

        sb1 = findViewById(R.id.sb1)
        tv1 = findViewById(R.id.tv1)

        btnPlay.setOnClickListener {
            mPlayer = MediaPlayer()
            mPlayer.setDataSource(mp3Path + selectedMP3)
            mPlayer.prepare()
            mPlayer.start()
            btnPlay.isClickable = false
            btnPause.isClickable = true
            btnStop.isClickable = true
            tvMP3.text = "실행중인 음악 :  $selectedMP3"
            pbMP3.visibility = View.VISIBLE



            object : Thread() {
                override fun run() {

                    sb1.max = mPlayer.duration

                    while(mPlayer != null && mPlayer.isPlaying && mPlayer.currentPosition < mPlayer.duration){
                        runOnUiThread {
                            sb1.progress = mPlayer.currentPosition
                            var time1 = SimpleDateFormat("mm:ss").format(mPlayer.currentPosition)
                            tv1.text = ("진행시간 : " + time1 )
                        }
                        SystemClock.sleep(100)
                    }
                    pbMP3.visibility = View.INVISIBLE
                }
            }.start()
        }

        btnPause.setOnClickListener {
            if (!PAUSED) {//일시정지가 아니면,
                mPlayer.pause()
                btnPause.text = "이어듣기"
                PAUSED = true//일시정지
                pbMP3.visibility = View.INVISIBLE
            } else {//일시정지이면
                mPlayer.start()//시작하세요
                PAUSED = false
                btnPause.text = "일시정지"
                pbMP3.visibility = View.VISIBLE
            }
        }
        btnPause.isClickable = false

        btnStop.setOnClickListener {
            mPlayer.stop()
            mPlayer.reset()
            btnPlay.isClickable = true
            btnPause.isClickable = false
            btnPause.text = "일시정지"
            btnStop.isClickable = false
            tvMP3.text = "실행중인 음악 :  "
            pbMP3.visibility = View.INVISIBLE
        }
        btnStop.isClickable = false

    }

}
