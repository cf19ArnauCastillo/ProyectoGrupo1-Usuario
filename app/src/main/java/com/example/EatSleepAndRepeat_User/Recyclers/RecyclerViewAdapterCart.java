package com.example.EatSleepAndRepeat_User.Recyclers;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.EatSleepAndRepeat_User.Classes.Order;
import com.example.EatSleepAndRepeat_User.R;

import java.util.ArrayList;
public class RecyclerViewAdapterCart extends RecyclerView.Adapter<RecyclerViewAdapterCart.ViewHolder> {
    private ArrayList<Order> order;
    private Context context;

    public RecyclerViewAdapterCart(Context context, ArrayList<Order> arrA){
        this.context = context;
        this.order = arrA;
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
        return order.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        TextView desc;
        ImageView add;
        ImageView remove;
        TextView amount;
        TextView delete;
        Button order;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imgCart);
            name = itemView.findViewById(R.id.txtProductCart);
            desc = itemView.findViewById(R.id.txtDescriptionCart);
            add = itemView.findViewById(R.id.btnAddCart);
            remove = itemView.findViewById(R.id.btnRemoveCart);
            amount = itemView.findViewById(R.id.txtAmount);
            delete = itemView.findViewById(R.id.btnDelete);
            order = itemView.findViewById(R.id.removeOrder);
        }
    }

}