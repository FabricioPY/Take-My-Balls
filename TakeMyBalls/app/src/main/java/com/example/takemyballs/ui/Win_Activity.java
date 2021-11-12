package com.example.takemyballs.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.takemyballs.dao.GamerDAO;
import com.example.takemyballs.model.EvenOdd;

import com.example.takemyballs.R;

import java.util.Random;


public class Win_Activity extends AppCompatActivity {

    public static final String even = "EVEN";
    public static final String odd = "ODD";

    public static final String win = "WIN";
    public static final String loss = "LOSS";
    public static String winOrLoss = "NO_CHOICE";

    private int min = 1;
    private int max = 10;
    private Random random = new Random();

    public static EvenOdd choice;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        GamerDAO dao = new GamerDAO();

        EvenOdd ballsEvenOrOdd;

        int balls = random.nextInt(max + min);

        if ( balls % 2 == 0 )
            ballsEvenOrOdd = new EvenOdd(even);
        else
            ballsEvenOrOdd = new EvenOdd(odd);



        Toast.makeText(Win_Activity.this, balls +" "+ ballsEvenOrOdd,
                Toast.LENGTH_LONG).show();

        TextView evenOdd =  (TextView) findViewById(R.id.activity_even_or_odd);

        choice = dao.choice();

        evenOdd.setText(choice.getEvenOdd());

        if(choice.getEvenOdd() == ballsEvenOrOdd.getEvenOdd())
            winOrLoss = win;
        else
            winOrLoss = loss;

        TextView winLoss =  (TextView) findViewById(R.id.activity_win_or_loss);

        winLoss.setText(winOrLoss);


    }


}