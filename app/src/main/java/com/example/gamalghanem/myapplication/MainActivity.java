package com.example.gamalghanem.myapplication;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreA = 0;
    int scoreB = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * increases team A score by 3
     * @param view
     */
    public void addThreeForA(View view) {
        scoreA += 3;
        displayA(scoreA);
    }

    /**
     * increases team A score by two
     * @param view
     */
    public void addTwoForA(View view) {
        scoreA += 2;
        displayA(scoreA);
    }

    /**
     * increases team A score by one
     * @param view
     */
    public void addOneForA(View view) {
        scoreA += 1;
        displayA(scoreA);
    }

    /**
     * changes the score on the screen
     */
    public void displayA(int score) {
        TextView scoreAView = (TextView) findViewById(R.id.scoreA);
        scoreAView.setText(""+score);
    }


    /**
     * increases team B score by 3
     * @param view
     */
    public void addThreeForB(View view) {
        scoreB += 3;
        displayB(scoreB);
    }

    /**
     * increases team A score by two
     * @param view
     */
    public void addTwoForB(View view) {
        scoreB += 2;
        displayB(scoreB);
    }

    /**
     * increases team A score by one
     * @param view
     */
    public void addOneForB(View view) {
        scoreB += 1;
        displayB(scoreB);
    }

    /**
     * changes the score on the screen
     */
    public void displayB(int score) {
        TextView scoreBView = (TextView) findViewById(R.id.scoreB);
        scoreBView.setText(""+score);
    }

    public void reset(View view) {
        scoreA = 0;
        scoreB = 0;
        displayA(scoreA);
        displayB(scoreB);
    }

}
