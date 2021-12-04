package com.example.takemyballs.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.takemyballs.R;
import com.example.takemyballs.dao.GamerDAO;
import com.example.takemyballs.model.EvenOdd;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class HowManyWinOrLosActivity extends AppCompatActivity {

    public static final String even = "EVEN";
    public static final String odd = "ODD";
    public static EvenOdd evenOrOdd;

    public static String pusless;


    public static final String win = "WIN";
    public static final String lose = "LOSE";
    public static String winOrLose = "NO_CHOICE";

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_many_win_or_los);
        GamerDAO dao = new GamerDAO();

        Intent intent;

        EvenOdd ballsEvenOrOdd;

        Random random = new Random();

        if ( random.nextBoolean() )
            evenOrOdd = new EvenOdd(even);
        else
            evenOrOdd = new EvenOdd(odd);

        if ( dao.getHowManyBalls() % 2 == 0 )
            ballsEvenOrOdd = new EvenOdd(even);
        else
            ballsEvenOrOdd = new EvenOdd(odd);


        TextView evenOdd =  (TextView) findViewById(R.id.activity_even_or_odd);

        TextView numbersBalls =  (TextView) findViewById(R.id.activity_nunber_balls);


        evenOdd.setText(ballsEvenOrOdd.getEvenOdd());

        if(evenOrOdd.getEvenOdd() == ballsEvenOrOdd.getEvenOdd()){
            winOrLose = win;
            pusless = "+";
            dao.add(dao.getHowManyBalls());
            intent = new Intent(HowManyWinOrLosActivity.this,
                    HowManyActivity.class);}
        else{
            winOrLose = lose;
            pusless = "-";
            dao.subtract(dao.getHowManyBalls());
            intent = new Intent(HowManyWinOrLosActivity.this,
                    EvenOrOddActivity.class);}

        numbersBalls.setText(pusless + String.valueOf(dao.getHowManyBalls()));

        TextView winLoss =  (TextView) findViewById(R.id.activity_win_or_loss);

        winLoss.setText(winOrLose);


        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        }, 4000);
    }

}