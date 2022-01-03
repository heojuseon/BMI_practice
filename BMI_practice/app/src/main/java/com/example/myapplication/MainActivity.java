package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtHeight = (EditText)findViewById(R.id.edtheight);
        EditText edtWeight = (EditText)findViewById(R.id.edtweight);
        Button button = (Button) findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {      //버튼 클릭시 2번째 메인 액티비티로 넘기기 위한 intent함수 사용
                String height = edtHeight.getText().toString(); //String객체로 Text를 리턴
                String weight = edtWeight.getText().toString();

                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

//                intent.putExtra("age", "20살 \n");    //putExtra: intent로 값 전달
//                intent.putExtra("weight", "70kg \n");
//                intent.putExtra("height", "180cm");

                intent.putExtra("height",Double.parseDouble(height));   //double형으로 형 변환하여 값 보냄
                intent.putExtra("weight",Double.parseDouble(weight));
//                intent.putExtra("height", height);
//                intent.putExtra("weight", weight);

                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //2번째 메인 액티비티에서 다시 메인 액티비티로 넘기기 위한 메소드
        super.onActivityResult(requestCode, resultCode, data);

        String username = data.getExtras().getString("username");

        Log.d("username", username);

    }
}