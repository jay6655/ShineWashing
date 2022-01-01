package com.example.shinewashing.templete;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesApplication {

    private static SharedPreferencesApplication sharedPreferencesApplication;
    public static final String PREFERENCES = "MyPreference";
    private SharedPreferences sharedPreferences;

    public static SharedPreferencesApplication getInstance() {
        if (sharedPreferencesApplication == null) {
            sharedPreferencesApplication = new SharedPreferencesApplication();
        }
        return sharedPreferencesApplication;
    }

    public void setOtpVerified(Context context, boolean set) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(PREFERENCES, MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("OTP_VERIFIED", set);
        editor.apply();
    }

    public boolean getOtpVerified(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(PREFERENCES, MODE_PRIVATE);
        }
        if (sharedPreferences.contains("OTP_VERIFIED")) {
            return sharedPreferences.getBoolean("OTP_VERIFIED", false);
        }
        return false;
    }
}