package com.contraslash.android.pabloadventurequest.applications.game.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.contraslash.android.base.BaseActivity;
import com.contraslash.android.pabloadventurequest.R;

public class Credits extends BaseActivity {

    ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_credits;
    }

    @Override
    protected void mapGUI() {
        home = (ImageButton) findViewById(R.id.credits_home);
    }

    @Override
    protected void loadEvents() {
        addListenerToChangeActivity(home, MainMenu.class);
    }
}
