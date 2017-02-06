package com.example.kemojallow.hello;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button playMusic;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playMusic   = (Button) findViewById(R.id.button);

        mediaPlayer   = new MediaPlayer();
        mediaPlayer  = MediaPlayer.create(getApplicationContext(), R.raw.rise );

        playMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( mediaPlayer.isPlaying()){
                    pauseMusic();
                }else{
                    startMusic();
                }
            }
        });


    }
    public  void pauseMusic(){
        if (mediaPlayer != null){
            mediaPlayer.pause();
            playMusic.setText("PLAY");
        }
    }

    public void startMusic(){
        if(mediaPlayer != null){
            mediaPlayer.start();
            playMusic.setText("PAUSE");
        }
    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer  = null;
        }
        super.onDestroy();
    }
}
