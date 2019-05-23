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

import com.example.assignapp2019s1.R;
import com.example.assignapp2019s1.puzzles.PuzzleSevenActivity;
import com.example.assignapp2019s1.puzzles.PuzzleSixActivity;

/*
    This activity is contains the controls and methods for the Beach Map of the story. It is the first part of the third map.
 */
public class FirstBeachActivity extends AppCompatActivity {

    float characterX;
    float characterY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_beach);
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

        ImageView yellowKey = (ImageView) findViewById(R.id.yellowKey); //gets the id of image
        yellowKey.setVisibility(View.INVISIBLE); //sets the visibility to invisible until needed

        ImageView shovel = (ImageView) findViewById(R.id.shovel);
        shovel.setVisibility(View.INVISIBLE);

        ImageView imageView = (ImageView) findViewById(R.id.character);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] values = new int[2];
                view.getLocationOnScreen(values);
                Log.d("X & Y",values[0]+" "+values[1]);
            }
        });

        ImageView puzzleChest7 = (ImageView) findViewById(R.id.puzzleChest7);
        puzzleChest7.setVisibility(View.INVISIBLE);
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

        ImageView puzzleChest7 = (ImageView) findViewById(R.id.puzzleChest7);
        ImageView shovel = (ImageView) findViewById(R.id.shovel);

        if (x >= 1775 && x <= 1900 && y >= 230 && y <= 300) {
            Intent puzzle6 = new Intent(this, PuzzleSixActivity.class);
            startActivityForResult(puzzle6,0);
        } else if ( x >= 15 && x <= 175 && y >= 720 && y <=820) {
            if (gotShovel()) {
                Toast.makeText(getApplicationContext(),"Found a Puzzle Chest!",Toast.LENGTH_LONG).show();
                puzzleChest7.setVisibility(View.VISIBLE);
                shovel.setVisibility(View.GONE);
            } else if (foundPuzzleChest7()) {
                Intent puzzle7 = new Intent(this, PuzzleSevenActivity.class);
                startActivityForResult(puzzle7, 1);
            } else {
                Toast.makeText(getApplicationContext(), "It looks like I can dig here...", Toast.LENGTH_LONG).show();
            }
        } else if (x >= 2405 && y >= 530 && y <= 910) {
            if (gotYellowKey()) {
                Intent nextScreen = new Intent(this, SecondBeachActivity.class);
                startActivity(nextScreen);
            }
            else {
                Toast.makeText(getApplicationContext(),"Please complete all puzzles before continuing",Toast.LENGTH_LONG).show();
            }
        }
    }

    //checks whether image is viewable on screen
    private boolean gotShovel() {
        ImageView shovel = (ImageView) findViewById(R.id.shovel);
        return  (shovel.getVisibility() == View.VISIBLE);
    }

    private boolean foundPuzzleChest7() {
        ImageView puzzleChest7 = (ImageView) findViewById(R.id.puzzleChest7);
        return  (puzzleChest7.getVisibility() == View.VISIBLE);
    }

    private boolean gotYellowKey() {
        ImageView yellowKey = (ImageView) findViewById(R.id.yellowKey);
        return yellowKey.getVisibility() == View.VISIBLE;
    }

    //gets data which has been sent from another activity without restarting this activity and sets images according to the result
    //https://stackoverflow.com/questions/10407159/how-to-manage-startactivityforresult-on-android
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ImageView shovel = (ImageView) findViewById(R.id.shovel);
        ImageView yellowKey = (ImageView) findViewById(R.id.yellowKey);
        if (requestCode == 0) {
            if (resultCode == Activity.RESULT_OK) {
                int getData = data.getIntExtra("sendData", -1);
                if (getData == 0) {
                    shovel.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"Found a Shovel!",Toast.LENGTH_LONG).show();
                }
            }
        } else if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                int getData = data.getIntExtra("sendData", -1);
                if (getData == 0) {
                    yellowKey.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"Found a Yellow Key!",Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
