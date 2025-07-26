package com.example.animedxd;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private BottomNavigationView navBottom;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); // Hide default title

        // Setup Navigation
        navBottom = findViewById(R.id.nav_bottom);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);

        // Configure the fragments that should be considered as top-level destinations
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home,
                R.id.navigation_list,
                R.id.navigation_about
        ).build();

        NavigationUI.setupWithNavController(navBottom, navController);

        // Listener for BottomNavigationView
        navBottom.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            int currentId = navController.getCurrentDestination().getId();

            if (currentId == id) {
                return false; // Already on the same page, don't navigate again
            }

            // Show toast according to menu item
            if (id == R.id.navigation_home) {
                Toast.makeText(this, "Home pressed", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.navigation_list) {
                Toast.makeText(this, "List pressed", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.navigation_about) {
                Toast.makeText(this, "About pressed", Toast.LENGTH_SHORT).show();
            }

            // Navigate with popUpTo to clear previous fragments
            NavOptions navOptions = new NavOptions.Builder()
                    .setPopUpTo(R.id.mobile_navigation, true)
                    .setLaunchSingleTop(true)
                    .build();

            navController.navigate(id, null, navOptions);
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        int currentId = navController.getCurrentDestination().getId();
//
//        if (id == R.id.action_notifications && currentId != R.id.navigation_notifications) {
//            navController.navigate(R.id.navigation_notifications);
//            return true;
//        } else if (id == R.id.action_profile && currentId != R.id.navigation_profile) {
//            navController.navigate(R.id.navigation_profile);
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}