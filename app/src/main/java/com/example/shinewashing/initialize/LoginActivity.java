package com.example.shinewashing.initialize;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shinewashing.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText edtMobileNo ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public static Intent getLoginActivityIntent(Context context){
        return new Intent(context , LoginActivity.class);
    }

    @Override
    protected void onStart() {
        super.onStart();

        edtMobileNo = findViewById(R.id.mobile_field);
        edtMobileNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() < 10){
                    edtMobileNo.setError("Mobile number must be 10 digit");
                }
                else {
                    edtMobileNo.setError(null);
                }
            }
        });

        Button btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(view -> {
            if(edtMobileNo.getText().length() == 10){
                startActivity(OtpVerifyActivity.getOtpVerifyActivityIntent(LoginActivity.this));
            }
        });
    }
}
