package com.example.dev.test;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.framelayout,new Fragment_main_home()).commit();





    }


    public void onclick(View view){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (view.getId()) {
            case R.id.btn_home:
                transaction.replace(R.id.framelayout,new Fragment_main_home()).commit();
                break;
            case R.id.btn_add:
                transaction.replace(R.id.framelayout,new Fragment_main_addpost()).commit();
                break;
            case R.id.btn_nofification:
                transaction.replace(R.id.framelayout,new Fragment_main_notificatiin()).commit();
                break;
            case R.id.btn_profile:
                transaction.replace(R.id.framelayout,new Fragment_main_profile()).commit();
                break;



        }}






}
