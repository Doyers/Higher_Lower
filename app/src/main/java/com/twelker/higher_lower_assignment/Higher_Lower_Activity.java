package com.twelker.higher_lower_assignment;

import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Higher_Lower_Activity extends AppCompatActivity {

    private int[] mImages;
    private int randomNumber, oldNumber, scoreInt = 4;
    private Random rand;
    private ImageView mImageView;
    private TextView scoreTextview;
    private FloatingActionButton mHigherButton;
    private FloatingActionButton mLowerButton;

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

        randomNumber = generateNewRandom();
        oldNumber = randomNumber;

        scoreTextview.setText(Integer.toString(scoreInt));

        mHigherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                oldNumber = randomNumber;
                randomNumber = generateNewRandom();
                generateImage();
                if(randomNumber > oldNumber){
                    scoreInt++;
                } else {
                    scoreInt = 0;
                }
                scoreTextview.setText(Integer.toString(scoreInt));
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
                } else {
                    scoreInt = 0;
                }
                scoreTextview.setText(Integer.toString(scoreInt));
            }
        });
    }

    int generateNewRandom(){
        return rand.nextInt(6) + 1;
    }

    public void generateImage(){
        mImageView.setImageResource(mImages[randomNumber - 1]);
    }
}
