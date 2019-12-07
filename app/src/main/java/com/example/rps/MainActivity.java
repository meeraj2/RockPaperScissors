package com.example.rps;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private String userChooses = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureExitAppButton();
        configureRockButton();
        configurePaperButton();
        configureScissorsButton();
    }

    public  void configureExitAppButton() {
        Button exitAppButton = findViewById(R.id.exit);
        exitAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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


//    public void rPSTester() {
//
//        String userChoice = userChooses;
//
//        //determining if user input is valid or not and playing game based if input is valid
//        if(userChoice.equalsIgnoreCase("rock")
//                || userChoice.equalsIgnoreCase("paper")
//                || userChoice.equalsIgnoreCase("scissors")) {
//            RockPaperScissorsGame newGame = new RockPaperScissorsGame();
//            newGame.playRPS(userChoice);
//        }
//        else
//            Toast.makeText(this, "INVALID DATA. PLEASE CHOOSE <ROCK, PAPER, OR SCISSORS>", Toast.LENGTH_SHORT).show();;
//    }
}
