package com.example.solarsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Pluto extends _SwipeActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pluto);
    }

    @Override
    protected void onSwipeRight() {
        openNeptune();
    }

    @Override
    protected void onSwipeLeft() {
        openSun();
    }

    public void openNeptune(){
        Intent intent = new Intent(this, Neptune.class);
        startActivity(intent);
    }
    public void openSun(){
        Intent intent = new Intent(this, Sun.class);
        startActivity(intent);
    }
}