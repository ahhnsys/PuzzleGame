package com.example.assignapp2019s1.puzzles;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignapp2019s1.R;

public class PuzzleOneActivity extends AppCompatActivity {

    private String solution = "SOFTWARE";

    private String answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_one);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    public void onClickButtonA(View view){
        answer = answer + 'A';
        updateScreen(findViewById(R.id.answerScreen));
        check();
    }

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

    public void onClickButtonS(View view){
        answer = answer + 'S';
        updateScreen(findViewById(R.id.answerScreen));
        check();
    }

    public void onClickButtonT(View view){
        answer = answer + 'T';
        updateScreen(findViewById(R.id.answerScreen));
        check();
    }

    public void onClickButtonW(View view){
        answer = answer + 'W';
        updateScreen(findViewById(R.id.answerScreen));
        check();
    }

    public void check(){
        if (answer.length() == 8){
            if (answer.equals(solution)){
                checkedRightAnswer();
            }
            else {
                checkedWrongAnswer();
            }
        }
    }

    public void checkedRightAnswer(){
        Toast.makeText(getApplicationContext(),"Congratulations! Your answer(SOFTWARE) is correct. You have passed this level.",Toast.LENGTH_LONG).show();
        finish();
    }

    public void checkedWrongAnswer(){
        Toast.makeText(getApplicationContext(),"Sorry! Your answer is not correct. Try it again!",Toast.LENGTH_SHORT).show();
        clear();
    }

    public void onClickButtonClear(View view){
        clear();
    }

    public void clear(){
        answer = "";
        updateScreen(findViewById(R.id.answerScreen));
    }

    public void onClickButtonBack(View view){
        finish();
    }

    public void onClickButtonHelp(View view){
        TextView tv = findViewById(R.id.textViewLevelOneHint);
        tv.setText("Hint: This word is related to the computer");
    }

    public void onClickButtonSkip(View view){
        checkedRightAnswer();
    }

    public void updateScreen(View view){
        TextView tv = view.findViewById(R.id.answerScreen);
        tv.setText(answer);
    }


}
