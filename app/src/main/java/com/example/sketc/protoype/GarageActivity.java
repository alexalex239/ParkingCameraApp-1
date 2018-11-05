package com.example.sketc.protoype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GarageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage);

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        //If statement checks to see if the intent actually has an extra
        if (getIntent().hasExtra("garageImage") && getIntent().hasExtra("garageName") && getIntent().hasExtra("garageCounter")) {


            String garageImage = getIntent().getStringExtra("garageImage");
            String garageName = getIntent().getStringExtra("garageName");
            String garageCounter = getIntent().getStringExtra("garageCounter");


            setActivity(garageImage,garageName,garageCounter);
        }
    }
    //Uses the incoming Intent and sets the newly created variable to the widgets in the activity
    private void setActivity(String garageImage, String garageName, String garageCounter) {

        TextView GarageName = findViewById(R.id.garage_Name);
        GarageName.setText(garageName);

        TextView GarageCounter = findViewById(R.id.garage_Counter);
        GarageCounter.setText(garageCounter);

        ImageView GarageImage = findViewById(R.id.garage_Image);
        Glide.with(this).asBitmap().load(garageImage).into(GarageImage);


    }
}
