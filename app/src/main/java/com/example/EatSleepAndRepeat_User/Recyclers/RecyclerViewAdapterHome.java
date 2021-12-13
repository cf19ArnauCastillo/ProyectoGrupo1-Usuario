package com.example.EatSleepAndRepeat_User.Recyclers;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.EatSleepAndRepeat_User.Classes.Category;
import com.example.EatSleepAndRepeat_User.R;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
public class RecyclerViewAdapterHome extends RecyclerView.Adapter<RecyclerViewAdapterHome.ViewHolder> {
    private ArrayList<Category> categories;
    Context context;
    public RecyclerViewAdapterHome(ArrayList<Category> arrC){
        this.categories = arrC;
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
        Category cat = new Category(categories.get(position));

        holder.category.setText(cat.getCategoryName());
        //Glide.with(context).load(cat.getImagePath()).into(holder.image);
        // TODO set image category
        // holder.category.
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView category;
        ImageView image;

        public ViewHolder(@NonNull View v) {
            super(v);
            category = v.findViewById(R.id.txtCategory);
            image = v.findViewById(R.id.imgCategory);
        }
    }

}
