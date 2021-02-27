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

public class Saturn extends _SwipeActivityClass {

    ImageView mSaturnView;
    ImageView mTitanView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_saturn);

        mSaturnView = (ImageView) findViewById(R.id.saturn_button);
        Glide.with(this).asGif().load(R.drawable.ssaturn2).into(mSaturnView);//library to use the gif
        mSaturnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: add description
            }
        });
        mTitanView = (ImageView) findViewById(R.id.titan_button);
        Glide.with(this).asGif().load(R.drawable.titan).into(mTitanView);//library to use the gif
        mTitanView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: add description
            }
        });


    }

    @Override
    protected void onSwipeRight() {
        openJupiter();
    }

    @Override
    protected void onSwipeLeft() {
        openUranus();
    }

    public void openJupiter(){
        Intent intent = new Intent(this, Jupiter.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_right_out,R.anim.push_right_in);
    }

    public void openUranus(){
        Intent intent = new Intent(this, Uranus.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }
}