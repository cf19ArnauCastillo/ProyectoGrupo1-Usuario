package com.example.EatSleepAndRepeat_User;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.EatSleepAndRepeat_User.Classes.Dish;
import com.example.EatSleepAndRepeat_User.SQLITE.CartListDBHelper;

public class FragmentFoodDetail extends Fragment {
    private SQLiteDatabase dblite;
    private CartListDBHelper cartHelper;

    public FragmentFoodDetail() {
        // Required empty public constructor
    }

    public FragmentFoodDetail(CartListDBHelper cartHelper, SQLiteDatabase dblite) {
        this.cartHelper = cartHelper;
        this.dblite = dblite;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //hello
        View view = inflater.inflate(R.layout.fragment_food_detail, container, false);
        // Recoje la informacion mandada desde el recycler
        Bundle bundle = getArguments();
        Dish dish = (Dish) bundle.getSerializable("dish");

        TextView txtPlato = view.findViewById(R.id.txtPlato);
        txtPlato.setText(dish.getName());

        Spinner spinner = (Spinner) view.findViewById(R.id.spinnersize);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter;
        adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.size,
                android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setSelection(0, false);

        return view;
    }
}