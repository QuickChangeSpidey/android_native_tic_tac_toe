package com.example.akshay.ticktactoe.Views;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.akshay.ticktactoe.R;

import Helpers.NavigationHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavigationHelper navigationHelper = new NavigationHelper();
        navigationHelper.createMenuForActivity(this);
    }


    public void startGame(View view) {
    }
}
