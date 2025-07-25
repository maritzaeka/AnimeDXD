package com.example.animedxd.ui.home; // Use your actual package name

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.animedxd.R;
import com.example.animedxd.ui.home.MangaFragment;
import com.example.animedxd.ui.home.NewsFragment;
import com.google.android.material.tabs.TabLayout;
// Removed import for TabLayoutMediator as we'll handle tab selection manually
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomepageFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    public HomepageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homepage_activity, container, false);

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), getLifecycle());
        viewPager.setAdapter(viewPagerAdapter);

        // Manually add tabs and set up listener for no slide transition
        tabLayout.addTab(tabLayout.newTab().setText("News"));
        tabLayout.addTab(tabLayout.newTab().setText("Manga"));

        // Add a listener to handle tab selection
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Set the ViewPager2 current item WITHOUT smooth scroll animation
                viewPager.setCurrentItem(tab.getPosition(), false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Not needed for this functionality
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Not needed for this functionality
            }
        });

        // Add a listener to synchronize ViewPager2 swipes with TabLayout
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        return view;
    }

    /**
     * Adapter for the ViewPager2 to manage fragments for each tab.
     */
    private static class ViewPagerAdapter extends FragmentStateAdapter {

        public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new NewsFragment();
                case 1:
                    return new MangaFragment();
                default:
                    return new NewsFragment();
            }
        }

        @Override
        public int getItemCount() {
            return 2; // Number of tabs
        }
    }
}
