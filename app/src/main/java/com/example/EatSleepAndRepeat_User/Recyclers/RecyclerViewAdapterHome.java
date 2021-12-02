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
public class RecyclerViewAdapterHome extends RecyclerView.Adapter<RecyclerViewAdapterHome.ViewHolder> {
    private ArrayList<String> array_categories;

    public RecyclerViewAdapterHome(ArrayList<String> arrC){
        this.array_categories = arrC;
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
        holder.textView3.setText(array_categories.get(position));
    }

    @Override
    public int getItemCount() {
        return array_categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView3 = itemView.findViewById(R.id.textView3);
        }
    }

}
