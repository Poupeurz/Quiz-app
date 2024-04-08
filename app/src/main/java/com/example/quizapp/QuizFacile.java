package com.example.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizFacile extends AppCompatActivity {

    TextView quiztext,aans,bans,cans,dans;
    List<QuestionsItem> questionsItems;
    int currentQuestions = 0;
    int correct=0,wrong=0;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quiztext=findViewById(R.id.quizText);
        aans=findViewById(R.id.reponseA);
        bans=findViewById(R.id.reponseB);
        cans=findViewById(R.id.reponseC);
        dans=findViewById(R.id.reponseD);

        loadAllQuestions();
        Collections.shuffle(questionsItems);
        setQuestionScreen(currentQuestions);

        aans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionsItems.get(currentQuestions).getReponse1().equals(questionsItems.get(currentQuestions).getCorrect())){
                    correct++;
                    aans.setBackgroundResource(R.color.green);
                    aans.setTextColor(getResources().getColor(R.color.white));
                }else {
                    wrong++;
                    aans.setBackgroundResource(R.color.red);
                    aans.setTextColor(getResources().getColor(R.color.white));
                }

                if (currentQuestions < questionsItems.size()-1){
                    Handler handler = new Handler();
                    int delayMillis = 500;
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            aans.setBackgroundResource(R.color.white);
                            aans.setTextColor(getResources().getColor(R.color.text_secondery_color));
                        }
                    }, delayMillis);
                }else {
                    Intent intent = new Intent(QuizFacile.this,ResultActivity.class);
                    intent.putExtra("correct",correct);
                    intent.putExtra("wrong",wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });
        bans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionsItems.get(currentQuestions).getReponse2().equals(questionsItems.get(currentQuestions).getCorrect())){
                    correct++;
                    bans.setBackgroundResource(R.color.green);
                    bans.setTextColor(getResources().getColor(R.color.white));
                }else {
                    wrong++;
                    bans.setBackgroundResource(R.color.red);
                    bans.setTextColor(getResources().getColor(R.color.white));
                }

                if (currentQuestions < questionsItems.size()-1){
                    Handler handler = new Handler();
                    int delayMillis = 500;
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            bans.setBackgroundResource(R.color.white);
                            bans.setTextColor(getResources().getColor(R.color.text_secondery_color));
                        }
                    }, delayMillis);
                }else {
                    Intent intent = new Intent(QuizFacile.this,ResultActivity.class);
                    intent.putExtra("correct",correct);
                    intent.putExtra("wrong",wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });
        cans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionsItems.get(currentQuestions).getReponse3().equals(questionsItems.get(currentQuestions).getCorrect())){
                    correct++;
                    cans.setBackgroundResource(R.color.green);
                    cans.setTextColor(getResources().getColor(R.color.white));
                }else {
                    wrong++;
                    cans.setBackgroundResource(R.color.red);
                    cans.setTextColor(getResources().getColor(R.color.white));
                }

                if (currentQuestions < questionsItems.size()-1){
                    Handler handler = new Handler();
                    int delayMillis = 500;
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            cans.setBackgroundResource(R.color.white);
                            cans.setTextColor(getResources().getColor(R.color.text_secondery_color));
                        }
                    }, delayMillis);
                }else {
                    Intent intent = new Intent(QuizFacile.this,ResultActivity.class);
                    intent.putExtra("correct",correct);
                    intent.putExtra("wrong",wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });
        dans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionsItems.get(currentQuestions).getReponse4().equals(questionsItems.get(currentQuestions).getCorrect())){
                    correct++;
                    dans.setBackgroundResource(R.color.green);
                    dans.setTextColor(getResources().getColor(R.color.white));
                }else {
                    wrong++;
                    dans.setBackgroundResource(R.color.red);
                    dans.setTextColor(getResources().getColor(R.color.white));
                }

                if (currentQuestions < questionsItems.size()-1){
                    Handler handler = new Handler();
                    int delayMillis = 500;
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            currentQuestions++;
                            setQuestionScreen(currentQuestions);
                            dans.setBackgroundResource(R.color.white);
                            dans.setTextColor(getResources().getColor(R.color.text_secondery_color));
                        }
                    }, delayMillis);
                }else {
                    Intent intent = new Intent(QuizFacile.this,ResultActivity.class);
                    intent.putExtra("correct",correct);
                    intent.putExtra("wrong",wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void setQuestionScreen(int currentQuestions) {
        quiztext.setText(questionsItems.get(currentQuestions).getQuestions());
        aans.setText(questionsItems.get(currentQuestions).getReponse1());
        bans.setText(questionsItems.get(currentQuestions).getReponse2());
        cans.setText(questionsItems.get(currentQuestions).getReponse3());
        dans.setText(questionsItems.get(currentQuestions).getReponse4());
    }

    private void loadAllQuestions() {
        questionsItems=new ArrayList<>();
        String jsonquiz=loadJsonFromAsset("questionfacile.json");
        try {
            JSONObject jsonObject = new JSONObject(jsonquiz);
            JSONArray questions=jsonObject.getJSONArray("questionfacile");
            for(int i=0;i<questions.length();i++) {
                JSONObject question = questions.getJSONObject(i);

                String questionString = question.getString("question");
                String reponse1String = question.getString("reponse1");
                String reponse2String = question.getString("reponse2");
                String reponse3String = question.getString("reponse3");
                String reponse4String = question.getString("reponse4");
                String correctString = question.getString("correct");

                questionsItems.add(new QuestionsItem(questionString,reponse1String,reponse2String,reponse3String,reponse4String,correctString));
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String loadJsonFromAsset(String s) {
        String json="";
        try {
            InputStream inputStream = getAssets().open(s);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json=new String(buffer, "UTF-8");
        }catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    @Override
    public void onBackPressed(){
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(QuizFacile.this);
        materialAlertDialogBuilder.setTitle(R.string.app_name);
        materialAlertDialogBuilder.setMessage("Êtes-vous sur de voir quitter le quiz ?");
        materialAlertDialogBuilder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        materialAlertDialogBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(QuizFacile.this,MainActivity.class));
                finish();
            }
        });
        materialAlertDialogBuilder.show();
    }
}