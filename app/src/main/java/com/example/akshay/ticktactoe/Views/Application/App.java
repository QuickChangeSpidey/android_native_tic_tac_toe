package com.example.akshay.ticktactoe.Views.Application;

import android.app.Application;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import io.realm.Realm;

public class App extends Application{

    public Bus bus;

    @Override
    public void onCreate() {
        super.onCreate();
        this.bus = new Bus(ThreadEnforcer.MAIN);

    }

    public Bus getBus(){
        return this.bus;
    }


}
