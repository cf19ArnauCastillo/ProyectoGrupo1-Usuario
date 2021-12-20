package com.example.EatSleepAndRepeat_User;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.EatSleepAndRepeat_User.DB.DBHelper;
import com.example.EatSleepAndRepeat_User.SQLITE.CartListDBHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActivity extends AppCompatActivity {

    private CartListDBHelper cartHelper;
    private SQLiteDatabase dblite;
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        cartHelper = new CartListDBHelper(context);
        // Initialize in home fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_app, new FragmentHome()).commit();

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
                    selectedFragment = new FragmentProducts();
                    break;
                case R.id.nav_cart:
                    selectedFragment = new FragmentCart(cartHelper, dblite);
                    break;
                case R.id.nav_settings:
                    selectedFragment = new FragmentSettings();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_app, selectedFragment).commit();
            return true;

        });

    }
}

