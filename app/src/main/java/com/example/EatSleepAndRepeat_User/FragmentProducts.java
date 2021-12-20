package com.example.EatSleepAndRepeat_User;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.EatSleepAndRepeat_User.Classes.Dish;
import com.example.EatSleepAndRepeat_User.Recyclers.RecyclerViewAdapterProducts;
import com.example.EatSleepAndRepeat_User.SQLITE.CartListDBHelper;
import com.example.EatSleepAndRepeat_User.databinding.FragmentProductLabelBinding;
import com.example.EatSleepAndRepeat_User.ui.main.PlaceholderFragment;
import com.example.EatSleepAndRepeat_User.ui.main.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentProducts#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentProducts extends Fragment {

    private Fragment productFragment;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private SQLiteDatabase dblite;
    private CartListDBHelper cartHelper;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    public FragmentProducts() {
        // Required empty public constructor
    }
    public FragmentProducts(CartListDBHelper cartHelper, SQLiteDatabase dblite) {
        this.cartHelper = cartHelper;
        this.dblite = dblite;
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentProducts newInstance() {
        return new FragmentProducts();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.activity_products, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getContext(), getFragmentManager());
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(getContext(), "Tab selected " +  tab.getPosition(), Toast.LENGTH_SHORT).show();
                PlaceholderFragment.newInstance(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    private TabLayout.OnTabSelectedListener getOnTabSelectedListener(final ViewPager viewPager) {
        return new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                Toast.makeText(getContext(), "Tab selected " +  tab.getPosition(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // nothing now
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // nothing now
            }
        };
    }


}