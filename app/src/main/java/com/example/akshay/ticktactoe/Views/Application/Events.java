package com.example.akshay.ticktactoe.Views.Application;

public class Events {

    public static class Message {

        private String message;

        public Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
