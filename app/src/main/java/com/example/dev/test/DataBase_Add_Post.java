package com.example.dev.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;


public class DataBase_Add_Post {
    private myDbHelper helperaddpost;
    ArrayList<Model_post_hom_hesam> list =new ArrayList<>();

    public DataBase_Add_Post(Context context)
    {
        helperaddpost = new myDbHelper(context);
    }



    public Long insertData(Model_post_hom_hesam model) {

        SQLiteDatabase dbb = helperaddpost.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
      //  contentValues.put(myDbHelper.UID, model.ID);
        contentValues.put(myDbHelper.Photo, model.getImage());
        contentValues.put(myDbHelper.Discription,model.getDes());
        long id = dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        return id;
    }

    public ArrayList<Model_post_hom_hesam> getData()
    {
        ArrayList<Model_post_hom_hesam> model_Post ;
        model_Post=new ArrayList<>();

        SQLiteDatabase db = helperaddpost.getWritableDatabase();
        String[] columns = {myDbHelper.UID, myDbHelper.Discription, myDbHelper.Photo};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,null,null,null,null,null);
        while (cursor.moveToNext())
        {

            int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            String Dis =cursor.getString(cursor.getColumnIndex(myDbHelper.Discription));
          //  String Tozih = cursor.getString(cursor.getColumnIndex(myDbHelper.Tozihat));

            byte[] photo = cursor.getBlob(cursor.getColumnIndex(myDbHelper.Photo));

            model_Post.add(new Model_post_hom_hesam(photo,Dis));
        }
        return model_Post;
    }

    public  int delete(String uname)
    {
        SQLiteDatabase db = helperaddpost.getWritableDatabase();
        String[] whereArgs ={uname};

        int count =db.delete(myDbHelper.TABLE_NAME , myDbHelper.Tozihat+" = ?",whereArgs);
        return  count;
    }

    public int updateName(String oldName , String newName)
    {
        SQLiteDatabase db = helperaddpost.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.Tozihat,newName);
        String[] whereArgs= {oldName};
        int count =db.update(myDbHelper.TABLE_NAME,contentValues, myDbHelper.Tozihat+" = ?",whereArgs );
        return count;
    }

    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "DataBaseGhoozh";    // Database Name
        private static final String TABLE_NAME = "Post";   // Table Name
        private static final int DATABASE_Version = 1;    // Database Version
        private static final String UID="_id";     // Column I (Primary Key)
        private static final String Discription = "Discription";    //Column II
        private static final String Tozihat= "Tozihat";    // Column III
//        private static final String PassWord= "PassWord";    // Column IIII
        private static final String Photo= "Photo";    // Column IIIII
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                Discription+" TEXT,"+
                Photo+" BLOB);";

        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                Toast.makeText(context, "Not Create Table", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Toast.makeText(context, "Upgrade", Toast.LENGTH_SHORT).show();
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
                Toast.makeText(context, "Not Upgraded", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
