package com.example.assignapp2019s1.puzzles;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignapp2019s1.R;
import com.example.assignapp2019s1.Storyboard.FirstBeachActivity;

import java.util.Set;
import java.util.TreeSet;

/**The 7th level
 * @author Yishun Shi*/
public class PuzzleSevenActivity extends AppCompatActivity {

    //prepare possible correct answers
    private Set<String> solutions = new TreeSet<String>(){{
        add("ARMET");
        add("ASTER");
        add("MARES");
        add("MARTS");
        add("MATER");
        add("MATES");
        add("MEATS");
        add("RAMET");
        add("RATES");
        add("REAMS");
        add("REAST");
        add("RESAT");
        add("SMART");
        add("SMEAR");
        add("STARE");
        add("STEAM");
        add("TAMER");
        add("TAMES");
        add("TARES");
        add("TASER");
        add("TEAMS");
        add("TEARS");
        add("TERMS");
        add("TRAMS");
    }};

    private Set<String> answers = new TreeSet<String>();

    private String currentAnswer = "";

    public CountDownTimer mCountDownTimer7;

    public boolean timeCancel7 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_seven);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        iniTimer();
    }

    public void iniTimer(){

        if (mCountDownTimer7!=null){
            mCountDownTimer7.cancel();
        }

        mCountDownTimer7 = new CountDownTimer(300000+500, 1000) {

            TextView tvt7 = findViewById(R.id.textViewTimer7) ;

            public void onTick(long millisUntilFinished) {
                if(!PuzzleSevenActivity.this.isFinishing()){
                    tvt7.setText("seconds remaining: " + millisUntilFinished / 1000);
                    if (timeCancel7==true)
                        this.cancel();
                }
            }

            public void onFinish() {
                tvt7.setText("Time is up!");
                Toast.makeText(getApplicationContext(),"Time is up and you haven't solved this puzzle yet. Try it again!",Toast.LENGTH_LONG).show();
                finish();
            }
        };
        mCountDownTimer7.start();
    }

    public void onClickButtonA7(View view){
        currentAnswer = currentAnswer + 'A';
        updateScreen(findViewById(R.id.answerScreen7));
        check();
    }

    public void onClickButtonE7(View view){
        currentAnswer = currentAnswer + 'E';
        updateScreen(findViewById(R.id.answerScreen7));
        check();
    }

    public void onClickButtonM7(View view){
        currentAnswer = currentAnswer + 'M';
        updateScreen(findViewById(R.id.answerScreen7));
        check();
    }

    public void onClickButtonR7(View view){
        currentAnswer = currentAnswer + 'R';
        updateScreen(findViewById(R.id.answerScreen7));
        check();
    }

    public void onClickButtonS7(View view){
        currentAnswer = currentAnswer + 'S';
        updateScreen(findViewById(R.id.answerScreen7));
        check();
    }

    public void onClickButtonT7(View view){
        currentAnswer = currentAnswer + 'T';
        updateScreen(findViewById(R.id.answerScreen7));
        check();
    }


    public void check(){
        if (currentAnswer.length() == 5){
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
        TextView tvc = findViewById(R.id.textViewLevelSevenCount);
        tvc.setText("Number of words found: " + answers.size());
        clear();
        if (answers.size() >= 5){
            Toast.makeText(getApplicationContext(),"Congratulations! You have found enough words. You have passed this level.",Toast.LENGTH_LONG).show();
            mCountDownTimer7.cancel();
            timeCancel7 = true;

            //authored by Natalie Phan
            //sends data that puzzle has been completed to original class
            Intent intent = new Intent(this, FirstBeachActivity.class);
            intent.putExtra("sendData",0);
            setResult(Activity.RESULT_OK,intent);
            finish();
        }
    }

    public void checkedWrongAnswer(){
        Toast.makeText(getApplicationContext(),"Sorry! Your answer is not correct. Try it again!",Toast.LENGTH_SHORT).show();
        clear();
    }

    public void onClickButtonClear7(View view){
        clear();
    }

    public void clear(){
        currentAnswer = "";
        updateScreen(findViewById(R.id.answerScreen7));
    }

    public void onClickButtonBack7(View view){
        mCountDownTimer7.cancel();
        timeCancel7 = true;
        finish();
    }

    public void onClickButtonSkip7(View view){
        mCountDownTimer7.cancel();
        timeCancel7 = true;
        finish();
    }

    public void updateScreen(View view){
        TextView tv = view.findViewById(R.id.answerScreen7);
        tv.setText(currentAnswer);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (mCountDownTimer7 != null){
            timeCancel7 = true;
            mCountDownTimer7.cancel();
        }
    }

}
