package com.example.assignapp2019s1.Storyboard;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.assignapp2019s1.R;
import com.example.assignapp2019s1.puzzles.PuzzleFiveActivity;

public class FirstCaveActivity extends AppCompatActivity {

    public ImageView orangeKey = (ImageView) findViewById(R.id.orangeKey);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_cave);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ImageButton upButton = (ImageButton) findViewById(R.id.imageButtonUp);
        ImageButton downButton = (ImageButton) findViewById(R.id.imageButtonDown);
        ImageButton leftButton = (ImageButton) findViewById(R.id.imageButtonLeft);
        ImageButton rightButton = (ImageButton) findViewById(R.id.imageButtonRight);

        FirstCaveActivity.MyTouchListener touchListener = new FirstCaveActivity.MyTouchListener();
        upButton.setOnTouchListener(touchListener);
        downButton.setOnTouchListener(touchListener);
        leftButton.setOnTouchListener(touchListener);
        rightButton.setOnTouchListener(touchListener);

        orangeKey.setVisibility(View.INVISIBLE);
    }

    float characterX;
    float characterY;



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

    //incomplete
    public void onClickButtonA(View v) {
        final ImageView character = (ImageView) findViewById(R.id.character);

        int[] imageCoordinates = new int[2];
        character.getLocationOnScreen(imageCoordinates);

        int x = imageCoordinates[0];
        int y = imageCoordinates[1];

        if (x >= 454 && x <= 477 && y >= 295 && y <= 325) {
                Intent puzzle5 = new Intent(this, PuzzleFiveActivity.class);
                startActivity(puzzle5);
         } else if (x >=  1924 && x <= 2314 && y <= 50) {
            Intent nextScreen = new Intent(this, SecondCaveActivity.class);
            startActivity(nextScreen);
        }
    }

}

