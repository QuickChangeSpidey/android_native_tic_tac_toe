package com.example.akshay.ticktactoe.Views.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.akshay.ticktactoe.R;
import com.example.akshay.ticktactoe.Views.Helpers.OnMessageSendListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameFragment extends Fragment implements View.OnClickListener {

    OnMessageSendListener mCallback;

    boolean PLAYER_X = true;

    int TURN_COUNT = 0;

    @BindView(R.id.b00)
    Button b00;

    @BindView(R.id.b01)
    Button b01;

    @BindView(R.id.b02)
    Button b02;

    @BindView(R.id.b10)
    Button b10;

    @BindView(R.id.b11)
    Button b11;

    @BindView(R.id.b12)
    Button b12;

    @BindView(R.id.b20)
    Button b20;

    @BindView(R.id.b21)
    Button b21;

    @BindView(R.id.b22)
    Button b22;

    int[][] boardStatus = new int[3][3];



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        b00.setOnClickListener(this);
        b01.setOnClickListener(this);
        b02.setOnClickListener(this);
        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        b20.setOnClickListener(this);
        b21.setOnClickListener(this);
        b22.setOnClickListener(this);

        initBoard();

    }

    private void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardStatus[i][j] = -1;
            }
        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.b00:
                if (PLAYER_X) {
                    b00.setText("X");
                    boardStatus[0][0] = 1;
                } else {
                    b00.setText("O");
                    boardStatus[0][0] = 0;
                }
                b00.setEnabled(false);
                break;

            case R.id.b01:
                if (PLAYER_X) {
                    b01.setText("X");
                    boardStatus[0][1] = 1;
                } else {
                    b01.setText("O");
                    boardStatus[0][1] = 0;
                }
                b01.setEnabled(false);
                break;

            case R.id.b02:
                if (PLAYER_X) {
                    b02.setText("X");
                    boardStatus[0][2] = 1;
                } else {
                    b02.setText("O");
                    boardStatus[0][2] = 0;
                }
                b02.setEnabled(false);
                break;

            case R.id.b10:
                if (PLAYER_X) {
                    b10.setText("X");
                    boardStatus[1][0] = 1;
                } else {
                    b10.setText("O");
                    boardStatus[1][0] = 0;
                }
                b10.setEnabled(false);
                break;

            case R.id.b11:
                if (PLAYER_X) {
                    b11.setText("X");
                    boardStatus[1][1] = 1;
                } else {
                    b11.setText("O");
                    boardStatus[1][1] = 0;
                }
                b11.setEnabled(false);
                break;

            case R.id.b12:
                if (PLAYER_X) {
                    b12.setText("X");
                    boardStatus[1][2] = 1;
                } else {
                    b12.setText("O");
                    boardStatus[1][2] = 0;
                }
                b12.setEnabled(false);
                break;

            case R.id.b20:
                if (PLAYER_X) {
                    b20.setText("X");
                    boardStatus[2][0] = 1;
                } else {
                    b20.setText("O");
                    boardStatus[2][0] = 0;
                }
                b20.setEnabled(false);
                break;

            case R.id.b21:
                if (PLAYER_X) {
                    b21.setText("X");
                    boardStatus[2][1] = 1;
                } else {
                    b21.setText("O");
                    boardStatus[2][1] = 0;
                }
                b21.setEnabled(false);
                break;

            case R.id.b22:
                if (PLAYER_X) {
                    b22.setText("X");
                    boardStatus[2][2] = 1;
                } else {
                    b22.setText("O");
                    boardStatus[2][2] = 0;
                }
                b22.setEnabled(false);
                break;

            default:
                break;

        }

            TURN_COUNT ++;
            PLAYER_X = !PLAYER_X;
            if(PLAYER_X){
                mCallback.onMessageSelected("Player X's turn");

            }
            else {
                mCallback.onMessageSelected("Player O's turn");

            }
            if(TURN_COUNT==9){
                mCallback.onMessageSelected("Game Draw");
                broadcastIntent("Game Draw");
            }
            checkWinner();
    }

    private void checkWinner(){

        //Horizontal --- rows
        for(int i=0; i<3; i++){
            if(boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2]){
                if (boardStatus[i][0]==1){
                    result("Player X winner\n" + (i+1)+" row");
                    broadcastIntent("Player X winner\n");
                    break;
                }
                else if (boardStatus[i][0]==0) {
                    result("Player O winner\n" + (i+1)+" row");
                    broadcastIntent("Player O winner\n");
                    break;
                }
            }
        }

        //Vertical --- columns
        for(int i=0; i<3; i++){
            if(boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i]){
                if (boardStatus[0][i]==1){
                    result("Player X winner\n" + (i+1)+" column");
                    broadcastIntent("Player X winner\n");
                    break;
                }
                else if (boardStatus[0][i]==0) {
                    result("Player O winner\n" + (i+1)+" column");
                    broadcastIntent("Player O winner\n");

                    break;
                }
            }
        }

        //First diagonal
        if(boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2]){
            if (boardStatus[0][0]==1){
                result("Player X winner\nFirst Diagonal");
                broadcastIntent("Player X winner\n");

            }
            else if (boardStatus[0][0]==0) {
                result("Player O winner\nFirst Diagonal");
                broadcastIntent("Player O winner\n");

            }
        }

        //Second diagonal
        if(boardStatus[0][2] == boardStatus[1][1] && boardStatus[0][2] == boardStatus[2][0]){
            if (boardStatus[0][2]==1){
                result("Player X winner\nSecond Diagonal");
                broadcastIntent("Player X winner\n");
            }
            else if (boardStatus[0][2]==0) {
                result("Player O winner\nSecond Diagonal");
                broadcastIntent("Player O winner\n");

            }
        }
    }

    private void enableAllBoxes(boolean value){
        b00.setEnabled(value);
        b01.setEnabled(value);
        b02.setEnabled(value);
        b10.setEnabled(value);
        b11.setEnabled(value);
        b12.setEnabled(value);
        b20.setEnabled(value);
        b21.setEnabled(value);
        b22.setEnabled(value);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (OnMessageSendListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnMessageSendListener");
        }
    }

    private void result(String message){
        mCallback.onMessageSelected(message);
        enableAllBoxes(false);
    }

    public void broadcastIntent(String message) {
        Intent intent = new Intent();
        intent.putExtra("Winner",message);
        intent.setAction("com.example.akshay.ticktactoe.WIN_INTENT_RECEIVER");
        getActivity().sendBroadcast(intent);
    }

}
