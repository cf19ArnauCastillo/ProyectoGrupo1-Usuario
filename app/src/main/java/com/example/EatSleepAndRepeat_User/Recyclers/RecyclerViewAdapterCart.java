package com.example.EatSleepAndRepeat_User.Recyclers;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.EatSleepAndRepeat_User.R;

import java.util.ArrayList;
public class RecyclerViewAdapterCart extends RecyclerView.Adapter<RecyclerViewAdapterCart.ViewHolder> {
    private ArrayList<String> array_cart;

    public RecyclerViewAdapterCart(ArrayList<String> arrA){
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
    }

    @Override
    public int getItemCount() {
        return array_cart.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        TextView desc;
        ImageView add;
        ImageView remove;
        TextView amount;
        TextView delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imgCart);
            name = itemView.findViewById(R.id.txtProductCart);
            desc = itemView.findViewById(R.id.txtDescriptionCart);
            add = itemView.findViewById(R.id.btnAddCart);
            remove = itemView.findViewById(R.id.btnRemoveCart);
            amount = itemView.findViewById(R.id.txtAmount);
            delete = itemView.findViewById(R.id.btnDelete);
        }
    }

}