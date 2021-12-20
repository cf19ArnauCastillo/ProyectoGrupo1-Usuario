package com.example.EatSleepAndRepeat_User;

import static androidx.databinding.DataBindingUtil.setContentView;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.EatSleepAndRepeat_User.Classes.Category;
import com.example.EatSleepAndRepeat_User.DB.DBHelper;
import com.example.EatSleepAndRepeat_User.Recyclers.RecyclerViewAdapterHome;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    private DBHelper dbHelper;
    FirebaseDatabase db;
    DatabaseReference refCat;

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
        // Crea la instancia a la BD
        dbHelper = new DBHelper();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        ArrayList<Category> categories = new ArrayList<Category>();
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerHome);

        // Provando que funciona: (Borrar cuando funcione)
        db = FirebaseDatabase.getInstance("https://admin-987aa-default-rtdb.europe-west1.firebasedatabase.app/");
        refCat = db.getReference("category");
        refCat.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()){
                    Category cat = ds.getValue(Category.class);
                    categories.add(cat);
                    Log.i("desdeHome", "------------------------------------" + cat.getCategoryName() + ds);
                }

                RecyclerViewAdapterHome adapter = new RecyclerViewAdapterHome(getContext(), categories);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return view;
    }
}