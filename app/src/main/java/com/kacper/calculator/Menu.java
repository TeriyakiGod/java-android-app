// DrawerManager.java

package com.kacper.calculator;

import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Menu implements NavigationView.OnNavigationItemSelectedListener {

    private final AppCompatActivity activity;
    private final DrawerLayout drawerLayout;
    private final ActionBar actionBar;
    private final Toolbar toolbar;

    public Menu(AppCompatActivity activity, DrawerLayout drawerLayout, Toolbar toolbar) {
        this.activity = activity;
        this.drawerLayout = drawerLayout;
        this.toolbar = toolbar;

        activity.setSupportActionBar(toolbar);
        actionBar = activity.getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                activity,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = activity.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.nav_calculator) {
            // Optional: Check if already on the Calculator activity to avoid restarting it
            if (!activity.getClass().getSimpleName().equals("Calculator")) {
                activity.startActivity(new Intent(activity, CalculatorView.class));
            }
        } else if (itemId == R.id.nav_gallery) {
            activity.startActivity(new Intent(activity, GalleryView.class));
            // Add more cases for other menu items as needed
        }

        // Close the drawer after handling the item click
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
