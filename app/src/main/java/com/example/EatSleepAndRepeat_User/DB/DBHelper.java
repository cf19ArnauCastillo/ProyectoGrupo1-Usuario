package com.example.EatSleepAndRepeat_User.DB;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.EatSleepAndRepeat_User.Classes.Dish;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DBHelper {

    private final DatabaseReference db;
    private static final String TAG = "DB";

    public DBHelper(DatabaseReference db) {
        this.db = FirebaseDatabase.getInstance().getReference();
    }
    public String name;
    public String description;
    public String type;
    public int price;


    public void addDish(String name, String description, String type, int price){
        // [START add_ada_lovelace]
        // Create a dish
       Dish dish = new Dish(name, description, type, price);
    }

    /*public void getAllDishes(){
        db.collection("dish")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }*/


}
