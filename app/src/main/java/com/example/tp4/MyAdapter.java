package com.example.tp4;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context ;
    List<item> items;

    private OnItemClickListener mListener;

    public MyAdapter(Context context, List<item> items) {
        this.context = context;
        this.items = items;
    }

     @SuppressLint("NotifyDataSetChanged")
     public void setFilteredList(List<item> filteredList){
        this.items= filteredList;
        notifyDataSetChanged();
     }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        boolean attachToRoot = false;
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      holder.titleView.setText(items.get(position).getTitle() );
      holder.imageView.setImageResource(items.get(position).getImage() );
      holder.dateView.setText(items.get(position).getDate() );
      holder.imageView.setOnClickListener(view -> {
          if(mListener != null ){
              mListener.onItemClick(position);
          }
      });
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
}



