package com.example.EatSleepAndRepeat_User;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.EatSleepAndRepeat_User.Classes.Dish;
import com.example.EatSleepAndRepeat_User.Classes.ItemCart;
import com.example.EatSleepAndRepeat_User.Classes.Order;
import com.example.EatSleepAndRepeat_User.DB.DBHelper;
import com.example.EatSleepAndRepeat_User.R;
import com.example.EatSleepAndRepeat_User.Recyclers.RecyclerViewAdapterCart;
import com.example.EatSleepAndRepeat_User.Recyclers.RecyclerViewAdapterHome;
import com.example.EatSleepAndRepeat_User.Recyclers.RecyclerViewAdapterProducts;
import com.example.EatSleepAndRepeat_User.SQLITE.CartList;
import com.example.EatSleepAndRepeat_User.SQLITE.CartListDBHelper;
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

public class FragmentCart extends Fragment {

    private DBHelper dbHelper;
    private DatabaseReference refOrd;
    private FirebaseDatabase db;
    private ArrayList<CartList> items;
    private SQLiteDatabase dblite;
    private CartListDBHelper cartHelper;
    private DatabaseReference refDish;

    public FragmentCart() {
        // Required empty public constructor
    }

    public FragmentCart(CartListDBHelper cartHelper, SQLiteDatabase dblite) {
        this.cartHelper = cartHelper;
        this.dblite = dblite;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerCart);

        // Get all items from cart
        items = cartHelper.getAllData(dblite);

        RecyclerViewAdapterCart adapter = new RecyclerViewAdapterCart(getContext(), items, cartHelper, dblite);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Set total amount
        TextView amount = view.findViewById(R.id.intTotal);
        amount.setText(getAmount());

        // Delete the order
        Button removeOrder = view.findViewById(R.id.removeOrder);
        removeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: BD

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle(getString(R.string.alertDelete));
                builder.setMessage(getString(R.string.confirmation))
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //OK METHOD
                                //TODO: BD
                                cartHelper.deleteOrder(dblite);
                                cartHelper.createTable(dblite);
                                refresh();
                                Toast.makeText(getContext(), getString(R.string.deletedOrder), Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //KO METHOD
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        Button checkout = view.findViewById(R.id.btnCheckout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<ItemCart> cart = new ArrayList<>();

                for(int i = 0; i < items.size(); i++){
                    CartList c = items.get(i);
                    Dish dish = new Dish(c.getIdFirebase(), c.getImage(), c.getCategory(), c.getName(), c.getCategory(), Double.valueOf(c.getPrice()));
                    ItemCart item = new ItemCart(dish, Integer.valueOf(c.getQuantity()));
                    cart.add(item);
                }

                Date date = Calendar.getInstance().getTime();
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String strDate = dateFormat.format(date);
                SharedPreferences prefs = getContext().getSharedPreferences("SharedP", Context.MODE_PRIVATE);
                Log.i("___________", "__________");

                Log.i("user", ""+prefs.getString("mail", ""));
                Order order = new Order(
                        prefs.getString("mail", ""),
                        cart,
                        "Sent",
                        strDate,
                        Double.valueOf(getAmount())
                );

                dbHelper.addOrder(order);
                Toast.makeText(getContext(), "Confirmation order", Toast.LENGTH_LONG).show();
                cartHelper.deleteOrder(dblite);
                cartHelper.createTable(dblite);
                refresh();
            }
        });


        return view;
    }
    public String getAmount(){
        double total = 0;

        for (int i = 0; i < items.size(); i++) {
            total += Double.valueOf(items.get(i).getPrice())*Double.valueOf(items.get(i).getQuantity());
        }

        return String.format("%.2f", total);
    }

    // Fragment screen it refresh.
    public void refresh(){
        getFragmentManager().beginTransaction().detach(this).attach(this).commit();
    }


}