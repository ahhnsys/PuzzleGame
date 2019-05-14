package com.example.assignapp2019s1.puzzles;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignapp2019s1.R;

public class PuzzleTwoActivity extends AppCompatActivity {

    private String solution = "FOREST";

    private String answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_two);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

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
        Toast.makeText(getApplicationContext(),"Congratulations! Your answer(FOREST) is correct. You have passed this level.",Toast.LENGTH_LONG).show();
        finish();
    }

    public void checkedWrongAnswer(){
        Toast.makeText(getApplicationContext(),"Sorry! Your answer is not correct. Try it again!",Toast.LENGTH_SHORT).show();
        clear();
    }

    public void onClickButtonClear2(View view){
        clear();
    }

    public void clear(){
        answer = "";
        updateScreen(findViewById(R.id.answerScreen2));
    }

    public void onClickButtonBack2(View view){
        finish();
    }

    public void onClickButtonHelp2(View view){
        TextView tv = findViewById(R.id.textViewLevelTwoHint);
        tv.setText("Hint: This word may be used in the data structure");
    }

    public void onClickButtonSkip2(View view){
        checkedRightAnswer();
    }

    public void updateScreen(View view){
        TextView tv = view.findViewById(R.id.answerScreen2);
        tv.setText(answer);
    }


}
