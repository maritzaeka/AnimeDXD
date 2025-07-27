package com.example.animedxd.ui.model;


public class NewsArticle {
    private int thumbnailResId;
    private String title;
    private String snippet;

    public NewsArticle(int thumbnailResId, String title, String snippet) {
        this.thumbnailResId = thumbnailResId;
        this.title = title;
        this.snippet = snippet;
    }

    public int getThumbnailResId() {
        return thumbnailResId;
    }

    public String getTitle() {
        return title;
    }

    public String getSnippet() {
        return snippet;
    }
}
    