package com.example.dell.mementos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecycleAdapterComments extends RecyclerView.Adapter<RecycleAdapterComments.MyViewHolder>
{
    private List<Data> dataList;

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView text;
        public MyViewHolder(View view)
        {
            super(view);
            img = view.findViewById(R.id.image);
            text = view.findViewById(R.id.text);
        }
    }

        public RecycleAdapterComments(List<Data> dataList)
        {
            this.dataList = dataList;
        }

        @Override
        public RecycleAdapterComments.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.comments, parent, false);

            return new RecycleAdapterComments.MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(RecycleAdapterComments.MyViewHolder holder, int position)
        {
            Data data = dataList.get(position);
            //holder.img;
            holder.text.setText(data.getText());
        }

        @Override
        public int getItemCount()
        {
            return dataList.size();
        }
}

