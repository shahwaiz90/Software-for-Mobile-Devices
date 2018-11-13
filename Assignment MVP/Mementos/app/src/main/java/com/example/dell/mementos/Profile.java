package com.example.dell.mementos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Profile extends Fragment
{
    private RecycleAdapterProfile mAdapter;
    private List<String> imgs;
    private int layoutCreated = 0;

    public Profile()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        imgs = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView =  inflater.inflate(R.layout.profile, container, false);

        setRecycleView(rootView);
        if(layoutCreated == 0)
        {
            loadData();
            layoutCreated = 1;
        }

        TextView follower = rootView.findViewById(R.id.textView1);
        follower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToFollowers(v);
            }
        });

        TextView following = rootView.findViewById(R.id.textView2);
        following.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToFollowing(v);
            }
        });


        return rootView;
    }

    public void moveToFollowers(View view)
    {
            Intent i = new Intent(getActivity(), Followers.class);
            startActivity(i);
    }

    public void moveToFollowing(View view)
    {
        Intent i = new Intent(getActivity(), Following.class);
        startActivity(i);
    }

    public void setRecycleView(View rootView)
    {
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
        mAdapter = new RecycleAdapterProfile(imgs);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getActivity()), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
    }

    public void loadData()
    {
        imgs.add("img");
        imgs.add("img");
        imgs.add("img");

        imgs.add("img");
        imgs.add("img");
        imgs.add("img");

        imgs.add("img");
        imgs.add("img");
        imgs.add("img");

        imgs.add("img");
        imgs.add("img");
        imgs.add("img");

        imgs.add("img");
        imgs.add("img");
        imgs.add("img");

        imgs.add("img");
        imgs.add("img");

        mAdapter.notifyDataSetChanged();
    }

}
