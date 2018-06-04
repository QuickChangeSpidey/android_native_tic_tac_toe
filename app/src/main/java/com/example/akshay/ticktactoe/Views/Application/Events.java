package com.example.akshay.ticktactoe.Views.Application;

public class Events {

    private String message;
    private String winnerName;


    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public Events(String message, String winnerName) {
            this.message = message;
            this.winnerName = winnerName;
        }
    public String getMessage() {
            return message;
        }

    }

