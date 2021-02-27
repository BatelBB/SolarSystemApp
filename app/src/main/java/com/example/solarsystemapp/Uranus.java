package com.example.solarsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrPosition;

public class Uranus extends _SwipeActivityClass {

    ImageView mUranusView;
    ImageView mTitaniaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_uranus);

        mUranusView = (ImageView) findViewById(R.id.uranus_button);
        Glide.with(this).asGif().load(R.drawable.uranus2).into(mUranusView);//library to use the gif
        mUranusView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: add description
            }
        });
        mTitaniaView = (ImageView) findViewById(R.id.titania_button);
        Glide.with(this).asGif().load(R.drawable.titania).into(mTitaniaView);//library to use the gif
        mTitaniaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: add description
            }
        });

    }

    @Override
    protected void onSwipeRight() {
        openSaturn();
    }

    @Override
    protected void onSwipeLeft() {
        openNeptune();
    }

    public void openSaturn(){
        Intent intent = new Intent(this, Saturn.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_right_out,R.anim.push_right_in);
    }

    public void openNeptune(){
        Intent intent = new Intent(this, Neptune.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }
}