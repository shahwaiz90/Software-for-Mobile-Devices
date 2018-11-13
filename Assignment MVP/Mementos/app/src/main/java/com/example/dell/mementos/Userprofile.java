package com.example.dell.mementos;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Userprofile extends AppCompatActivity {

    private RecycleAdapterProfile mAdapter;
    private List<String> imgs;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        ActionBar bar = getSupportActionBar();
        bar.setTitle("User");
        bar.setDisplayHomeAsUpEnabled(true);

        //initializations
        imgs = new ArrayList<>();

        TextView follower = findViewById(R.id.textView1);
        follower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToFollowers(v);
            }
        });

        TextView following = findViewById(R.id.textView2);
        following.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToFollowing(v);
            }
        });


        setRecycleView();
        loadData();
    }

    public void moveToFollowers(View view)
    {
        Intent i = new Intent(this, Followers.class);
        startActivity(i);
    }

    public void moveToFollowing(View view)
    {
        Intent i = new Intent(this, Following.class);
        startActivity(i);
    }

    public void setRecycleView()
    {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        mAdapter = new RecycleAdapterProfile(imgs);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(this), LinearLayoutManager.VERTICAL));
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
