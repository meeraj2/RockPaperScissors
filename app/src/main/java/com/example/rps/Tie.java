package com.example.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tie extends AppCompatActivity {

    MediaPlayer tieMusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tie);

        int resID = getResources().getIdentifier("tieMusic", "raw", getPackageName());
        tieMusic = MediaPlayer.create(this, resID);
        tieMusic.start();

        configurePlayAgain();
        configureSeeResultButton();
    }

    @Override
    protected void onPause() {
        super.onPause();
        tieMusic.release();
    }

    public void configurePlayAgain() {
        Button playAgainButton = findViewById(R.id.playOnceMore);
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Tie.this, MainActivity.class));
            }
        });
    }
    public void configureSeeResultButton() {
        Button seeResults = findViewById(R.id.seeResult);
        seeResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
