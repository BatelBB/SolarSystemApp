package com.example.solarsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.r0adkll.slidr.Slidr;

public class Mars extends _SwipeActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mars);

        Slidr.attach(this);
    }

    @Override
    protected void onSwipeRight() {
        openEarth();
    }

    @Override
    protected void onSwipeLeft() {
        openJupiter();
    }
    public void openEarth(){
        Intent intent = new Intent(this, Earth.class);
        startActivity(intent);
    }
    public void openJupiter(){
        Intent intent = new Intent(this, Jupiter.class);
        startActivity(intent);
    }
}