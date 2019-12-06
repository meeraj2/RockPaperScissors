package com.example.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class RockPaperScissorsGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors_game);
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
        }
        else if (computerChoice > 1.0/3.0 && computerChoice <= 2.0/3.0) {
            compPicks = "paper";
        }
        else {
            compPicks = "scissors";
        }

        /**
         creating a method to return the winner of the round
         @param the winner of the round
         */
        if(userChoice.equalsIgnoreCase("rock"))
        {
            if (compPicks.equals("paper")) {
                startActivity(new Intent(RockPaperScissorsGame.this, YouLose.class));
            } else if (compPicks.equals("scissors")) {
                startActivity(new Intent(RockPaperScissorsGame.this, YouWin.class));
            } else {
                startActivity(new Intent(RockPaperScissorsGame.this, Tie.class));
            }
        }

        else if (userChoice.equalsIgnoreCase("paper"))
        {
            if (compPicks.equals("rock")) {
                startActivity(new Intent(RockPaperScissorsGame.this, YouWin.class));
            } else if (compPicks.equals("scissors")) {
                startActivity(new Intent(RockPaperScissorsGame.this, YouLose.class));
            } else {
                startActivity(new Intent(RockPaperScissorsGame.this, Tie.class));
            }
        }

        else if (userChoice.equalsIgnoreCase("scissors"))
        {
            if (compPicks.equals("rock")) {
                startActivity(new Intent(RockPaperScissorsGame.this, YouLose.class));
            } else if (compPicks.equals("paper")) {
                startActivity(new Intent(RockPaperScissorsGame.this, YouWin.class));
            } else {
                startActivity(new Intent(RockPaperScissorsGame.this, Tie.class));
            }
        }

    }
}
