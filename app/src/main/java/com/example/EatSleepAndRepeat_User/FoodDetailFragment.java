package com.example.EatSleepAndRepeat_User;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.EatSleepAndRepeat_User.Classes.Dish;

/**
 * Scroll view in Fragment
 */
public class FoodDetailFragment extends Fragment {

    public FoodDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_detail, container, false);

        Bundle bundle = getArguments();
        Dish dish = (Dish) bundle.getSerializable("dish");

        TextView txtPlato = view.findViewById(R.id.txtPlato);
        txtPlato.setText(dish.getName());

        return view;
    }
}