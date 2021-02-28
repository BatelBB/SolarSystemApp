package com.example.solarsystemapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrPosition;

public class Uranus extends _SwipeActivityClass {

    private ImageView mUranusView;
    private ImageView mTitaniaView;

    private boolean isOpen = false;
    private FrameLayout mFragmentContainer;
    private UranusFragment fragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_uranus);

        mUranusView = (ImageView) findViewById(R.id.uranus_button);
        Glide.with(this).asGif().load(R.drawable.uranus2).into(mUranusView);//library to use the gif
        mUranusView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isOpen){
                    String UranusString = getResources().getString(R.string.uranus); //gets the string from the strings.xml
                    openFragment(UranusString, R.string.uranus);
                }else{
                    closeFragment();
                }
            }
        });
        mTitaniaView = (ImageView) findViewById(R.id.titania_button);
        Glide.with(this).asGif().load(R.drawable.titania).into(mTitaniaView);//library to use the gif

    }

    private void openFragment(String text, int ID) {
        isOpen = true;
        fragment = UranusFragment.newInstance(text);
        addText(ID, fragment);
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.earth_from_bottom, R.anim.earth_to_bottom);//in order to add a button or something than add both again
        transaction.addToBackStack(null);//in order to close only the fragment and not the whole activity
        transaction.add(R.id.uranus_fragment_container, fragment, "fragment_uranus").commit();
    }

    private void closeFragment() {
        isOpen = false;
        transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.earth_to_bottom, R.anim.earth_from_bottom);
        transaction.remove(fragment).commit();
    }

    private void addText(int ID, UranusFragment fragment) {
        fragment.setmTextView(ID);
    }

    @Override
    protected void onSwipeRight() {
        openSaturn();
    }

    @Override
    protected void onSwipeLeft() {
        openNeptune();
    }

    private void openSaturn(){
        Intent intent = new Intent(this, Saturn.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_right_out,R.anim.push_right_in);
    }

    private void openNeptune(){
        Intent intent = new Intent(this, Neptune.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }
}