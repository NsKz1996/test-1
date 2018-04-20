package com.example.dev.test;

/**
 * Created by Amir Hossein on 4/20/2018.
 */

public class Model_Post_Home {



    public Model_Post_Home(int photo, String name, String time, String comment, String like) {
        this.photo = photo;
        this.name = name;
        this.time = time;
        this.comment = comment;
        this.like = like;
    }

    int photo;
    String name;
    String time;
    String comment;
    String like;

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

}
