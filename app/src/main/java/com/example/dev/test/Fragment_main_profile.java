package com.example.dev.test;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


public class Fragment_main_profile extends Fragment {

//    @BindView(R.id.FragmentProfile_CircularImageView_Photo)
//    CircleImageView photo;


//
//    @BindView(R.id.FragmentProfile_TextView_UserName)
//    TextView userName;

    Context context;

    public static Fragment_main_profile newInstance() {

        return new Fragment_main_profile();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context = inflater.getContext();
        LayoutInflater in = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //  ButterKnife.bind(context);

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ImageView photo = view.findViewById(R.id.FragmentProfile_CircularImageView_Photo);
        TextView Username = view.findViewById(R.id.FragmentProfile_TextView_UserName);


        DataBase_User dataBase_user = new DataBase_User(getActivity());

        ArrayList<Model_Data_User> Data_User = null;
        Data_User = dataBase_user.getData();

        if (Data_User == null) {
            Toast.makeText(getActivity(), "Khali", Toast.LENGTH_SHORT).show();
        } else {
            String S = Data_User.get(0).UserName;
            byte[] b = Data_User.get(0).Profile;
            Log.i("Byte", b + "");
            Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
            Username.setText(S);
            photo.setImageBitmap(bitmap);
        }


        return view;

    }

}
