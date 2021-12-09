package com.example.EatSleepAndRepeat_User.DB;

import android.util.Log;

import com.example.EatSleepAndRepeat_User.Classes.Dish;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DBHelper {
    private static final String TAG = "DBHelper";

    // Instance  of the Firebase Database

    FirebaseDatabase db;
    DatabaseReference refDish;
    ArrayList<Dish> dishes;

    public DBHelper() {
        this.db = FirebaseDatabase.getInstance("https://admin-987aa-default-rtdb.europe-west1.firebasedatabase.app/");
        this.refDish = db.getReference("dish");
        dishes = new ArrayList<Dish>();
    }

    public void readDishes(){

        Log.i("entro", "------------_");
        refDish.child("Drink").addListenerForSingleValueEvent(new ValueEventListener() {
          @Override
          public void onDataChange(DataSnapshot dataSnapshot) {
              for (DataSnapshot ds : dataSnapshot.getChildren()){
                  Dish dish = ds.getValue(Dish.class);
                  dishes.add(dish);
                  Log.i("prova", "------------------------------------" + dish.getName() + ds);
              }

              //Log.i("prova", "" + dishes.size() + " - " + dishes.get(0).getName());

          }

          @Override
          public void onCancelled(DatabaseError databaseError) {
             // System.out.println("The read failed: " + databaseError.getCode());
          }
        });
    }
    public ArrayList<Dish> getDishes(){
        readDishes();
        return dishes;
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
