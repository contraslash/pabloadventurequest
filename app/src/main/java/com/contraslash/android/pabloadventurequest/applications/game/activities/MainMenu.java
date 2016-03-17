package com.contraslash.android.pabloadventurequest.applications.game.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.contraslash.android.base.BaseActivity;
import com.contraslash.android.pabloadventurequest.R;

public class MainMenu extends BaseActivity {

    ImageButton survival;
    ImageButton time;
    ImageButton standard;
    ImageButton instructions;
    ImageButton credits;
    ImageButton settings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main_menu;
    }

    @Override
    protected void mapGUI()
    {
        survival = (ImageButton)findViewById(R.id.main_menu_survival);
        time = (ImageButton)findViewById(R.id.main_menu_time);
        standard = (ImageButton)findViewById(R.id.main_menu_standard);
        instructions = (ImageButton)findViewById(R.id.main_menu_instructions);
        credits = (ImageButton)findViewById(R.id.main_menu_credits);
        settings = (ImageButton)findViewById(R.id.main_menu_settings);
    }

    @Override
    protected void loadEvents()
    {
        addListenerToChangeActivity(survival, Survival.class);
        addListenerToChangeActivity(time, Time.class);
        addListenerToChangeActivity(standard, Standard.class);
        addListenerToChangeActivity(instructions, Instructions.class);
        addListenerToChangeActivity(credits, Credits.class);
        addListenerToChangeActivity(settings, Settings.class);
    }
}
