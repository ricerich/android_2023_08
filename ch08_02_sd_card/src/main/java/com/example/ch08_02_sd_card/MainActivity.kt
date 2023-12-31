package com.example.ch08_02_sd_card

import android.content.Context
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.io.FileInputStream

class MainActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), Context.MODE_PRIVATE)

        var btnRead : Button
        var edtSD : EditText
        btnRead = findViewById<Button>(R.id.btnRead)
        edtSD = findViewById<EditText>(R.id.edtSD)

        btnRead.setOnClickListener {
//            var inFs = FileInputStream("/storage/emulated/0/sd_test.txt")

            var inFs = FileInputStream(Environment.getExternalStorageDirectory().absolutePath+"/sd_test.txt")
            var txt = ByteArray(inFs.available())
            inFs.read(txt)
            edtSD.setText(txt.toString(Charsets.UTF_8))
            inFs.close()
        }
    }
}