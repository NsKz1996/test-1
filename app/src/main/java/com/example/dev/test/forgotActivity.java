package com.example.dev.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;

public class forgotActivity extends AppCompatActivity {


    @BindView(R.id.activityfofgot_button_ersal)
    Button ersal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        ButterKnife.bind(this);

        ersal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(forgotActivity.this, Login.class);
                startActivity(intent);

                finish();
            }
        });


    }
}
