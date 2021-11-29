package com.example.EatSleepAndRepeat_User.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.EatSleepAndRepeat_User.FragmentCarrito;
import com.example.EatSleepAndRepeat_User.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tabAll, R.string.tabPizzas, R.string.tabStarters, R.string.tabDesserts, R.string.tabDrinks};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;


        switch (position){
            case 0:
                fragment = new FragmentCarrito();
                break;
            case 1:
                fragment = new FragmentCarrito();
                break;
            case 2:
                fragment = new FragmentCarrito();
                break;
            case 3:
                fragment = new FragmentCarrito();
                break;
            case 4:
                fragment = new FragmentCarrito();
                break;
        }
        return PlaceholderFragment.newInstance(position + 1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 5;
    }
}