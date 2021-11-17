package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        /**
         * Bottom navigation: change the screen to the fragment selected.
         */
        BottomNavigationView bottomNav = findViewById(R.id.);
        bottomNav.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.nav_menu:
                    selectedFragment = new MenuActivity();
                    break;
                case R.id.nav_cart:
                    selectedFragment = new FormFragment();
                    break;
                case R.id.nav_settings:
                    selectedFragment = new ListFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        });
}
