package com.example.solarsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Venus extends _SwipeActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venus);
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
    }

    public void openEarth(){
        Intent intent = new Intent(this, Earth.class);
        startActivity(intent);
    }
}