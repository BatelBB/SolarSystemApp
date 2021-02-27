package com.example.solarsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Uranus extends _SwipeActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uranus);
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
    }

    public void openNeptune(){
        Intent intent = new Intent(this, Neptune.class);
        startActivity(intent);
    }
}