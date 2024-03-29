package com.example.assignapp2019s1.puzzles;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignapp2019s1.R;
import com.example.assignapp2019s1.Storyboard.FirstForestActivity;

/**The 1st level
 * @author Yishun Shi*/
public class PuzzleOneActivity extends AppCompatActivity {

    //the correct answer
//    private String solution = "SOFTWARE";
    private String solution = "FLOWER";

    //user's current answer
    private String answer = "";

    //timer
    public CountDownTimer mCountDownTimer;

    public boolean timeCancel = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_one);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        iniTimer();
    }

    //initialize timer
    public void iniTimer(){

        if (mCountDownTimer!=null){
            mCountDownTimer.cancel();
        }

        //set 5 minutes, modify display every second
        mCountDownTimer = new CountDownTimer(300000+500, 1000) {

            TextView tvt = findViewById(R.id.textViewTimer) ;

            //activity per second
            public void onTick(long millisUntilFinished) {
                if(!PuzzleOneActivity.this.isFinishing()){
                    tvt.setText("seconds remaining: " + millisUntilFinished / 1000);
                    if (timeCancel==true)
                        this.cancel();
                }
            }

            //activity when time is up
            public void onFinish() {
                tvt.setText("Time is up!");
                Toast.makeText(getApplicationContext(),"Time is up and you haven't solved this puzzle yet. Try it again!",Toast.LENGTH_LONG).show();
                finish();
            }
        };
        mCountDownTimer.start();
    }

    //set letter buttons
//    public void onClickButtonA(View view){
//        answer = answer + 'A';
//        updateScreen(findViewById(R.id.answerScreen));
//        check();
//    }

    public void onClickButtonE(View view){
        answer = answer + 'E';
        updateScreen(findViewById(R.id.answerScreen));
        check();
    }

    public void onClickButtonF(View view){
        answer = answer + 'F';
        updateScreen(findViewById(R.id.answerScreen));
        check();
    }

    public void onClickButtonL(View view){
        answer = answer + 'L';
        updateScreen(findViewById(R.id.answerScreen));
        check();
    }

    public void onClickButtonO(View view){
        answer = answer + 'O';
        updateScreen(findViewById(R.id.answerScreen));
        check();
    }

    public void onClickButtonR(View view){
        answer = answer + 'R';
        updateScreen(findViewById(R.id.answerScreen));
        check();
    }

//    public void onClickButtonS(View view){
//        answer = answer + 'S';
//        updateScreen(findViewById(R.id.answerScreen));
//        check();
//    }
//
//    public void onClickButtonT(View view){
//        answer = answer + 'T';
//        updateScreen(findViewById(R.id.answerScreen));
//        check();
//    }

    public void onClickButtonW(View view){
        answer = answer + 'W';
        updateScreen(findViewById(R.id.answerScreen));
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
        Toast.makeText(getApplicationContext(),"Congratulations! Your answer(FLOWER) is correct. You have passed this level.",Toast.LENGTH_LONG).show();
        mCountDownTimer.cancel();
        timeCancel = true;

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

    public void onClickButtonClear(View view){
        clear();
    }

    //Clear the current answer and display.
    public void clear(){
        answer = "";
        updateScreen(findViewById(R.id.answerScreen));
    }

    //Return to the last activity.
    public void onClickButtonBack(View view){
        mCountDownTimer.cancel();
        timeCancel = true;
        finish();
    }

    //Show the hint.
    public void onClickButtonHelp(View view){
        TextView tv = findViewById(R.id.textViewLevelOneHint);
        tv.setText("Hint: This item appeared in the previous scene.");
    }

    //Skip this level.
    public void onClickButtonSkip(View view){
        checkedRightAnswer();
    }

    public void updateScreen(View view){
        TextView tv = view.findViewById(R.id.answerScreen);
        tv.setText(answer);
    }

    //Cancel the timer if this activity is finished.
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (mCountDownTimer != null){
            timeCancel = true;
            mCountDownTimer.cancel();
        }
    }

}
