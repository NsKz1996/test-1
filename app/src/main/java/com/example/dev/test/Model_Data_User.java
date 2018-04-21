package com.example.dev.test;

public class Model_Data_User {

    //  int ID;
    String PhoneNumber, UserName, Password;
    byte[] Profile;

    public Model_Data_User(String phoneNumber, String userName, String password, byte[] profile) {
        //  ID=id;
        PhoneNumber = phoneNumber;
        UserName = userName;
        Password = password;
        Profile = profile;
    }

//    public int getID() {
//        return ID;
//    }
//
//    public void setID(int ID) {
//        this.ID = ID;
//    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public byte[] getProfile() {
        return Profile;
    }

    public void setProfile(byte[] profile) {
        Profile = profile;
    }
}
