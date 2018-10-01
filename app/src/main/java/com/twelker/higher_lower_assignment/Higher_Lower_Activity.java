package com.twelker.higher_lower_assignment;

import android.os.Debug;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.Random;

public class Higher_Lower_Activity extends AppCompatActivity {

    private int[] mImages;
    private int randomNumber, oldNumber, scoreInt, highscoreInt;
    private Random rand;
    private ImageView mImageView;
    private TextView scoreTextview, highscoreTextview;
    private FloatingActionButton mHigherButton;
    private FloatingActionButton mLowerButton;
    private ListView mThrows;
    SimpleCursorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_higher__lower_);

        rand = new Random();
        mImages = new int[]{R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,R.drawable.d6};
        mImageView = findViewById(R.id.DiceImages);
        mHigherButton = findViewById(R.id.HigherButton);
        mLowerButton = findViewById(R.id.LowerButton);
        scoreTextview = findViewById(R.id.ScoreNumber);
        highscoreTextview = findViewById(R.id.HighScoreNumber);
        mThrows = findViewById(R.id.ListView);

        randomNumber = generateNewRandom();
        oldNumber = randomNumber;

        highscoreTextview.setText(Integer.toString(highscoreInt));
        scoreTextview.setText(Integer.toString(scoreInt));

        mHigherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                oldNumber = randomNumber;
                randomNumber = generateNewRandom();
                generateImage();
                if(randomNumber > oldNumber){
                    scoreInt++;
                    Snackbar.make (v, "You win", Snackbar.LENGTH_SHORT).setAction("Action",null).show();
                } else {
                    scoreInt = 0;
                    Snackbar.make (v, "You lose", Snackbar.LENGTH_SHORT).setAction("Action",null).show();
                }
                scoreTextview.setText(Integer.toString(scoreInt));
                HighscoreCheck();
                highscoreTextview.setText(Integer.toString(highscoreInt));
            }
        });

        mLowerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                oldNumber = randomNumber;
                randomNumber = generateNewRandom();
                generateImage();
                if(randomNumber < oldNumber){
                    scoreInt++;
                    Snackbar.make (v, "You win", Snackbar.LENGTH_SHORT).setAction("Action",null).show();
                } else {
                    scoreInt = 0;
                    Snackbar.make (v, "You lose", Snackbar.LENGTH_SHORT).setAction("Action",null).show();
                }
                scoreTextview.setText(Integer.toString(scoreInt));
                HighscoreCheck();
                highscoreTextview.setText(Integer.toString(highscoreInt));
            }
        });
    }

    public void HighscoreCheck(){
        if(highscoreInt < scoreInt){
            highscoreInt++;
        }
    }

    int generateNewRandom(){
        return rand.nextInt(6) + 1;
    }

    public void generateImage(){
        mImageView.setImageResource(mImages[randomNumber - 1]);
    }
}
