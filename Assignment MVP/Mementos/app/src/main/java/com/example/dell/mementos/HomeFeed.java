package com.example.dell.mementos;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeFeed extends Fragment
{
    private RecycleAdapterFeed mAdapter;
    private List<FeedData> dataList;
    private int layoutCreated = 0;

    public HomeFeed()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        dataList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView =  inflater.inflate(R.layout.fragment_notification, container, false);

        setRecycleView(rootView);
        if(layoutCreated == 0)
        {
            loadData();
            layoutCreated = 1;
        }

        return rootView;
    }

    public void setRecycleView(View rootView)
    {
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
        mAdapter = new RecycleAdapterFeed(dataList,new ClickListener() {
            @Override
            public void onPositionClicked(int position) {



            }


        });
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getActivity()), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
    }

    public void loadData()
    {
        FeedData data = new FeedData("Baroque", "img", "img", "8.6");
        dataList.add(data);
        data = new FeedData("Shagoofa", "img", "img", "7.5");
        dataList.add(data);
        data = new FeedData("Jurgen", "img", "img", "9.3");
        dataList.add(data);
        data = new FeedData("Kaoichi", "img", "img", "6.8");
        dataList.add(data);
        data = new FeedData("Lariana", "img", "img", "7.6");
        dataList.add(data);
        data = new FeedData("Jackie", "img", "img", "8.3");
        dataList.add(data);

        mAdapter.notifyDataSetChanged();
    }

}
