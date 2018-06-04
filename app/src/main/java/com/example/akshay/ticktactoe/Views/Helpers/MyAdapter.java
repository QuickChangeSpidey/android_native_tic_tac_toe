package com.example.akshay.ticktactoe.Views.Helpers;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.akshay.ticktactoe.R;
import com.example.akshay.ticktactoe.Views.Models.Game;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class MyAdapter extends RealmRecyclerViewAdapter<Game,MyAdapter.ViewHolder> {


    public MyAdapter(@NonNull Context context, @Nullable OrderedRealmCollection<Game> data, boolean autoUpdate) {
        super(context, data, autoUpdate);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       Game game = getData().get(position);
       holder.winnerDetailText.setText(game.getWinnerName());
       holder.dateText.setText(game.getDate().toString());
       holder.gameNumberText.setText(Integer.toString(position+1));

        if (position % 2 == 0) {

            holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));

        } else {

            holder.itemView.setBackgroundColor(Color.parseColor("#FF69B4"));

        }


    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView gameNumberText;
        public TextView winnerDetailText;
        public TextView dateText;

        public ViewHolder(View v) {
            super(v);
            gameNumberText = (TextView) v.findViewById(R.id.game_number);
            winnerDetailText = (TextView) v.findViewById(R.id.winner_details);
            dateText = (TextView) v.findViewById(R.id.date_holder);
        }
    }

}


