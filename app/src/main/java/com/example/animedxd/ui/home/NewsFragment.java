package com.example.animedxd.ui.home; // Use your actual package name

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton; // Import ImageButton
import android.os.Handler; // Import Handler

import com.example.animedxd.R;
import com.example.animedxd.ui.adapter.ImageCarouselAdapter;
import com.example.animedxd.ui.adapter.NewsArticleAdapter;
import com.example.animedxd.ui.model.NewsArticle;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {

    private ViewPager2 imageCarouselViewPager;
    private ImageButton btnPrevCarousel;
    private ImageButton btnNextCarousel;
    private RecyclerView recyclerViewNewsArticles;

    private Handler carouselHandler = new Handler();
    private Runnable carouselRunnable = new Runnable() {
        @Override
        public void run() {
            if (imageCarouselViewPager != null && imageCarouselViewPager.getAdapter() != null) {
                imageCarouselViewPager.setCurrentItem(imageCarouselViewPager.getCurrentItem() + 1, true);
                carouselHandler.postDelayed(this, 5000); // Auto-scroll every 5 seconds
            }
        }
    };

    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        imageCarouselViewPager = view.findViewById(R.id.imageCarouselViewPager);
        btnPrevCarousel = view.findViewById(R.id.btnPrevCarousel);
        btnNextCarousel = view.findViewById(R.id.btnNextCarousel);
        recyclerViewNewsArticles = view.findViewById(R.id.recyclerViewNewsArticles);

        // Set up Image Carousel ViewPager2
        ImageCarouselAdapter carouselAdapter = new ImageCarouselAdapter(getCarouselImages());
        imageCarouselViewPager.setAdapter(carouselAdapter);

        // Set up click listeners for carousel navigation arrows
        btnPrevCarousel.setOnClickListener(v -> {
            imageCarouselViewPager.setCurrentItem(imageCarouselViewPager.getCurrentItem() - 1, true);
            resetAutoScrollTimer();
        });

        btnNextCarousel.setOnClickListener(v -> {
            imageCarouselViewPager.setCurrentItem(imageCarouselViewPager.getCurrentItem() + 1, true);
            resetAutoScrollTimer();
        });


        // Set up News Articles RecyclerView
        recyclerViewNewsArticles.setLayoutManager(new LinearLayoutManager(getContext()));
        NewsArticleAdapter newsArticleAdapter = new NewsArticleAdapter(getNewsArticlesData());
        recyclerViewNewsArticles.setAdapter(newsArticleAdapter);

        return view;
    }

    private void resetAutoScrollTimer(){
        carouselHandler.removeCallbacks(carouselRunnable);
        carouselHandler.postDelayed(carouselRunnable, 5000);
    }

    @Override
    public void onResume() {
        super.onResume();
        // Start auto-scrolling when the fragment is visible
        carouselHandler.postDelayed(carouselRunnable, 5000);
    }

    @Override
    public void onPause() {
        super.onPause();
        // Stop auto-scrolling when the fragment is not visible
        carouselHandler.removeCallbacks(carouselRunnable);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Clean up handler callbacks to prevent memory leaks
        carouselHandler.removeCallbacks(carouselRunnable);
    }

    /**
     * Dummy data for the image carousel. In a real app, this would come from an API.
     */
    private List<Integer> getCarouselImages() {
        List<Integer> images = new ArrayList<>();
        // Add your drawable resource IDs here
        images.add(R.drawable.car_jjk);
        images.add(R.drawable.car_spy);
        images.add(R.drawable.car_wind);
        return images;
    }


    private List<NewsArticle> getNewsArticlesData() {
        List<NewsArticle> articles = new ArrayList<>();
        articles.add(new NewsArticle(
                R.drawable.news_noveloni,
                "Novel 'Oni no Hanayome' Receives TV Anime Adaptation",
                "An anime adaptation of Kureha's Oni no Hanayome (The Ogre's Bride) light novel was announced by publishing company Starts Shuppan on Tuesday."
        ));
        articles.add(new NewsArticle(
                R.drawable.news_drstone,
                "'Dr. Stone: Science Future' Part 2 Announces New Cast, Theme Songs",
                "The official website of the Dr. Stone anime series revealed two new cast, theme songs, and the main promotional video for the second part of Dr. Stone."
        ));
        articles.add(new NewsArticle(
                R.drawable.news_lovelive,
                "'Love Live! Hasunosora Jogakuin School Idol Club' 3D Anime Movie Announced",
                "The 4th live concert of the Hasunosora Jogakuin School Idol Club (Hasunosora Girls' High School Idol Club) announced a 3D anime movie on Sunday."
        ));
        articles.add(new NewsArticle(
                R.drawable.news_tenseishitara,
                "'Tensei shitara Dragon no Tamago datta' Unveils Main Staff, Teaser Promo for 2026",
                "The official website of the Tensei shitara Dragon no Tamago datta (Reincarnated as a Dragon Hatchling) television anime unveiled the main staff on Friday."
        ));
        articles.add(new NewsArticle(
                R.drawable.news_disneytwisted,
                "'Disney: Twisted Wonderland the Animation' Announces Additional Cast Members",
                "The official website for the Disney: Twisted-Wonderland the Animation anime series announced 23 additional cast premiere on Disney+ in October 2025."
        ));
        return articles;
    }
}
