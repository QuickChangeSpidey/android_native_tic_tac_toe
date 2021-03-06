package com.example.akshay.ticktactoe.Views.Helpers;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;


public class MessageHelper {

    public Dialog stopDialogMessage(final Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Are you sure you want to stop the game?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ((AppCompatActivity) context).finish();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //do nothing
                    }
                });
        return builder.create();
    }

    public Dialog winnerDialog(final Context context, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message)
                .setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                })
                .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ((AppCompatActivity) context).finish();
                    }
                });
        return builder.create();
    }

    public Dialog drawDialog(final Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("It is a Draw!!!")
                .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ((AppCompatActivity) context).finish();
                    }
                });
        return builder.create();
    }
}
