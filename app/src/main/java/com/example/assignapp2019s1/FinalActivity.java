package com.example.assignapp2019s1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
//authored by Natalie Phan
import com.example.assignapp2019s1.R;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        TextView textView = findViewById(R.id.textView);
        textView.setTextColor(Color.parseColor("white"));

        //intents to next activity by touching anywhere on the screen
        RelativeLayout layout   = (RelativeLayout)findViewById(R.id.relativeLayout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), WelcomeActivity.class);
                startActivity(intent);
            }
        });
    }


}
