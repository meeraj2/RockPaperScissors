package com.example.rps;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    MediaPlayer mySong;
    private String userChooses = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySong = MediaPlayer.create(MainActivity.this, R.raw.music);

        configureRockButton();
        configurePaperButton();
        configureScissorsButton();
    }

    public void playIT(View v) {
        mySong.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mySong.release();
    }

    public void configureRockButton() {
        Button rockButton = findViewById(R.id.rockButton);
        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userChooses = "rock";
                startActivity(new Intent(MainActivity.this, RockPaperScissorsGame.class).putExtra("userChoice", userChooses));
            }
        });
    }

    public void configurePaperButton() {
        Button paperButton = findViewById(R.id.paperButton);
        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userChooses = "paper";
                startActivity(new Intent(MainActivity.this, RockPaperScissorsGame.class).putExtra("userChoice", userChooses));
            }
        });

    }

    public void configureScissorsButton() {
        Button scissorsButton = findViewById(R.id.scissorsButton);
        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userChooses = "scissors";
                startActivity(new Intent(MainActivity.this, RockPaperScissorsGame.class).putExtra("userChoice", userChooses));
            }
        });

    }

}
