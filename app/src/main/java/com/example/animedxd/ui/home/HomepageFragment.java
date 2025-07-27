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
import com.example.animedxd.ui.LoginActivity;
import com.example.animedxd.ui.home.MangaFragment;
import com.example.animedxd.ui.home.NewsFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

        TextView welcomeMessage = view.findViewById(R.id.welcomeMessage);
        String username = LoginActivity.GLOBAL_USERNAME;
        welcomeMessage.setText("Welcome, " + username + "!");

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);

        // Ensure the TabLayout is empty before attaching the mediator
        // This is a crucial step to prevent duplicate tabs if they were somehow added elsewhere
        tabLayout.removeAllTabs();

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), getLifecycle());
        viewPager.setAdapter(viewPagerAdapter);

        // Re-link TabLayout with ViewPager2 using TabLayoutMediator
        // This will automatically create tabs based on the ViewPager's adapter getItemCount()
        // and set their text based on the lambda.
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    // Set the text for each tab based on its position
                    // This will ensure the text is "NEWS" and "MANGA"
                    switch (position) {
                        case 0:
                            tab.setText("NEWS");
                            break;
                        case 1:
                            tab.setText("MANGA");
                            break;
                    }
                }).attach();

        // Add a listener to handle tab selection without animation (no slide)
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

        viewPager.setUserInputEnabled(false);

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
            return 2; // Number of tabs (News and Manga)
        }
    }
}
