package com.example.animedxd.ui.model;

public class MangaItem {
    private String title;
    private String genre;
    private int imageResId;

    public MangaItem(String title, String genre, int imageResId) {
        this.title = title;
        this.genre = genre;
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getImageResId() {
        return imageResId;
    }
}
    