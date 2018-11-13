package com.example.dell.mementos;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Post extends AppCompatActivity
{
    private RecycleAdapterComments mAdapter;
    private List<Data> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);

        ActionBar bar = getSupportActionBar();
        bar.setTitle("Post");
        bar.setDisplayHomeAsUpEnabled(true);

        setRecyclerView();
        loadData();
    }

    public void setRecyclerView()
    {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        mAdapter = new RecycleAdapterComments(dataList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
    }

    public void loadData()
    {
        Data data = new Data("img", "Nice picture");
        dataList.add(data);
        data = new Data("img", "Is that a ship?");
        dataList.add(data);
        data = new Data("img", "I really miss this place");
        dataList.add(data);
        data = new Data("img", "get free likes n follows");
        dataList.add(data);
        data = new Data("img", "Cool photo, man.");
        dataList.add(data);

        mAdapter.notifyDataSetChanged();
    }


    public static void makeRateBox(final View v)
    {
        final View view = (LayoutInflater.from(v.getContext())).inflate(R.layout.ratealert,null);
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(v.getContext());

        alertBuilder.setView(view);
        alertBuilder.setTitle("Rate");
        alertBuilder.setPositiveButton("Submit", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                EditText alertInput = view.findViewById(R.id.rateText);

                if (alertInput.getText().toString().isEmpty()) {
                    Toast.makeText(v.getContext(), "Field must not be empty", Toast.LENGTH_SHORT).show();
                } else {
                    Float input = Float.valueOf(alertInput.getText().toString());
                    if (input > 10 || input < 1) {
                        Toast.makeText(v.getContext(), "Error! Rate within 0 - 10", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });

        Dialog d = alertBuilder.create();
        d.show();

        //
        EditText alertInput =  view.findViewById(R.id.rateText);
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
