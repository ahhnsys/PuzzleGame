package com.example.assignapp2019s1;

//authored by Natalie Phan
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/*
    This activity is a starting screen for the Game. It is the first screen.
 */

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        startService(new Intent(WelcomeActivity.this, BackgroundMusic.class));

    }

    public void startButton(View v) {
        Intent intent = new Intent(getBaseContext(), AppActivity.class);
        startActivity(intent);
    }
}
