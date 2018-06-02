package com.example.akshay.ticktactoe.Views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.akshay.ticktactoe.R;

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
                return true;
            case R.id.menu_rules:
                playVideo();
                return true;
            case R.id.menu_stop:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void playVideo(){
        Intent intent = new Intent(this, RulesActivity.class);
        startActivity(intent);
    }
}
