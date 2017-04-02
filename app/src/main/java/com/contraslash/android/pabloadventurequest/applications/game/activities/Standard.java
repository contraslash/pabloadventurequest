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
import com.contraslash.android.pabloadventurequest.conf.Conf;

import java.util.ArrayList;

public class Standard extends BaseActivity implements AnswerCallback {

    // Question Engine Objects

    TextView question;

    Button optionA;
    Button optionB;
    Button optionC;
    Button optionD;

    //End of Question Engine Objects

    ImageButton home;
    Button points;
    Button number;

    int numberPoints;

    int questionNumber;

    int maxNumberQuestion;

    QuestionManager questionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        numberPoints = 0;
        questionNumber = 1;
        maxNumberQuestion = getPreferences().getInt(Conf.STANDARD_QUESTION_NUMBER,20);

        number.setText(questionNumber+"/"+maxNumberQuestion);

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
        return R.layout.activity_standard;
    }

    @Override
    protected void mapGUI() {

        home = (ImageButton)findViewById(R.id.standard_home);
        points = (Button)findViewById(R.id.standard_points);
        number = (Button)findViewById(R.id.standard_number);

        question = (TextView)findViewById(R.id.standard_question);

        optionA = (Button)findViewById(R.id.standard_answer_a);
        optionB = (Button)findViewById(R.id.standard_answer_b);
        optionC = (Button)findViewById(R.id.standard_answer_c);
        optionD = (Button)findViewById(R.id.standard_answer_d);
    }

    @Override
    protected void loadEvents() {

        addListenerToChangeActivity(home, MainMenu.class);
    }

    @Override
    public void rightAnswer() {
        numberPoints+=1;
        points.setText(numberPoints+"");

        checkLast();
    }

    @Override
    public void wrongAnswer() {

        checkLast();
    }

    private void checkLast()
    {
        questionNumber+=1;
        if(questionNumber>maxNumberQuestion)
        {
            new AlertDialog.Builder(this)
                    .setTitle(getResources().getString(R.string.you_lost))
                    .setMessage(getResources().getString(R.string.your_puntiation) + numberPoints)
                    .setNeutralButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Standard.this.changeActivity(MainMenu.class);
                        }
                    })
                    .setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            Standard.this.changeActivity(MainMenu.class);
                        }
                    })
                    .show();
        }
        else
        {
            number.setText(questionNumber+"/"+maxNumberQuestion);
        }
    }
}

