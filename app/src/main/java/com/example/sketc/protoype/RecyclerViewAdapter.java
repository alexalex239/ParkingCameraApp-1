package com.example.sketc.protoype;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private ArrayList<String> mgarageImage = new ArrayList<>();
    private ArrayList<String> mgarageName = new ArrayList<>();
    private ArrayList<String> mgarageCounter = new ArrayList<>();
    //private int[] mprogressBar;

    private Context mContext;


    //Constructor that adds image , name of garage, progress bar, and counter
    public RecyclerViewAdapter(Context Context,
                               ArrayList<String> garageImage,
                               ArrayList<String> garageName,
                               ArrayList<String> garageCounter) {

        mgarageImage = garageImage;
        mgarageName = garageName;
        mgarageCounter = garageCounter;
        //mprogressBar = progressBar;
        mContext = Context;
    }

    //Puts the view holders into position (A standard needed for every RecyclerView)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,
                parent, false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    // Will change things based on layout and what we want the items to look like
    // Sets up what variables that will go into the XML I'Ds
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        //Sets up images acquired from the internet using URLS
        Glide.with(mContext).asBitmap().load(mgarageImage.get(position)).into(holder.garageImage);

        holder.garageName.setText(mgarageName.get(position));
        holder.garageCounter.setText(mgarageCounter.get(position));

        // !!!Need to set up progress bar
        //holder.progressBar.setProgress(mprogressBar);

        //Everytime an item in the recycler view is clicked, it opens the activity related to it
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mgarageName.get(position), Toast.LENGTH_SHORT).show();
                Intent intentToGarage = new Intent(mContext, GarageActivity.class);
                intentToGarage.putExtra("garageImage", mgarageImage.get(position));
                intentToGarage.putExtra("garageName", mgarageName.get(position));
                intentToGarage.putExtra("garageCounter", mgarageCounter.get(position));
                mContext.startActivity(intentToGarage);
            }
        });

    }

    // Sets how many items will be in your recycle view
    @Override
    public int getItemCount() {
        return mgarageName.size();
    }


    //----------------------------------------------------------------------------------------------
    //Class holds each individual recylerview item in memory
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView garageImage;
        TextView garageName;
        TextView garageCounter;
        RelativeLayout parentLayout;
        //ProgressBar progressBar;

        //Connects XML ID's with variables
        public ViewHolder(View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.parentLayout);
            garageImage = itemView.findViewById(R.id.garageImage);
            garageName = itemView.findViewById(R.id.garageName);
            garageCounter = itemView.findViewById(R.id.garageCounter);
            //progressBar = itemView.findViewById(R.id.progressbar);

        }
    }
}
