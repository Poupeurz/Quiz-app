package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.card.MaterialCardView;

public class ResultActivity extends AppCompatActivity {

    MaterialCardView home;
    TextView correctt,wrongt,resultinfo,resultscore;
    ImageView resultImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        home = findViewById(R.id.returnHome);
        correctt = findViewById(R.id.correctScore);
        wrongt = findViewById(R.id.wrongScore);
        resultinfo = findViewById(R.id.resultInfo);
        resultscore = findViewById(R.id.resultScore);
        resultImage = findViewById(R.id.resultImage);

        int correct = getIntent().getIntExtra("correct", 0);
        int wrong = getIntent().getIntExtra("wrong", 0);
        int score = correct*5;

        correctt.setText(""+correct);
        wrongt.setText(""+wrong);
        resultscore.setText(""+score);

        if (correct >=0 && correct <=2) {
            resultinfo.setText("Retourne lire et reviens après");
            resultImage.setImageResource(R.drawable.ic_sad);
        } else if (correct >= 3 && correct <=5) {
            resultinfo.setText("Tu est presque au niveau... presque...");
            resultImage.setImageResource(R.drawable.ic_neutral);
        } else if (correct >= 6 && correct <=9) {
            resultinfo.setText("Tu as un bon niveau !");
            resultImage.setImageResource(R.drawable.ic_smile);
        } else {
            resultinfo.setText("Impressionnant !");
            resultImage.setImageResource(R.drawable.ic_amazed);
        }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this,MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public  void onBackPressed(){
        startActivity(new Intent(ResultActivity.this,MainActivity.class));
        finish();
    }
}