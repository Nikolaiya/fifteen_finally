package com.example.fifteen;

import android.content.Context;
import android.content.SharedPreferences;

public class MyBase {

    private static  final String SHARED_PREF = "sharedPred";
    private static  final String LAST_STEP = "lastStep";
    private static  final String LAST_TIME = "lastTime";
    private static  final String BEST_STEP = "bestStep";
    private static  final String BEST_TIME = "bestTime";
    private static  final String IS_NIGHT_MODE = "isNight";
    private static  final String IS_MUSIC = "isMusic";


    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public MyBase(Context context){
        preferences = context.getSharedPreferences(SHARED_PREF,Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void saveLastStep(int steps){
        editor.putInt(LAST_STEP,steps).commit();
    }

    public int getLastStep(){
        return preferences.getInt(LAST_STEP, 0 );
    }

    public void saveLastTime(int seconds){
        editor.putInt(LAST_TIME,seconds).commit();
    }

    public int getLastTime(){
        return preferences.getInt(LAST_TIME, 0 );
    }

    public void saveBestTime(int seconds){
        editor.putInt(BEST_TIME, seconds).commit();
    }

    public int getBestTime(){
        return preferences.getInt(BEST_TIME, 0 );
    }

    public void saveBestStep(int steps){
        editor.putInt(BEST_STEP,steps).commit();
    }

    public int getBestStep(){
        return preferences.getInt(BEST_STEP, 0 );
    }


    public void saveMode(boolean mode){
        editor.putBoolean(IS_NIGHT_MODE, mode).commit();
    }

    public boolean getMode(){
        return preferences.getBoolean(IS_NIGHT_MODE, false );
    }

    public boolean saveMusic(boolean music){
        editor.putBoolean(IS_MUSIC,  music).commit();
        return music;
    }

    public boolean getMusic(){
        return preferences.getBoolean(IS_MUSIC, false );
    }




}
