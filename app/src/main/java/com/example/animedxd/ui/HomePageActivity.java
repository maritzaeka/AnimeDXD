package com.example.animedxd.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.example.animedxd.R;
import com.example.animedxd.ui.adapter.CarouselAdapter; // Ensure this exists
import com.example.animedxd.ui.model.CarouselItem; // Ensure this exists
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {

    private ViewPager2 carouselViewPager;
    private final Handler autoScrollHandler = new Handler();
    private final long AUTO_SCROLL_DELAY = 3000; // 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        // Set welcome message
//        TextView welcomeText = findViewById(R.id.welcomeText);
//        welcomeText.setText("Welcome, " + getIntent().getStringExtra("USER_NAME"));

        // Setup carousel
        setupCarousel();

        // Setup tabs
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new NewsFragment();
                        break;
                    case 1:
                        fragment = new MangaFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        // Load default fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new NewsFragment())
                .commit();
    }

    private void setupCarousel() {
        carouselViewPager = findViewById(R.id.carouselViewPager);
        ImageButton btnLeft = findViewById(R.id.btnLeft);
        ImageButton btnRight = findViewById(R.id.btnRight);
        LinearLayout indicatorLayout = findViewById(R.id.indicatorLayout);

        // Sample data
        List<CarouselItem> carouselItems = new ArrayList<>();
        carouselItems.add(new CarouselItem("Marine Style", "6.99%", Color.BLUE));
        carouselItems.add(new CarouselItem("New Releases", "Summer 2025", Color.RED));
        carouselItems.add(new CarouselItem("Top Rated", "9.2/10", Color.GREEN));

        CarouselAdapter adapter = new CarouselAdapter(carouselItems);
        carouselViewPager.setAdapter(adapter);

        // Setup indicators
        setupIndicators(carouselItems.size(), indicatorLayout);

        // Auto-scroll
        autoScrollHandler.postDelayed(autoScrollRunnable, AUTO_SCROLL_DELAY);

        // Navigation buttons
        btnLeft.setOnClickListener(v -> {
            int currentItem = carouselViewPager.getCurrentItem();
            if (currentItem > 0) {
                carouselViewPager.setCurrentItem(currentItem - 1, true);
            }
        });

        btnRight.setOnClickListener(v -> {
            int currentItem = carouselViewPager.getCurrentItem();
            if (currentItem < carouselItems.size() - 1) {
                carouselViewPager.setCurrentItem(currentItem + 1, true);
            }
        });

        // Update indicators on page change
        carouselViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                updateIndicators(position, indicatorLayout);
                autoScrollHandler.removeCallbacks(autoScrollRunnable);
                autoScrollHandler.postDelayed(autoScrollRunnable, AUTO_SCROLL_DELAY);
            }
        });
    }

    private void setupIndicators(int count, LinearLayout indicatorLayout) {
        indicatorLayout.removeAllViews();
        for (int i = 0; i < count; i++) {
            View view = new View(this);
            view.setBackgroundResource(i == 0 ?
                    R.drawable.indicator_selected :
                    R.drawable.indicator_unselected);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(16, 16);
            params.setMargins(8, 0, 8, 0);
            indicatorLayout.addView(view, params);
        }
    }

    private void updateIndicators(int position, LinearLayout indicatorLayout) {
        for (int i = 0; i < indicatorLayout.getChildCount(); i++) {
            View view = indicatorLayout.getChildAt(i);
            view.setBackgroundResource(i == position ?
                    R.drawable.indicator_selected :
                    R.drawable.indicator_unselected);
        }
    }

    private final Runnable autoScrollRunnable = new Runnable() {
        @Override
        public void run() {
            int currentItem = carouselViewPager.getCurrentItem();
            int totalItems = carouselViewPager.getAdapter().getItemCount();
            carouselViewPager.setCurrentItem((currentItem + 1) % totalItems, true);
            autoScrollHandler.postDelayed(this, AUTO_SCROLL_DELAY);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        autoScrollHandler.removeCallbacksAndMessages(null);
    }
}