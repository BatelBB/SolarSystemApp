package com.example.solarsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Mercury extends _SwipeActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercury);
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
    }
    public void openVenus(){
        Intent intent = new Intent(this, Venus.class);
        startActivity(intent);
    }
}