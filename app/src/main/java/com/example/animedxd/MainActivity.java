package com.example.animedxd; // Replace with your package name

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.animedxd.R;
import com.example.animedxd.ui.home.HomepageFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;
import android.widget.Toast; // For simple toast messages

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView; // Declared here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set the new main activity layout

        // Corrected line: Use bottomNavigationView as the ID
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Load the default fragment when the activity is created (e.g., HomepageFragment)
        if (savedInstanceState == null) {
            loadFragment(new HomepageFragment());
        }

        // Handle Bottom Navigation View item selections
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.navigation_home) {
                    // Load the HomepageFragment when Home is selected
                    loadFragment(new HomepageFragment());
                    return true;
                } else if (itemId == R.id.navigation_home) {
                    // Placeholder for List Fragment
                    Toast.makeText(MainActivity.this, "List Clicked - Load List Fragment", Toast.LENGTH_SHORT).show();
                    // Example: loadFragment(new ListFragment());
                    return true;
                } else if (itemId == R.id.navigation_home) {
                    // Placeholder for About Fragment
                    Toast.makeText(MainActivity.this, "About Clicked - Load About Fragment", Toast.LENGTH_SHORT).show();
                    // Example: loadFragment(new AboutFragment());
                    return true;
                }
                return false;
            }
        });

        // Set the default selected item for the bottom navigation (e.g., Home)
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
    }

    /**
     * Helper method to load a fragment into the FragmentContainerView.
     * @param fragment The fragment to load.
     */
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Replace the content of the fragment_container with the new fragment
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
