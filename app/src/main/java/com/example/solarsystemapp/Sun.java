package com.example.solarsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Sun extends _SwipeActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sun);
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
    }

    public void openMercury(){
        Intent intent = new Intent(this, Mercury.class);
        startActivity(intent);
    }
}