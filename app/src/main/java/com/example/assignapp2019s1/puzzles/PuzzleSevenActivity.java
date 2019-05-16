package com.example.assignapp2019s1.puzzles;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignapp2019s1.R;

import java.util.Set;
import java.util.TreeSet;

public class PuzzleSevenActivity extends AppCompatActivity {

    private Set<String> solutions = new TreeSet<String>(){{
        add("EAST");
        add("ETAS");
        add("FAST");
        add("FATE");
        add("FATS");
        add("FEAT");
        add("FETA");
        add("FOES");
        add("OAFS");
        add("OATS");
        add("SAFE");
        add("SATE");
        add("SEAT");
        add("SETA");
        add("SOFA");
        add("SOFT");
        add("TEAS");
        add("TOES");
    }};

    private Set<String> answers = new TreeSet<String>();

    private String currentAnswer = "";

    public CountDownTimer mCountDownTimer3;

    public boolean timeCancel3 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_three);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        iniTimer();
    }

    public void iniTimer(){

        if (mCountDownTimer3!=null){
            mCountDownTimer3.cancel();
        }

        mCountDownTimer3 = new CountDownTimer(300000+500, 1000) {

            TextView tvt3 = findViewById(R.id.textViewTimer3) ;

            public void onTick(long millisUntilFinished) {
                if(!PuzzleSevenActivity.this.isFinishing()){
                    tvt3.setText("seconds remaining: " + millisUntilFinished / 1000);
                    if (timeCancel3==true)
                        this.cancel();
                }
            }

            public void onFinish() {
                tvt3.setText("Time is up!");
                Toast.makeText(getApplicationContext(),"Time is up and you haven't solved this puzzle yet. Try it again!",Toast.LENGTH_LONG).show();
                finish();
            }
        };
        mCountDownTimer3.start();
    }

    public void onClickButtonA3(View view){
        currentAnswer = currentAnswer + 'A';
        updateScreen(findViewById(R.id.answerScreen3));
        check();
    }

    public void onClickButtonE3(View view){
        currentAnswer = currentAnswer + 'E';
        updateScreen(findViewById(R.id.answerScreen3));
        check();
    }

    public void onClickButtonF3(View view){
        currentAnswer = currentAnswer + 'F';
        updateScreen(findViewById(R.id.answerScreen3));
        check();
    }

    public void onClickButtonO3(View view){
        currentAnswer = currentAnswer + 'O';
        updateScreen(findViewById(R.id.answerScreen3));
        check();
    }

    public void onClickButtonS3(View view){
        currentAnswer = currentAnswer + 'S';
        updateScreen(findViewById(R.id.answerScreen3));
        check();
    }

    public void onClickButtonT3(View view){
        currentAnswer = currentAnswer + 'T';
        updateScreen(findViewById(R.id.answerScreen3));
        check();
    }


    public void check(){
        if (currentAnswer.length() == 4){
            if (answers.contains(currentAnswer)){
                Toast.makeText(getApplicationContext(),"Your have found this word.",Toast.LENGTH_SHORT).show();
                clear();
            }
            else {
                if (solutions.contains(currentAnswer)){
                    checkedRightAnswer();
                }
                else {
                    checkedWrongAnswer();
                }
            }
        }
    }

    public void checkedRightAnswer(){
        Toast.makeText(getApplicationContext(),"You find a new word "+currentAnswer,Toast.LENGTH_SHORT).show();
        answers.add(currentAnswer);
        TextView tvc = findViewById(R.id.textViewLevelThreeCount);
        tvc.setText("Number of words found: " + answers.size());
        clear();
        if (answers.size() >= 5){
            Toast.makeText(getApplicationContext(),"Congratulations! You have found enough words. You have passed this level.",Toast.LENGTH_LONG).show();
            mCountDownTimer3.cancel();
            timeCancel3 = true;
            finish();
        }
    }

    public void checkedWrongAnswer(){
        Toast.makeText(getApplicationContext(),"Sorry! Your answer is not correct. Try it again!",Toast.LENGTH_SHORT).show();
        clear();
    }

    public void onClickButtonClear3(View view){
        clear();
    }

    public void clear(){
        currentAnswer = "";
        updateScreen(findViewById(R.id.answerScreen3));
    }

    public void onClickButtonBack3(View view){
        mCountDownTimer3.cancel();
        timeCancel3 = true;
        finish();
    }

    public void onClickButtonSkip3(View view){
        mCountDownTimer3.cancel();
        timeCancel3 = true;
        finish();
    }

    public void updateScreen(View view){
        TextView tv = view.findViewById(R.id.answerScreen3);
        tv.setText(currentAnswer);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (mCountDownTimer3 != null){
            timeCancel3 = true;
            mCountDownTimer3.cancel();
        }
    }

}
