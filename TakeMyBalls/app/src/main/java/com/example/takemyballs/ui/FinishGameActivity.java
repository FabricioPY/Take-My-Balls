package com.example.takemyballs.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.takemyballs.R;
import com.example.takemyballs.dao.GamerDAO;

public class FinishGameActivity extends AppCompatActivity {

    public static final String win = "WIN";
    public static final String lose = "LOSE";
    public static String winOrLose = "NO_CHOICE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_game);

        GamerDAO dao = new GamerDAO();

        if(dao.getBalls() > 20){
            winOrLose = win;}

        else{
            winOrLose = lose;}

        TextView finishWinLose = (TextView) findViewById(R.id.activity_finish_win_lose);

        finishWinLose.setText(winOrLose);
    }
}