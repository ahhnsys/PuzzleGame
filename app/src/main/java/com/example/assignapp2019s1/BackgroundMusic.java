package com.example.assignapp2019s1;
//authored by Natalie Phan
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.example.assignapp2019s1.R;

//https://stackoverflow.com/questions/8209858/android-background-music-service/8209975#8209975
/*
    This activity creates background music to play music in all activities.
    The audio file is from: https://incompetech.com/music/royalty-free/index.html?isrc=USUAN1500073&Search=Search
 */
public class BackgroundMusic extends Service {
    private static final String TAG = null;
    MediaPlayer player;
    public IBinder onBind(Intent arg0) {

        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.bit_quest);
        player.setLooping(true);
        player.setVolume(100,100);

    }

    public void onStart(Intent intent, int startId) {
        player.start();
    }
    public IBinder onUnBind(Intent arg0) {
        return null;
    }

    public void onStop() {
        player.stop();
    }

    public void onPause() {
        player.stop();
    }

    @Override
        public void onDestroy() {
        player.stop();
        player.release();
    }

}