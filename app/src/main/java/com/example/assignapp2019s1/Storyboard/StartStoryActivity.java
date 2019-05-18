package com.example.assignapp2019s1.Storyboard;
//authored by Natalie Phan

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.assignapp2019s1.AppActivity;
import com.example.assignapp2019s1.R;

/*
    This activity will create an opening sequence when the start button in WelcomeActivity is pressed.
    It aims to show a graphic comic of the main character, Bo and how he arrives in the Puzzle World.
 */
public class StartStoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_story);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        RelativeLayout layout   = (RelativeLayout)findViewById(R.id.relativeLayout1);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AppActivity.class);
                startActivity(intent);
            }
        });
    }




}
