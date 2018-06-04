package com.example.akshay.ticktactoe.Views.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.akshay.ticktactoe.R;
import com.example.akshay.ticktactoe.Views.Helpers.MyAdapter;
import com.example.akshay.ticktactoe.Views.Models.Game;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

public class HistoryFragment extends Fragment {

    @BindView(R.id.my_recycler_view)
    RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        Realm realm = Realm.getDefaultInstance();

        RealmResults<Game> games = realm.where(Game.class).findAll();


        mAdapter = new MyAdapter(games);
        mRecyclerView.setAdapter(mAdapter);

    }
}

