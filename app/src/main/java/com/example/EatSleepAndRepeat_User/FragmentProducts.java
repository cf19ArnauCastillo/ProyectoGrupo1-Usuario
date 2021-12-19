package com.example.EatSleepAndRepeat_User;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.EatSleepAndRepeat_User.Classes.Dish;
import com.example.EatSleepAndRepeat_User.Recyclers.RecyclerViewAdapterProducts;
import com.example.EatSleepAndRepeat_User.SQLITE.CartListDBHelper;
import com.example.EatSleepAndRepeat_User.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentProducts#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentProducts extends Fragment  {

    private static final String KEY_MODEL = "KEY_MODEL";

    private Dish[] dishes = createDummyListModel("hola");
    private OnListFragmentInteractionListener interactionListener;
    private CartListDBHelper cartHelper;
    private SQLiteDatabase dblite;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    public FragmentProducts() {
    }
    public FragmentProducts(CartListDBHelper cartHelper, SQLiteDatabase dblite) {
        this.cartHelper = cartHelper;
        this.dblite = dblite;
    }


    /**
     * Receive the model list
     */
    public static FragmentProducts newInstance() {
        Dish[] dish = createDummyListModel("hola");
        FragmentProducts fragment = new FragmentProducts();
        Bundle args = new Bundle();

        args.putParcelableArray(KEY_MODEL, dish);
        fragment.setArguments(args);
        return fragment;
    }
    public static FragmentProducts newInstance(Dish[] dishes) {
        FragmentProducts fragment = new FragmentProducts();
        Bundle args = new Bundle();
        args.putParcelableArray(KEY_MODEL, dishes);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("args", ""+getArguments());
        if (getArguments() == null) {
            dishes = createDummyListModel("hola");
        } else {
            dishes = (Dish[]) getArguments().getParcelableArray(KEY_MODEL);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products, container, false);
        Context context = view.getContext();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewProducts);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(new RecyclerViewAdapterProducts(dishes, interactionListener));
        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // activity must implement OnListFragmentInteractionListener
        if (context instanceof OnListFragmentInteractionListener) {
            interactionListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        interactionListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * <p/>
     */
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Dish item);
    }
    private static Dish[] createDummyListModel(String msj) {
        List<Dish> l = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            l.add(new Dish(String.valueOf(i), "description " + i, "category " + i + " -" + "desde fragmentproduct"));
        }
        return l.toArray(new Dish[l.size()]);
    }
}