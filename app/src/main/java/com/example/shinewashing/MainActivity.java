package com.example.shinewashing;
//Jay chamuda Maa
//Date : 19/12/2021
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public static Intent getMainActivityIntent(Context context){
        return new Intent(context , MainActivity.class);
    }
}