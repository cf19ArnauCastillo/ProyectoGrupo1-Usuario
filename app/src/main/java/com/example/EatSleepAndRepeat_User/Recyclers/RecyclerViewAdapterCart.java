package com.example.EatSleepAndRepeat_User.Recyclers;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.EatSleepAndRepeat_User.Classes.Dish;
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
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        //Image text1;
        //Image text2;
        //Image text3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.txtDescriptionProduct2);
            textView2 = itemView.findViewById(R.id.txtPriceProduct2);
            textView3 = itemView.findViewById(R.id.txtNumber2);
            textView4 = itemView.findViewById(R.id.txtNameProduct2);

            //text1 = itemView.findViewById(R.id.imatgePizza);
            //text2 = itemView.findViewById(R.id.restar);
            //text3 = itemView.findViewById(R.id.sumar);
        }
    }

}