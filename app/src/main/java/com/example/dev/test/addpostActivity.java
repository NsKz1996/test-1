package com.example.dev.test;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class addpostActivity extends AppCompatActivity {

    @BindView(R.id.fragmentaddpost_Imageview_addpost)
     ImageView photo_;
    @BindView(R.id.fragmentaddpost_EditText_title)
    EditText Titel_;
    @BindView(R.id.Activityaddpost_button_eshterakgozari)
    Button Save;



    private Uri uri;
    private Bitmap bitmap;
    private DataBase_Add_Post db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpost);
        ButterKnife.bind(this);
        db=new DataBase_Add_Post(this);

        photo_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    // intent.setType("image/*");
                    startActivityForResult(intent, 2);
                } catch (Exception x) {
                    Toast.makeText(getApplicationContext(), "Error Choose Image", Toast.LENGTH_SHORT).show();
                }
            }
        });


        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap =((BitmapDrawable)photo_.getDrawable()).getBitmap();
                ByteArrayOutputStream stream= new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,0,stream);
                byte [] image = stream.toByteArray();
               String t= Titel_.getText().toString();

                Long ID=  db.insertData(new Model_post_hom_hesam(image,t));
                if (ID<=0){
                    Toast.makeText(getApplicationContext(), "Erore", Toast.LENGTH_SHORT).show();
                }else {
                    finish();
                }


            }
        });



    }

    public void Bitmaptoarray(ImageView imageView){



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2 && resultCode == RESULT_OK && null != data) {

            uri = data.getData();
            CropImage();

        } else if (requestCode == 1) {
            if (data != null) {
                Bundle bundle = data.getExtras();
                bitmap = bundle.getParcelable("data");
                photo_.setImageBitmap(bitmap);

            }



        }
    }

    private void CropImage () {

        try {
            Intent CropIntent = new Intent("com.android.camera.action.CROP");
            CropIntent.setDataAndType(uri, "image/*");

            CropIntent.putExtra("crop", "true");
            CropIntent.putExtra("outputX", 500);
            CropIntent.putExtra("outputY", 500);
            CropIntent.putExtra("aspectX", 1);
            CropIntent.putExtra("aspectY", 1);
            CropIntent.putExtra("scaleUpIfNeeded", true);
            CropIntent.putExtra("return-data", true);

            Log.i("Crop", uri.toString());

            startActivityForResult(CropIntent, 1);
        } catch (ActivityNotFoundException ex) {

        }

    }

}