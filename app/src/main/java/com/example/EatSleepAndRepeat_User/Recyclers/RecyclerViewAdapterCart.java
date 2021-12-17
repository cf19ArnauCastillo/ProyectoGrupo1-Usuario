package com.example.EatSleepAndRepeat_User.Recyclers;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.EatSleepAndRepeat_User.Classes.ItemCart;
import com.example.EatSleepAndRepeat_User.Classes.Order;
import com.example.EatSleepAndRepeat_User.DB.DBHelper;
import com.example.EatSleepAndRepeat_User.FragmentCart;
import com.example.EatSleepAndRepeat_User.R;
import com.example.EatSleepAndRepeat_User.SQLITE.CartList;
import com.example.EatSleepAndRepeat_User.SQLITE.CartListDBHelper;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
public class RecyclerViewAdapterCart extends RecyclerView.Adapter<RecyclerViewAdapterCart.ViewHolder> {
    private ArrayList<CartList> items;
    private Context context;
    private SQLiteDatabase dblite;
    private CartListDBHelper cartHelper;
    private Fragment fragment;
    private DBHelper dbHelper = new DBHelper();

    public RecyclerViewAdapterCart(Context context, ArrayList<CartList> arrA, CartListDBHelper cartHelper, SQLiteDatabase dblite){
        this.context = context;
        this.items = arrA;
        this.cartHelper = cartHelper;
        this.dblite = dblite;
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
        return items.size();
    }

    public String getAmount(String quantity, String price){
        int q = Integer.valueOf(quantity);
        double p = Double.valueOf(price);
        return String.format("%.2f", q * p);
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        TextView desc;
        TextView amount;
        TextView quantity;
        ImageButton deleteItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imgCart);
            name = itemView.findViewById(R.id.txtProductCart);
            desc = itemView.findViewById(R.id.txtDescriptionCart);
            quantity = itemView.findViewById(R.id.txtNumber);
            deleteItem = itemView.findViewById(R.id.removeItem);
            amount = itemView.findViewById(R.id.txtAmount);
        }
    }

}