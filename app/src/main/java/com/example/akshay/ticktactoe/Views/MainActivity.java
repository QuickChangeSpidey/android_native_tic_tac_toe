package com.example.akshay.ticktactoe.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.akshay.ticktactoe.R;

import Helpers.NavigationHelper;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.player_one_name_edit_text)
    EditText playerOneText;

    @BindView(R.id.player_two_name_edit_text)
    EditText playerTwoText;

    @BindView(R.id.start_game_button)
    Button startButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        NavigationHelper navigationHelper = new NavigationHelper();
        navigationHelper.createMenuForActivity(this);


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!playerOneText.getText().toString().equals("")
                        && !playerTwoText.getText().toString().equals("")
                        && !playerTwoText.getText().toString().equals(playerOneText.getText().toString())) {
                    Intent startGame = new Intent(getApplicationContext(), GameActivity.class);
                    startGame.putExtra("PlayerOne", playerOneText.getText().toString());
                    startGame.putExtra("PlayerTwo", playerTwoText.getText().toString());
                    startActivity(startGame);
                } else {
                    Toast.makeText(getApplicationContext(), "Please check player names", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }
}
