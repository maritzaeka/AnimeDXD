package com.example.animedxd.ui.listpage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animedxd.R;

public class ListViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView titleView;
    TextView genreView;
    TextView descView;

    public ListViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
        titleView = itemView.findViewById(R.id.title);
        genreView = itemView.findViewById(R.id.genre);
        descView = itemView.findViewById(R.id.description);


    }
}
