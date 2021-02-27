package com.example.solarsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Jupiter extends _SwipeActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jupiter);
    }

    @Override
    protected void onSwipeRight() {
        openMars();
    }

    @Override
    protected void onSwipeLeft() {
        openSaturn();
    }

    public void openMars(){
        Intent intent = new Intent(this, Mars.class);
        startActivity(intent);
    }

    public void openSaturn(){
        Intent intent = new Intent(this, Saturn.class);
        startActivity(intent);
    }
}