package com.example.shinewashing.initialize;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shinewashing.AddVehicleActivity;
import com.example.shinewashing.R;
import com.example.shinewashing.templete.SharedPreferencesApplication;

public class SplashActivity extends AppCompatActivity {

    private final SharedPreferencesApplication sh = SharedPreferencesApplication.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onStart() {
        super.onStart();

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (sh.getOtpVerified(SplashActivity.this)) {
                startActivity(AddVehicleActivity.getAddVehicleActivityIntent(SplashActivity.this));
            } else {
                startActivity(LoginActivity.getLoginActivityIntent(SplashActivity.this));
            }
            finish();
        }, 1000);
    }
}
