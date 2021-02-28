package com.example.solarsystemapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrPosition;

import org.w3c.dom.Text;


public class Earth extends _SwipeActivityClass {

    private ImageView mEarthView;
    private ImageView mMoonView;

    private boolean isOpen = false;
    private FrameLayout mFragmentContainer;
    private EarthFragment fragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //next three lines are for setting full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        mFragmentContainer = (FrameLayout) findViewById(R.id.fragment_container);

        mEarthView = (ImageView) findViewById(R.id.earth_button);
        Glide.with(this).asGif().load(R.drawable.earth_rotation2).into(mEarthView);//library to use the gif
        mEarthView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOpen) {
                    String earthString = getResources().getString(R.string.earth); //gets the string from the strings.xml
                    openFragment(earthString, R.string.earth);
                } else {
                    closeFragment();
                }
            }
        });

        mMoonView = (ImageView) findViewById(R.id.moon_button);
        Glide.with(this).asGif().load(R.drawable.small_moon_button).into(mMoonView);//library to use the gif
        mMoonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOpen) {
                    String moonString = getResources().getString(R.string.moon);
                    openFragment(moonString, R.string.moon);
                }else{
                    closeFragment();
                }
            }
        });

    }

    @Override
    protected void onSwipeRight() {
        openVenus();
    }

    @Override
    protected void onSwipeLeft() {
        openMars();
    }

    private void openFragment(String text, int ID) {
        isOpen = true;
        fragment = EarthFragment.newInstance(text);
        addText(ID, fragment);
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.earth_from_bottom, R.anim.earth_to_bottom);//in order to add a button or something than add both again
        transaction.addToBackStack(null);//in order to close only the fragment and not the whole activity
        transaction.add(R.id.fragment_container, fragment, "fragment_earth").commit();
    }

    private void closeFragment() {
        isOpen = false;
        transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.earth_to_bottom, R.anim.earth_from_bottom);
        transaction.remove(fragment).commit();
    }

    private void addText(int ID, EarthFragment fragment) {
        fragment.setmTextView(ID);
    }

    private void openMars() {
        Intent intent = new Intent(this, Mars.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    private void openVenus() {
        Intent intent = new Intent(this, Venus.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_right_out, R.anim.push_right_in);
    }

}