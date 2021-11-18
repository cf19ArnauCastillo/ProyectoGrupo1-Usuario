package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        // Initialize in home fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentHome()).commit();

        /**
         * Bottom navigation: change the screen to the fragment selected.
         */
        BottomNavigationView bottomNav = findViewById(R.id.main_menu);
        bottomNav.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.nav_menu:
                    selectedFragment = new FragmentHome();
                    break;
                case R.id.nav_cart:
                    selectedFragment = new FragmentCarrito();
                    break;
                case R.id.nav_settings:
                    selectedFragment = new FragmentSettings();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        });
    }
}
