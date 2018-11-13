package com.example.dell.mementos;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecycleAdapterProfile extends RecyclerView.Adapter<RecycleAdapterProfile.MyViewHolder>
{
    private List<String> imgs;

    public RecycleAdapterProfile(List<String> imgs)
    {
        this.imgs = imgs;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView post;
        public MyViewHolder(View view)
        {
            super(view);
            post = view.findViewById(R.id.posta);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_grid, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        //ImageView img = imgs.get(position);
        holder.post.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(v.getContext(), Post.class);
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return imgs.size();
    }
}
