package com.example.animedxd.ui.adapter; // Replace with your package name

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animedxd.R;
import com.example.animedxd.model.Anime;

import java.util.List;

public class MangaAdapter extends RecyclerView.Adapter<MangaAdapter.MangaViewHolder> {

    private List<Anime> mangaList;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }
    public MangaAdapter(List<Anime> mangaList) {
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
        Anime mangaItem = mangaList.get(position);
        holder.mangaImage.setImageResource(mangaItem.getImageResId());
        holder.mangaTitle.setText(mangaItem.getTitle());
        holder.mangaGenre.setText(mangaItem.getGenre());

        holder.itemView.setOnClickListener(v ->{
            if(onItemClickCallback!=null){
                onItemClickCallback.onItemClicked(mangaList.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        // Return the total number of items in the list
        return mangaList.size();
    }

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
        public interface OnItemClickCallback{
            void onItemClicked(Anime data);
        }

}
