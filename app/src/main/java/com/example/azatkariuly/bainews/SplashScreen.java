package com.example.azatkariuly.bainews;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(4000)
                .withBackgroundColor(Color.parseColor("#FFFFFF"))
                .withLogo(R.drawable.bayterek)
                .withAfterLogoText("Bay News");

        //Set Text Color
        config.getAfterLogoTextView().setTextColor(Color.parseColor("#9F2FFF"));

        //Set to view
        View view = config.create();

        //Set view to content view
        setContentView(view);
    }
}
