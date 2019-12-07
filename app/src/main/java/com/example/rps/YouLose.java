package com.example.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class YouLose extends AppCompatActivity {

    MediaPlayer loseMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_lose);

        int resID = getResources().getIdentifier("losemusic", "raw", getPackageName());
        loseMusic = MediaPlayer.create(this, resID);
        loseMusic.start();

        configurePlayAgain();
        configureSeeResults();
    }

    @Override
    protected void onPause() {
        super.onPause();
        loseMusic.release();
    }

    public void configurePlayAgain() {
        Button playAgainButton = findViewById(R.id.playagain);
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(YouLose.this, MainActivity.class));
            }
        });
    }
    public void configureSeeResults() {
        Button seeResults = findViewById(R.id.seeResults);
        seeResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
