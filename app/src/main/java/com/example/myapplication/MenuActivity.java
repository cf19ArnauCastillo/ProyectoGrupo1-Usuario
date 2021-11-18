package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        BottomNavigationView bottomNav = findViewById(R.id.main_menu);
        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
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

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, selectedFragment).commit();
            return true;

        });
    }
}
