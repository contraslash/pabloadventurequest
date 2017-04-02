package com.contraslash.android.pabloadventurequest.applications.game.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.contraslash.android.base.BaseActivity;
import com.contraslash.android.pabloadventurequest.R;
import com.contraslash.android.pabloadventurequest.applications.game.core.AnswerCallback;
import com.contraslash.android.pabloadventurequest.applications.game.core.QuestionManager;
import com.contraslash.android.pabloadventurequest.applications.game.core.Utils;
import com.contraslash.android.pabloadventurequest.conf.Conf;

public class Time extends BaseActivity implements AnswerCallback {

    int SECONDS;

    final int TIME_SECONDS = 1000;

    CountDownTimer timer;

    TextView textTime;


    // Question Engine Objects

    TextView question;

    Button optionA;
    Button optionB;
    Button optionC;
    Button optionD;

    //End of Question Engine Objects
    int numberPoints;

    QuestionManager questionManager;


    ImageButton home;
    Button points;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        questionManager = new QuestionManager(
                this,
                question,
                optionA,
                optionB,
                optionC,
                optionD
        );

        questionManager.setQuestions(Utils.readQuestionsFromFile(this));

        questionManager.configure();

        questionManager.setCurrentRandomQuestion();

        SECONDS = getPreferences().getInt(Conf.TIME_SECONDES_DURATION,60);

        textTime.setText(SECONDS+"");

        initializeTimer();

        startTimer();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_time;
    }

    @Override
    protected void mapGUI() {
        home = (ImageButton)findViewById(R.id.time_home);
        points = (Button)findViewById(R.id.time_points);

        textTime = (TextView)findViewById(R.id.time_seconds);

        question = (TextView)findViewById(R.id.time_question);

        optionA = (Button)findViewById(R.id.time_answer_a);
        optionB = (Button)findViewById(R.id.time_answer_b);
        optionC = (Button)findViewById(R.id.time_answer_c);
        optionD = (Button)findViewById(R.id.time_answer_d);

    }

    @Override
    protected void loadEvents() {
        addListenerToChangeActivity(home, MainMenu.class);
    }


    private void initializeTimer()
    {
        timer = new CountDownTimer(SECONDS*TIME_SECONDS,TIME_SECONDS) {
            @Override
            public void onTick(long millisUntilFinished) {
                textTime.setText(millisUntilFinished/TIME_SECONDS+"");
                Log.i(TAG, millisUntilFinished+"");
            }

            @Override
            public void onFinish() {
                new AlertDialog.Builder(Time.this)
                        .setTitle(getResources().getString(R.string.you_lost))
                        .setMessage(getResources().getString(R.string.your_puntiation)+numberPoints)
                        .setNeutralButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Time.this.changeActivity(MainMenu.class);
                            }
                        })
                        .setOnDismissListener(new DialogInterface.OnDismissListener() {
                            @Override
                            public void onDismiss(DialogInterface dialog) {
                                Time.this.changeActivity(MainMenu.class);
                            }
                        })
                        .show();
            }
        };
    }

    private void startTimer()
    {
        timer.start();
    }

    private void stopTimer()
    {
        timer.cancel();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopTimer();
    }

    @Override
    public void rightAnswer() {
        numberPoints+=1;
        points.setText(numberPoints + "");
    }

    @Override
    public void wrongAnswer() {

    }

}
