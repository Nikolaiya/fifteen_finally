package com.example.fifteen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Settings_activity extends AppCompatActivity {

    private Switch switchDayNight;
    private MyBase myBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        myBase = new MyBase(this);

    switchDayNight = findViewById(R.id.switch_day_night);

    switchDayNight.setChecked(myBase.getMode());

    switchDayNight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            myBase.saveMode(b);
            switchDayNight.setChecked(b);

            if (myBase.getMode()){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(MainActivity.REQUEST_CODE);
    }


    }
