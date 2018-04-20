package com.example.dev.test;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;



public class Fragment_main_profile extends Fragment {

    @BindView(R.id.FragmentProfile_CircularImageView_Photo)
    CircleImageView photo;
    @BindView(R.id.FragmentProfile_TextView_UserName)
    TextView userName;

    Context context;

    public static Fragment_main_profile newInstance() {

        return new Fragment_main_profile();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
<<<<<<< HEAD
        

        return inflater.inflate(R.layout.fragment_profile, container, false);
=======

        ButterKnife.bind(getActivity());

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
//        DataBase_User dataBase_user = new DataBase_User(getContext());
//        dataBase_user.getData();
//        ArrayList<Model_Data_User> model_data_users = new ArrayList<>(dataBase_user.getData());
//        userName.setText(model_data_users.get());
//        dataBase_user.getData();
        return view;
>>>>>>> 4408723ddea876229887a6553fb19d449df858a7
    }

}
