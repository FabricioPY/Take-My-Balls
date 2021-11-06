package com.example.takemyballs.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.takemyballs.R;
import com.example.takemyballs.model.EvenOdd;

public class EvenOrOddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_even_or_odd);

        String even = "EVEN";
        String odd = "ODD";

        EvenOdd evenOdd;

        ImageView ButtonEven = findViewById(R.id.activity_button_even);
        ButtonEven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EvenOdd evenOdd = new EvenOdd(even);
                Toast.makeText(EvenOrOddActivity.this, evenOdd.getEvenOrOdd(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        ImageView ButtonOdd = findViewById(R.id.activity_button_odd);
        ButtonOdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EvenOdd evenOdd = new EvenOdd(odd);
                Toast.makeText(EvenOrOddActivity.this, evenOdd.getEvenOrOdd(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}