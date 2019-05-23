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
import com.example.assignapp2019s1.Storyboard.SecondBeachActivity;

public class PuzzleNineActivity extends AppCompatActivity {

    private String solution = "STORE";

    private String answer = "";

    public CountDownTimer mCountDownTimer9;

    public boolean timeCancel9 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_nine);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        iniTimer();
    }

    public void iniTimer(){

        if (mCountDownTimer9!=null){
            mCountDownTimer9.cancel();
        }

        mCountDownTimer9 = new CountDownTimer(300000+500, 1000) {

            TextView tvt9 = findViewById(R.id.textViewTimer9) ;

            public void onTick(long millisUntilFinished) {
                if(!PuzzleNineActivity.this.isFinishing()){
                    tvt9.setText("seconds remaining: " + millisUntilFinished / 1000);
                    if (timeCancel9)
                        this.cancel();
                }
            }

            public void onFinish() {
                tvt9.setText("Time is up!");
                Toast.makeText(getApplicationContext(),"Time is up and you haven't solved this puzzle yet. Try it again!",Toast.LENGTH_LONG).show();
                finish();
            }
        };
        mCountDownTimer9.start();
    }

    public void onClickButtonA9(View view){
        answer = answer + 'A';
        updateScreen(findViewById(R.id.answerScreen9));
        check();
    }

    public void onClickButtonE9(View view){
        answer = answer + 'E';
        updateScreen(findViewById(R.id.answerScreen9));
        check();
    }

    public void onClickButtonF9(View view){
        answer = answer + 'F';
        updateScreen(findViewById(R.id.answerScreen9));
        check();
    }

    public void onClickButtonO9(View view){
        answer = answer + 'O';
        updateScreen(findViewById(R.id.answerScreen9));
        check();
    }

    public void onClickButtonR9(View view){
        answer = answer + 'R';
        updateScreen(findViewById(R.id.answerScreen9));
        check();
    }

    public void onClickButtonS9(View view){
        answer = answer + 'S';
        updateScreen(findViewById(R.id.answerScreen9));
        check();
    }

    public void onClickButtonT9(View view){
        answer = answer + 'T';
        updateScreen(findViewById(R.id.answerScreen9));
        check();
    }

    public void onClickButtonW9(View view){
        answer = answer + 'W';
        updateScreen(findViewById(R.id.answerScreen9));
        check();
    }

    public void check(){
        if (answer.length() == 5){
            if (answer.equals(solution)){
                checkedRightAnswer();
            }
            else {
                checkedWrongAnswer();
            }
        }
    }

    public void checkedRightAnswer(){
        Toast.makeText(getApplicationContext(),"Congratulations! Your answer(STORE) is correct. You have passed this level.",Toast.LENGTH_LONG).show();
        mCountDownTimer9.cancel();
        timeCancel9 = true;

        //authored by Natalie Phan
        //sends data that puzzle has been completed to original class
        Intent intent = new Intent(this, SecondBeachActivity.class);
        intent.putExtra("sendData",0);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }

    public void checkedWrongAnswer(){
        Toast.makeText(getApplicationContext(),"Sorry! Your answer is not correct. Try it again!",Toast.LENGTH_SHORT).show();
        clear();
    }

    public void onClickButtonClear9(View view){
        clear();
    }

    public void clear(){
        answer = "";
        updateScreen(findViewById(R.id.answerScreen9));
    }

    public void onClickButtonBack9(View view){
        mCountDownTimer9.cancel();
        timeCancel9 = true;
        finish();
    }

    public void onClickButtonHelp9(View view){
        TextView tv = findViewById(R.id.textViewLevelNineHint);
        tv.setText("Hint: The use of a disk.");
    }

    public void onClickButtonSkip9(View view){
        checkedRightAnswer();
    }

    public void updateScreen(View view){
        TextView tv = view.findViewById(R.id.answerScreen9);
        tv.setText(answer);
    }

    public void onClickImageButton9(View view){
        Button btnA = findViewById(R.id.buttonA9);
        btnA.setText("");
        Button btnF = findViewById(R.id.buttonF9);
        btnF.setText("");
        Button btnW = findViewById(R.id.buttonW9);
        btnW.setText("");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (mCountDownTimer9 != null){
            timeCancel9 = true;
            mCountDownTimer9.cancel();
        }
    }

}
