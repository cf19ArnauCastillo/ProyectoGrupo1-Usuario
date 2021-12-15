package com.example.EatSleepAndRepeat_User.Recyclers;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.EatSleepAndRepeat_User.Classes.Dish;
import com.example.EatSleepAndRepeat_User.FragmentFoodDetail;
import com.example.EatSleepAndRepeat_User.R;
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

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("dish", dishes.get(position));

                AppCompatActivity app = (AppCompatActivity) v.getContext();
                FragmentFoodDetail fragmentFoodDetail = new FragmentFoodDetail();
                fragmentFoodDetail.setArguments(bundle);

                app.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragmentFoodDetail).commit();
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
        ImageView image;
        Button btnRemove;
        Button btnAdd;
        Button btnAddProduct;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtNameProduct);
            desc = itemView.findViewById(R.id.txtDescriptionProduct);
            price = itemView.findViewById(R.id.txtPriceProduct);
            add = itemView.findViewById(R.id.btnAdd);
            image = itemView.findViewById(R.id.imgProduct);
        }
    }
}