package com.example.a2fa_10_dhjetor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button signOutButton;

    @Override
    protected void onCreate(Bundle setInstanceState){
        super.onCreate(setInstanceState);
        setContentView(R.layout.activity_main);

        signOutButton=findViewById(R.id.signOutButton);

        signOutButton.setOnClickListener(v -> {

            Intent sintent=new Intent( this, SignActivity.class);
            sintent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
            startActivity(sintent);
            finish();

        });
    }

}
