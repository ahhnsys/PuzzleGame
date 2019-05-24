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
import com.example.assignapp2019s1.Storyboard.FirstCaveActivity;

/**The 11st level (replace the 4th level)
 * @author Yishun Shi*/
public class PuzzleElevenActivity extends AppCompatActivity {

//    private String solution = "GITLAB";
    private String solution = "DARKNESS";

    private String answer = "";

    public CountDownTimer mCountDownTimer11;

    public boolean timeCancel11 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_eleven);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        iniTimer();
    }

    public void iniTimer(){

        if (mCountDownTimer11!=null){
            mCountDownTimer11.cancel();
        }

        mCountDownTimer11 = new CountDownTimer(300000+500, 1000) {

            TextView tvt11 = findViewById(R.id.textViewTimer11) ;

            public void onTick(long millisUntilFinished) {
                if(!PuzzleElevenActivity.this.isFinishing()){
                    tvt11.setText("seconds remaining: " + millisUntilFinished / 1000);
                    if (timeCancel11)
                        this.cancel();
                }
            }

            public void onFinish() {
                tvt11.setText("Time is up!");
                Toast.makeText(getApplicationContext(),"Time is up and you haven't solved this puzzle yet. Try it again!",Toast.LENGTH_LONG).show();
                finish();
            }
        };
        mCountDownTimer11.start();
    }

    public void onClickButtonA11(View view){
        answer = answer + 'A';
        updateScreen(findViewById(R.id.answerScreen11));
        check();
    }

//    public void onClickButtonB11(View view){
//        answer = answer + 'B';
//        updateScreen(findViewById(R.id.answerScreen11));
//        check();
//    }

    public void onClickButtonD11(View view){
        answer = answer + 'D';
        updateScreen(findViewById(R.id.answerScreen11));
        check();
    }

    public void onClickButtonE11(View view){
        answer = answer + 'E';
        updateScreen(findViewById(R.id.answerScreen11));
        check();
    }

    public void onClickButtonK11(View view){
        answer = answer + 'K';
        updateScreen(findViewById(R.id.answerScreen11));
        check();
    }

    public void onClickButtonN11(View view){
        answer = answer + 'N';
        updateScreen(findViewById(R.id.answerScreen11));
        check();
    }

    public void onClickButtonR11(View view){
        answer = answer + 'R';
        updateScreen(findViewById(R.id.answerScreen11));
        check();
    }

    public void onClickButtonS11(View view){
        answer = answer + 'S';
        updateScreen(findViewById(R.id.answerScreen11));
        check();
    }

//    public void onClickButtonG11(View view){
//        answer = answer + 'G';
//        updateScreen(findViewById(R.id.answerScreen11));
//        check();
//    }
//
//    public void onClickButtonI11(View view){
//        answer = answer + 'I';
//        updateScreen(findViewById(R.id.answerScreen11));
//        check();
//    }
//
//    public void onClickButtonL11(View view){
//        answer = answer + 'L';
//        updateScreen(findViewById(R.id.answerScreen11));
//        check();
//    }
//
//    public void onClickButtonT11(View view){
//        answer = answer + 'T';
//        updateScreen(findViewById(R.id.answerScreen11));
//        check();
//    }

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
        Toast.makeText(getApplicationContext(),"Congratulations! Your answer(DARKNESS) is correct. You have passed this level.",Toast.LENGTH_LONG).show();
        mCountDownTimer11.cancel();
        timeCancel11 = true;

        //authored by Natalie Phan
        //sends data that puzzle has been completed to original class
        Intent intent = new Intent(this, FirstCaveActivity.class);
        intent.putExtra("sendData",0);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }

    public void checkedWrongAnswer(){
        Toast.makeText(getApplicationContext(),"Sorry! Your answer is not correct. Try it again!",Toast.LENGTH_SHORT).show();
        clear();
    }

    public void onClickButtonClear11(View view){
        clear();
    }

    public void clear(){
        answer = "";
        updateScreen(findViewById(R.id.answerScreen11));
    }

    public void onClickButtonBack11(View view){
        mCountDownTimer11.cancel();
        timeCancel11 = true;
        finish();
    }

    public void onClickButtonHelp11(View view){
        TextView tv = findViewById(R.id.textViewLevelElevenHint);
        tv.setText("Hint: Fear often appears with it.");
    }

    public void onClickButtonSkip11(View view){
        checkedRightAnswer();
    }

    public void updateScreen(View view){
        TextView tv11 = view.findViewById(R.id.answerScreen11);
        tv11.setText(answer);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (mCountDownTimer11 != null){
            timeCancel11 = true;
            mCountDownTimer11.cancel();
        }
    }

}
