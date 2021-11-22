package com.example.myapplication.Recyclers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
        private ArrayList<Categories> arrayCategories;
        //Constructor of RecyclerViewAdapter
        public RecyclerViewAdapter(ArrayList<Categories> arrN){ arrayCategories = arrN;    }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.pizza.setText(arrayCategories.get(position).getPizzas());
            holder.entantes.setText(arrayCategories.get(position).getEntrantes());
            holder.bebidas.setText(arrayCategories.get(position).getBebidas());
            holder.postres.setText(arrayCategories.get(position).getPostres());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatActivity app = (AppCompatActivity) view.getContext();

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("pizza", arrayCategories.get(position));

                    app.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container).commit();

                }
            });
        }

        //Get the size of the data.
        @Override
        public int getItemCount() {
            return arrayCategories.size();
        }

        //Links the elements of item_list with the RecyclerView
        public class ViewHolder extends RecyclerView.ViewHolder{
            TextView categories;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                categories = itemView.findViewById(R.id.txtcategories);

            }
        }

        public Object getMyPos(int pos){ return arrayCategories.get(pos);}


    }
}
