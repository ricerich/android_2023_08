package com.example.calc2_number_button


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    //멤버변수 자리
    //var edt1 = findViewById<EditText>(R.id.Edit1);

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //onCreate()메소드의 지역변수 자리

        //1.kotlin 객체 만들기 +  2.xml객체를 가져와서, kotlin 객체에 연결(바인딩)
        var edt1 = findViewById<EditText>(R.id.Edit1);
        var edt2 = findViewById<EditText>(R.id.Edit2);

        var btn1 = findViewById<Button>(R.id.BtnAdd);
        var btn2 = findViewById<Button>(R.id.BtnSub);
        var btn3 = findViewById<Button>(R.id.BtnMul);
        var btn4 = findViewById<Button>(R.id.BtnDiv);

        var btn5 = findViewById<Button>(R.id.BtnMod);

        var tv1 = findViewById<TextView>(R.id.TextResult);


//        var btn_num0 = findViewById<Button>(R.id.BtnNum0);
//        var btn_num1 = findViewById<Button>(R.id.BtnNum1);
//        var btn_num2 = findViewById<Button>(R.id.BtnNum2);
//        var btn_num3 = findViewById<Button>(R.id.BtnNum3);
//        var btn_num4 = findViewById<Button>(R.id.BtnNum4);
//        var btn_num5 = findViewById<Button>(R.id.BtnNum5);
//        var btn_num6 = findViewById<Button>(R.id.BtnNum6);
//        var btn_num7 = findViewById<Button>(R.id.BtnNum7);
//        var btn_num8 = findViewById<Button>(R.id.BtnNum8);
//        var btn_num9 = findViewById<Button>(R.id.BtnNum9);



        //버튼객체 배열
        //1.자바 객체배열예제
//        Button btnArr = new Button[10];
//        btnArr[0] = new Button();
//        btnArr[1] = new Button();
//        btnArr[2] = new Button();
        //2.자바 ArrayList 예제
//        Button btnArr = new ArrayList<Button>(10)

        var btnArr = ArrayList<Button>(10)
//        btnArr.get(0) //전통적인 방식

//        btnArr[0] = findViewById<Button>(R.id.BtnNum0);
        //위 처럼 하면 안 먹힘
//        btnArr.add(findViewById<Button>(R.id.BtnNum0));
//        btnArr.add(findViewById<Button>(R.id.BtnNum1));
//        btnArr.add(findViewById<Button>(R.id.BtnNum2));
//        btnArr.add(findViewById<Button>(R.id.BtnNum3));
//        btnArr.add(findViewById<Button>(R.id.BtnNum4));
//        btnArr.add(findViewById<Button>(R.id.BtnNum5));
//        btnArr.add(findViewById<Button>(R.id.BtnNum6));
//        btnArr.add(findViewById<Button>(R.id.BtnNum7));
//        btnArr.add(findViewById<Button>(R.id.BtnNum8));
//        btnArr.add(findViewById<Button>(R.id.BtnNum9));

        //버튼 ID를 저장하는 정수형(INT)배열 만들기
        var btnID_Arr = arrayOf(R.id.BtnNum0,R.id.BtnNum1,R.id.BtnNum2,
                                R.id.BtnNum3,R.id.BtnNum4,R.id.BtnNum5,
                                R.id.BtnNum6,R.id.BtnNum7,R.id.BtnNum8,
                                R.id.BtnNum9)

        for(i in 0..9) {
//            btnArr.add(findViewById<Button>(R.id.BtnNum + i));
            btnArr.add(findViewById<Button>(btnID_Arr[i]));
        }

//        btnArr.get(0) //전통적인 방식

        for(i in 0..9)
        {
//            btnArr.get(i).setOnClickListener {
            btnArr[i].setOnClickListener {

                //포커스가 어디있는지 체크
                if(edt1.isFocused)
                {
                    edt1.setText(edt1.text.toString() + i)
                }
                else if(edt2.isFocused)
                {
                    edt2.setText(edt2.text.toString() + i)
                }else{
                    Toast.makeText(this,"에디트 텍스틀 선택해주세요",Toast.LENGTH_SHORT).show();
                }
            }
        }



