package com.example.a2fa_10_dhjetor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText inputEmail, inputPassword;
    private Button loginButton;

    @Override
    protected  void onCreate(Bundle setInstanceState){
        super.onCreate(setInstanceState);
        setContentView(R.layout.login);

        inputEmail=findViewById(R.id.inputEmail);
        inputPassword=findViewById(R.id.inputPassword);
        loginButton=findViewById(R.id.buttonSignIn);

        loginButton.setOnClickListener(v -> {
            String email=inputEmail.getText().toString();
            String password=inputPassword.getText().toString();
            if(ValidateCredent(email , password)){
                Toast.makeText(this , "U logua" ,Toast.LENGTH_SHORT).show();
                navigateToMain();
            }
        });
    }
    public boolean ValidateCredent(String email, String password){
        return email.equals("gmail@gmail.com") && password.equals("hello123");
    }
    public void navigateToMain(){
        Intent intent= new Intent(this , MainActivity.class);
        startActivity(intent);
        finish();
    }
}
