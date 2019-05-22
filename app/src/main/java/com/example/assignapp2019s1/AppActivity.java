package com.example.assignapp2019s1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.assignapp2019s1.Storyboard.FirstBeachActivity;
import com.example.assignapp2019s1.Storyboard.FirstCaveActivity;
import com.example.assignapp2019s1.Storyboard.FirstForestActivity;
import com.example.assignapp2019s1.Storyboard.SecondBeachActivity;
import com.example.assignapp2019s1.Storyboard.SecondForestActivity;
import com.example.assignapp2019s1.puzzles.PuzzleEightActivity;
import com.example.assignapp2019s1.puzzles.PuzzleOneActivity;
import com.example.assignapp2019s1.puzzles.PuzzleTwoActivity;
import com.example.assignapp2019s1.puzzles.PuzzleThreeActivity;
import com.example.assignapp2019s1.puzzles.PuzzleFourActivity;
import com.example.assignapp2019s1.puzzles.PuzzleEightActivity;
import com.example.assignapp2019s1.puzzles.PuzzleFiveActivity;

public class AppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    public void onClickButtonLevelOne(View view){
        Intent intent = new Intent(this, PuzzleOneActivity.class);
        startActivity(intent);
    }

    public void onClickButtonLevelTwo(View view){
        Intent intent = new Intent(this, PuzzleTwoActivity.class);
        startActivity(intent);
    }

    public void onClickButtonLevelThree(View view){
        Intent intent = new Intent(this, PuzzleThreeActivity.class);
        startActivity(intent);
    }

    public void onClickButtonLevelFour(View view){
        Intent intent = new Intent(this, PuzzleFourActivity.class);
        startActivity(intent);
    }

    public void onClickButtonGameplay(View view){
        Intent intent = new Intent(this, FirstBeachActivity.class);
        startActivity(intent);
    }

    public void onClickButtonLevelEight(View view){
        Intent intent = new Intent(this, PuzzleEightActivity.class);
        startActivity(intent);
    }

    public void onClickButtonLevelFive(View view){
        Intent intent = new Intent(this, PuzzleFiveActivity.class);
        startActivity(intent);
    }
}
