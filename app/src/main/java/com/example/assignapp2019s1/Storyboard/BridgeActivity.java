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

import com.example.assignapp2019s1.R;
import com.example.assignapp2019s1.puzzles.PuzzleTenActivity;



//authored by Natalie
//https://stackoverflow.com/questions/17864143/single-method-to-implement-ontouchlistener-for-multiple-buttons
public class BridgeActivity extends AppCompatActivity {

    float characterX;
    float characterY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridge);
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


        ImageView blueKey = (ImageView) findViewById(R.id.blueKey);
        blueKey.setVisibility(View.INVISIBLE);
        ImageView imageView = (ImageView) findViewById(R.id.character);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] values = new int[2];
                view.getLocationOnScreen(values);
                Log.d("X & Y",values[0]+" "+values[1]);
            }
        });

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

    //incomplete
    public void onClickButtonGreyA (View v) {
        ImageView character = (ImageView) findViewById(R.id.character);

        int[] imageCoordinates = new int[2];
        character.getLocationOnScreen(imageCoordinates);

        int x = imageCoordinates[0];
        int y = imageCoordinates[1];

        if (x >= 1354 && x <= 1443 && y >= 592 && y <= 692) {
            Intent puzzle10 = new Intent(this, PuzzleTenActivity.class);
            startActivity(puzzle10);
        }
    }

}