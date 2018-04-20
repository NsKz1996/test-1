package com.example.dev.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class DataBase_User {
    myDbHelper myhelper;
    ArrayList<Model_Data_User> list =new ArrayList<>();

    public DataBase_User(Context context)
    {
        myhelper = new myDbHelper(context);
    }



    public Long insertData(Model_Data_User model) {

        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
      //  contentValues.put(myDbHelper.UID, model.ID);
        contentValues.put(myDbHelper.PhoneNumber, model.getPhoneNumber());
        contentValues.put(myDbHelper.PassWord, model.getPassword());
        contentValues.put(myDbHelper.Username, model.getUserName());
        contentValues.put(myDbHelper.Photo, model.getProfile());
        long id = dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        return id;
    }

    public ArrayList<Model_Data_User> getData()
    {
        ArrayList<Model_Data_User> model_data_users =new ArrayList<>() ;

        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID,myDbHelper.Username ,myDbHelper.PhoneNumber, myDbHelper.PassWord, myDbHelper.Photo};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,null,null,null,null,null);
        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            String phoneNumber =cursor.getString(cursor.getColumnIndex(myDbHelper.PhoneNumber));
            String userName = cursor.getString(cursor.getColumnIndex(myDbHelper.Username));
            String password =cursor.getString(cursor.getColumnIndex(myDbHelper.PassWord));
            byte[] photo = cursor.getBlob(cursor.getColumnIndex(myDbHelper.Photo));
            Log.i("Byte savve sql",photo+"");

            model_data_users.add(new Model_Data_User(phoneNumber, userName, password, photo));
        }
        return model_data_users;
    }

    public  int delete(String uname)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] whereArgs ={uname};

        int count =db.delete(myDbHelper.TABLE_NAME , myDbHelper.PhoneNumber+" = ?",whereArgs);
        return  count;
    }

    public int updateName(String oldName , String newName)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.PhoneNumber,newName);
        String[] whereArgs= {oldName};
        int count =db.update(myDbHelper.TABLE_NAME,contentValues, myDbHelper.PhoneNumber+" = ?",whereArgs );
        return count;
    }

    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "DataBaseGhoozh";    // Database Name
        private static final String TABLE_NAME = "User";   // Table Name
        private static final int DATABASE_Version = 1;    // Database Version
        private static final String UID="_id";     // Column I (Primary Key)
        private static final String PhoneNumber = "PhoneNumber";    //Column II
        private static final String Username= "UserName";    // Column III
        private static final String PassWord= "PassWord";    // Column IIII
        private static final String Photo= "Photo";    // Column IIIII
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                PhoneNumber+" TEXT,"+
                Username+" TEXT ,"+
                PassWord+" TEXT ,"+
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
