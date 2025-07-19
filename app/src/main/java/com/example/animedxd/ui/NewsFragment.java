package com.example.animedxd.ui;

import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.example.animedxd.R;
import java.util.Timer;
import java.util.TimerTask;

public class NewsFragment extends Fragment {

    private ViewPager carouselViewPager;
    private int currentPage = 0;
    private final Handler handler = new Handler();

    private final Runnable update = () -> {
        currentPage = (currentPage + 1) % 3;
        carouselViewPager.setCurrentItem(currentPage, true);
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_fragment, container, false);

        carouselViewPager = view.findViewById(R.id.carousel_viewpager);
        carouselViewPager.setAdapter(new CarouselAdapter(getContext()));

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 5000, 5000);

        RecyclerView newsList = view.findViewById(R.id.news_recyclerview);
        newsList.setLayoutManager(new LinearLayoutManager(getContext()));
        newsList.setAdapter(new NewsAdapter());

        return view;
    }
}
