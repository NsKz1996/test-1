package com.example.dev.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Login extends AppCompatActivity {

    @BindView(R.id.Login_EditText_UserName)
    EditText userName;
    @BindView(R.id.Login_EditText_Password)
    EditText password;
    @BindView(R.id.Login_Button_SignIn)
    EditText signIn;
    @BindView(R.id.Login_TextView_SignUp)
    EditText signUp;
    @BindView(R.id.Login_TextView_Forget)
    EditText forgetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);

            }
        });
    }
}
