package com.contraslash.android.pabloadventurequest.applications.game.activities;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.contraslash.android.base.BaseActivity;
import com.contraslash.android.pabloadventurequest.R;
import com.contraslash.android.pabloadventurequest.applications.game.models.Question;
import com.contraslash.android.pabloadventurequest.conf.Conf;
import com.contraslash.android.pabloadventurequest.conf.PabloAdventureQuest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainMenu extends BaseActivity {

    ImageButton survival;
    ImageButton time;
    ImageButton standard;
    ImageButton instructions;
    ImageButton credits;
    ImageButton settings;

    ArrayList <Question> questions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        questions = new ArrayList<>();

//        if(!getPreferences().getBoolean(Conf.READED_FROM_FILE,false))
//        {
//        }
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
