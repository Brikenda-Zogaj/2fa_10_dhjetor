package com.example.a2fa_10_dhjetor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class VerificationActivity extends AppCompatActivity {
    private EditText otpField;
    private Button confirmButton, requestNewOtpButton;
    private String userEmail;
    private String generatedOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        otpField = findViewById(R.id.otpInput);
        confirmButton = findViewById(R.id.confirmOtpButton);
        requestNewOtpButton = findViewById(R.id.resendOtpButton);

        userEmail = getIntent().getStringExtra("email_address");
        generatedOtp = generateOtp();

        MailUtil.dispatchEmail(userEmail, "Your OTP Code", "Your one-time code is: " + generatedOtp);

        confirmButton.setOnClickListener(v -> {
            String enteredOtp = otpField.getText().toString().trim();
            if (validateOtp(enteredOtp)) {
                Toast.makeText(this, "Verification Successful!", Toast.LENGTH_SHORT).show();
                proceedToMainScreen();
            } else {
                Toast.makeText(this, "Invalid Code. Please try again.", Toast.LENGTH_SHORT).show();
            }
        });

        requestNewOtpButton.setOnClickListener(v -> {
            generatedOtp = generateOtp();
            MailUtil.dispatchEmail(userEmail, "Your New OTP Code", "Your new one-time code is: " + generatedOtp);
            Toast.makeText(this, "A new OTP has been sent to your email.", Toast.LENGTH_SHORT).show();
        });
    }

    private String generateOtp() {
        int otp = (int) (Math.random() * 900000) + 100000;
        return String.valueOf(otp);
    }

    private boolean validateOtp(String otp) {
        return otp.equals(generatedOtp);
    }

    private void proceedToMainScreen() {
        Intent mainScreenIntent = new Intent(this, MainActivity.class);
        startActivity(mainScreenIntent);
    }
}
