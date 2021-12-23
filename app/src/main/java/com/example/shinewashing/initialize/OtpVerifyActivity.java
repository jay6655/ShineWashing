package com.example.shinewashing.initialize;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class OtpVerifyActivity extends AppCompatActivity {

    public static Intent getOtpVerifyActivityIntent(Context context){
        return new Intent(context , OtpVerifyActivity.class);
    }

}
