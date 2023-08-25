package com.example.ch06_03_tabhost

import android.app.TabActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

@Suppress("DEPRECATION")
class MainActivity : TabActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tabHost = this.tabHost

//        var tab1 = tabHost.newTabSpec("Song").setIndicator("음악별")
//        tab1.setContent(R.id.tabSong)
//        tabHost.addTab(tab1)
//
//        var tab2 = tabHost.newTabSpec("Artist").setIndicator("가수별")
//        tab2.setContent(R.id.tabArtist)
//        tabHost.addTab(tab2)
//
//        var tab3 = tabHost.newTabSpec("Album").setIndicator("앨범별")
//        tab3.setContent(R.id.tabAlbum)
//        tabHost.addTab(tab3)

        var tab1 = tabHost.newTabSpec("Dog").setIndicator("강아지")
        tab1.setContent(R.id.iv1)
        tabHost.addTab(tab1)

        var tab2 = tabHost.newTabSpec("Cat").setIndicator("고양이")
        tab2.setContent(R.id.iv2)
        tabHost.addTab(tab2)

        var tab3 = tabHost.newTabSpec("Rabbit").setIndicator("토끼")
        tab3.setContent(R.id.iv3)
        tabHost.addTab(tab3)

        var tab4 = tabHost.newTabSpec("Horse").setIndicator("말")
        tab4.setContent(R.id.iv4)
        tabHost.addTab(tab4)

        tabHost.currentTab = 1
    }
}