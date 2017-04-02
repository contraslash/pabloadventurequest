package com.contraslash.android.pabloadventurequest.applications.game.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.contraslash.android.base.BaseActivity;
import com.contraslash.android.pabloadventurequest.R;
import com.contraslash.android.pabloadventurequest.conf.Conf;

public class Settings extends BaseActivity {

    EditText questions;
    EditText seconds;
    Button save;

    ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        questions.setText(getPreferences().getInt(Conf.STANDARD_QUESTION_NUMBER, 20) + "");
        seconds.setText(getPreferences().getInt(Conf.TIME_SECONDES_DURATION,20)+"");
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_settings;
    }

    @Override
    protected void mapGUI() {
        questions = (EditText)findViewById(R.id.settings_number_questions);
        seconds = (EditText)findViewById(R.id.settings_seconds);
        save = (Button)findViewById(R.id.settings_save);

        home = (ImageButton) findViewById(R.id.settings_home);

    }

    @Override
    protected void loadEvents() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        addListenerToChangeActivity(home, MainMenu.class);
    }

    private void save()
    {
        int numberQuestions=20;

        try {
            numberQuestions = Integer.parseInt(questions.getText() + "");
        }catch (NumberFormatException nfe)
        {
            nfe.printStackTrace();
        }

        int numberSeconds = 60;

        try {
            numberSeconds = Integer.parseInt(seconds.getText() + "");
        }catch (NumberFormatException nfe)
        {
            nfe.printStackTrace();
        }

        getPreferences().edit()
                .putInt(Conf.STANDARD_QUESTION_NUMBER,numberQuestions)
                .putInt(Conf.TIME_SECONDES_DURATION, numberSeconds)
                .apply();

        changeActivity(MainMenu.class);
    }
}
