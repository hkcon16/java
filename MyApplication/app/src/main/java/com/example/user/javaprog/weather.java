package com.example.user.javaprog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class weather extends AppCompatActivity {
    Intent intent;
    ArrayList<String> get;
    String emotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        Button sunny = (Button)findViewById(R.id.sunny);
        Button cloudy = (Button)findViewById(R.id.cloudy);
        Button rainy = (Button)findViewById(R.id.rainy);


        get = new ArrayList<>();
        intent = getIntent();

        get = intent.getStringArrayListExtra("send");// 값 받아오기
        emotion = get.get(0);

        Log.d("first get","현재 기분 : " + emotion);

        sunny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , gps.class);

                ArrayList send = new ArrayList();
                send.add("sunny");
                send.add(emotion);
                intent.putExtra("send",send);
                startActivity(intent);
            }
        });
        cloudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , gps.class);
                ArrayList send = new ArrayList();
                send.add("cloudy");
                send.add(emotion);
                intent.putExtra("send",send);
                startActivity(intent);
            }
        });
        rainy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , gps.class);
                ArrayList send = new ArrayList();
                send.add("rainy");
                send.add(emotion);
                intent.putExtra("send",send);
                startActivity(intent);
            }
        });
    }
}
