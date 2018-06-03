package com.example.akshay.ticktactoe.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.akshay.ticktactoe.R;
import com.example.akshay.ticktactoe.Views.Fragments.LoginFragment;

import Helpers.NavigationHelper;
import butterknife.BindView;
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
