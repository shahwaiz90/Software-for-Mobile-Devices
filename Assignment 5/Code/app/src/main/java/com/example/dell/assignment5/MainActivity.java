package com.example.dell.assignment5;

import android.app.Application;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private List<Word> stringList;
    private RecyclerView recyclerView;
    private RecycleAdapter mAdapter;
    //private WordViewModel mWordViewModel;
    private static final String DATABASE_NAME = "words_db";
    private database db;
    private List<String> words = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeDB();

        setRecyclerView();
    }

    public void initializeDB()
    {
        db = Room.databaseBuilder(getApplicationContext(),
                database.class, DATABASE_NAME)
                .allowMainThreadQueries().fallbackToDestructiveMigration()
                .build();
    }

    public void setRecyclerView()
    {
        recyclerView = findViewById(R.id.recycler_view);
        try {
            mAdapter = new RecycleAdapter(words);
        }catch(Exception e)
        {
            Toast.makeText(this, "Error"+e, Toast.LENGTH_LONG).show();
        }
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

       
    }

    public void adder(View view)
    {
        try {
            EditText input = findViewById(R.id.editText);
            Word word = new Word(input.getText().toString());
            db.wordDao().insert(word);
            words.add(input.getText().toString());
            mAdapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), "Added in Database", Toast.LENGTH_SHORT).show();
        }catch (Exception e)
        {
            Toast.makeText(this, "error: "+e, Toast.LENGTH_SHORT).show();
        }
    }


}
