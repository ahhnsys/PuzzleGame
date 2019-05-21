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
import com.example.assignapp2019s1.puzzles.PuzzleOneActivity;
import com.example.assignapp2019s1.puzzles.PuzzleSixActivity;
import com.example.assignapp2019s1.puzzles.PuzzleTwoActivity;

import static android.view.View.VISIBLE;


//authored by Natalie
//https://stackoverflow.com/questions/17864143/single-method-to-implement-ontouchlistener-for-multiple-buttons
public class FirstBeachActivity extends AppCompatActivity {

    float characterX;
    float characterY;

    ImageView yellowKey = (ImageView) findViewById(R.id.yellowKey);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_beach);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ImageButton upButton = (ImageButton) findViewById(R.id.imageButtonUp);
        ImageButton downButton = (ImageButton) findViewById(R.id.imageButtonDown);
        ImageButton leftButton = (ImageButton) findViewById(R.id.imageButtonLeft);
        ImageButton rightButton = (ImageButton) findViewById(R.id.imageButtonRight);

        MyTouchListener touchListener = new MyTouchListener();
        upButton.setOnTouchListener(touchListener);
        downButton.setOnTouchListener(touchListener);
        leftButton.setOnTouchListener(touchListener);
        rightButton.setOnTouchListener(touchListener);

        ImageView imageView = (ImageView) findViewById(R.id.character);

        yellowKey.setVisibility(View.INVISIBLE);

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
        final int[] characterBackAnimation = new int[]{R.drawable.character_bo_back, R.drawable.character_bo_back_walking, R.drawable.character_bo_back_walking2};
        character.setImageResource(R.drawable.character_bo_back);

    }


    public void onClickButtonDown(View v) {
        ImageView character = (ImageView) findViewById(R.id.character);
        characterY = character.getY();
        characterY += 10;
        character.setY(characterY);
        character.setImageResource(R.drawable.character_bo);
    }

    public void onClickButtonLeft(View v) {
        ImageView character = (ImageView) findViewById(R.id.character);
        characterX = character.getX();
        characterX -= 10;
        character.setX(characterX);
        character.setImageResource(R.drawable.character_bo_left);
    }

    public void onClickButtonRight(View v) {
        ImageView character = (ImageView) findViewById(R.id.character);
        characterX = character.getX();
        characterX += 10;
        character.setX(characterX);
        character.setImageResource(R.drawable.character_bo_right);
    }

    public boolean gotShovel(View v) {
        return false;
    }

    //incomplete
    public void onClickButtonGreyA (View v) {
        ImageView character = (ImageView) findViewById(R.id.character);

        int[] imageCoordinates = new int[2];
        character.getLocationOnScreen(imageCoordinates);

        int x = imageCoordinates[0];
        int y = imageCoordinates[1];

        if (x >= 454 && x <= 477 && y >= 295 && y <= 325) {
            Intent puzzle6 = new Intent(this, PuzzleSixActivity.class);
            startActivity(puzzle6);
        } else if (x >=  1924 && x <= 2314 && y <= 50) {
            Intent nextScreen = new Intent(this, SecondBeachActivity.class);
            startActivity(nextScreen);
        }
    }
}
