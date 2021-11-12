package com.example.takemyballs.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.example.takemyballs.R;
import com.example.takemyballs.dao.GamerDAO;
import com.example.takemyballs.model.EvenOdd;

import java.util.Timer;
import java.util.TimerTask;

public class EvenOrOddActivity extends AppCompatActivity {

    Timer timer;

    public static final String even = "EVEN";
    public static final String odd = "ODD";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_even_or_odd);

        ImageView pointer = findViewById(R.id.activity_poniter);

        GamerDAO dao = new GamerDAO();

        int topPointer = 0;

        int time = 360;

        float exoX = 100;
        float exoY = 100;



        Animation rotate = new RotateAnimation(topPointer, time, exoY, exoX);
        rotate.setDuration(5000);
        rotate.setFillAfter(true);
        pointer.startAnimation(rotate);

        Intent intent = new Intent(EvenOrOddActivity.this, WinOrLoseActivity.class);

        ImageView ButtonEven = findViewById(R.id.activity_button_even);
        ButtonEven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EvenOdd evenOdd = new EvenOdd(even);
                dao.save(evenOdd);
            }
        });

        ImageView ButtonOdd = findViewById(R.id.activity_button_odd);
        ButtonOdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EvenOdd evenOdd = new EvenOdd(odd);
                dao.save(evenOdd);
            }
        });



        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        }, 5000);

    }
}