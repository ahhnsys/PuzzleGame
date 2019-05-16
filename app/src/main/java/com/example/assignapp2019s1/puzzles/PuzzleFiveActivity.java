package com.example.assignapp2019s1.puzzles;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignapp2019s1.R;

public class PuzzleFiveActivity extends AppCompatActivity {

    private String solution = "SMARTPHONE";

    private String answer = "";

    public CountDownTimer mCountDownTimer5;

    public boolean timeCancel5 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_one);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        iniTimer();
    }

    public void iniTimer(){

        if (mCountDownTimer5!=null){
            mCountDownTimer5.cancel();
        }

        mCountDownTimer5 = new CountDownTimer(300000+500, 1000) {

            TextView tvt5 = findViewById(R.id.textViewTimer5) ;

            public void onTick(long millisUntilFinished) {
                if(!PuzzleFiveActivity.this.isFinishing()){
                    tvt5.setText("seconds remaining: " + millisUntilFinished / 1000);
                    if (timeCancel5==true)
                        this.cancel();
                }
            }

            public void onFinish() {
                tvt5.setText("Time is up!");
                Toast.makeText(getApplicationContext(),"Time is up and you haven't solved this puzzle yet. Try it again!",Toast.LENGTH_LONG).show();
                finish();
            }
        };
        mCountDownTimer5.start();
    }

    public void onClickButtonA5(View view){
        answer = answer + 'A';
        updateScreen(findViewById(R.id.answerScreen5));
        check();
    }

    public void onClickButtonE5(View view){
        answer = answer + 'E';
        updateScreen(findViewById(R.id.answerScreen5));
        check();
    }

    public void onClickButtonH5(View view){
        answer = answer + 'H';
        updateScreen(findViewById(R.id.answerScreen5));
        check();
    }

    public void onClickButtonM5(View view){
        answer = answer + 'M';
        updateScreen(findViewById(R.id.answerScreen5));
        check();
    }

    public void onClickButtonN5(View view){
        answer = answer + 'N';
        updateScreen(findViewById(R.id.answerScreen5));
        check();
    }

    public void onClickButtonO5(View view){
        answer = answer + 'O';
        updateScreen(findViewById(R.id.answerScreen5));
        check();
    }

    public void onClickButtonP5(View view){
        answer = answer + 'P';
        updateScreen(findViewById(R.id.answerScreen5));
        check();
    }

    public void onClickButtonR5(View view){
        answer = answer + 'R';
        updateScreen(findViewById(R.id.answerScreen5));
        check();
    }

    public void onClickButtonS5(View view){
        answer = answer + 'S';
        updateScreen(findViewById(R.id.answerScreen5));
        check();
    }

    public void onClickButtonT5(View view){
        answer = answer + 'T';
        updateScreen(findViewById(R.id.answerScreen5));
        check();
    }

    public void check(){
        if (answer.length() == 10){
            if (answer.equals(solution)){
                checkedRightAnswer();
            }
            else {
                checkedWrongAnswer();
            }
        }
    }

    public void checkedRightAnswer(){
        Toast.makeText(getApplicationContext(),"Congratulations! Your answer(SMARTPHONE) is correct. You have passed this level.",Toast.LENGTH_LONG).show();
        mCountDownTimer5.cancel();
        timeCancel5 = true;
        finish();
    }

    public void checkedWrongAnswer(){
        Toast.makeText(getApplicationContext(),"Sorry! Your answer is not correct. Try it again!",Toast.LENGTH_SHORT).show();
        clear();
    }

    public void onClickButtonClear5(View view){
        clear();
    }

    public void clear(){
        answer = "";
        updateScreen(findViewById(R.id.answerScreen5));
    }

    public void onClickButtonBack5(View view){
        mCountDownTimer5.cancel();
        timeCancel5 = true;
        finish();
    }

    public void onClickButtonHelp5(View view){
        TextView tv = findViewById(R.id.textViewLevelFiveHint);
        tv.setText("Hint: This object may be lying in your pocket now.");
    }

    public void onClickButtonSkip5(View view){
        checkedRightAnswer();
    }

    public void updateScreen(View view){
        TextView tv5 = view.findViewById(R.id.answerScreen5);
        tv5.setText(answer);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (mCountDownTimer5 != null){
            timeCancel5 = true;
            mCountDownTimer5.cancel();
        }
    }

}
