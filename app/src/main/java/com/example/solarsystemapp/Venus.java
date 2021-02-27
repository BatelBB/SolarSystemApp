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

public class Venus extends _SwipeActivityClass {

    ImageView mVenusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_venus);

        mVenusView = (ImageView) findViewById(R.id.venus_button);
        Glide.with(this).asGif().load(R.drawable.venus2).into(mVenusView);//library to use the gif
        mVenusView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: add description
            }
        });

    }

    @Override
    protected void onSwipeRight() {
        openMercury();
    }

    @Override
    protected void onSwipeLeft() {
        openEarth();
    }

    public void openMercury(){
        Intent intent = new Intent(this, Mercury.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_right_out,R.anim.push_right_in);
    }

    public void openEarth(){
        Intent intent = new Intent(this, Earth.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }
}