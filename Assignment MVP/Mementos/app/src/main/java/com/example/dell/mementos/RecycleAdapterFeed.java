package com.example.dell.mementos;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.List;

public class RecycleAdapterFeed extends RecyclerView.Adapter<RecycleAdapterFeed.MyViewHolder>
{
    private List<FeedData> dataList;
    private final ClickListener listener;

    public static  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView dp;
        TextView name;
        ImageView post;
        TextView rating;
        EditText comment;
        Button ratingbtn;
        //private WeakReference<ClickListener> listenerRef;

        public MyViewHolder(View view,  ClickListener listener )
        {
            super(view);
            dp = view.findViewById(R.id.dp);
            name = view.findViewById(R.id.name);
            post = view.findViewById(R.id.post);
            rating = view.findViewById(R.id.rating);
            comment = view.findViewById(R.id.comment);

            ratingbtn = view.findViewById(R.id.rate);

            view.setOnClickListener(this);
            ratingbtn.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            if (v.getId() == ratingbtn.getId())                 //why this works then?
            {
                makeRateBox(v);
            }
           /* else if(v.getId() == R.id.dpa)
            {
                Log.i("Error","in DP");
                Intent i = new Intent(v.getContext(), Userprofile.class);
                v.getContext().startActivity(i);
            }
            else if(v.getId() == R.id.posta)
            {
                Log.i("Error","in POST");
                Intent i = new Intent(v.getContext(), Post.class);
                v.getContext().startActivity(i);
            }*/
            //listenerRef.get().onPositionClicked(getAdapterPosition());
        }
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


    public RecycleAdapterFeed(List<FeedData> dataList, ClickListener listener)
    {
        this.dataList = dataList;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feed_row, parent, false);

        return new MyViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        FeedData data = dataList.get(position);
        //holder.dp.setImageDrawable(data.getDp());
        //holder.post.setImageDrawable(data.getPost());
        holder.name.setText(data.getName());
        holder.rating.setText(data.getRating());

        holder.post.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(v.getContext(), Post.class);
                v.getContext().startActivity(i);
            }
        });

        holder.dp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(v.getContext(), Userprofile.class);
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return dataList.size();
    }


}
