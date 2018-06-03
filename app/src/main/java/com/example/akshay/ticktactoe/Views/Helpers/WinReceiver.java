package com.example.akshay.ticktactoe.Views.Helpers;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class WinReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        MessageHelper messageHelper = new MessageHelper();
        Dialog dialog =messageHelper.
                winnerDialog(context,intent.getStringExtra("Winner Name").toString());
        dialog.show();

    }
}
