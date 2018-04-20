package com.example.dev.test;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_main_home extends Fragment {


    private List<Model_Post_Home> model_post_homes = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerViewHomeAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.Fragment_Main_Home_RecyclerView);

        mAdapter = new RecyclerViewHomeAdapter(model_post_homes);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();

        return view;
    }

    private void prepareMovieData() {

        Model_Post_Home model_post_home = new Model_Post_Home(R.drawable.ghoozhism, "Ghoozh", "12:14", "Khoob", "52");
        model_post_homes.add(model_post_home);
        model_post_homes.add(new Model_Post_Home(R.drawable.ghoozhism, "Ghoozh", "12:14", "10", "52"));
        model_post_homes.add(new Model_Post_Home(R.drawable.ghoozhism, "Ghoozh", "12:14", "10", "52"));
        model_post_homes.add(new Model_Post_Home(R.drawable.ghoozhism, "Ghoozh", "12:14", "10", "52"));
        model_post_homes.add(new Model_Post_Home(R.drawable.ghoozhism, "Ghoozh", "12:14", "10", "52"));
        model_post_homes.add(new Model_Post_Home(R.drawable.ghoozhism, "Ghoozh", "12:14", "10", "52"));
        model_post_homes.add(new Model_Post_Home(R.drawable.ghoozhism, "Ghoozh", "12:14", "10", "52"));
        model_post_homes.add(new Model_Post_Home(R.drawable.ghoozhism, "Ghoozh", "12:14", "10", "52"));
        model_post_homes.add(new Model_Post_Home(R.drawable.ghoozhism, "Ghoozh", "12:14", "10", "52"));
        model_post_homes.add(new Model_Post_Home(R.drawable.ghoozhism, "Ghoozh", "12:14", "10", "52"));
        model_post_homes.add(new Model_Post_Home(R.drawable.ghoozhism, "Ghoozh", "12:14", "10", "52"));

    }

}
