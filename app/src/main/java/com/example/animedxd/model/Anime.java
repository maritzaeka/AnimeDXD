package com.example.animedxd.model;

public class Anime {
    private String title;
    private String genre;
    private String description;
    private int imageResId; // atau String imageUrl jika menggunakan gambar dari internet

    public Anime(String title, String genre, String description, int imageResId) {
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.imageResId = imageResId;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResId() {
        return imageResId;
    }
}