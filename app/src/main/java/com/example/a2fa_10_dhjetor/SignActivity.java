package com.example.a2fa_10_dhjetor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignActivity extends AppCompatActivity {

    private EditText emailInput, passwordInput, nameInput, usernameInput;
    private Button signInButton, loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        emailInput = findViewById(R.id.inputEmail);
        passwordInput = findViewById(R.id.inputPassword);
        nameInput = findViewById(R.id.inputName);
        usernameInput = findViewById(R.id.inputUsername);
        signInButton = findViewById(R.id.buttonSignIn);
        loginButton = findViewById(R.id.buttonLogin);


        signInButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();
            String name = nameInput.getText().toString().trim();
            String username = usernameInput.getText().toString().trim();

            if (authenticateUser(email, password)) {
                Toast.makeText(this, "Access granted!", Toast.LENGTH_SHORT).show();
                redirectToVerification(email, name, username);
            } else {
                Toast.makeText(this, "Invalid email or password!", Toast.LENGTH_SHORT).show();
            }
        });


        loginButton.setOnClickListener(v -> {

            Intent loginIntent = new Intent(SignActivity.this, LoginActivity.class);
            loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(loginIntent);
            finish();
        });
    }


    private boolean authenticateUser(String email, String password) {
        return email.equals("email@gmail.com") && password.equals("hello123");
    }


    private void redirectToVerification(String userEmail, String userName, String userUsername) {
        Intent verifyIntent = new Intent(this, VerificationActivity.class);
        verifyIntent.putExtra("email_address", userEmail);
        verifyIntent.putExtra("name", userName);
        verifyIntent.putExtra("username", userUsername);
        startActivity(verifyIntent);
    }
}
