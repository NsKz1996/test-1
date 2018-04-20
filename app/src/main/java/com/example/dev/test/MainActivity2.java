package com.example.dev.test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


public class MainActivity2 extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();


            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction.replace(R.id.view_fragment,new Fragment_main_home()).commit();
                    return true;
                case R.id.navigation_addpost:
                    transaction.replace(R.id.view_fragment,new Fragment_main_addpost()).commit();
                    return true;
                case R.id.navigation_notifications:
                    transaction.replace(R.id.view_fragment,new Fragment_main_notificatiin()).commit();
                    return true;
                case R.id.navigation_profile:
                    transaction.replace(R.id.view_fragment,new Fragment_main_profile()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.view_fragment,new Fragment_main_home()).commit();
    }

}
