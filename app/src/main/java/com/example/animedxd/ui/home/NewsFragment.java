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
                int currentItem = imageCarouselViewPager.getCurrentItem();
                int totalItems = imageCarouselViewPager.getAdapter().getItemCount();
                int nextItem = (currentItem + 1) % totalItems;
                imageCarouselViewPager.setCurrentItem(nextItem, true); // Smooth scroll
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
            int currentItem = imageCarouselViewPager.getCurrentItem();
            if (currentItem > 0) {
                imageCarouselViewPager.setCurrentItem(currentItem - 1, true);
            } else {
                // Loop to the last item if at the beginning
                imageCarouselViewPager.setCurrentItem(imageCarouselViewPager.getAdapter().getItemCount() - 1, true);
            }
            // Reset auto-scroll timer on manual interaction
            carouselHandler.removeCallbacks(carouselRunnable);
            carouselHandler.postDelayed(carouselRunnable, 5000);
        });

        btnNextCarousel.setOnClickListener(v -> {
            int currentItem = imageCarouselViewPager.getCurrentItem();
            int totalItems = imageCarouselViewPager.getAdapter().getItemCount();
            if (currentItem < totalItems - 1) {
                imageCarouselViewPager.setCurrentItem(currentItem + 1, true);
            } else {
                // Loop to the first item if at the end
                imageCarouselViewPager.setCurrentItem(0, true);
            }
            // Reset auto-scroll timer on manual interaction
            carouselHandler.removeCallbacks(carouselRunnable);
            carouselHandler.postDelayed(carouselRunnable, 5000);
        });


        // Set up News Articles RecyclerView
        recyclerViewNewsArticles.setLayoutManager(new LinearLayoutManager(getContext()));
        NewsArticleAdapter newsArticleAdapter = new NewsArticleAdapter(getNewsArticlesData());
        recyclerViewNewsArticles.setAdapter(newsArticleAdapter);

        return view;
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
                R.drawable.news_lovelive,
                "Novel 'Oni no Hanayome'...",
                "An anime adaptation of Kureha's 'Oni no Hanayome' (The Ogre's Bride) light novel was announced by publishing company Starts Shuppan on Tuesday. Kureha o..."
        ));
        articles.add(new NewsArticle(
                R.drawable.news_noveloni,
                "'Dr. Stone: Science Futu...",
                "The official website of the Dr. Stone anime series revealed two new cast, theme songs, and the main promotional video for the second part of Dr. Stone..."
        ));
        articles.add(new NewsArticle(
                R.drawable.news_drstone,
                "'Love Live! Hasunosora J...",
                "The 4th live concert of the Hasunosora Jogakuin School Idol Club is set to take place on November 25-26, 2023, at the Saitama Super Arena..."
        ));
        articles.add(new NewsArticle(
                R.drawable.news_drstone,
                "Another Anime News",
                "This is a placeholder for another exciting anime news article. Stay tuned for more updates!"
        ));
        articles.add(new NewsArticle(
                R.drawable.news_lovelive,
                "Final News Update",
                "The latest and greatest news from the anime world, bringing you all the hot topics and discussions."
        ));
        return articles;
    }
}
