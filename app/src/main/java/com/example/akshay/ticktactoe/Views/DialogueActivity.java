package com.example.akshay.ticktactoe.Views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.akshay.ticktactoe.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DialogueActivity extends AppCompatActivity{

    @BindView(R.id.winner_text)
    TextView winnerText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
        winnerText.setText(getIntent().getStringExtra("Winner"));

    }

    public void closeDialog(View view){
        finish();

    }
    public void restartGame(View view){


    }
}
