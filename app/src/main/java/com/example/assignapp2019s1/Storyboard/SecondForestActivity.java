package com.example.assignapp2019s1.Storyboard;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.assignapp2019s1.R;
import com.example.assignapp2019s1.puzzles.PuzzleOneActivity;
import com.example.assignapp2019s1.puzzles.PuzzleThreeActivity;
import com.example.assignapp2019s1.puzzles.PuzzleTwoActivity;

public class SecondForestActivity extends AppCompatActivity {
    float characterX;
    float characterY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_forest);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ImageButton upButton = (ImageButton) findViewById(R.id.imageButtonUp);
        ImageButton downButton = (ImageButton) findViewById(R.id.imageButtonDown);
        ImageButton leftButton = (ImageButton) findViewById(R.id.imageButtonLeft);
        ImageButton rightButton = (ImageButton) findViewById(R.id.imageButtonRight);

        SecondForestActivity.MyTouchListener touchListener = new SecondForestActivity.MyTouchListener();
        upButton.setOnTouchListener(touchListener);
        downButton.setOnTouchListener(touchListener);
        leftButton.setOnTouchListener(touchListener);
        rightButton.setOnTouchListener(touchListener);

        ImageView imageView = (ImageView) findViewById(R.id.character);
        int[] values = new int[2];
        imageView.getLocationOnScreen(values);
        Log.d("X & Y",values[0]+" "+values[1]);
    }

    public class MyTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (v.getId()) {
                case R.id.imageButtonUp:
                    onClickButtonUp(v);
                    break;
                case R.id.imageButtonDown:
                    onClickButtonDown(v);
                    break;
                case R.id.imageButtonLeft:
                    onClickButtonLeft(v);
                    break;
                case R.id.imageButtonRight:
                    onClickButtonRight(v);
                    break;
                case R.id.imageButtonA:
                    onClickButtonA(v);
                    break;
                default:
                    break;
            }
            return true;
        }
    }

    public void onClickButtonUp(View v) {
        final ImageView character = (ImageView) findViewById(R.id.character);
        characterY = character.getY();
        characterY -= 10;
        character.setY(characterY);
        character.setImageResource(R.drawable.character_bo_back);
    }

    public void onClickButtonDown(View v) {
        final ImageView character = (ImageView) findViewById(R.id.character);
        characterY = character.getY();
        characterY += 10;
        character.setY(characterY);
        character.setImageResource(R.drawable.character_bo);
    }

    public void onClickButtonLeft(View v) {
        final ImageView character = (ImageView) findViewById(R.id.character);
        characterX = character.getX();
        characterX -= 10;
        character.setX(characterX);
        character.setImageResource(R.drawable.character_bo_left);
    }

    public void onClickButtonRight(View v) {
        final ImageView character = (ImageView) findViewById(R.id.character);
        characterX = character.getX();
        characterX += 10;
        character.setX(characterX);
        character.setImageResource(R.drawable.character_bo_right);
    }

    private boolean gotGreenKey() {
        return false;
    }

    private boolean gotTorch() {
    return false;
    }

    //incomplete
    public void onClickButtonA(View v) {
        final ImageView character = (ImageView) findViewById(R.id.character);

        int[] imageCoordinates = new int[2];
        character.getLocationOnScreen(imageCoordinates);

        int x = imageCoordinates[0];
        int y = imageCoordinates[1];

        if (x >= 454 && x <= 477 && y >= 295 && y <= 325) {
                if (gotGreenKey()) {
                    Intent puzzle3 = new Intent(this, PuzzleThreeActivity.class);
                    startActivity(puzzle3);
                } else {
                    Toast.makeText(getApplicationContext(), "I need a green key...", Toast.LENGTH_SHORT).show();
                }
        } else if (x >= 1704 && x <= 1736 && y >= 494 && y <= 592) {
            if (gotTorch()) {
                Intent cave = new Intent(this, FirstCaveActivity.class);
                startActivity(cave);
            } else {
                Toast.makeText(getApplicationContext(), "It's too dark, I need a light...", Toast.LENGTH_SHORT).show();
            }
        }

    }

}

