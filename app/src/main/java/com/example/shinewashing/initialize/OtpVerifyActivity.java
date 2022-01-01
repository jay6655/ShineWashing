package com.example.shinewashing.initialize;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shinewashing.AddVehicleActivity;
import com.example.shinewashing.R;
import com.example.shinewashing.templete.SharedPreferencesApplication;

public class OtpVerifyActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText otp1ET, otp2ET, otp3ET, otp4ET;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verify);
        Button validateButton = findViewById(R.id.validate_button);
        validateButton.setOnClickListener(this);
    }

    public static Intent getOtpVerifyActivityIntent(Context context) {
        return new Intent(context, OtpVerifyActivity.class);
    }

    @Override
    protected void onStart() {
        super.onStart();

        String mobile_no = getString(R.string.verification_code_subtext);
        mobile_no = mobile_no.replace("###", getIntent().getStringExtra("mobile_no"));
        TextView validationStr = findViewById(R.id.validationStr);
        validationStr.setText(mobile_no);

        otp1ET = findViewById(R.id.otp_1);
        otp2ET = findViewById(R.id.otp_2);
        otp3ET = findViewById(R.id.otp_3);
        otp4ET = findViewById(R.id.otp_4);

        otp1ET.addTextChangedListener(new GenericTextWatcher(otp1ET));
        otp2ET.addTextChangedListener(new GenericTextWatcher(otp2ET));
        otp3ET.addTextChangedListener(new GenericTextWatcher(otp3ET));
        otp4ET.addTextChangedListener(new GenericTextWatcher(otp4ET));

        otp2ET.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                if (otp2ET.getText().toString().equals("")) {
                    otp1ET.requestFocus();
                }
            }
            return false;
        });

        otp3ET.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                if (otp3ET.getText().toString().equals("")) {
                    otp2ET.requestFocus();
                }
            }
            return false;
        });

        otp4ET.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                if (otp4ET.getText().toString().equals("")) {
                    otp3ET.requestFocus();
                }
            }
            return false;
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.validate_button) {
            if (getOtp().equals("1234")) {
                SharedPreferencesApplication.getInstance().setOtpVerified(OtpVerifyActivity.this, true);
                startActivity(AddVehicleActivity.getAddVehicleActivityIntent(OtpVerifyActivity.this));
                finish();
            }
        }
    }

    public String getOtp() {
        return otp1ET.getText().toString() +
                otp2ET.getText().toString() +
                otp3ET.getText().toString() +
                otp4ET.getText().toString();
    }

    public class GenericTextWatcher implements TextWatcher {

        private final View view;

        private GenericTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            String text = s.toString();
            int i = view.getId();
            if (i == R.id.otp_1) {
                if (text.length() == 1) {
                    otp2ET.requestFocus();
                }
            } else if (i == R.id.otp_2) {
                if (text.length() == 1) {
                    otp3ET.requestFocus();
                }
            } else if (i == R.id.otp_3) {
                if (text.length() == 1) {
                    otp4ET.requestFocus();
                }
            } else if (i == R.id.otp_4) {
            }
        }
    }
}