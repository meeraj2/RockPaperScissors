package com.example.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class YouWin extends AppCompatActivity {

    MediaPlayer winSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_win);

        int resID = getResources().getIdentifier("winmusic", "raw", getPackageName());
        winSong = MediaPlayer.create(this, resID);
        winSong.start();

        configurePlayAgain();
        configureSeeOutcomes();
    }

    @Override
    protected void onPause() {
        super.onPause();
        winSong.release();
    }

    public void configurePlayAgain() {
        Button playAgainButton = findViewById(R.id.playAgain);
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(YouWin.this, MainActivity.class));
            }
        });
    }
    public void configureSeeOutcomes() {
        Button seeResults = findViewById(R.id.seeOutcomes);
        seeResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