//        btn_num0.setOnClickListener {
//
//            //포커스가 어디있는지 체크
//            if(edt1.isFocused)
//            {
//                edt1.setText(edt1.text.toString() + "0")
//            }
//            else if(edt2.isFocused)
//            {
//                edt2.setText(edt2.text.toString() + "0")
//            }else{
//                Toast.makeText(this,"에디트 텍스틀 선택해주세요",Toast.LENGTH_SHORT).show();
//            }
//        }
//
//        btn_num1.setOnClickListener {
//
//            //포커스가 어디있는지 체크
//            if(edt1.isFocused)
//            {
//                edt1.setText(edt1.text.toString() + "1")
//            }
//            else if(edt2.isFocused)
//            {
//                edt2.setText(edt2.text.toString() + "1")
//            }else{
//                Toast.makeText(this,"에디트 텍스틀 선택해주세요",Toast.LENGTH_SHORT).show();
//            }
//        }
//
//        btn_num2.setOnClickListener {
//
//            //포커스가 어디있는지 체크
//            if(edt1.isFocused)
//            {
//                edt1.setText(edt1.text.toString() + "2")
//            }
//            else if(edt2.isFocused)
//            {
//                edt2.setText(edt2.text.toString() + "2")
//            }else{
//                Toast.makeText(this,"에디트 텍스틀 선택해주세요",Toast.LENGTH_SHORT).show();
//            }
//        }
//
//        btn_num3.setOnClickListener {
//
//            //포커스가 어디있는지 체크
//            if(edt1.isFocused)
//            {
//                edt1.setText(edt1.text.toString() + "3")
//            }
//            else if(edt2.isFocused)
//            {
//                edt2.setText(edt2.text.toString() + "3")
//            }else{
//                Toast.makeText(this,"에디트 텍스틀 선택해주세요",Toast.LENGTH_SHORT).show();
//            }
//        }
//
//        btn_num4.setOnClickListener {
//
//            //포커스가 어디있는지 체크
//            if(edt1.isFocused)
//            {
//                edt1.setText(edt1.text.toString() + "4")
//            }
//            else if(edt2.isFocused)
//            {
//                edt2.setText(edt2.text.toString() + "4")
//            }else{
//                Toast.makeText(this,"에디트 텍스틀 선택해주세요",Toast.LENGTH_SHORT).show();
//            }
//        }
//
//        btn_num5.setOnClickListener {
//
//            //포커스가 어디있는지 체크
//            if(edt1.isFocused)
//            {
//                edt1.setText(edt1.text.toString() + "5")
//            }
//            else if(edt2.isFocused)
//            {
//                edt2.setText(edt2.text.toString() + "5")
//            }else{
//                Toast.makeText(this,"에디트 텍스틀 선택해주세요",Toast.LENGTH_SHORT).show();
//            }
//        }
//
//        btn_num6.setOnClickListener {
//
//            //포커스가 어디있는지 체크
//            if(edt1.isFocused)
//            {
//                edt1.setText(edt1.text.toString() + "6")
//            }
//            else if(edt2.isFocused)
//            {
//                edt2.setText(edt2.text.toString() + "6")
//            }else{
//                Toast.makeText(this,"에디트 텍스틀 선택해주세요",Toast.LENGTH_SHORT).show();
//            }
//        }
//
//        btn_num7.setOnClickListener {
//
//            //포커스가 어디있는지 체크
//            if(edt1.isFocused)
//            {
//                edt1.setText(edt1.text.toString() + "7")
//            }
//            else if(edt2.isFocused)
//            {
//                edt2.setText(edt2.text.toString() + "7")
//            }else{
//                Toast.makeText(this,"에디트 텍스틀 선택해주세요",Toast.LENGTH_SHORT).show();
//            }
//        }
//
//        btn_num8.setOnClickListener {
//
//            //포커스가 어디있는지 체크
//            if(edt1.isFocused)
//            {
//                edt1.setText(edt1.text.toString() + "8")
//            }
//            else if(edt2.isFocused)
//            {
//                edt2.setText(edt2.text.toString() + "8")
//            }else{
//                Toast.makeText(this,"에디트 텍스틀 선택해주세요",Toast.LENGTH_SHORT).show();
//            }
//        }
//
//        btn_num9.setOnClickListener {
//
//            //포커스가 어디있는지 체크
//            if(edt1.isFocused)
//            {
//                edt1.setText(edt1.text.toString() + "9")
//            }
//            else if(edt2.isFocused)
//            {
//                edt2.setText(edt2.text.toString() + "9")
//            }else{
//                Toast.makeText(this,"에디트 텍스틀 선택해주세요",Toast.LENGTH_SHORT).show();
//            }
//        }
        //2.xml객체를 가져와서, kotlin 객체에 연결(바인딩)
//        edt1 = findViewById<EditText>(R.id.Edit1);

        //3.이벤트 처리
//        btn1.setOnClickListener {
//            var n1 = edt1.text.toString()
//            var n2 = edt2.text.toString()
//
//            var n3 = n1.toInt() + n2.toInt()
//
//            tv1.text = "결과값: "+n3
//        }

        btn1.setOnTouchListener { view, motionEvent ->
            var n1 = edt1.text.toString()
            var n2 = edt2.text.toString()

//            if(n1.equals("") || n2.equals(""))
            if(n1 == "" || n2 == "")
            {
                Toast.makeText(this, "빈값입니다", Toast.LENGTH_SHORT).show()
            }
            else
            {
                var n3 = n1.toDouble()+ n2.toDouble()
                n3 = (n3*1000).toInt()/1000.0

                tv1.text = "결과값: "+n3
            }

//            return false
            false
        }

        btn2.setOnClickListener {
            var n1 = edt1.text.toString()
            var n2 = edt2.text.toString()

            var n3 = n1.toInt() - n2.toInt()

            tv1.text = "결과값: "+n3
        }
        btn3.setOnClickListener {
            var n1 = edt1.text.toString()
            var n2 = edt2.text.toString()

            var n3 = n1.toInt() * n2.toInt()

            tv1.text = "결과값: "+n3
        }

        btn4.setOnClickListener {
            var n1 = edt1.text.toString()
            var n2 = edt2.text.toString()

//            if(n1.equals("") || n2.equals(""))
            if(n1 == "" || n2 == "")
            {
                Toast.makeText(this, "빈값입니다", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(n2 == "0") {
                Toast.makeText(this, "0으로 나눌수 없어요!!!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var n3 = n1.toDouble() / n2.toDouble()
            n3 = (n3 * 1000).toInt() / 1000.0

            tv1.text = "결과값: " + n3

//            return false
            false
        }

        btn5.setOnClickListener {
            var n1 = edt1.text.toString()
            var n2 = edt2.text.toString()

            var n3 = n1.toInt() % n2.toInt()

            tv1.text = "결과값: "+n3
        }
//        btn2.setOnClickListener {
//            tv1.text = "결과값: "+ edt1.text.toString().toInt()
//                                + edt2.text.toString().toInt()
//        }
    }
}