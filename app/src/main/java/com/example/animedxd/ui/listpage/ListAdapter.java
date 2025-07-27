package com.example.animedxd.ui.listpage;
import android.os.Bundle;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.navigation.Navigation;

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

        holder.viewMoreButton.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("title", animeList.get(position).getTitle());
            bundle.putString("genre", animeList.get(position).getGenre());
            bundle.putString("synopsis", animeList.get(position).getDescription());
            bundle.putInt("imageRes", animeList.get(position).getImageResId());

            Navigation.findNavController(v).navigate(R.id.navigation_detail, bundle);

        });
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }
}
