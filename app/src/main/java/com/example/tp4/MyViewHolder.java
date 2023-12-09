package com.example.tp4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView ;
    TextView titleView , dateView ;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
         imageView = itemView.findViewById(R.id.imageview);
         titleView = itemView.findViewById(R.id.title);
         dateView = itemView.findViewById(R.id.date);


    }
}
