package com.example.EatSleepAndRepeat_User;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.EatSleepAndRepeat_User.SQLITE.CartListDBHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActivity extends AppCompatActivity {

    private CartListDBHelper cartHelper;
    private SQLiteDatabase dblite;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Initialize in home fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentHome()).commit();

        // Connect with bd
        cartHelper = new CartListDBHelper(getApplicationContext());
        dblite = cartHelper.getWritableDatabase();

        BottomNavigationView bottomNav = findViewById(R.id.main_menu);
        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.nav_home:
                    selectedFragment = new FragmentHome();
                    break;
                case R.id.nav_menu:
                    selectedFragment = new FragmentProducts(cartHelper, dblite);
                    break;
                case R.id.nav_cart:
                    selectedFragment = new FragmentCart(cartHelper, dblite);
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

