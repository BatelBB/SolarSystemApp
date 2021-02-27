package com.example.solarsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Neptune extends _SwipeActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neptune);
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
    }
    public void openPluto(){
        Intent intent = new Intent(this, Pluto.class);
        startActivity(intent);
    }
}