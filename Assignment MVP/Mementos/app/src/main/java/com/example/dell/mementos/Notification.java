package com.example.dell.mementos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Notification extends Fragment
{

    private RecycleAdapter mAdapter;
    private List<Data> dataList = new ArrayList<>();
    private int layoutCreated = 0;

       public Notification()
       {

       }

        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            View rootview = inflater.inflate(R.layout.fragment_notification, container, false);

            setRecyclerView(rootview);
            if(layoutCreated == 0)
            {
                loadData();
                layoutCreated = 1;
            }

            return rootview;
        }

    public void setRecyclerView(View rootview)
    {
        RecyclerView recyclerView = rootview.findViewById(R.id.recycler_view);
        mAdapter = new RecycleAdapter(dataList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getActivity()), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
    }

    public void loadData()
    {
        Data data = new Data("img", "Micheal Blaha rated your post");
        dataList.add(data);
        data = new Data("img", "Long Bottom commented on your post");
        dataList.add(data);
        data = new Data("img", "Ajeeb Bnda followed you");
        dataList.add(data);
        data = new Data("img", "Man in Black rated your post");
        dataList.add(data);
        data = new Data("img", "Akainu-San commented on your post");
        dataList.add(data);

        mAdapter.notifyDataSetChanged();
    }
}


