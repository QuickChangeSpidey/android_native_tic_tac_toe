package com.example.akshay.ticktactoe.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.akshay.ticktactoe.R;
import com.example.akshay.ticktactoe.Views.Fragments.LoginFragment;

import com.example.akshay.ticktactoe.Views.Helpers.NavigationHelper;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        NavigationHelper navigationHelper = new NavigationHelper();
        navigationHelper.createMenuForActivity(this);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_main, new LoginFragment(),null)
                .commit();

    }
}
