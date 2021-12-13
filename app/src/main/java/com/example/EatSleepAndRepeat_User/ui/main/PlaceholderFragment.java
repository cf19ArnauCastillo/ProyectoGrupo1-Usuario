package com.example.EatSleepAndRepeat_User.ui.main;

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
import com.example.EatSleepAndRepeat_User.R;
import com.example.EatSleepAndRepeat_User.Recyclers.RecyclerViewAdapterProducts;
import com.example.EatSleepAndRepeat_User.databinding.FragmentProductLabelBinding;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final int[] TAB_TITLES = new int[]{R.string.tabAll, R.string.tabPizzas, R.string.tabStarters, R.string.tabDesserts, R.string.tabDrinks};

    private PageViewModel pageViewModel;
    private FragmentProductLabelBinding binding;

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


        if(Integer.valueOf(getArguments().getInt(ARG_SECTION_NUMBER)) == 0){
            array.add(new Dish("1","hola", "all", "all", 25));
            array.add(new Dish("1","adeu", "all", "all", 25));
            array.add(new Dish("1","all", "all", "all", 25));
            array.add(new Dish("1","all", "all", "all", 25));
            Log.i("IF1 ", ARG_SECTION_NUMBER );
        } else if (ARG_SECTION_NUMBER.equals("1")){
            array.add(new Dish("1","hola", "all", "all", 25));
            array.add(new Dish("1","adeu", "all", "all", 25));
            array.add(new Dish("1","all", "all", "all", 25));
            array.add(new Dish("1","all", "all", "all", 25));
        }

        RecyclerViewAdapterProducts adapter = new RecyclerViewAdapterProducts(array);
        recyclerProducts.setAdapter(adapter);
        recyclerProducts.setLayoutManager(new GridLayoutManager(getContext(), 2));
        /*
        final TextView textView = binding.sectionLabel;
        pageViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

         */
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}