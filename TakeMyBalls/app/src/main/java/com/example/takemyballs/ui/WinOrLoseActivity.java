package com.example.takemyballs.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.takemyballs.dao.GamerDAO;
import com.example.takemyballs.model.EvenOdd;

import com.example.takemyballs.R;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class WinOrLoseActivity extends AppCompatActivity {

    public static final String even = "EVEN";
    public static final String odd = "ODD";

    public static String pusless;

    public static final String win = "WIN";
    public static final String lose = "LOSE";
    public static String winOrLose = "NO_CHOICE";

    private int min = 1;
    private int max = 10;
    private Random random = new Random();

    public static EvenOdd choice;

    Timer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_or_lose);

        GamerDAO dao = new GamerDAO();

        EvenOdd ballsEvenOrOdd;

        int balls = random.nextInt(max - min + 1) + min;

        if ( balls % 2 == 0 )
            ballsEvenOrOdd = new EvenOdd(even);
        else
            ballsEvenOrOdd = new EvenOdd(odd);

        TextView evenOdd =  (TextView) findViewById(R.id.activity_even_or_odd);

        TextView numbersBalls =  (TextView) findViewById(R.id.activity_nunber_balls);

        choice = dao.choice();



        evenOdd.setText(ballsEvenOrOdd.getEvenOdd());

        if(choice.getEvenOdd() == ballsEvenOrOdd.getEvenOdd()){
            winOrLose = win;
            pusless = "+";
            dao.add(balls);}
        else{
            winOrLose = lose;
            pusless = "-";
            dao.subtract(balls);}

        numbersBalls.setText(pusless + String.valueOf(balls));

        TextView winLoss =  (TextView) findViewById(R.id.activity_win_or_loss);

        winLoss.setText(winOrLose);

        Intent intent = new Intent(WinOrLoseActivity.this, EvenOrOddActivity.class);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        }, 6000);
    }

}