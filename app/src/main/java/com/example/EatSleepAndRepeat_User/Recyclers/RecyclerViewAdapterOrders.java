package com.example.EatSleepAndRepeat_User.Recyclers;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.EatSleepAndRepeat_User.Classes.Category;
import com.example.EatSleepAndRepeat_User.Classes.Order;
import com.example.EatSleepAndRepeat_User.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class RecyclerViewAdapterOrders extends RecyclerView.Adapter<RecyclerViewAdapterOrders.ViewHolder> {
    private ArrayList<Order> orders;
    Context context;

    public RecyclerViewAdapterOrders(Context context, ArrayList<Order> arrC){
        this.context = context;
        this.orders = arrC;
        Log.i("Orders_________", "" + getItemCount());
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_home, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String statusItem = orders.get(position).getStatus();
        holder.status.setText(orders.get(position).getStatus());

        Drawable statusImage = context.getResources().getDrawable(R.drawable.ic_replay);
        if (statusItem.equals("Received")){
            statusImage = context.getResources().getDrawable(R.drawable.ic_recieved);
        } else if(statusItem.equals("Process")){
            statusImage = context.getResources().getDrawable(R.drawable.ic_process);
        } else if (statusItem.equals("Sent")){
            statusImage = context.getResources().getDrawable(R.drawable.ic_check);
        }

        //holder.nameOrder.setText("Order ref. " + orders.get(position).getId());
        holder.time.setText(orders.get(position).getDate());
        String[] textArray = {"One", "Two", "Three", "Four"};



        //holder.amount.setText(orders.get(position).getAmount());

    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView statusImg;
        TextView status;
        TextView nameOrder;
        TextView time;
        TextView amount;

        public ViewHolder(@NonNull View v) {
            super(v);

            status = v.findViewById(R.id.txtStatus);
            statusImg = v.findViewById(R.id.imgStatus);
            nameOrder = v.findViewById(R.id.txtOrder);
            time = v.findViewById(R.id.txtTime);
            amount = v.findViewById(R.id.txtAmount);

        }
    }

}
