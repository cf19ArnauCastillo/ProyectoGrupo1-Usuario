package com.example.EatSleepAndRepeat_User.Recyclers;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.EatSleepAndRepeat_User.Classes.Dish;
import com.example.EatSleepAndRepeat_User.DB.DBHelper;
import com.example.EatSleepAndRepeat_User.R;
import com.example.EatSleepAndRepeat_User.SQLITE.CartList;
import com.example.EatSleepAndRepeat_User.SQLITE.CartListDBHelper;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class RecyclerViewAdapterProducts extends RecyclerView.Adapter<RecyclerViewAdapterProducts.ViewHolder> {
    private ArrayList<Dish> dishes;
    private Context context;
    private SQLiteDatabase dblite;
    private CartListDBHelper cartHelper;

    public RecyclerViewAdapterProducts(Context context ,ArrayList<Dish> dishes, CartListDBHelper cartHelper, SQLiteDatabase dblite){
        this.dishes = dishes;
        this.context = context;
        this.cartHelper = cartHelper;
        this.dblite = dblite;
    }
    public RecyclerViewAdapterProducts(Context context ,ArrayList<Dish> dishes){
        this.dishes = dishes;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_products, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    //okay

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(dishes.get(position).getName());
        holder.desc.setText(dishes.get(position).getDescription());
        String p = String.format("%.2f", dishes.get(position).getPrice());
        holder.price.setText(p);

        // Load image
        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
        StorageReference dateRef = storageRef.child(dishes.get(position).getImageName());
        dateRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>(){
            @Override
            public void onSuccess(Uri downloadUrl){
                Glide.with(context).load(downloadUrl).into(holder.image);
            }
        });

        holder.btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartHelper = new CartListDBHelper(context);
                dblite = cartHelper.getWritableDatabase();

                boolean isAdded = cartHelper.itemAdded(dblite, dishes.get(position).getName());
                if(isAdded){
                    cartHelper.updateQuantity(dblite, dishes.get(position).getName(), holder.txtNumber.getText().toString() );
                } else {
                    CartList item = new CartList(dishes.get(position).getName(),
                            "a",
                            holder.txtNumber.getText().toString(),
                            Double.toString(dishes.get(position).getPrice()),
                            dishes.get(position).getImageName());

                    Log.i("PRODUCT_____", dishes.get(position).getName());

                    cartHelper.insertContact(dblite, item);
                }
                    Toast.makeText(view.getContext(), dishes.get(position).getName() + " added", Toast.LENGTH_LONG).show();

            }
        });

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = Integer.parseInt(holder.txtNumber.getText().toString())+1;

                holder.txtNumber.setText(String.valueOf(quantity));

            }
        });

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = Integer.parseInt(holder.txtNumber.getText().toString())-1;
                if(quantity<=1){
                    quantity = 1;
                }

                holder.txtNumber.setText(String.valueOf(quantity));

            }
        });

    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView desc;
        TextView price;
        ImageView add;
        ImageView remove;
        ImageView image;
        Button btnAddProduct;
        TextView txtNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtNameProduct);
            desc = itemView.findViewById(R.id.txtDescriptionProduct);
            price = itemView.findViewById(R.id.txtPriceProduct);
            add = itemView.findViewById(R.id.btnAdd);
            remove = itemView.findViewById(R.id.btnRemove);
            image = itemView.findViewById(R.id.imgProduct);
            btnAddProduct = itemView.findViewById(R.id.btnAddProduct);
            txtNumber = itemView.findViewById(R.id.txtNumber);
        }
    }



}