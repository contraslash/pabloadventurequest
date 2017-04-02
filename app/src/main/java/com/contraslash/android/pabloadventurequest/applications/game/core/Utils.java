package com.contraslash.android.pabloadventurequest.applications.game.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.contraslash.android.pabloadventurequest.R;
import com.contraslash.android.pabloadventurequest.applications.game.models.Question;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by ma0 on 3/22/16.
 */
public class Utils {



    public static ArrayList<Question> readQuestionsFromFile(Context context)
    {
        ArrayList <Question> questions = new ArrayList<>();
        try
        {
            Resources res = context.getResources();
            InputStream inputStream = res.openRawResource(R.raw.preguntas);

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            String texto = "";
            while ((line = reader.readLine()) != null)
            {
                texto+=line;

            }
            JSONArray questionsJSON = new JSONArray(texto);
            for(int i=0;i<questionsJSON.length();i++)
            {
                JSONObject questionJSON = questionsJSON.getJSONObject(i);
                Question question = new Question();
                question.setQuestion(questionJSON.getString("pregunta"));
                question.setAnswerA(questionJSON.getString("a"));
                question.setAnswerB(questionJSON.getString("b"));
                question.setAnswerC(questionJSON.getString("c"));
                question.setAnswerD(questionJSON.getString("d"));
                question.setRightAnswer(questionJSON.getString("correcta"));
                questions.add(question);
            }

        }catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        catch (JSONException jse)
        {
            jse.printStackTrace();
        }
        return questions;
    }
}
