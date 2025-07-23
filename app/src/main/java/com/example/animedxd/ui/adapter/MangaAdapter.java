package com.example.animedxd.ui.adapter; // Make sure this matches your actual package

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

    private final List<MangaItem> mangaItems;  // Made final for safety

    public MangaAdapter(List<MangaItem> mangaItems) {
        this.mangaItems = mangaItems;
    }

    @NonNull
    @Override
    public MangaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_manga, parent, false);
        return new MangaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MangaViewHolder holder, int position) {
        MangaItem item = mangaItems.get(position);
        holder.bind(item);  // Delegate to ViewHolder
    }

    @Override
    public int getItemCount() {
        return mangaItems.size();
    }

    static class MangaViewHolder extends RecyclerView.ViewHolder {
        private final ImageView cover;
        private final TextView title;
        private final TextView genre;

        public MangaViewHolder(@NonNull View itemView) {
            super(itemView);
            cover = itemView.findViewById(R.id.mangaCover);
            title = itemView.findViewById(R.id.mangaTitle);
            genre = itemView.findViewById(R.id.mangaGenre);
        }

        // Added bind method to separate concerns
        public void bind(MangaItem item) {
            title.setText(item.getTitle());
            genre.setText(item.getChapter());
            cover.setImageResource(R.drawable.manga1);
        }
    }
}