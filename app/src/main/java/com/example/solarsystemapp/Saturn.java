package com.example.solarsystemapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrPosition;

public class Saturn extends _SwipeActivityClass {

    private ImageView mSaturnView;
    private ImageView mTitanView;

    private boolean isOpen = false;
    private FrameLayout mFragmentContainer;
    private SaturnFragment fragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_saturn);

        mFragmentContainer = (FrameLayout) findViewById(R.id.saturn_fragment_container);

        mSaturnView = (ImageView) findViewById(R.id.saturn_button);
        Glide.with(this).asGif().load(R.drawable.ssaturn3).into(mSaturnView);//library to use the gif
        mSaturnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOpen) {
                    String saturnString = getResources().getString(R.string.saturn);
                    openFragment(saturnString, R.string.saturn);
                }else{
                    closeFragment();
                }
            }
        });
        mTitanView = (ImageView) findViewById(R.id.titan_button);
        Glide.with(this).asGif().load(R.drawable.titan).into(mTitanView);//library to use the gif
        mTitanView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOpen) {
                    String titanString = getResources().getString(R.string.titan);
                    openFragment(titanString, R.string.titan);
                }else{
                    closeFragment();
                }
            }
        });
    }

    private void openFragment(String text, int ID) {
        isOpen = true;
        fragment = SaturnFragment.newInstance(text);
        addText(ID, fragment);
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.earth_from_bottom, R.anim.earth_to_bottom);//in order to add a button or something than add both again
        transaction.addToBackStack(null);//in order to close only the fragment and not the whole activity
        transaction.add(R.id.saturn_fragment_container, fragment, "fragment_saturn").commit();
    }

    private void closeFragment() {
        isOpen = false;
        transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.earth_to_bottom, R.anim.earth_from_bottom);
        transaction.remove(fragment).commit();
    }

    private void addText(int ID, SaturnFragment fragment) {
        fragment.setmTextView(ID);
    }

    @Override
    protected void onSwipeRight() {
        openJupiter();
    }

    @Override
    protected void onSwipeLeft() {
        openUranus();
    }

    private void openJupiter(){
        Intent intent = new Intent(this, Jupiter.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_right_out,R.anim.push_right_in);
    }

    private void openUranus(){
        Intent intent = new Intent(this, Uranus.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }
}