package com.example.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tie);
        configurePlayAgain();
        configureSeeResultButton();
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
