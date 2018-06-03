package com.example.akshay.ticktactoe.Views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.akshay.ticktactoe.R;

public class DialogueActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

    }

    public void closeDialog(View view){
        finish();

    }
    public void restartGame(View view){

        
    }
}
