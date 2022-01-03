package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button2 = (Button)findViewById(R.id.btn2);

        TextView textView = (TextView)findViewById(R.id.result);

//        Log.d("weight", "70");
//        Log.d("height", "180");
//        Log.d("age", "20");

        Intent intent = getIntent();

//        String height = intent.getExtras().getString("height");
//        String weight = intent.getExtras().getString("weight");
        double height = intent.getDoubleExtra("height",0);  //double형으로 값 받음
        double weight = intent.getDoubleExtra("weight", 0);
        double Bmi = weight / ((height*0.01) * (height*0.01));  //Bmi계산식

//        String age = "";
//        String weight = "";
//        String high = "";
//
//        if (intent.getExtras().getString("age") != null){   //getExtras: 값 받을때
//            age = intent.getExtras().getString("age");
//        }
//        if (intent.getExtras().getString("weight") != null){
//            weight = intent.getExtras().getString("weight");
//        }
//        if (intent.getExtras().getString("height") != null){
//            high = intent.getExtras().getString("height");
//        }
//        textView.setText(height + "\n" + weight);       // 이부분에서 Bmi식 값을 추가하면 애러 발생

        textView.setText(String.valueOf(Bmi));  // Bmi값은 double형이여서 형변환 해주어야 함

        Log.d("height", String.valueOf(height)); //Log값 출력(확인하기 위함)
        Log.d("weight" , String.valueOf(weight));

        button2.setOnClickListener(new View.OnClickListener() {    //2번째 메인 액티비티에서 다시 메인 액티비티로 넘기기 위한 메소드

            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                intent.putExtra("username", "hjs");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}