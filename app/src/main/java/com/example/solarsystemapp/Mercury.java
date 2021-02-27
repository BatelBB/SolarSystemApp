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

public class Mercury extends _SwipeActivityClass {

    ImageView mMercuryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mercury);

        mMercuryView = (ImageView) findViewById(R.id.mercury_button);
        Glide.with(this).asGif().load(R.drawable.mercury2).into(mMercuryView);//library to use the gif
        mMercuryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: add description
            }
        });

    }

    @Override
    protected void onSwipeRight() {
        openSun();
    }

    @Override
    protected void onSwipeLeft() {
        openVenus();
    }

    public void openSun(){
        Intent intent = new Intent(this, Sun.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_right_out,R.anim.push_right_in);
    }
    public void openVenus(){
        Intent intent = new Intent(this, Venus.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }
}