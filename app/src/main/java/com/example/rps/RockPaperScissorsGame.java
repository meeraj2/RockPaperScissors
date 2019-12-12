package com.example.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class RockPaperScissorsGame extends AppCompatActivity {

    private ImageView usersChoosing;
    private ImageView compChoosing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors_game);

        configuretoResultButton();
        usersChoosing= findViewById(R.id.userOption);
        compChoosing = findViewById(R.id.compOption);
        playRPS(getIntent().getStringExtra("userChoice"));
    }

    public void configuretoResultButton() {
        ImageButton toResult = findViewById(R.id.toResult);
        toResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RockPaperScissorsGame.this, MainActivity.class));
            }
        });
    }

    public void playRPS(String userChoice) {

        String compPicks;
        /**
         creating method to generate the computer's choice
         @param the comp's choice for the round
         */
        double computerChoice = Math.random();

        if(computerChoice <= 1.0/3.0) {
            compPicks = "rock";
            compChoosing.setImageResource(R.drawable.rock);
        }
        else if (computerChoice > 1.0/3.0 && computerChoice <= 2.0/3.0) {
            compPicks = "paper";
            compChoosing.setImageResource(R.drawable.paper);
        }
        else {
            compPicks = "scissors";
            compChoosing.setImageResource(R.drawable.scissors);
        }



        /**
         creating a method to return the winner of the round
         @param the winner of the round
         */
        if(userChoice.equalsIgnoreCase("rock"))
        {
            usersChoosing.setImageResource(R.drawable.rock);
            if (compPicks.equals("paper")) {
                startActivity(new Intent(RockPaperScissorsGame.this, YouLose.class));
                Toast.makeText(this, "Computer chose PAPER", Toast.LENGTH_SHORT).show();
            } else if (compPicks.equals("scissors")) {
                startActivity(new Intent(this, YouWin.class));
                Toast.makeText(this, "Computer chose SCISSORS", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(new Intent(this, Tie.class));
                Toast.makeText(this, "Computer chose ROCK", Toast.LENGTH_SHORT).show();
            }
        }

        else if (userChoice.equalsIgnoreCase("paper"))
        {
            usersChoosing.setImageResource(R.drawable.paper);
            if (compPicks.equals("rock")) {
                startActivity(new Intent(this, YouWin.class));
                Toast.makeText(this, "Computer chose ROCK", Toast.LENGTH_SHORT).show();
            } else if (compPicks.equals("scissors")) {
                startActivity(new Intent(this, YouLose.class));
                Toast.makeText(this, "Computer chose SCISSORS", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(new Intent(this, Tie.class));
                Toast.makeText(this, "Computer chose PAPER", Toast.LENGTH_SHORT).show();
            }
        }

        else if (userChoice.equalsIgnoreCase("scissors"))
        {
            usersChoosing.setImageResource(R.drawable.scissors);
            if (compPicks.equals("rock")) {
                startActivity(new Intent(this, YouLose.class));
                Toast.makeText(this, "Computer chose ROCK", Toast.LENGTH_SHORT).show();
            } else if (compPicks.equals("paper")) {
                startActivity(new Intent(this, YouWin.class));
                Toast.makeText(this, "Computer chose PAPER", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(new Intent(this, Tie.class));
                Toast.makeText(this, "Computer chose SCISSORS", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
