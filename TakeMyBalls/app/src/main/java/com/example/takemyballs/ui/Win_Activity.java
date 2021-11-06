package com.example.takemyballs.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import com.example.takemyballs.model.EvenOdd;

import com.example.takemyballs.R;

public class Win_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        EvenOdd evenOdd = null;

        TextView eveOddF = findViewById(R.id.activity_even_or_odd);
        eveOddF.setText(evenOdd.getEvenOrOdd());
    }
}