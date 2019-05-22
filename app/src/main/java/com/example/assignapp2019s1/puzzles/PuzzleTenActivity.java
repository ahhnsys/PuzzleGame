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

public class PuzzleTenActivity extends AppCompatActivity {

    private Set<String> solutions = new TreeSet<String>(){{
        add("AIL");
        add("ALB");
        add("BAG");
        add("BAT");
        add("BIG");
        add("BIT");
        add("GAB");
        add("GAL");
        add("LAB");
        add("LAG");
        add("LIT");
        add("TAB");
        add("TAG");
    }};

    private Set<String> answers = new TreeSet<String>();

    private String currentAnswer = "";

    public CountDownTimer mCountDownTimer10;

    public boolean timeCancel10 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_ten);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        iniTimer();
    }

    public void iniTimer(){

        if (mCountDownTimer10!=null){
            mCountDownTimer10.cancel();
        }

        mCountDownTimer10 = new CountDownTimer(300000+500, 1000) {

            TextView tvt10 = findViewById(R.id.textViewTimer10) ;

            public void onTick(long millisUntilFinished) {
                if(!PuzzleTenActivity.this.isFinishing()){
                    tvt10.setText("seconds remaining: " + millisUntilFinished / 1000);
                    if (timeCancel10==true)
                        this.cancel();
                }
            }

            public void onFinish() {
                tvt10.setText("Time is up!");
                Toast.makeText(getApplicationContext(),"Time is up and you haven't solved this puzzle yet. Try it again!",Toast.LENGTH_LONG).show();
                finish();
            }
        };
        mCountDownTimer10.start();
    }

    public void onClickButtonA10(View view){
        currentAnswer = currentAnswer + 'A';
        updateScreen(findViewById(R.id.answerScreen10));
        check();
    }

    public void onClickButtonB10(View view){
        currentAnswer = currentAnswer + 'B';
        updateScreen(findViewById(R.id.answerScreen10));
        check();
    }

    public void onClickButtonG10(View view){
        currentAnswer = currentAnswer + 'G';
        updateScreen(findViewById(R.id.answerScreen10));
        check();
    }

    public void onClickButtonI10(View view){
        currentAnswer = currentAnswer + 'I';
        updateScreen(findViewById(R.id.answerScreen10));
        check();
    }

    public void onClickButtonL10(View view){
        currentAnswer = currentAnswer + 'L';
        updateScreen(findViewById(R.id.answerScreen10));
        check();
    }

    public void onClickButtonT10(View view){
        currentAnswer = currentAnswer + 'T';
        updateScreen(findViewById(R.id.answerScreen10));
        check();
    }


    public void check(){
        if (currentAnswer.length() == 3){
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
        TextView tvc10 = findViewById(R.id.textViewLevelTenCount);
        tvc10.setText("Number of words found: " + answers.size());
        clear();
        if (answers.size() >= 5){
            Toast.makeText(getApplicationContext(),"Congratulations! You have found enough words. You have passed this level.",Toast.LENGTH_LONG).show();
            mCountDownTimer10.cancel();
            timeCancel10 = true;
            finish();
        }
    }

    public void checkedWrongAnswer(){
        Toast.makeText(getApplicationContext(),"Sorry! Your answer is not correct. Try it again!",Toast.LENGTH_SHORT).show();
        clear();
    }

    public void onClickButtonClear10(View view){
        clear();
    }

    public void clear(){
        currentAnswer = "";
        updateScreen(findViewById(R.id.answerScreen10));
    }

    public void onClickButtonBack10(View view){
        mCountDownTimer10.cancel();
        timeCancel10 = true;
        finish();
    }

    public void onClickButtonSkip10(View view){
        mCountDownTimer10.cancel();
        timeCancel10 = true;
        finish();
    }

    public void updateScreen(View view){
        TextView tv = view.findViewById(R.id.answerScreen3);
        tv.setText(currentAnswer);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (mCountDownTimer10 != null){
            timeCancel10 = true;
            mCountDownTimer10.cancel();
        }
    }

}
