package com.allam.revampgopets.utils;

import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreferenceStorage {
    private static SharedPreferenceStorage sharedPreferenceStorage;
    SharedPreferences sharedPreferences;

    private SharedPreferenceStorage() {
        sharedPreferences = App.getContext().getSharedPreferences(GlobalValues.SHARED_FILE_NAME, MODE_PRIVATE);
    }

    public static SharedPreferenceStorage getInstance() {
        if (sharedPreferenceStorage == null) {
            sharedPreferenceStorage = new SharedPreferenceStorage();
        }
        return sharedPreferenceStorage;
    }

    public void putString(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, null);
    }

    public String getString(String key, String defValue) {
        return sharedPreferences.getString(key, defValue);
    }

    public void putInt(String key, int value) {
        sharedPreferences.edit().putInt(key, value).apply();
    }

    public int getInt(String key, int defValue) {
        return sharedPreferences.getInt(key, defValue);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return sharedPreferences.getBoolean(key, defValue);
    }

    public void putBoolean(String key, boolean value) {
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

//    public void clear(){
//        sharedPreferences.edit().clear().apply();
//        NavigatorHelper.navigateActivityClear(App.getContext(), SplashActivity.class,null);
//    }
}
