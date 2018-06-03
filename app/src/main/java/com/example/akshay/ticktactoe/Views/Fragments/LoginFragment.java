package com.example.akshay.ticktactoe.Views.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.akshay.ticktactoe.R;
import com.example.akshay.ticktactoe.Views.GameActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginFragment extends Fragment {

    @BindView(R.id.player_one_name_edit_text)
    EditText playerOneText;

    @BindView(R.id.player_two_name_edit_text)
    EditText playerTwoText;

    @BindView(R.id.start_game_button)
    Button startButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!playerOneText.getText().toString().equals("")
                        && !playerTwoText.getText().toString().equals("")
                        && !playerTwoText.getText().toString().equals(playerOneText.getText().toString())) {
                    Intent startGame = new Intent(getActivity(), GameActivity.class);
                    startGame.putExtra("PlayerOne", playerOneText.getText().toString());
                    startGame.putExtra("PlayerTwo", playerTwoText.getText().toString());
                    startActivity(startGame);
                } else {
                    Toast.makeText(getActivity(), "Please check player names", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }
}
