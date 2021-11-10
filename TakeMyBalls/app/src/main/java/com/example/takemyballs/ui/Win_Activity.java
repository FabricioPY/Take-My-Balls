package com.example.takemyballs.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.example.takemyballs.model.EvenOdd;

import com.example.takemyballs.R;

public class Win_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        Intent intent =  getIntent();
        String choice = intent.getStringExtra(EvenOrOddActivity.evenOdd);

        TextView evenOdd =  (TextView) findViewById(R.id.activity_even_or_odd);

        evenOdd.setText(choice);

    }
}