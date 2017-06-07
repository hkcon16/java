package com.example.user.javaprog;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class gps extends AppCompatActivity {
    Intent intent;
    ArrayList<String> get;
    String emotion , weather;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);


        intent = getIntent();
        get = new ArrayList();

        get = intent.getStringArrayListExtra("send");
        weather =  get.get(0);
        emotion =  get.get(1);

        Log.d("second get","현재 감정 : " + emotion + "\n현재 날씨 : " + weather);


        textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLocationService();
            }
        });
    }

    public void startLocationService() {
        long minTime = 10000; //10초가지난다음에 위치가 갱신되었는지 확인
        float minDistance = 0; //원래있던 위치에서 0m 떨어질경우 위치정보 업데이트

        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        manager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                minTime,
                minDistance,
                new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        Double latitude = location.getLatitude(); //경도
                        Double longitude = location.getLongitude(); //위도

                        textView.setText("위도 : " + latitude + "\n경도 : "+longitude);


                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {

                    }

                    @Override
                    public void onProviderEnabled(String provider) {

                    }

                    @Override
                    public void onProviderDisabled(String provider) {

                    }
                }
        );
    }
}
