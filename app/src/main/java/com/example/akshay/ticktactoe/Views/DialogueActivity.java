package com.example.akshay.ticktactoe.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.akshay.ticktactoe.R;
import com.example.akshay.ticktactoe.Views.Application.App;
import com.example.akshay.ticktactoe.Views.Application.Events;

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
        this.setFinishOnTouchOutside(false);

    }

    public void closeDialog(View view){

        finish();
        App app = (App)getApplicationContext();
        app.getBus().post(new Events("save",winnerText.getText().toString()));
        Intent i = new Intent(this,MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);

    }

    public void restartGame(View view){
        finish();
        App app = (App)getApplicationContext();
        app.getBus().post(new Events("restart",winnerText.getText().toString()));
    }
}
