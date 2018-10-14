package com.example.dell.assignment5;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder>
{
    private List<String> stringLists;

    public  class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView string;
        TextView id;
        public MyViewHolder(View view)
        {
            super(view);
            string = view.findViewById(R.id.stringa);
            id = view.findViewById(R.id.id);
        }
    }

    public RecycleAdapter(List<String> words)
    {
        this.stringLists = words;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
            String worda = stringLists.get(position);
            holder.string.setText(worda);
            holder.id.setText("-");
    }

    @Override
    public int getItemCount()
    {
            return stringLists.size();
    }
}

