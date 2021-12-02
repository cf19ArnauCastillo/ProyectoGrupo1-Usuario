package com.example.EatSleepAndRepeat_User;

import static androidx.databinding.DataBindingUtil.setContentView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.EatSleepAndRepeat_User.Recyclers.RecyclerViewAdapterHome;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    public FragmentHome() {
            // Required empty public constructor
    }
    public static FragmentHome newInstance(String param1, String param2) {
        FragmentHome fragment = new FragmentHome();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            ArrayList<String> array_categories = new ArrayList<>();
            array_categories.add("Luke Skywalker");
            array_categories.add("Leia Organa");
            array_categories.add("Chewbacca");
            array_categories.add("C3P0");
            array_categories.add("R2D2");
            array_categories.add("Darth Vader");
            array_categories.add("Han Solo");
            array_categories.add("Luke Skywalker");

            View view = inflater.inflate(R.layout.fragment_home, container, false);
            RecyclerView recyclerView = view.findViewById(R.id.recyclerHome);
            RecyclerViewAdapterHome adapter = new RecyclerViewAdapterHome(array_categories);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        // Inflate the layout for this fragment
        return view;
    }
}