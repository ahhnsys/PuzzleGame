package com.example.assignapp2019s1.puzzles;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignapp2019s1.R;

public class PuzzleFourActivity extends AppCompatActivity {

    EditText et16 = findViewById(R.id.editText16);
    EditText et17 = findViewById(R.id.editText17);
    EditText et19 = findViewById(R.id.editText19);
    EditText et21 = findViewById(R.id.editText21);
    EditText et25 = findViewById(R.id.editText25);
    EditText et27 = findViewById(R.id.editText27);
    EditText et28 = findViewById(R.id.editText28);
    EditText et31 = findViewById(R.id.editText31);
    EditText et33 = findViewById(R.id.editText33);
    EditText et34 = findViewById(R.id.editText34);
    EditText et36 = findViewById(R.id.editText36);
    EditText et41 = findViewById(R.id.editText41);
    EditText et42 = findViewById(R.id.editText42);
    EditText et43 = findViewById(R.id.editText43);
    EditText et44 = findViewById(R.id.editText44);
    EditText et47 = findViewById(R.id.editText47);
    EditText et49 = findViewById(R.id.editText49);
    EditText et53 = findViewById(R.id.editText53);
    EditText et55 = findViewById(R.id.editText55);
    EditText et62 = findViewById(R.id.editText62);
    EditText et63 = findViewById(R.id.editText63);
    EditText et65 = findViewById(R.id.editText65);
    EditText et67 = findViewById(R.id.editText67);
    EditText et68 = findViewById(R.id.editText68);
    EditText et74 = findViewById(R.id.editText74);
    EditText et78 = findViewById(R.id.editText78);
    EditText et85 = findViewById(R.id.editText85);
    EditText et88 = findViewById(R.id.editText88);
    EditText et89 = findViewById(R.id.editText89);
    EditText et92 = findViewById(R.id.editText92);
    EditText et93 = findViewById(R.id.editText93);
    EditText et94 = findViewById(R.id.editText94);
    EditText et95 = findViewById(R.id.editText95);
    EditText et98 = findViewById(R.id.editText98);
    EditText et99 = findViewById(R.id.editText99);

    public CountDownTimer mCountDownTimer4;

    public boolean timeCancel4 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_four);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        iniTimer();
    }

    public void iniTimer(){

        if (mCountDownTimer4!=null){
            mCountDownTimer4.cancel();
        }

        mCountDownTimer4 = new CountDownTimer(1200000+500, 1000) {

            TextView tvt4 = findViewById(R.id.textViewTimer4) ;

            public void onTick(long millisUntilFinished) {
                if(!PuzzleFourActivity.this.isFinishing()){
                    tvt4.setText("seconds remaining: " + millisUntilFinished / 1000);
//                    check();
                    if (timeCancel4)
                        this.cancel();
                }
            }

            public void onFinish() {
                tvt4.setText("Time is up!");
                Toast.makeText(getApplicationContext(),"Time is up and you haven't solved this puzzle yet. Try it again!",Toast.LENGTH_LONG).show();
                finish();
            }
        };
        mCountDownTimer4.start();
    }

    public void onClickButtonCheck4(View view){
        check();
    }


    public void check(){
        if (et16.getText().toString().equals("6") && et17.getText().toString().equals("4") && et19.getText().toString().equals("7") && et21.getText().toString().equals("3") && et25.getText().toString().equals("2")
                && et27.getText().toString().equals("6") && et28.getText().toString().equals("9") && et31.getText().toString().equals("6") && et33.getText().toString().equals("1") && et34.getText().toString().equals("4")
                && et36.getText().toString().equals("8") && et41.getText().toString().equals("8") && et42.getText().toString().equals("4") && et43.getText().toString().equals("3") && et44.getText().toString().equals("6")
                && et47.getText().toString().equals("7") && et49.getText().toString().equals("9") && et53.getText().toString().equals("5") && et55.getText().toString().equals("8") && et62.getText().toString().equals("6")
                && et63.getText().toString().equals("2") && et65.getText().toString().equals("5") && et67.getText().toString().equals("8") && et68.getText().toString().equals("4") && et74.getText().toString().equals("2")
                && et78.getText().toString().equals("7") && et85.getText().toString().equals("6") && et88.getText().toString().equals("8") && et89.getText().toString().equals("5") && et92.getText().toString().equals("1")
                && et93.getText().toString().equals("6") && et94.getText().toString().equals("8") && et95.getText().toString().equals("7") && et98.getText().toString().equals("3") && et99.getText().toString().equals("4")){
            checkedRightAnswer();
        }
        else {
            Toast.makeText(getApplicationContext(),"Sorry! Your answer is not correct. Try it again!",Toast.LENGTH_SHORT).show();
        }
    }

    public void checkedRightAnswer(){
        Toast.makeText(getApplicationContext(),"Congratulations! Your answer is correct. You have passed this level.",Toast.LENGTH_LONG).show();
        mCountDownTimer4.cancel();
        timeCancel4 = true;
        finish();
    }

    public void onClickButtonClear4(View view){
        clear();
    }

    public void clear(){
        et16.setText("");
        et17.setText("");
        et19.setText("");
        et21.setText("");
        et25.setText("");
        et27.setText("");
        et28.setText("");
        et31.setText("");
        et33.setText("");
        et34.setText("");
        et36.setText("");
        et41.setText("");
        et42.setText("");
        et43.setText("");
        et44.setText("");
        et47.setText("");
        et49.setText("");
        et53.setText("");
        et55.setText("");
        et62.setText("");
        et63.setText("");
        et65.setText("");
        et67.setText("");
        et68.setText("");
        et74.setText("");
        et78.setText("");
        et85.setText("");
        et88.setText("");
        et89.setText("");
        et92.setText("");
        et93.setText("");
        et94.setText("");
        et95.setText("");
        et98.setText("");
        et99.setText("");
    }

    public void onClickButtonBack4(View view){
        mCountDownTimer4.cancel();
        timeCancel4 = true;
        finish();
    }

    public void onClickButtonSkip4(View view){
        checkedRightAnswer();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (mCountDownTimer4 != null){
            timeCancel4 = true;
            mCountDownTimer4.cancel();
        }
    }

}
