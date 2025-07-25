package com.example.animedxd.ui.adapter; // Replace with your package name

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animedxd.R;
import com.example.animedxd.ui.model.NewsArticle;

import java.util.List;

public class NewsArticleAdapter extends RecyclerView.Adapter<NewsArticleAdapter.NewsArticleViewHolder> {

    private List<NewsArticle> newsArticles;

    public NewsArticleAdapter(List<NewsArticle> newsArticles) {
        this.newsArticles = newsArticles;
    }

    @NonNull
    @Override
    public NewsArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_article, parent, false);
        return new NewsArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsArticleViewHolder holder, int position) {
        NewsArticle article = newsArticles.get(position);
        holder.articleThumbnail.setImageResource(article.getThumbnailResId());
        holder.articleTitle.setText(article.getTitle());
        holder.articleSnippet.setText(article.getSnippet());
    }

    @Override
    public int getItemCount() {
        return newsArticles.size();
    }

    public static class NewsArticleViewHolder extends RecyclerView.ViewHolder {
        ImageView articleThumbnail;
        TextView articleTitle;
        TextView articleSnippet;

        public NewsArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            articleThumbnail = itemView.findViewById(R.id.articleThumbnail);
            articleTitle = itemView.findViewById(R.id.articleTitle);
            articleSnippet = itemView.findViewById(R.id.articleSnippet);
        }
    }
}
