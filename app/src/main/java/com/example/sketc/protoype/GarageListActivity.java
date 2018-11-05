package com.example.sketc.protoype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class GarageListActivity extends AppCompatActivity {


    //Variables
    private ArrayList<String> mImageURLS = new ArrayList<>();
    private ArrayList<String> mGarageName = new ArrayList<>();
    private ArrayList<String> mGarageCounter = new ArrayList<>();
    //private int [] mprogressBar = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_list);
        initGarageItems();
    }
    private void initGarageItems() {
        //Garage 1
        mImageURLS.add("https://www.servicecontracting.com/wp-content/uploads/2013/05/FGCU-Parking-Structure.jpg");
        mGarageName.add("Garage 1");
        mGarageCounter.add("350 / 1000");

        //Garage 2
        mImageURLS.add("http://ociassociates.com/wp-content/uploads/2017/08/FGCU-Parking-Garage-4-stairs_800x600.jpg");
        mGarageName.add("Garage 2");
        mGarageCounter.add("850 / 1000");

        //Garage 3
        mImageURLS.add("http://eaglenews.org/wp-content/uploads/2016/12/Parking-Garage.png");
        mGarageName.add("Garage 3");
        mGarageCounter.add("1000 / 1000");

        //Garage 4
        mImageURLS.add("http://ociassociates.com/wp-content/uploads/2017/08/FGCU-Parking-Garage-4-Aerial_800x600-800x600.jpg");
        mGarageName.add("Garage 4");
        mGarageCounter.add("133 / 1000");

        //Dirt Parking Garage
        mImageURLS.add("");
        mGarageName.add("Dirt Parking Garage");
        mGarageCounter.add("135 / 250");

        initializeRecycleView();
    }

    private void initializeRecycleView() {
        RecyclerView recyclerView = findViewById(R.id.recylerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mImageURLS, mGarageName,
                mGarageCounter);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
