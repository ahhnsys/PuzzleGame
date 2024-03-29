package com.example.assignapp2019s1.puzzles;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignapp2019s1.R;
import com.example.assignapp2019s1.Storyboard.SecondBeachActivity;

/**The 8th level
 * @author Yishun Shi*/
public class PuzzleEightActivity extends AppCompatActivity {

    private static Tokenizer tokenizer;
    private static Parser parser;

    //parse the user's input
//    private static Integer parse(String equation) {
    public static Integer parse(String equation) {
//        System.out.println("Parsing equation: " + equation);
        tokenizer.setBuffer(equation);
        Exp exp = parser.parse();
        if(exp==null) {
            return null;
        } else {
            return exp.value();
        }
    }

    //user's current answer
    private String answer = "";

    //timer
    public CountDownTimer mCountDownTimer8;

    public boolean timeCancel8 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_eight);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        iniTimer();
    }

    //initialize timer
    public void iniTimer(){

        if (mCountDownTimer8!=null){
            mCountDownTimer8.cancel();
        }

        //set 5 minutes, modify display every second
        mCountDownTimer8 = new CountDownTimer(300000+500, 1000) {

            TextView tvt8 = findViewById(R.id.textViewTimer8) ;

            //activity per second
            public void onTick(long millisUntilFinished) {
                if(!PuzzleEightActivity.this.isFinishing()){
                    tvt8.setText("seconds remaining: " + millisUntilFinished / 1000);
                    if (timeCancel8==true)
                        this.cancel();
                }
            }

            //activity when time is up
            public void onFinish() {
                tvt8.setText("Time is up!");
                Toast.makeText(getApplicationContext(),"Time is up and you haven't solved this puzzle yet. Try it again!",Toast.LENGTH_LONG).show();
                finish();
            }
        };
        mCountDownTimer8.start();
    }


    //check whether the answer is correct
    public void check(){
        EditText etLevel8 = findViewById(R.id.answerInput);
        tokenizer = new Tokenizer();
        parser = new Parser(tokenizer);
        Integer result;
        Integer rightResult = Integer.valueOf(24);

        answer = etLevel8.getText().toString();
        result = parse(answer);

        if (result.equals(rightResult) && answer.contains("1") && answer.contains("4") && answer.contains("6") && answer.contains("7")){
            checkedRightAnswer();
        }
        else {
            checkedWrongAnswer();
        }
    }

    //If answer is correct, cancel the timer and complete this level.
    public void checkedRightAnswer(){
        Toast.makeText(getApplicationContext(),"Congratulations! Your answer is correct. You have passed this level.",Toast.LENGTH_LONG).show();
        mCountDownTimer8.cancel();
        timeCancel8 = true;

        //authored by Natalie Phan
        //sends data that puzzle has been completed to original class
        Intent intent = new Intent(this, SecondBeachActivity.class);
        intent.putExtra("sendData",0);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }

    //If the answer is wrong, clear the current answer.
    public void checkedWrongAnswer(){
        Toast.makeText(getApplicationContext(),"Sorry! Your answer is not correct. Try it again!",Toast.LENGTH_SHORT).show();
        clear();
    }

    public void onClickButtonClear8(View view){
        clear();
    }

    //Clear the current answer.
    public void clear(){
        answer = "";
        updateScreen(findViewById(R.id.answerInput));
    }

    //Return to the last activity.
    public void onClickButtonBack8(View view){
        mCountDownTimer8.cancel();
        timeCancel8 = true;
        finish();
    }

    public void onClickButtonCheck8(View view){
        check();
    }

    //Skip this level.
    public void onClickButtonSkip8(View view){
        checkedRightAnswer();
    }

    public void updateScreen(View view){
        EditText et8 = view.findViewById(R.id.answerInput);
        et8.setText(answer);
    }

    //Cancel the timer if this activity is finished.
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (mCountDownTimer8 != null){
            timeCancel8 = true;
            mCountDownTimer8.cancel();
        }
    }

}
