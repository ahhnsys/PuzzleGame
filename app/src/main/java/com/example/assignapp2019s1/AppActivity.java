package com.example.assignapp2019s1;
//authored by Natalie Phan
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.assignapp2019s1.Storyboard.FirstForestActivity;
import com.example.assignapp2019s1.puzzles.PuzzleEightActivity;
import com.example.assignapp2019s1.puzzles.PuzzleOneActivity;
import com.example.assignapp2019s1.puzzles.PuzzleTwoActivity;
import com.example.assignapp2019s1.puzzles.PuzzleThreeActivity;
import com.example.assignapp2019s1.puzzles.PuzzleFourActivity;
import com.example.assignapp2019s1.puzzles.PuzzleFiveActivity;
import com.example.assignapp2019s1.puzzles.PuzzleTenActivity;

/*
    This activity will create an opening sequence when the start button in WelcomeActivity is pressed.
    It aims to show Instructions and Controls.
 */
public class AppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        TextView textView = findViewById(R.id.textView);
        textView.setTextColor(Color.parseColor("white"));

        RelativeLayout layout   = (RelativeLayout)findViewById(R.id.relativeLayout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), FirstForestActivity.class);
                startActivity(intent);
            }
        });
    }

}
