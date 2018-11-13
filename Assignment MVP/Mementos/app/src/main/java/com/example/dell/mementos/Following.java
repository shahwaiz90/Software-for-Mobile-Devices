package com.example.dell.mementos;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Following extends AppCompatActivity
{
    private RecycleAdapter mAdapter;
    private List<Data> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_notification);
        dataList = new ArrayList<>();

        ActionBar bar = getSupportActionBar();
        bar.setTitle("Following");
        bar.setDisplayHomeAsUpEnabled(true);

        setRecyclerView();
        loadData();
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

        /*recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.com.example.dell.mementos.ClickListener() {
            @Override
            public void onClick(View view, int position)
            {
                Word stringa = stringList.get(position);
                Toast.makeText(getApplicationContext(),  stringa.getWord()+ " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position)
            {
                Word stringa = stringList.get(position);
                Toast.makeText(getApplicationContext(),  stringa.getWord()+ " is long tapped", Toast.LENGTH_SHORT).show();
            }
        }));*/
    }

    public void loadData()
    {
        Data data = new Data("img", "Micheal Blaha");
        dataList.add(data);
        data = new Data("img", "Long Bottom");
        dataList.add(data);
        data = new Data("img", "Ajeeb Bnda");
        dataList.add(data);
        data = new Data("img", "Man in Black");
        dataList.add(data);
        data = new Data("img", "Akainu-San");
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
