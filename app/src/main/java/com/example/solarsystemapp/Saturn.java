package com.example.solarsystemapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Saturn extends _SwipeActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saturn);
    }

    @Override
    protected void onSwipeRight() {
        openJupiter();
    }

    @Override
    protected void onSwipeLeft() {
        openUranus();
    }

    public void openJupiter(){
        Intent intent = new Intent(this, Jupiter.class);
        startActivity(intent);
    }

    public void openUranus(){
        Intent intent = new Intent(this, Uranus.class);
        startActivity(intent);
    }
}