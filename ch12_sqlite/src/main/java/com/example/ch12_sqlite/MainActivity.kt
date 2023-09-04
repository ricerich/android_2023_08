package com.example.ch12_sqlite

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    lateinit var edtName: EditText
    lateinit var edtNumber: EditText
    lateinit var edtNameResult: EditText
    lateinit var edtNumberResult: EditText
    lateinit var btnInit: Button
    lateinit var btnInsert: Button
    lateinit var btnUpdate: Button//추가
    lateinit var btnDelete: Button//추가
    lateinit var btnSelect: Button

    lateinit var myHelper: MyDBHelper
    lateinit var sqlDB: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "가수 그룹 관리 DB"

        edtName = findViewById<EditText>(R.id.edtName)
        edtNumber = findViewById<EditText>(R.id.edtNumber)
        edtNameResult = findViewById<EditText>(R.id.edtNameResult)
        edtNumberResult = findViewById<EditText>(R.id.edtNumberResult)

        btnInit = findViewById<Button>(R.id.btnInit)

        btnInsert = findViewById<Button>(R.id.btnInsert)
        btnUpdate = findViewById<Button>(R.id.btnUpdate)//추가
        btnDelete = findViewById<Button>(R.id.btnDelete)//추가
        btnSelect = findViewById<Button>(R.id.btnSelect)

        myHelper = MyDBHelper(this)

        btnInit.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            myHelper.onUpgrade(sqlDB, 1, 2)
            sqlDB.close()
        }

        btnInsert.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            var name = edtName.text.toString()
            var count = edtNumber.text.toString()
            sqlDB.execSQL("insert into groupTBL values ('"+name+"', "+count+"); ")
            sqlDB.close()
            Toast.makeText(this, "insert", Toast.LENGTH_SHORT).show()
            btnSelect.callOnClick()
        }

        //수정추가
        btnUpdate.setOnClickListener {
            sqlDB = myHelper.writableDatabase

            var name = edtName.text.toString()
            var count = edtNumber.text.toString()

            if(name.equals(""))
            {
                Toast.makeText(this, "이름이 없어요", Toast.LENGTH_SHORT).show()
                sqlDB.close()
                return@setOnClickListener
            }

            if(count.equals("")) {
                Toast.makeText(this, "이름이 없어요", Toast.LENGTH_SHORT).show()
                sqlDB.close()
                return@setOnClickListener
            }


            sqlDB.execSQL("update groupTBL set gNumber = "+count+" where gName = '"+name+"'; ")
            sqlDB.close()

            Toast.makeText(this, "수정되었습니다", Toast.LENGTH_SHORT).show()
            btnSelect.callOnClick()
        }

        //삭제추가
        btnDelete.setOnClickListener {
            sqlDB = myHelper.writableDatabase

            var name = edtName.text.toString()

            if(name.equals(""))
            {
                Toast.makeText(this, "이름이 없어요", Toast.LENGTH_SHORT).show()
                sqlDB.close()
                return@setOnClickListener
            }

            sqlDB.execSQL("delete from groupTBL where gName = '"+name+"'; ")
            sqlDB.close()

            Toast.makeText(this, "삭제되었습니다", Toast.LENGTH_SHORT).show()
            btnSelect.callOnClick()


        }

        btnSelect.setOnClickListener {
            sqlDB = myHelper.readableDatabase
            var rs : Cursor
            rs = sqlDB.rawQuery("select gName, gNumber from groupTBL;", null)

            var gName = "";
            var gNumber = "";
            while(rs.moveToNext())//1줄(튜플)씩 읽어온다
            {
                gName = gName + rs.getString(0) + "\r\n"
                gNumber = gNumber + rs.getString(1) + "\r\n"
            }

            edtNameResult.setText(gName)
            edtNumberResult.setText(gNumber)

            rs.close()
            sqlDB.close()

        }


    }

    //내부 클래스 MyDBHelper 를 정의(define)한다. 상속받아서 만든다.
    inner class MyDBHelper(context: Context) : SQLiteOpenHelper(context,"groupDB", null, 1)
    {
        override fun onCreate(p0: SQLiteDatabase?) {
            p0!!.execSQL("create table groupTBL (gName char(20) primary key, gNumber integer);")
        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
            p0!!.execSQL("drop table if exists groupTBL;")
//            p0!!.execSQL("create table groupTBL (gName char(20) primary key, gNumber integer);")
            onCreate(p0)
        }

    }


}





