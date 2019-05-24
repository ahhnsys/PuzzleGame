package com.example.assignapp2019s1.Storyboard;

//authored by Natalie Phan
import android.app.Activity;
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

import com.example.assignapp2019s1.BackgroundMusic;
import com.example.assignapp2019s1.R;
import com.example.assignapp2019s1.puzzles.PuzzleThreeActivity;

import static android.view.View.VISIBLE;

/*
    This activity is contains the controls and methods for the Forest Map of the story. It is the second part of the first map.
 */
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

        ImageView greenKey = (ImageView) findViewById(R.id.greenKey); //gets the id of image
        greenKey.setVisibility(View.VISIBLE); //sets the visibility to invisible until needed

        ImageView flashlight = (ImageView)  findViewById(R.id.flashlight);
        flashlight.setVisibility(View.INVISIBLE);

        //set touch for buttons
        //https://stackoverflow.com/questions/17864143/single-method-to-implement-ontouchlistener-for-multiple-buttons
        SecondForestActivity.MyTouchListener touchListener = new SecondForestActivity.MyTouchListener();
        upButton.setOnTouchListener(touchListener);
        downButton.setOnTouchListener(touchListener);
        leftButton.setOnTouchListener(touchListener);
        rightButton.setOnTouchListener(touchListener);

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

    //defines actions for buttons
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

    //moves the image north on the Y axis
    public void onClickButtonUp(View v) {
        final ImageView character = (ImageView) findViewById(R.id.character);
        characterY = character.getY();
        characterY -= 10;
        character.setY(characterY);
        character.setImageResource(R.drawable.character_bo_back);
    }

    //moves the image south on the Y axis
    public void onClickButtonDown(View v) {
        final ImageView character = (ImageView) findViewById(R.id.character);
        characterY = character.getY();
        characterY += 10;
        character.setY(characterY);
        character.setImageResource(R.drawable.character_bo);
    }

    //moves the image west on the X axis
    public void onClickButtonLeft(View v) {
        final ImageView character = (ImageView) findViewById(R.id.character);
        characterX = character.getX();
        characterX -= 10;
        character.setX(characterX);
        character.setImageResource(R.drawable.character_bo_left);
    }

    //moves the image east on the X axis
    public void onClickButtonRight(View v) {
        final ImageView character = (ImageView) findViewById(R.id.character);
        characterX = character.getX();
        characterX += 10;
        character.setX(characterX);
        character.setImageResource(R.drawable.character_bo_right);
    }

    //intents to other activities
    public void onClickButtonGreyA(View v) {
        final ImageView character = (ImageView) findViewById(R.id.character);

        int[] imageCoordinates = new int[2];
        character.getLocationOnScreen(imageCoordinates);

        int x = imageCoordinates[0];
        int y = imageCoordinates[1];

        if (x >= 1130 && x <= 1175 && y >= 275 && y <= 350) {
                if (gotGreenKey()) {
                    Intent puzzle3 = new Intent(this, PuzzleThreeActivity.class);
                    startActivityForResult(puzzle3,0);
                } else {
                    Toast.makeText(getApplicationContext(), "I need a green key...", Toast.LENGTH_LONG).show();
                }
        } else if (x >= 100 && y >= 450 && y <= 550) {
            if (gotFlashlight()) {
                Intent cave = new Intent(this, FirstCaveActivity.class);
                startActivity(cave);
            } else {
                Toast.makeText(getApplicationContext(), "It's too dark, I need a light...", Toast.LENGTH_LONG).show();
            }
        }

    }

    //checks whether image is viewable on screen
    private boolean gotGreenKey() {
        ImageView greenKey = (ImageView) findViewById(R.id.greenKey);
        return greenKey.getVisibility() == VISIBLE;
    }

    private boolean gotFlashlight() {
        ImageView flashlight = (ImageView) findViewById(R.id.flashlight);
        return flashlight.getVisibility() == VISIBLE;
    }

    //gets data which has been sent from another activity without restarting this activity and sets images according to the result
    //https://stackoverflow.com/questions/10407159/how-to-manage-startactivityforresult-on-android
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ImageView flashlight = (ImageView) findViewById(R.id.flashlight);
        if (requestCode == 0) {
            if (resultCode == Activity.RESULT_OK) {
                int getData = data.getIntExtra("sendData", -1);
                if (getData == 0) {
                    flashlight.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"Found a Flashlight!",Toast.LENGTH_LONG).show();
                }
            }
        }
    }
    public void onClickSoundOff(View v) {
        ImageButton sound = (ImageButton)findViewById(R.id.soundOff);
        Intent intent = new Intent(this,BackgroundMusic.class);
        stopService(intent);
    }

    public void onClickSoundOn(View v) {
        ImageButton sound = (ImageButton)findViewById(R.id.soundOn);
        Intent intent = new Intent(this,BackgroundMusic.class);
        startService(intent);
    }

}

