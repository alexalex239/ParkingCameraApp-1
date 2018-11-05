package com.example.sketc.protoype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button logInButton;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ties logIn variable to XML button ID
        logInButton = findViewById(R.id.SignInButton);
        //Calls function :openGarageListActivity whenever the button is clicked
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGarageListActivity();
            }
        });

        //Connects registerButton variable to XML button ID
        signUpButton = findViewById(R.id.SignUpButton);
        //Calls function :openRegisterActivity whenever button is clicked
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterActivity();
            }
        });

    }
    //Function that opens Garage List Activity
    public void openGarageListActivity() {
        Intent intentGarageList = new Intent(this, GarageListActivity.class);
        startActivity(intentGarageList);
    }

    //Function that opens Register Activity
    public void openRegisterActivity(){
        Intent intentRegister = new Intent(this,RegisterActivity.class);
        startActivity(intentRegister);
        }
    }

