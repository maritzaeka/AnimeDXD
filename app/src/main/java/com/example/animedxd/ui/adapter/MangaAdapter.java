package com.example.animedxd.ui.adapter; // Replace with your package name

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animedxd.R;
import com.example.animedxd.ui.model.MangaItem;

import java.util.List;

public class MangaAdapter extends RecyclerView.Adapter<MangaAdapter.MangaViewHolder> {

    private List<MangaItem> mangaList;

    public MangaAdapter(List<MangaItem> mangaList) {
        this.mangaList = mangaList;
    }

    @NonNull
    @Override
    public MangaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item_manga_card layout for each item in the RecyclerView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_manga_card, parent, false);
        return new MangaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MangaViewHolder holder, int position) {
        // Bind data to the views in each item
        MangaItem mangaItem = mangaList.get(position);
        holder.mangaImage.setImageResource(mangaItem.getImageResId());
        holder.mangaTitle.setText(mangaItem.getTitle());
        holder.mangaGenre.setText(mangaItem.getGenre());
    }

    @Override
    public int getItemCount() {
        // Return the total number of items in the list
        return mangaList.size();
    }

    /**
     * ViewHolder class to hold references to the views in each item layout.
     */
    public static class MangaViewHolder extends RecyclerView.ViewHolder {
        ImageView mangaImage;
        TextView mangaTitle;
        TextView mangaGenre;

        public MangaViewHolder(@NonNull View itemView) {
            super(itemView);
            mangaImage = itemView.findViewById(R.id.mangaImage);
            mangaTitle = itemView.findViewById(R.id.mangaTitle);
            mangaGenre = itemView.findViewById(R.id.mangaGenre);
        }
    }
}
