package com.example.dev.test;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_main_notificatiin extends Fragment {

    private List<Model_Notification> model_notificationList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerViewNotificationAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_notifcation, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.Fragment_Main_Notification_RecyclerView);

        mAdapter = new RecyclerViewNotificationAdapter(model_notificationList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();

        return view;
    }

    private void prepareMovieData() {

        Model_Notification model_notification = new Model_Notification(R.drawable.ghoozhism, "25", "10", "100" );
        model_notificationList.add(model_notification);
        model_notificationList.add(new Model_Notification(R.drawable.ghoozhism, "25", "10", "100" ));
        model_notificationList.add(new Model_Notification(R.drawable.ghoozhism, "25", "10", "100" ));
        model_notificationList.add(new Model_Notification(R.drawable.ghoozhism, "25", "10", "100" ));
        model_notificationList.add(new Model_Notification(R.drawable.ghoozhism, "25", "10", "100" ));
        model_notificationList.add(new Model_Notification(R.drawable.ghoozhism, "25", "10", "100" ));
        model_notificationList.add(new Model_Notification(R.drawable.ghoozhism, "25", "10", "100" ));
        model_notificationList.add(new Model_Notification(R.drawable.ghoozhism, "25", "10", "100" ));
        model_notificationList.add(new Model_Notification(R.drawable.ghoozhism, "25", "10", "100" ));
        model_notificationList.add(new Model_Notification(R.drawable.ghoozhism, "25", "10", "100" ));
        model_notificationList.add(new Model_Notification(R.drawable.ghoozhism, "25", "10", "100" ));
        model_notificationList.add(new Model_Notification(R.drawable.ghoozhism, "25", "10", "100" ));
    }

}
