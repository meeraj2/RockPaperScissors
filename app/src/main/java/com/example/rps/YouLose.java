package com.example.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class YouLose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_lose);
        configurePlayAgain();
        configureExit();
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

    public void configureExit() {
        Button exitAppButton = findViewById(R.id.exitbutton);
        exitAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
