package com.contraslash.android.pabloadventurequest.applications.game.core;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.contraslash.android.base.BaseActivity;
import com.contraslash.android.pabloadventurequest.applications.game.models.Question;

import java.util.ArrayList;

/**
 * Created by ma0 on 3/20/16.
 */
public class QuestionManager {

    ArrayList<Question> questions;

    Question currentQuestion;

    AnswerCallback context;

    TextView question;

    Button optionA;
    Button optionB;
    Button optionC;
    Button optionD;


    public QuestionManager(AnswerCallback context, TextView question, Button optionA, Button optionB, Button optionC, Button optionD) {
        this.context = context;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public TextView getQuestion() {
        return question;
    }

    public void setQuestion(TextView question) {
        this.question = question;
    }

    public Button getOptionA() {
        return optionA;
    }

    public void setOptionA(Button optionA) {
        this.optionA = optionA;
    }

    public Button getOptionB() {
        return optionB;
    }

    public void setOptionB(Button optionB) {
        this.optionB = optionB;
    }

    public Button getOptionC() {
        return optionC;
    }

    public void setOptionC(Button optionC) {
        this.optionC = optionC;
    }

    public Button getOptionD() {
        return optionD;
    }

    public void setOptionD(Button optionD) {
        this.optionD = optionD;
    }

    public Question getRandomQuestion()
    {
        return questions.get((int)(Math.random()*questions.size()));
    }

    public boolean checkQuestion(Question question, String answer)
    {
        return question.getRightAnswer().compareTo(answer)==0;
    }

    public void setCurrentRandomQuestion()
    {
        currentQuestion = getRandomQuestion();
        question.setText(currentQuestion.getQuestion());
        optionA.setText(currentQuestion.getAnswerA());
        optionB.setText(currentQuestion.getAnswerB());
        optionC.setText(currentQuestion.getAnswerC());
        optionD.setText(currentQuestion.getAnswerD());

    }

    public void configure()
    {
        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(optionA.getText()+"");
            }
        });

        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(optionB.getText()+"");
            }
        });

        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(optionC.getText()+"");
            }
        });

        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(optionD.getText()+"");
            }
        });
    }

    private void checkAnswer(String text)
    {

        if(checkQuestion(currentQuestion,text))
        {

            context.rightAnswer();
        }
        else
        {
            context.wrongAnswer();
        }
        setCurrentRandomQuestion();

    }

}
