package com.example.dell.assignment6;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder>
{
    private List<Contacts> contactsList;

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        TextView number;
        public MyViewHolder(View view)
        {
            super(view);
            name = view.findViewById(R.id.name);
            number = view.findViewById(R.id.number);
        }
    }

    public RecycleAdapter(List<Contacts> contactsList)
    {
        this.contactsList = contactsList;
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
        Contacts contact = contactsList.get(position);
        holder.name.setText(contact.getName());
        holder.number.setText(contact.getNumber());
    }

    @Override
    public int getItemCount()
    {
        return contactsList.size();
    }
}

