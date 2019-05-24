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
import com.example.assignapp2019s1.puzzles.PuzzleEightActivity;
import com.example.assignapp2019s1.puzzles.PuzzleNineActivity;

/*
    This activity is contains the controls and methods for the Beach Map of the story. It is the second part of the third map.
 */
public class SecondBeachActivity extends AppCompatActivity {

    float characterX;
    float characterY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_beach);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ImageButton upButton = (ImageButton) findViewById(R.id.imageButtonUp);
        ImageButton downButton = (ImageButton) findViewById(R.id.imageButtonDown);
        ImageButton leftButton = (ImageButton) findViewById(R.id.imageButtonLeft);
        ImageButton rightButton = (ImageButton) findViewById(R.id.imageButtonRight);

        //set touch for buttons
        //https://stackoverflow.com/questions/17864143/single-method-to-implement-ontouchlistener-for-multiple-buttons
        MyTouchListener touchListener = new MyTouchListener();
        upButton.setOnTouchListener(touchListener);
        downButton.setOnTouchListener(touchListener);
        leftButton.setOnTouchListener(touchListener);
        rightButton.setOnTouchListener(touchListener);

        ImageView imageView = (ImageView) findViewById(R.id.character); //gets the id of image

        ImageView purpleKey = (ImageView) findViewById(R.id.purpleKey);
        purpleKey.setVisibility(View.INVISIBLE); //sets the visibility to invisible until needed

        ImageView blueKey = (ImageView) findViewById(R.id.blueKey);
        blueKey.setVisibility(View.INVISIBLE);

        ImageView bridge = (ImageView) findViewById(R.id.bridge);
        bridge.setVisibility(View.INVISIBLE);
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
        ImageView character = (ImageView) findViewById(R.id.character);
        characterY = character.getY();
        characterY += 10;
        character.setY(characterY);
        character.setImageResource(R.drawable.character_bo);
    }

    //moves the image west on the X axis
    public void onClickButtonLeft(View v) {
        ImageView character = (ImageView) findViewById(R.id.character);
        characterX = character.getX();
        characterX -= 10;
        character.setX(characterX);
        character.setImageResource(R.drawable.character_bo_left);
    }

    //moves the image east on the X axis
    public void onClickButtonRight(View v) {
        ImageView character = (ImageView) findViewById(R.id.character);
        characterX = character.getX();
        characterX += 10;
        character.setX(characterX);
        character.setImageResource(R.drawable.character_bo_right);
    }

    //intents to other activities
    public void onClickButtonGreyA (View v) {
        ImageView character = (ImageView) findViewById(R.id.character);

        int[] imageCoordinates = new int[2];
        character.getLocationOnScreen(imageCoordinates);

        int x = imageCoordinates[0];
        int y = imageCoordinates[1];

        ImageView yellowKey = (ImageView) findViewById(R.id.yellowKey);

        if (x >= 111 && x <= 281 && y >= 280 && y <= 350) {
            Intent puzzle8 = new Intent(this, PuzzleEightActivity.class);
            startActivityForResult(puzzle8,0);
            yellowKey.setVisibility(View.GONE);
        } else if (x >= 1111 && x <= 1181 && y >= 830 && y <= 900) {
            if (gotPurpleKey()) {
                Intent puzzle9 = new Intent(this, PuzzleNineActivity.class);
                startActivityForResult(puzzle9, 1);
            } else {
                Toast.makeText(getApplicationContext(),"I need a purple key...",Toast.LENGTH_LONG).show();
            }
        } else if (x >= 2381 && y >= 440 && y <= 610) {
            if (bridgeAppeared() && gotBlueKey()) {
                Intent nextScreen = new Intent(this, BridgeActivity.class);
                startActivity(nextScreen);
            } else {
                Toast.makeText(getApplicationContext(),"Wow, you can walk on water... but please complete all puzzles before continuing",Toast.LENGTH_LONG).show();
            }
        }
    }

    //checks whether image is viewable on screen
    private boolean gotPurpleKey() {
        ImageView purpleKey = (ImageView) findViewById(R.id.purpleKey);
        return purpleKey.getVisibility() == View.VISIBLE;
    }

    private boolean bridgeAppeared() {
        ImageView bridge = (ImageView) findViewById(R.id.bridge);
        return bridge.getVisibility() == View.VISIBLE;
    }

    private boolean gotBlueKey() {
        ImageView blueKey = (ImageView) findViewById(R.id.blueKey);
        return blueKey.getVisibility() == View.VISIBLE;
    }

    //gets data which has been sent from another activity without restarting this activity and sets images according to the result
    //https://stackoverflow.com/questions/10407159/how-to-manage-startactivityforresult-on-android
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ImageView purpleKey = (ImageView) findViewById(R.id.purpleKey);
        ImageView bridge = (ImageView) findViewById(R.id.bridge);
        ImageView blueKey = (ImageView) findViewById(R.id.blueKey);
        if (requestCode == 0) {
            if (resultCode == Activity.RESULT_OK) {
                int getData = data.getIntExtra("sendData", -1);
                if (getData == 0) {
                    purpleKey.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"Found a Purple Key!",Toast.LENGTH_LONG).show();
                }
            }
        } else if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                int getData = data.getIntExtra("sendData", -1);
                if (getData == 0) {
                    bridge.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"A Bridge Appeared!",Toast.LENGTH_LONG).show();
                    blueKey.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"Found a Blue Key!",Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    //stop playing music
    public void onClickSoundOff(View v) {
        ImageButton sound = (ImageButton)findViewById(R.id.soundOff);
        Intent intent = new Intent(this,BackgroundMusic.class);
        stopService(intent);
    }

    //stop playing music
    public void onClickSoundOn(View v) {
        ImageButton sound = (ImageButton)findViewById(R.id.soundOn);
        Intent intent = new Intent(this,BackgroundMusic.class);
        startService(intent);
    }
}
