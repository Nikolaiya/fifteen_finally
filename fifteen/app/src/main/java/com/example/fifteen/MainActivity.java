package com.example.fifteen;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static final int REQUEST_CODE = 1;

    private Button buttonStartGame;
    private TextView textLastStep;
    private TextView textBestStep;
    private TextView textLastTime;
    private TextView textBestTime;
    private MyBase myBase;
    private Button buttonSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStartGame = findViewById(R.id.button_start_game);
        textLastStep = findViewById(R.id.text_last_step);
        textBestStep = findViewById(R.id.text_best_step);
        textLastTime = findViewById(R.id.text_last_time);
        textBestTime = findViewById(R.id.text_best_time);
        buttonSet = findViewById(R.id.button_settings);
        myBase = new MyBase(this);


        if (myBase.getMode()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        loadData();

        buttonStartGame.setOnClickListener((view) -> {
            startActivityForResult(new Intent(MainActivity.this, Game.class), REQUEST_CODE);
        });

        buttonSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, Settings_activity.class), REQUEST_CODE);
            }
        });

    }




    private void loadData(){
        textLastStep.setText(String.valueOf(myBase.getLastStep()));
        textBestStep.setText(String.valueOf(myBase.getBestStep()));

        int lastTime = myBase.getLastTime();
        int lastSecond = lastTime %60;
        int lastHour = lastTime/3600;
        int lastMinute = (lastTime-lastHour*3600) / 60;
        textLastTime.setText(String.format("%02d:%02d:%02d", lastHour, lastMinute, lastSecond));

        int bestTime = myBase.getBestTime();
        int bestSecond = bestTime %60;
        int bestHour = bestTime/3600;
        int bestMinute = (bestTime-bestHour*3600) / 60;
        textBestTime.setText(String.format("%02d:%02d:%02d", bestHour, bestMinute, bestSecond));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE){
            textLastStep.setText(String.valueOf(myBase.getLastStep()));
            textBestStep.setText(String.valueOf(myBase.getBestStep()));

            int lastTime = myBase.getLastTime();
            int lastSecond = lastTime %60;
            int lastHour = lastTime/3600;
            int lastMinute = (lastTime-lastHour*3600) / 60;
            textLastTime.setText(String.format("%02d:%02d:%02d", lastHour, lastMinute, lastSecond));

            int bestTime = myBase.getBestTime();
            int bestSecond = bestTime %60;
            int bestHour = bestTime/3600;
            int bestMinute = (bestTime-bestHour*3600) / 60;
            textBestTime.setText(String.format("%02d:%02d:%02d", bestHour, bestMinute, bestSecond));

            if (myBase.getMode()){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
    }
}

}

