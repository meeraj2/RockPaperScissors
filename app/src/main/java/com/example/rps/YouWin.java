package com.example.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class YouWin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_win);

        configurePlayAgain();
        configureExit();
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

    public void configureExit() {
        Button exitAppButton = findViewById(R.id.exitApp);
        exitAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
