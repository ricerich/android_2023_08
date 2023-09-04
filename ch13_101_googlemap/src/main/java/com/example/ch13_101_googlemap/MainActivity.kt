package com.example.ch13_101_googlemap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.ch13_101_googlemap.databinding.ActivityMainBinding
import com.example.ch13_101_googlemap.databinding.ActivityMapsBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

//        setContentView(R.layout.activity_main)
        setContentView(binding.root)

//        var btn1111 = findViewById<Button>(R.id.btn1)

        binding.btn1.setOnClickListener {
            var intent1 = Intent(this, MapsActivity::class.java)
            startActivity(intent1)
        }
    }
}