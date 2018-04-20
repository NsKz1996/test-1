package com.example.dev.test;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class addpostActivity extends AppCompatActivity {


    @BindView(R.id.Activityaddpost_button_virayesh)
    Button virayrsh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpost);
        ButterKnife.bind(this);

        virayrsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(addpostActivity.this,video_editor.class);
                startActivity(intent);

            }
        });


    }
}
