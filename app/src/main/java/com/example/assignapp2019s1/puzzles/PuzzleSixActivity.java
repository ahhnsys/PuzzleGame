package com.example.assignapp2019s1.puzzles;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignapp2019s1.R;
import com.example.assignapp2019s1.Storyboard.FirstBeachActivity;

public class PuzzleSixActivity extends AppCompatActivity {

    private String solution = "MASTER";

    private String answer = "";

    public CountDownTimer mCountDownTimer6;

    public boolean timeCancel6 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_six);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        iniTimer();
    }

    public void iniTimer(){

        if (mCountDownTimer6!=null){
            mCountDownTimer6.cancel();
        }

        mCountDownTimer6 = new CountDownTimer(300000+500, 1000) {

            TextView tvt6 = findViewById(R.id.textViewTimer6) ;

            public void onTick(long millisUntilFinished) {
                if(!PuzzleSixActivity.this.isFinishing()){
                    tvt6.setText("seconds remaining: " + millisUntilFinished / 1000);
                    if (timeCancel6==true)
                        this.cancel();
                }
            }

            public void onFinish() {
                tvt6.setText("Time is up!");
                Toast.makeText(getApplicationContext(),"Time is up and you haven't solved this puzzle yet. Try it again!",Toast.LENGTH_LONG).show();
                finish();
            }
        };
        mCountDownTimer6.start();
    }

    public void onClickButtonA6(View view){
        answer = answer + 'A';
        updateScreen(findViewById(R.id.answerScreen6));
        check();
    }

    public void onClickButtonE6(View view){
        answer = answer + 'E';
        updateScreen(findViewById(R.id.answerScreen6));
        check();
    }

    public void onClickButtonH6(View view){
        answer = answer + 'H';
        updateScreen(findViewById(R.id.answerScreen6));
        check();
    }

    public void onClickButtonM6(View view){
        answer = answer + 'M';
        updateScreen(findViewById(R.id.answerScreen6));
        check();
    }

    public void onClickButtonN6(View view){
        answer = answer + 'N';
        updateScreen(findViewById(R.id.answerScreen6));
        check();
    }

    public void onClickButtonO6(View view){
        answer = answer + 'O';
        updateScreen(findViewById(R.id.answerScreen6));
        check();
    }

    public void onClickButtonP6(View view){
        answer = answer + 'P';
        updateScreen(findViewById(R.id.answerScreen6));
        check();
    }

    public void onClickButtonR6(View view){
        answer = answer + 'R';
        updateScreen(findViewById(R.id.answerScreen6));
        check();
    }

    public void onClickButtonS6(View view){
        answer = answer + 'S';
        updateScreen(findViewById(R.id.answerScreen6));
        check();
    }

    public void onClickButtonT6(View view){
        answer = answer + 'T';
        updateScreen(findViewById(R.id.answerScreen6));
        check();
    }

    public void check(){
        if (answer.length() == 6){
            if (answer.equals(solution)){
                checkedRightAnswer();
            }
            else {
                checkedWrongAnswer();
            }
        }
    }

    public void checkedRightAnswer(){
        Toast.makeText(getApplicationContext(),"Congratulations! Your answer(MASTER) is correct. You have passed this level.",Toast.LENGTH_LONG).show();
        mCountDownTimer6.cancel();
        timeCancel6 = true;

        //authored by Natalie Phan
        //sends data that puzzle has been completed to original class
        Intent intent = new Intent(this, FirstBeachActivity.class);
        intent.putExtra("sendData",0);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }

    public void checkedWrongAnswer(){
        Toast.makeText(getApplicationContext(),"Sorry! Your answer is not correct. Try it again!",Toast.LENGTH_SHORT).show();
        clear();
    }

    public void onClickButtonClear6(View view){
        clear();
    }

    public void clear(){
        answer = "";
        updateScreen(findViewById(R.id.answerScreen6));
    }

    public void onClickButtonBack6(View view){
        mCountDownTimer6.cancel();
        timeCancel6 = true;
        finish();
    }

    public void onClickButtonHelp6(View view){
        TextView tv = findViewById(R.id.textViewLevelSixHint);
        tv.setText("Hint: One kind of degree");
    }

    public void onClickButtonSkip6(View view){
        checkedRightAnswer();
    }

    public void updateScreen(View view){
        TextView tv = view.findViewById(R.id.answerScreen6);
        tv.setText(answer);
    }

    public void onClickImageButton6(View view){
        Button btnH = findViewById(R.id.buttonH6);
        btnH.setText("");
        Button btnN = findViewById(R.id.buttonN6);
        btnN.setText("");
        Button btnO = findViewById(R.id.buttonO6);
        btnO.setText("");
        Button btnP = findViewById(R.id.buttonP6);
        btnP.setText("");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (mCountDownTimer6 != null){
            timeCancel6 = true;
            mCountDownTimer6.cancel();
        }
    }

}
