package com.example.EatSleepAndRepeat_User.Recyclers;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.EatSleepAndRepeat_User.Classes.Dish;
import com.example.EatSleepAndRepeat_User.R;

import java.util.ArrayList;

public class RecyclerViewAdapterProducts extends RecyclerView.Adapter<RecyclerViewAdapterProducts.ViewHolder> {
    private ArrayList<Dish> array_dish;

    public RecyclerViewAdapterProducts(ArrayList<Dish> arrP){
        array_dish = arrP;
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

    }

    @Override
    public int getItemCount() {
        return array_dish.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView Textiño;
        TextView Textiño1;
        TextView Textiño2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Textiño = itemView.findViewById(R.id.NombrePizza);
            Textiño1 = itemView.findViewById(R.id.Descripcio);
            Textiño2 = itemView.findViewById(R.id.Precio);
        }
    }
}