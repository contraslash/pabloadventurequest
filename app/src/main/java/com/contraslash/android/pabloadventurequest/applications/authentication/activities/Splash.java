package com.contraslash.android.pabloadventurequest.applications.authentication.activities;

import android.os.Bundle;

import com.contraslash.android.base.BaseActivity;
import com.contraslash.android.pabloadventurequest.R;
import com.contraslash.android.pabloadventurequest.applications.game.activities.MainMenu;


public class Splash extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                changeActivity(MainMenu.class);
            }
        }, 2000);

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void mapGUI() {

    }

    @Override
    protected void loadEvents() {

    }


}
