package com.example.akshay.ticktactoe.Views.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.akshay.ticktactoe.R;
import com.example.akshay.ticktactoe.Views.Models.Game;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

public class ScoreFragment extends Fragment {

    @BindView(R.id.player_turn_text)
    TextView playerTurnText;

    @BindView(R.id.player_x_name_text)
    TextView playerOneNameText;

    @BindView(R.id.player_o_name_text)
    TextView playerTwoNameText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    public void setPlayerNames(String playerOneName, String playerTwoName){

        playerOneNameText.setText("Player X: "+ playerOneName);
        playerTwoNameText.setText("Player O: "+ playerTwoName);

    }

    public void savePlayerInfoToDB(String winnerName) {

        Realm realm = Realm.getDefaultInstance();
        if (winnerName.equals("Player X winner\n"))
            winnerName = playerOneNameText.getText().toString();
        else
            winnerName = playerTwoNameText.getText().toString();

        RealmResults<Game> games = realm.where(Game.class).findAll();

        realm.beginTransaction();
        Game game = realm.createObject(Game.class, games.size()+1);
        game.setDate(Calendar.getInstance().getTime());
        game.setWinnerName(winnerName);
        realm.insertOrUpdate(game);
        realm.commitTransaction();

    }

    public void updateData(String message) {
        playerTurnText.setText(message);
    }
}
