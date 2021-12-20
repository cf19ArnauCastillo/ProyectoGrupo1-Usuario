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
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.EatSleepAndRepeat_User.Classes.Dish;
import com.example.EatSleepAndRepeat_User.DB.DBHelper;
import com.example.EatSleepAndRepeat_User.FragmentFoodDetail;
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

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(dishes.get(position).getName());
        holder.desc.setText(dishes.get(position).getDescription());
        String p = String.format("%.2f", dishes.get(position).getPrice());
        holder.price.setText(p);

        Log.i("llego aqui", "recycler");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity app = (AppCompatActivity) view.getContext();
                FragmentFoodDetail detailFragment = new FragmentFoodDetail(cartHelper, dblite);

                // Create a new empty bundle
                Bundle bundle = new Bundle();
                // Inserts a Serializable value on key format
                bundle.putSerializable("dish", dishes.get(position));
                // Supply the construction arguments for the fragment
                detailFragment.setArguments(bundle);
                // Start fragment associated
                app.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_app, detailFragment).commit();

            }
        });

        // Load image
        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
        StorageReference dateRef = storageRef.child(dishes.get(position).getImageName());
        dateRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>(){
            @Override
            public void onSuccess(Uri downloadUrl){
                Glide.with(context).load(downloadUrl).into(holder.image);
            }
        });
        // Cuando le clickas a la imagen te lleva al food detail fragment
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Guardas la infomacion en una "caja"
                Bundle bundle = new Bundle();
                bundle.putSerializable("dish", dishes.get(position));
                //Mandas la informacion a la nueva pantalla
                AppCompatActivity app = (AppCompatActivity) v.getContext();
                FragmentFoodDetail fragmentFoodDetail = new FragmentFoodDetail();
                fragmentFoodDetail.setArguments(bundle);

                app.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_app, fragmentFoodDetail).commit();
            }
        });

        holder.btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartHelper = new CartListDBHelper(context);
                dblite = cartHelper.getWritableDatabase();

                Log.i("id_____", ""+dishes.get(position).getId());

                boolean isAdded = cartHelper.itemAdded(dblite, dishes.get(position).getName());
                if(isAdded){
                    cartHelper.updateQuantity(dblite, dishes.get(position).getName(), holder.txtNumber.getText().toString() );
                } else {
                    CartList item = new CartList(dishes.get(position).getName(),
                            "a",
                            holder.txtNumber.getText().toString(),
                            Double.toString(dishes.get(position).getPrice()),
                            dishes.get(position).getImageName(),
                            dishes.get(position).getId(),
                            dishes.get(position).getCategory());

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
        Button btnRemove;
        Button btnAdd;

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