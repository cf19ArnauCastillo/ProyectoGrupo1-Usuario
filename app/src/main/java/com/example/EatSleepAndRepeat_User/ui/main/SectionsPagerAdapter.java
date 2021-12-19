package com.example.EatSleepAndRepeat_User.ui.main;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.EatSleepAndRepeat_User.Classes.Dish;
import com.example.EatSleepAndRepeat_User.FragmentCart;
import com.example.EatSleepAndRepeat_User.FragmentProducts;
import com.example.EatSleepAndRepeat_User.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private int numTabs;
    private Dish[] all;
    private Dish[] pizzas;
    private Dish[] starters;

    public SectionsPagerAdapter(FragmentManager fm, int numTabs, Dish[] all,
                                Dish[] pizzas, Dish[] starters) {
        super(fm);
        this.numTabs = numTabs;
        this.all = all;
        this.pizzas = pizzas;
        this.starters = starters;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentProducts tab1 = FragmentProducts.newInstance(all);
                return tab1;
            case 1:
                FragmentProducts tab2 = FragmentProducts.newInstance(pizzas);
                return tab2;
            case 2:
                FragmentProducts tab3 = FragmentProducts.newInstance(starters);
                return tab3;
            default:
                throw new RuntimeException("Tab position invalid " + position);
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}