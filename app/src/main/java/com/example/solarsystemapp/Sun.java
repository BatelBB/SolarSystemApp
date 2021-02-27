package com.example.solarsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrPosition;

public class Sun extends _SwipeActivityClass {

    ImageView mSunGif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sun);


        mSunGif = (ImageView) findViewById(R.id.sun_button);
        Glide.with(this).asGif().load(R.drawable.sun2).into(mSunGif);//library to use the gif
        mSunGif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: add description
            }
        });

    }

    @Override
    protected void onSwipeRight() {
        openPluto();
    }

    @Override
    protected void onSwipeLeft() {
        openMercury();
    }

    public void openPluto(){
        Intent intent = new Intent(this, Pluto.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_right_out,R.anim.push_right_in);
    }

    public void openMercury(){
        Intent intent = new Intent(this, Mercury.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }
}