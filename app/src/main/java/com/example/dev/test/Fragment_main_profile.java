package com.example.dev.test;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Fragment_main_profile extends Fragment {

    public static Fragment_main_profile newInstance() {
        return new Fragment_main_profile();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

}
