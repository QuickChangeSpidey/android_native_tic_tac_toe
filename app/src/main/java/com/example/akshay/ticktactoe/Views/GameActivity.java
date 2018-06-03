package com.example.akshay.ticktactoe.Views;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.akshay.ticktactoe.R;

import com.example.akshay.ticktactoe.Views.Helpers.MessageHelper;
import com.example.akshay.ticktactoe.Views.Helpers.NavigationHelper;
import butterknife.ButterKnife;


public class GameActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.game_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_restart:
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                return true;
            case R.id.menu_rules:
                NavigationHelper navigationHelper = new NavigationHelper();
                navigationHelper.goToRulesActivity(this);
                return true;
            case R.id.menu_stop:
                MessageHelper messageHelper = new MessageHelper();
                messageHelper.stopDialogMessage(this).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
