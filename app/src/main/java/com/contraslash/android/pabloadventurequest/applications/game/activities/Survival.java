package com.contraslash.android.pabloadventurequest.applications.game.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.contraslash.android.base.BaseActivity;
import com.contraslash.android.pabloadventurequest.R;
import com.contraslash.android.pabloadventurequest.applications.game.core.AnswerCallback;
import com.contraslash.android.pabloadventurequest.applications.game.core.QuestionManager;
import com.contraslash.android.pabloadventurequest.applications.game.core.Utils;

public class Survival extends BaseActivity implements AnswerCallback {

    // Question Engine Objects

    TextView question;

    Button optionA;
    Button optionB;
    Button optionC;
    Button optionD;

    //End of Question Engine Objects

    ImageButton home;
    Button points;
    ImageButton skip;

    int numberPoints;


    QuestionManager questionManager;

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
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_survival;
    }

    @Override
    protected void mapGUI() {

        home = (ImageButton)findViewById(R.id.survival_home);
        points = (Button)findViewById(R.id.survival_points);

        question = (TextView)findViewById(R.id.survival_question);

        optionA = (Button)findViewById(R.id.survival_answer_a);
        optionB = (Button)findViewById(R.id.survival_answer_b);
        optionC = (Button)findViewById(R.id.survival_answer_c);
        optionD = (Button)findViewById(R.id.survival_answer_d);

        skip = (ImageButton)findViewById(R.id.survival_skip);

    }

    @Override
    protected void loadEvents() {
        addListenerToChangeActivity(home, MainMenu.class);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionManager.setCurrentRandomQuestion();
            }
        });
    }

    @Override
    public void rightAnswer() {
        numberPoints+=1;
        points.setText(numberPoints+"");

    }

    @Override
    public void wrongAnswer() {
        new AlertDialog.Builder(this)
                .setTitle(getResources().getString(R.string.you_lost))
                .setMessage(getResources().getString(R.string.your_puntiation) + numberPoints)
                .setNeutralButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Survival.this.changeActivity(MainMenu.class);
                    }
                })
                .setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        Survival.this.changeActivity(MainMenu.class);
                    }
                })
                .show();

    }
}
