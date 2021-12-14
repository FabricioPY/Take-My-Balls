package com.example.takemyballs.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.takemyballs.R;
import com.example.takemyballs.dao.GamerDAO;

import java.util.Random;

public class OpenGameActivity extends AppCompatActivity {

    private AppCompatButton play;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GamerDAO dao = new GamerDAO();
        setContentView(R.layout.activity_open_game);

        play = findViewById(R.id.button_play);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.init10();

                Random random = new Random();

                if ( random.nextBoolean() )
                    startActivity(new Intent(OpenGameActivity.this,
                        HowManyActivity.class));

                else
                    startActivity(new Intent(OpenGameActivity.this,
                            EvenOrOddActivity.class));
            }
        });

    }
}