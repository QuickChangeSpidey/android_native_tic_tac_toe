package com.example.akshay.ticktactoe.Views.Helpers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.akshay.ticktactoe.Views.DialogueActivity;

public class WinReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, DialogueActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("Winner",intent.getStringExtra("Winner"));
        context.startActivity(i);
    }
}
