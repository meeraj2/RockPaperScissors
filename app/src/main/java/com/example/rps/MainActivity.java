package com.example.rps;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    private TextView textView;
    private ImageButton speakButton;
    private String userChooses = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.speakText);
        speakButton = findViewById(R.id.speakButton);

        speakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
    }

    private void speak() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hi, Choose Rock, Paper, or Scissors");

        try {
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
        } catch (Exception e) {
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case REQUEST_CODE_SPEECH_INPUT: {
                if (resultCode == REQUEST_CODE_SPEECH_INPUT && null!= data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    if (result.size() == 1) {
                        userChooses = result.get(0);
                        textView.setText(result.get(0));
                        rPSTester();
                    } else {
                        Toast.makeText(this, "Please choose Rock, Paper, or Scissors", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            }
        }
    }

    public void rPSTester() {

        //asking user for choice
        System.out.println("Please choose rock, paper, or scissors");
        String userChoice = userChooses;

        //determining if user input is valid or not and playing game based if input is valid
        if(userChoice.equalsIgnoreCase("rock")
                || userChoice.equalsIgnoreCase("paper")
                || userChoice.equalsIgnoreCase("scissors")) {
            RockPaperScissorsGame newGame = new RockPaperScissorsGame();
            newGame.playRPS(userChoice);
        }
        else
            System.out.println("INVALID DATA");
    }
}
