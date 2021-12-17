package com.example.EatSleepAndRepeat_User.Recyclers;
import android.icu.text.Transliterator;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.EatSleepAndRepeat_User.Classes.Dish;
import com.example.EatSleepAndRepeat_User.R;
import com.example.EatSleepAndRepeat_User.SQLITE.CartList;

import java.util.ArrayList;
public class RecyclerViewAdapterCart extends RecyclerView.Adapter<RecyclerViewAdapterCart.ViewHolder> {
    private ArrayList<CartList> array_cart;

    public RecyclerViewAdapterCart(ArrayList<CartList> arrA){
        this.array_cart = arrA;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cart, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.etiquetaNom.setText(array_cart.get(position).getNom());
        holder.etiquetaPreu.setText(array_cart.get(position).getPrecio());
        holder.etiquetaDescripcio.setText(array_cart.get(position).getDescripcion());
        holder.etiquetaQuantitat.setText(array_cart.get(position).getCantidad());
    }

    @Override
    public int getItemCount() {
        return array_cart.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView etiquetaNom;
        TextView etiquetaPreu;
        TextView etiquetaQuantitat;
        TextView etiquetaDescripcio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            etiquetaNom = itemView.findViewById(R.id.txtNameProduct2);
            etiquetaPreu = itemView.findViewById(R.id.txtPriceProduct2);
            etiquetaQuantitat = itemView.findViewById(R.id.txtNumber2);
            etiquetaDescripcio = itemView.findViewById(R.id.txtDescriptionProduct2);
        }
    }




}