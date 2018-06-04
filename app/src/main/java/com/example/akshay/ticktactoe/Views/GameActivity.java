package com.example.akshay.ticktactoe.Views;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.akshay.ticktactoe.R;

import com.example.akshay.ticktactoe.Views.Application.App;
import com.example.akshay.ticktactoe.Views.Application.Events;
import com.example.akshay.ticktactoe.Views.Fragments.ScoreFragment;
import com.example.akshay.ticktactoe.Views.Fragments.GameFragment;
import com.example.akshay.ticktactoe.Views.Helpers.MessageHelper;
import com.example.akshay.ticktactoe.Views.Helpers.NavigationHelper;
import com.example.akshay.ticktactoe.Views.Helpers.OnMessageSendListener;
import com.example.akshay.ticktactoe.Views.Models.Game;
import com.squareup.otto.Subscribe;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;


public class GameActivity extends AppCompatActivity implements OnMessageSendListener {


    Realm realm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_score_container,new ScoreFragment(),null)
                .commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_board_container,new GameFragment(),null)
                .commit();
        Realm.init(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ScoreFragment fragment = (ScoreFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_score_container);
        fragment.setPlayerNames(getIntent().getStringExtra("PlayerOne"),
                getIntent().getStringExtra("PlayerTwo"));

        realm = Realm.getDefaultInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.game_menu, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        App state = ((App) getApplicationContext());
        state.getBus().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App state = (App)getApplicationContext();
        state.getBus().unregister(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_restart:
                restart();
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


    @Override
    public void onMessageSelected(String message) {
        ScoreFragment scoreFragment = (ScoreFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_score_container);
        if (scoreFragment != null) {
            scoreFragment.updateData(message);
        }
    }

    @Subscribe
    public void restartMessage(Events message){


        Date currentTime = Calendar.getInstance().getTime();

        Game game = new Game();
        game.setDate(currentTime);
        game.setWinnerName(message.getWinnerName());

        if(message.getMessage().equals("restart")||message.getMessage().equals("save"))

            realm.beginTransaction();
            realm.copyToRealm(game);
            realm.commitTransaction();
            restart();


    }

    public void restart(){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

}
