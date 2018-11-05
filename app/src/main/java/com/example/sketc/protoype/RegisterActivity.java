package com.example.sketc.protoype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    private Button createAccountButton;
    private Button alreadyHaveAccountButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        createAccountButton = findViewById(R.id.CreateAccountButton);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        alreadyHaveAccountButton = findViewById(R.id.AlreadyHaveAccountButton);
        alreadyHaveAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

    }

    public void openMainActivity(){
        Intent intentToMainActivity = new Intent(this, MainActivity.class);
        startActivity(intentToMainActivity);
    }
}
