package com.example.myapplication.Recyclers;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Classes.Pizza;
import com.example.myapplication.R;

import java.util.ArrayList;

public class RecyclerViewAdapter1 extends RecyclerView.Adapter<RecyclerViewAdapter1.ViewHolder> {
    private ArrayList<Pizza> array_pizza;

    public RecyclerViewAdapter1(ArrayList<Pizza> arrP){
        array_pizza = arrP;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return array_pizza.size();
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