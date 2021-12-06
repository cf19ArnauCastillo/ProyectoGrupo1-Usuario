package com.example.EatSleepAndRepeat_User;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.EatSleepAndRepeat_User.Classes.Dish;
import com.example.EatSleepAndRepeat_User.R;
import com.example.EatSleepAndRepeat_User.Recyclers.RecyclerViewAdapterHome;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FragmentCarrito extends Fragment {

    public FragmentCarrito() {
        // Required empty public constructor
    }

    public static FragmentCarrito newInstance(String param1, String param2) {
        FragmentCarrito fragment = new FragmentCarrito();
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
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://admin-987aa-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
        ArrayList<String> array_cart = new ArrayList<>();

        View view = inflater.inflate(R.layout.fragment_carrito, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerviewcarrito);
        RecyclerViewAdapterHome adapter = new RecyclerViewAdapterHome(array_cart);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        return inflater.inflate(R.layout.fragment_carrito, container, false);
    }
}