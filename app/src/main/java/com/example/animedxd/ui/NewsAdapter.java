package com.example.animedxd.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.animedxd.R;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private final String[] dummyNews = {
            "Boruto Two Blue Vortex Release Date!",
            "One Piece Live Action Season 2 Confirmed!",
            "Jujutsu Kaisen Movie 2 Coming Soon!"
    };

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.textView.setText(dummyNews[position]);
    }

    @Override
    public int getItemCount() {
        return dummyNews.length;
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tvNewsTitle);
        }
    }
}
