package com.example.rps;

import androidx.appcompat.app.AppCompatActivity;

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

        if(computerChoice <= 1.0/3.0)
        {
            compPicks = "rock";
            System.out.println("Computer Picks rock");
        }
        else if (computerChoice > 1.0/3.0 && computerChoice <= 2.0/3.0)
        {
            compPicks = "paper";
            System.out.println("Computer Picks paper");
        }
        else
        {
            compPicks = "scissors";
            System.out.println("Computer Picks scissors");
        }

        /**
         creating a method to return the winner of the round
         @param the winner of the round
         */
        if(userChoice.equalsIgnoreCase("rock"))
        {
            if (compPicks.equals("paper"))
                System.out.println("Paper wins");
            else if (compPicks.equals("scissors"))
                System.out.println("Rock wins!");
            else
                System.out.println("It's a Tie!");
        }

        else if (userChoice.equalsIgnoreCase("paper"))
        {
            if (compPicks.equals("rock"))
                System.out.println("Paper Wins!");
            else if (compPicks.equals("scissors"))
                System.out.println("Scissors wins!");
            else
                System.out.println("It's a Tie!");
        }

        else if (userChoice.equalsIgnoreCase("scissors"))
        {
            if (compPicks.equals("rock"))
                System.out.println("Rock Wins!");
            else if (compPicks.equals("paper"))
                System.out.println("Scissors Wins!");
            else
                System.out.println("It's a Tie!");
        }

    }
}
