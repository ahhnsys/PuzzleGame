package com.example.assignapp2019s1;
//authored by Natalie Phan
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.assignapp2019s1.Storyboard.FirstForestActivity;
import com.example.assignapp2019s1.Storyboard.SecondBeachActivity;

/*
    This activity will create an opening sequence when the start button in WelcomeActivity is pressed.
    It aims to show Instructions and Controls.
 */
public class AppActivity extends AppCompatActivity {
    MediaPlayer player;

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
