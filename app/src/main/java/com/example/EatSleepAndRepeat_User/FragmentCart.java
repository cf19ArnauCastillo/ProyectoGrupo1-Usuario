package com.example.EatSleepAndRepeat_User;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.EatSleepAndRepeat_User.Classes.Category;
import com.example.EatSleepAndRepeat_User.Classes.Order;
import com.example.EatSleepAndRepeat_User.DB.DBHelper;
import com.example.EatSleepAndRepeat_User.Recyclers.RecyclerViewAdapterCart;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FragmentCart extends Fragment {

    DBHelper dbHelper;
    DatabaseReference refOrd;
    FirebaseDatabase db;

    public FragmentCart() {
        // Required empty public constructor
    }

    public static FragmentCart newInstance(String param1, String param2) {
        FragmentCart fragment = new FragmentCart();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DBHelper();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        ArrayList<Order> orders = new ArrayList<>();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerCart);

        // TODO: Coger array list de la BD

        Button removeOrder = view.findViewById(R.id.removeOrder);
        removeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Viene de la BD
            }
        });
        return view;
    }
}