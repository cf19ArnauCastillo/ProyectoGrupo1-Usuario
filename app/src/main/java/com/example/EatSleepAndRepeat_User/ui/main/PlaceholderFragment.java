package com.example.EatSleepAndRepeat_User.ui.main;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.EatSleepAndRepeat_User.Classes.Dish;
import com.example.EatSleepAndRepeat_User.DB.DBHelper;
import com.example.EatSleepAndRepeat_User.R;
import com.example.EatSleepAndRepeat_User.Recyclers.RecyclerViewAdapterProducts;
import com.example.EatSleepAndRepeat_User.SQLITE.CartListDBHelper;
import com.example.EatSleepAndRepeat_User.databinding.FragmentProductLabelBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String[] TAB_TITLES = new String[]{"All","Pizzas", "Appetizers", "Drinks", "Desserts"};

    FirebaseDatabase db;
    DatabaseReference refDish;
    private PageViewModel pageViewModel;
    private FragmentProductLabelBinding binding;
    private SQLiteDatabase dblite;
    private CartListDBHelper cartHelper;

    //private DBHelper db;

    private int index;

    public static PlaceholderFragment newInstance(int index) {
        Log.i("Index", String.valueOf(index));
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Crea la instancia de la BD
        //db = new DBHelper();

        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
//        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentProductLabelBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Log.i("Posicio ", ARG_SECTION_NUMBER );
        final RecyclerView recyclerProducts = binding.recyclerProduct;
        ArrayList<Dish> array = new ArrayList<Dish>();

        //en fer la consulta a la bbdd heu de passar el child de la categoria escollida

        db = FirebaseDatabase.getInstance("https://admin-987aa-default-rtdb.europe-west1.firebasedatabase.app/");
        refDish = db.getReference("dish");
        if(Integer.valueOf(getArguments().getInt(ARG_SECTION_NUMBER)) == 0){

            for (int i = 0; i < TAB_TITLES.length; i++){
                refDish.child(TAB_TITLES[i]).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {

                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (!task.isSuccessful()) {
                            Log.e("firebase", "Error getting data", task.getException());
                        }
                        else {
                            for (DataSnapshot ds : task.getResult().getChildren()){
                                Dish dish = ds.getValue(Dish.class);
                                array.add(dish);
                            }
                            RecyclerViewAdapterProducts adapter = new RecyclerViewAdapterProducts(getContext(), array);
                            recyclerProducts.setAdapter(adapter);
                            recyclerProducts.setLayoutManager(new GridLayoutManager(getContext(), 2));

                        }
                    }

                });
            }
        }
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}