package com.example.animedxd.ui.listpage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animedxd.R;
import com.example.animedxd.model.Anime;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {
    public ListAdapter(List<Anime> animeList, Context context) {
        this.animeList = animeList;
        this.context = context;
    }

    Context context;
    List<Anime> animeList;
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListViewHolder(LayoutInflater.from(context).inflate(R.layout.item_anime,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.titleView.setText(animeList.get(position).getTitle());
        holder.genreView.setText(animeList.get(position).getGenre());
        holder.descView.setText(animeList.get(position).getDescription());
        holder.imageView.setImageResource(animeList.get(position).getImageResId());

    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }
}
