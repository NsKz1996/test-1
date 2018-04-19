package com.example.dev.test;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;

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

    private static final int SELECT_PHOTO = 100;
    private Bitmap yourSelectedImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivityForResult(intent, SELECT_PHOTO);
                }catch (Exception x){
                    Toast.makeText(getApplicationContext(), "Error Choose Image", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        switch (resultCode){
            case SELECT_PHOTO:
                if(resultCode == RESULT_OK){
                    Uri selectImage = data.getData();
                    InputStream imageStream = null;
                    try{
                        imageStream = getContentResolver().openInputStream(selectImage);
                    }catch (Exception x){
                        Toast.makeText(getApplicationContext(), "Error Get File", Toast.LENGTH_SHORT).show();
                    }
                    yourSelectedImage = BitmapFactory.decodeStream(imageStream);
                    
                    photo.setImageBitmap(yourSelectedImage);

                }
        }
    }
}
