package com.example.animedxd.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.animedxd.R;
import com.example.animedxd.ui.model.NewsItem;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private final List<NewsItem> newsItems;

    public NewsAdapter(List<NewsItem> newsItems) {
        this.newsItems = newsItems;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsItem item = newsItems.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder {
        private final TextView date, title, percentage, content;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.newsDate);
            title = itemView.findViewById(R.id.newsTitle);
            percentage = itemView.findViewById(R.id.newsPercentage);
            content = itemView.findViewById(R.id.newsContent);
        }

        public void bind(NewsItem item) {
            date.setText(item.getDate());
            title.setText(item.getTitle());
            percentage.setText(item.getPercentage());
            content.setText(item.getContent());
        }
    }
}