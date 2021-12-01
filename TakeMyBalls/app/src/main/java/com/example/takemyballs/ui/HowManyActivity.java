package com.example.takemyballs.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.takemyballs.R;
import com.example.takemyballs.dao.GamerDAO;

public class HowManyActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView textView;
    TextView numbersBalls;
    int min = 1;
    int ballsBat;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_many);

        GamerDAO dao = new GamerDAO();

        numbersBalls = (TextView) findViewById(R.id.activity_balls);
        seekBar = (SeekBar)findViewById(R.id.activity_seek_bar_balls);
        textView =(TextView)findViewById(R.id.activity_bat_balls_nuber);

        numbersBalls.setText(String.valueOf(dao.getBalls()));

        ballsBat = dao.getBalls();

        seekBar.setMin(min);
        seekBar.setMax(ballsBat);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int ballsBat, boolean fromUser)
            {
                textView.setText("Balls" + String.valueOf(ballsBat));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}