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

public class Neptune extends _SwipeActivityClass {

    ImageView mNeptuneView;
    ImageView mTritanView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_neptune);

        mNeptuneView = (ImageView) findViewById(R.id.neptune_button);
        Glide.with(this).asGif().load(R.drawable.neptune2).into(mNeptuneView);//library to use the gif
        mNeptuneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:add description
            }
        });

        mTritanView = (ImageView) findViewById(R.id.tritan_button);
        Glide.with(this).asGif().load(R.drawable.tritan).into(mTritanView);//library to use the gif
        mTritanView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: add description
            }
        });

    }

    @Override
    protected void onSwipeRight() {
        openUranus();
    }

    @Override
    protected void onSwipeLeft() {
        openPluto();
    }

    public void openUranus(){
        Intent intent = new Intent(this, Uranus.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_right_out,R.anim.push_right_in);
    }
    public void openPluto(){
        Intent intent = new Intent(this, Pluto.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }
}