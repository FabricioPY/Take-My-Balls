package com.example.takemyballs.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.takemyballs.R;
import com.example.takemyballs.dao.GamerDAO;

import java.util.Timer;
import java.util.TimerTask;

public class HowManyActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView textView;
    TextView numbersBalls;
    int min = 1;
    int ballsBat;
    Timer timer;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_many);

        GamerDAO dao = new GamerDAO();


        if ((dao.getBalls() < 1) || (dao.getBalls() > 20)) {
            Intent intent = new Intent(HowManyActivity.this, FinishGameActivity.class);
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    startActivity(intent);
                    finish();
                }
            }, 0);
        }

        else {
            numbersBalls = (TextView) findViewById(R.id.activity_balls);
            seekBar = (SeekBar) findViewById(R.id.activity_seek_bar_balls);
            textView = (TextView) findViewById(R.id.activity_bat_balls_nuber);

            numbersBalls.setText(String.valueOf(dao.getBalls()));

            ballsBat = dao.getBalls();

            seekBar.setMin(min);
            seekBar.setMax(ballsBat);

            Intent intent = new Intent(HowManyActivity.this,
                    HowManyWinOrLosActivity.class);


            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                int progressChangedValue = 0;
                @Override
                public void onProgressChanged(SeekBar seekBar, int ballsBat, boolean fromUser) {
                    progressChangedValue = ballsBat;
                    textView.setText("Balls" + String.valueOf(ballsBat));
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                dao.batBalls(progressChangedValue);
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
}