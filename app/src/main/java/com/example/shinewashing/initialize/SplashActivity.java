package com.example.shinewashing.initialize;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shinewashing.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onStart() {
        super.onStart();

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            startActivity(LoginActivity.getLoginActivityIntent(SplashActivity.this));
            finish();
        }, 5000);
    }
}
