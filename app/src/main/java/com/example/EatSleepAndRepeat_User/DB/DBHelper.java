package com.example.EatSleepAndRepeat_User.DB;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.EatSleepAndRepeat_User.Classes.Category;
import com.example.EatSleepAndRepeat_User.Classes.Dish;
import com.example.EatSleepAndRepeat_User.Classes.ItemCart;
import com.example.EatSleepAndRepeat_User.Classes.Order;
import com.example.EatSleepAndRepeat_User.Classes.Order;
import com.example.EatSleepAndRepeat_User.Recyclers.RecyclerViewAdapterHome;
import com.example.EatSleepAndRepeat_User.Recyclers.RecyclerViewAdapterProducts;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DBHelper {
    private static final String TAG = "DBHelper";
    private static final String[] TAB_TITLES = new String[]{"All","Pizzas", "Appetizers", "Drinks", "Desserts"};


    // Instance  of the Firebase Database

    FirebaseDatabase db;
    DatabaseReference refDish;
    DatabaseReference refCat;
    DatabaseReference refOrder;

    ArrayList<Dish> dishes;
    ArrayList<Category> categories;

    public DBHelper() {
        this.db = FirebaseDatabase.getInstance("https://admin-987aa-default-rtdb.europe-west1.firebasedatabase.app/");
        this.refDish = db.getReference("dish");
        this.refCat = db.getReference("category");
        this.refOrder = db.getReference("order");
        dishes = new ArrayList<Dish>();
    }

    public void readCategories(){
        refCat.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()){
                    Category cat = ds.getValue(Category.class);
                    categories.add(cat);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public ArrayList<Dish> getDishes(){
        ArrayList array = new ArrayList();
        for (int i = 0; i < TAB_TITLES.length; i++){
            refDish.child(TAB_TITLES[i]).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {

                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (!task.isSuccessful()) {
                        Log.e("firebase", "Error getting data", task.getException());
                    }
                    else {
                        for (DataSnapshot ds : task.getResult().getChildren()){
                            Dish dish = ds.getValue(Dish.class);
                            array.add(dish);
                        }
                    }
                }

            });
        }
        return array;
    }


    // Creates a new Order object and adds it to the Database
    // This method also allows to update all the values from a dish element
    public void addOrder(Order order) {

        //mDatabase = mDatabase.child("dish");
        Log.i("total", ""+order.getTotalPrice());
        DatabaseReference pushedPostRef = refOrder.child("order").push();

        String orderId = pushedPostRef.getKey();
        Log.i("testDB", "" + orderId);

        refOrder.child(orderId).setValue(order);
    }

    // Creates a new Dish object and adds it to the Database
    // This method also allows to update all the values from a dish element
    public void addDish(String name, String imageName, String category, String description, Double price) {

        //mDatabase = mDatabase.child("dish");

        DatabaseReference pushedPostRef = refDish.child("dish").push();

        String dishId = pushedPostRef.getKey();
        Log.i("testDB", "" + dishId);

        Dish dish = new Dish(dishId,imageName,category,name,description,price);
        refDish.child("dish").child(dishId).setValue(dish);
    }


    // Replaces the name from a single dish element
    public void replaceName(Integer dishId, String newName) {
        refDish.child("dish").child(String.valueOf(dishId)).child("name").setValue(newName);
    }

    // Replaces the category from a single dish element
    public void replaceCategory(Integer dishIs, String newCategory) {
        refDish.child("dish").child(String.valueOf(dishIs)).child("category").setValue(newCategory);
    }

    // Replaces the description from a single dish element
    public void replaceDescription(Integer dishId, String newDescription) {
        refDish.child("dish").child(String.valueOf(dishId)).child("description").setValue(newDescription);
    }

    // Replaces the price from a single dish element
    public void replacePrice(Integer dishId, Double newPrice) {
        refDish.child("dish").child(String.valueOf(dishId)).child("price").setValue(newPrice);
    }

    // Removes a values from a single dish element
    public void removeValue(Integer dishId, String type) {
        refDish.child("dish").child(String.valueOf(dishId)).child(type).removeValue();
    }

    // Removes a hole Dish element
    public void removeDish(Integer dishId) {
        refDish.child("dish").child(String.valueOf(dishId)).removeValue();
    }

    // Receives a DataSnapshot that contains the values from a specific location on the database
    public void readDataSnapShot(DatabaseReference mDishReference) {
        ValueEventListener dishListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Dish object and use the values to update the UI
                Dish dish = dataSnapshot.getValue(Dish.class);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };
        mDishReference.addValueEventListener(dishListener);
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
    }
    */
}
