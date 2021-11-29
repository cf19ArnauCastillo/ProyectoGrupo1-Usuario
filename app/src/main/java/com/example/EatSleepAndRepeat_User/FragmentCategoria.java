package com.example.EatSleepAndRepeat_User;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentCategoria#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCategoria extends Fragment {

    public FragmentCategoria() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static FragmentCategoria newInstance(String param1, String param2) {
        FragmentCategoria fragment = new FragmentCategoria();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_category, container, false);
    }
}