package com.example.takemyballs.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.takemyballs.R;
import com.example.takemyballs.dao.GamerDAO;

public class OpenGameActivity extends AppCompatActivity {

    private ImageView play;


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
                startActivity(new Intent(OpenGameActivity.this,
                        EvenOrOddActivity.class));
            }
        });

    }
}