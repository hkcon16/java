package com.example.user.javaprog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button happy = (Button)findViewById(R.id.happy);
        Button excite = (Button)findViewById(R.id.excite);
        Button sad = (Button)findViewById(R.id.sad);

        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , weather.class);

                ArrayList<String> send = new ArrayList<>();
                send.add("happy");
                intent.putExtra("send",send);
                startActivity(intent);
            }
        });

        excite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , weather.class);

                ArrayList<String> send = new ArrayList<>();
                send.add("excite");
                intent.putExtra("send",send);
                startActivity(intent);
            }
        });

        sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , weather.class);

                ArrayList<String> send = new ArrayList<>();
                send.add("sad");
                intent.putExtra("send",send);
                startActivity(intent);
            }
        });
    }


}
