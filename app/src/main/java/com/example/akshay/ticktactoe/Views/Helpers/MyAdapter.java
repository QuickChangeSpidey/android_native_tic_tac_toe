package com.example.akshay.ticktactoe.Views.Helpers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.akshay.ticktactoe.Views.Models.Game;

import io.realm.RealmResults;

public class MyAdapter extends RecyclerView.Adapter {

    private RealmResults<Game> mDataset;

    public MyAdapter(RealmResults<Game> myDataset) {
        mDataset = myDataset;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
