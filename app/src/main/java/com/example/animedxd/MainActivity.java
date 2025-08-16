package com.example.animedxd;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.animedxd.ui.LoginActivity;
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

        toolbar.setNavigationIcon(R.drawable.ic_menu); // icon hamburger di kiri
        toolbar.setNavigationOnClickListener(v -> {
            Toast.makeText(this, "Hamburger diklik!", Toast.LENGTH_SHORT).show();
            showLogoutPopup(v);
        });

        // Setup Navigation
        navBottom = findViewById(R.id.nav_bottom);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.navigation_detail) {
                toolbar.setVisibility(View.GONE);
                navBottom.setVisibility(View.GONE);
            } else {
                toolbar.setVisibility(View.VISIBLE);
                navBottom.setVisibility(View.VISIBLE);

            }
        });

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

    private void showLogoutPopup(View anchorView) {
        View popupView = getLayoutInflater().inflate(R.layout.popup_logout, null);

        PopupWindow popupWindow = new PopupWindow(popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                true);

        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());


        popupWindow.showAsDropDown(anchorView, -30, 20);


        Button btnLogout = popupView.findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(v -> {
            popupWindow.dismiss();
            Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

    }
}