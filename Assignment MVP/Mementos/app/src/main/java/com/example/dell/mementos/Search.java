package com.example.dell.mementos;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Search extends AppCompatActivity
{
    private RecycleAdapter mAdapter;
    private List<Data> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("Search");
        bar.setDisplayHomeAsUpEnabled(true);

        dataList = new ArrayList<>();

        setRecyclerView();
        loadData();
    }

    public void validateSearch(View view)
    {
        EditText input = findViewById(R.id.input);

        String inp = input.getText().toString();


        int flag = 0;
        //email
        if (inp.isEmpty())
        {
            input.setError("Field must not be empty");
            flag = 1;
        }

        if (flag == 0)
        {
            Toast.makeText(this, "Search Successful", Toast.LENGTH_SHORT).show();
        }
    }

    public void setRecyclerView()
    {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        mAdapter = new RecycleAdapter(dataList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
    }

    public void loadData()
    {
        Data data = new Data("img", "Alex Rambough");
        dataList.add(data);
        data = new Data("img", "Talha Saqib");
        dataList.add(data);
        data = new Data("img", "All Might");
        dataList.add(data);
        data = new Data("img", "John Doe");
        dataList.add(data);
        data = new Data("img", "Dracule Mihwak");
        dataList.add(data);

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id==android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
