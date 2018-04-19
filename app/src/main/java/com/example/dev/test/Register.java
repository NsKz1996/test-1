package com.example.dev.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


public class Register extends AppCompatActivity {

    @BindView(R.id.RegisterActivity_CircleImageView_Photo)
    CircleImageView photo;
    @BindView(R.id.RegisterActivity_EditText_PhoneNumber)
    EditText phoneNumber;
    @BindView(R.id.RegisterActivity_EditText_UserName)
    EditText userName;
    @BindView(R.id.RegisterActivity_EditText_Password)
    EditText password;
    @BindView(R.id.RegisterActivity_EditText_PasswordAgain)
    EditText passwordAgain;
    @BindView(R.id.RegisterActivity_Button_SignUp)
    Button signUp;
    @BindView(R.id.RegisterActivity_TextView_Rules)
    TextView rules;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);



    }
}
