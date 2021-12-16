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
        Log.i("HOLA:_________", "llego aqui");
        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
        StorageReference dateRef = storageRef.child(dishes.get(position).getImageName());
        Log.i("REF:_________", dateRef.toString());
        dateRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>(){
            @Override
            public void onSuccess(Uri downloadUrl){
                Log.i("URL:_________", downloadUrl.toString());
                Glide.with(context).load(downloadUrl).into(holder.image);
            }
        });

        holder.btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartListDBHelper cartListDBHelper = new CartListDBHelper(context);
                SQLiteDatabase db = cartListDBHelper.getWritableDatabase();
                CartList item = new CartList(dishes.get(position).getName(), dishes.get(position).getDescription(), holder.txtNumber.getText().toString(), Double.toString(dishes.get(position).getPrice()));

                cartListDBHelper.insertContact(db, item);

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