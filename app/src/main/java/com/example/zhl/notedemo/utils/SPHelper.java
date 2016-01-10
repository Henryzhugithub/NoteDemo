package com.example.zhl.notedemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by zhl on 2016/1/7.
 */
public class SPHelper {

    public static SharedPreferences config;

    public static boolean getNightMode(Context context){
        config = context.getSharedPreferences("config",Context.MODE_PRIVATE);
        return config.getBoolean("isNightMode",false);
    }

    public static void putNightMode(boolean isNightMode){
        SharedPreferences.Editor editor = config.edit();
        editor.putBoolean("isNightMode",isNightMode);
        editor.commit();
    }
}
