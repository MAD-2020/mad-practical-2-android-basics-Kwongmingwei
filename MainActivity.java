package com.example.madpracticebuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int tScore=0;
    private Button buttonLeft;
    private Button buttonMiddle;
    private Button buttonRight;
    private static final String TAG = "TripleButton";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonLeft = (Button) findViewById(R.id.Button1);
        buttonMiddle = (Button) findViewById(R.id.Button2);
        buttonRight = (Button) findViewById(R.id.Button3);




    }
    private void randomMoles(){
        Random rand=new Random();
        int randomNum=rand.nextInt(3);
        if (randomNum==0){
            buttonLeft.setText("*");
            buttonMiddle.setText("O");
            buttonRight.setText("O");
        }
        else if (randomNum==1){
            buttonLeft.setText("O");
            buttonMiddle.setText("*");
            buttonRight.setText("O");
        }
        else {
            buttonLeft.setText("O");
            buttonMiddle.setText("O");
            buttonRight.setText("*");
        }
        return randomNum;
    }


    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TAG,"Start game");
        randomMoles();
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v(TAG, "Button 1 clicked");
                if (buttonLeft.getText() == "*") {
                    tScore += 1;
                }
                Log.v(TAG,"Score is: "+tScore);
                randomMoles();
            }

        });
        buttonMiddle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v(TAG, "Button 2 clicked");
                if (buttonMiddle.getText() == "*") {
                    tScore += 1;
                }
                Log.v(TAG,"Score is: "+tScore);
                randomMoles();
            }
        });
        buttonRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v(TAG, "Button 3 clicked");
                if (buttonRight.getText() == "*") {
                    tScore += 1;
                }
                Log.v(TAG,"Score is: "+tScore);
                randomMoles();
            }
        });

    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.v(TAG,"Resume game");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TAG,"Paused");

    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TAG,"Game stopped");

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(TAG,"Destroying");

    }
}
