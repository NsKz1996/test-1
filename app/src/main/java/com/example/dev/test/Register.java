package com.example.dev.test;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
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



    private static final int SELECT_PHOTO = 1;
    private Bitmap yourSelectedImage;
    private Context context;

    //hessam add
    private DataBase_User db;
    private Model_Data_User Model;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        context = getApplicationContext();

        db=new DataBase_User(this);



        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Register Activity", "Intent");
                if(phoneNumber.getText().toString().isEmpty() || phoneNumber.getText().toString().length() != 11 || !(phoneNumber.getText().toString().startsWith("09"))){
                    Toast.makeText(Register.this, context.getString(R.string.wrong_phone_number), Toast.LENGTH_SHORT).show();
                }else if (userName.getText().toString().isEmpty() || userName.getText().toString().length() < 7 ){
                    Toast.makeText(Register.this, context.getString(R.string.wrong_user_name), Toast.LENGTH_SHORT).show();
                }else if (password.getText().toString().isEmpty() || password.getText().toString().length() < 7 ){
                    Toast.makeText(Register.this, context.getString(R.string.wrong_password), Toast.LENGTH_SHORT).show();
                }else if (passwordAgain.getText().toString().isEmpty() || !(password.getText().toString().equals(passwordAgain.getText().toString()))){
                    Toast.makeText(Register.this, context.getString(R.string.wrong_re_password), Toast.LENGTH_SHORT).show();
                }else {
                    Bitmap bitmap =((BitmapDrawable)photo.getDrawable()).getBitmap();
                    ByteArrayOutputStream stream= new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG,0,stream);
                    byte [] image = stream.toByteArray();

                    Long ID=  db.insertData(new Model_Data_User(phoneNumber.getText().toString(),
                            userName.getText().toString(),
                            passwordAgain.getText().toString(),
                            image));
                    if (ID<=0){
                        Toast.makeText(context, "Erore", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Register.this,Login.class);
                        intent.putExtra("UserName",userName.getText().toString());
                        intent.putExtra("Password",passwordAgain.getText().toString());
                        startActivity(intent);
                        finish();
                    }


                }

            }
        });



        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                   // intent.setType("image/*");
                    startActivityForResult(intent, 2);
                }catch (Exception x){
                    Toast.makeText(getApplicationContext(), "Error Choose Image", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2 && resultCode==RESULT_OK && null!=data){

            uri=data.getData();
            CropImage();

        }else if (requestCode == 1){
            if (data != null){
                Bundle bundle =data.getExtras();
              Bitmap  bitmap= bundle.getParcelable("data");
                photo.setImageBitmap(bitmap);


            }
        }

        }





//        try {
//            if (requestCode == SELECT_PHOTO && resultCode==RESULT_OK && null!=data){
//
//                Uri uri = data.getData();
//                String [] filepachclumen = {MediaStore.Images.Media.DATA};
//                assert uri != null;
//                Cursor cursor = getContentResolver().query(uri,filepachclumen,null,null,null);
//                assert cursor != null;
//                cursor.moveToFirst();
//                int columnindex = cursor.getColumnIndex(filepachclumen[0]);
//                String imagedecodabel=cursor.getString(columnindex);
//                cursor.close();
//                photo.setImageBitmap(BitmapFactory.decodeFile(imagedecodabel));
//
//            }else {
//                Toast.makeText(context, "Aks ezaf nashod", Toast.LENGTH_SHORT).show();
//            }
//        }catch (Exception e){
//            Toast.makeText(context, "Wrong", Toast.LENGTH_SHORT).show();
//        }


//        switch (resultCode){
//            case SELECT_PHOTO:
//                if(resultCode == RESULT_OK){
//                    Uri selectImage = data.getData();
//                    InputStream imageStream = null;
//                    try{
//                        imageStream = getContentResolver().openInputStream(selectImage);
//                    }catch (Exception x){
//                        Toast.makeText(getApplicationContext(), "Error Get File", Toast.LENGTH_SHORT).show();
//                    }
//                    yourSelectedImage = BitmapFactory.decodeStream(imageStream);
//
//                    photo.setImageBitmap(yourSelectedImage);
//
//                }
//        }


    private void CropImage() {

        try{
            Intent CropIntent = new Intent("com.android.camera.action.CROP");
            CropIntent.setDataAndType(uri,"image/*");

            CropIntent.putExtra("crop","true");
            CropIntent.putExtra("outputX",500);
            CropIntent.putExtra("outputY",500);
            CropIntent.putExtra("aspectX",1);
            CropIntent.putExtra("aspectY",1);
            CropIntent.putExtra("scaleUpIfNeeded",true);
            CropIntent.putExtra("return-data",true);

            Log.i("Crop", uri.toString());

            startActivityForResult(CropIntent,1);
        }
        catch (ActivityNotFoundException ex)
        {

        }

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}


