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

public class Mars extends _SwipeActivityClass {

    private FrameLayout mFragmentContainer;

    ImageView mMarsView;
    ImageView mPhobosView;
    ImageView mDiemosView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mars);

        mFragmentContainer = (FrameLayout) findViewById(R.id.mars_fragment_container);

        mDiemosView = (ImageView) findViewById(R.id.diemos_button1);
        Glide.with(this).asGif().load(R.drawable.ddiemos).into(mDiemosView);//library to use the gif
        mDiemosView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: add description
            }
        });
        mMarsView = (ImageView) findViewById(R.id.mars_button);
        Glide.with(this).asGif().load(R.drawable.mars_rotation).into(mMarsView);//library to use the gif
        mMarsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String marsText = getResources().getString(R.string.mars);
                openFragment(marsText, R.string.mars);
            }
        });
        mPhobosView = (ImageView) findViewById(R.id.phobos_button2);
        Glide.with(this).asGif().load(R.drawable.phobos).into(mPhobosView);//library to use the gif
        mPhobosView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: add description
            }
        });


    }
    public void openFragment(String text, int ID) {
        MarsFragment fragment = MarsFragment.newInstance(text);
        addText(ID, fragment);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.earth_from_bottom, R.anim.earth_to_bottom);//in order to add a button or something than add both again
        transaction.addToBackStack(null);//in order to close only the fragment and not the whole activity
        transaction.add(R.id.mars_fragment_container, fragment, "fragment_mars").commit();
    }

    public void addText(int ID, MarsFragment fragment) {
        fragment.setmTextView(ID);
    }

    @Override
    protected void onSwipeRight() {
        openEarth();
    }

    @Override
    protected void onSwipeLeft() {
        openJupiter();
    }
    public void openEarth(){
        Intent intent = new Intent(this, Earth.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_right_out,R.anim.push_right_in);
    }
    public void openJupiter(){
        Intent intent = new Intent(this, Jupiter.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }
}