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
import com.example.assignapp2019s1.Storyboard.FirstForestActivity;

/**The 2nd level
 * @author Yishun Shi*/
public class PuzzleTwoActivity extends AppCompatActivity {

    //the correct answer
    private String solution = "FOREST";

    //user's current answer
    private String answer = "";

    //timer
    public CountDownTimer mCountDownTimer2;

    public boolean timeCancel2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_two);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        iniTimer();
    }

    //initialize timer
    public void iniTimer(){

        if (mCountDownTimer2!=null){
            mCountDownTimer2.cancel();
        }

        //set 5 minutes, modify display every second
        mCountDownTimer2 = new CountDownTimer(300000+500, 1000) {

            TextView tvt2 = findViewById(R.id.textViewTimer2) ;

            //activity per second
            public void onTick(long millisUntilFinished) {
                if(!PuzzleTwoActivity.this.isFinishing()){
                    tvt2.setText("seconds remaining: " + millisUntilFinished / 1000);
                    if (timeCancel2==true)
                        this.cancel();
                }
            }

            //activity when time is up
            public void onFinish() {
                tvt2.setText("Time is up!");
                Toast.makeText(getApplicationContext(),"Time is up and you haven't solved this puzzle yet. Try it again!",Toast.LENGTH_LONG).show();
                finish();
            }
        };
        mCountDownTimer2.start();
    }

    //set letter buttons
    public void onClickButtonA2(View view){
        answer = answer + 'A';
        updateScreen(findViewById(R.id.answerScreen2));
        check();
    }

    public void onClickButtonE2(View view){
        answer = answer + 'E';
        updateScreen(findViewById(R.id.answerScreen2));
        check();
    }

    public void onClickButtonF2(View view){
        answer = answer + 'F';
        updateScreen(findViewById(R.id.answerScreen2));
        check();
    }

    public void onClickButtonO2(View view){
        answer = answer + 'O';
        updateScreen(findViewById(R.id.answerScreen2));
        check();
    }

    public void onClickButtonR2(View view){
        answer = answer + 'R';
        updateScreen(findViewById(R.id.answerScreen2));
        check();
    }

    public void onClickButtonS2(View view){
        answer = answer + 'S';
        updateScreen(findViewById(R.id.answerScreen2));
        check();
    }

    public void onClickButtonT2(View view){
        answer = answer + 'T';
        updateScreen(findViewById(R.id.answerScreen2));
        check();
    }

    public void onClickButtonW2(View view){
        answer = answer + 'W';
        updateScreen(findViewById(R.id.answerScreen2));
        check();
    }

    //check whether the answer is correct
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

    //If answer is correct, cancel the timer and complete this level.
    public void checkedRightAnswer(){
        Toast.makeText(getApplicationContext(),"Congratulations! Your answer(FOREST) is correct. You have passed this level.",Toast.LENGTH_LONG).show();
        mCountDownTimer2.cancel();
        timeCancel2 = true;

        //authored by Natalie Phan
        //sends data that puzzle has been completed to original class
        Intent intent = new Intent(this,FirstForestActivity.class);
        intent.putExtra("sendData",0);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }

    //If the answer is wrong, clear the current answer.
    public void checkedWrongAnswer(){
        Toast.makeText(getApplicationContext(),"Sorry! Your answer is not correct. Try it again!",Toast.LENGTH_SHORT).show();
        clear();
    }

    public void onClickButtonClear2(View view){
        clear();
    }

    //Clear the current answer and display.
    public void clear(){
        answer = "";
        updateScreen(findViewById(R.id.answerScreen2));
    }

    //Return to the last activity.
    public void onClickButtonBack2(View view){
        mCountDownTimer2.cancel();
        timeCancel2 = true;
        finish();
    }

    //Show the hint.
    public void onClickButtonHelp2(View view){
        TextView tv = findViewById(R.id.textViewLevelTwoHint);
        tv.setText("Hint: This word may be used in the data structure");
    }

    //Skip this level.
    public void onClickButtonSkip2(View view){
        checkedRightAnswer();
    }

    public void updateScreen(View view){
        TextView tv = view.findViewById(R.id.answerScreen2);
        tv.setText(answer);
    }

    //Remove interference letters
    public void onClickImageButton(View view){
        Button btnA = findViewById(R.id.buttonA2);
        btnA.setText("");
        Button btnW = findViewById(R.id.buttonW2);
        btnW.setText("");
    }

    //Cancel the timer if this activity is finished.
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (mCountDownTimer2 != null){
            timeCancel2 = true;
            mCountDownTimer2.cancel();
        }
    }

}
