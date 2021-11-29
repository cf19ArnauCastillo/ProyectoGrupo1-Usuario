package com.example.EatSleepAndRepeat_User;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.EatSleepAndRepeat_User.Classes.Dish;
import com.example.EatSleepAndRepeat_User.R;
import com.example.myapplication.Recyclers.RecyclerViewAdapter1;

public class FragmentHome extends Fragment {

    public FragmentHome() {
            // Required empty public constructor
    }

    SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewForm = inflater.inflate(R.layout.fragment_home, container, false);
        return inflater.inflate(R.layout.fragment_home, container, false);

        /*RecyclerView recyclerView = viewForm.findViewById(R.id.recylcer1);
        RecyclerViewAdapter1 adapter = new RecyclerViewAdapter1(array_dish);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((viewForm.getContext())));
         */
    }
}