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

public class Neptune extends _SwipeActivityClass {

    private ImageView mNeptuneView;
    private ImageView mTritanView;


    private boolean isOpen = false;
    private FrameLayout mFragmentContainer;
    private NeptuneFragment fragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_neptune);

        mFragmentContainer = (FrameLayout) findViewById(R.id.neptune_fragment_container);

        mNeptuneView = (ImageView) findViewById(R.id.neptune_button);
        Glide.with(this).asGif().load(R.drawable.neptune2).into(mNeptuneView);//library to use the gif
        mNeptuneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOpen) {
                    String neptuneString = getResources().getString(R.string.neptune);
                    openFragment(neptuneString, R.string.neptune);
                }else{
                    closeFragment();
                }
            }
        });

        mTritanView = (ImageView) findViewById(R.id.tritan_button);
        Glide.with(this).asGif().load(R.drawable.tritan).into(mTritanView);//library to use the gif

    }

    private void openFragment(String text, int ID) {
        isOpen = true;
        fragment = NeptuneFragment.newInstance(text);
        addText(ID, fragment);
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.earth_from_bottom, R.anim.earth_to_bottom);//in order to add a button or something than add both again
        transaction.addToBackStack(null);//in order to close only the fragment and not the whole activity
        transaction.add(R.id.neptune_fragment_container, fragment, "fragment_neptune").commit();
    }

    private void closeFragment() {
        isOpen = false;
        transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.earth_to_bottom, R.anim.earth_from_bottom);
        transaction.remove(fragment).commit();
    }

    private void addText(int ID, NeptuneFragment fragment) {
        fragment.setmTextView(ID);
    }

    @Override
    protected void onSwipeRight() {
        openUranus();
    }

    @Override
    protected void onSwipeLeft() {
        openPluto();
    }

    private void openUranus(){
        Intent intent = new Intent(this, Uranus.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_right_out,R.anim.push_right_in);
    }
    private void openPluto(){
        Intent intent = new Intent(this, Pluto.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }
}