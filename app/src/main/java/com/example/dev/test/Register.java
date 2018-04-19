package com.example.dev.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Register extends AppCompatActivity {

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
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);

        
    }
}
