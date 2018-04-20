package com.example.dev.test;

/**
 * Created by Amir Hossein on 4/20/2018.
 */

public class Model_Notification {

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public Model_Notification(int photo, String like, String comment, String share) {
        this.photo = photo;
        this.like = like;
        this.comment = comment;
        this.share = share;
    }

    int photo;
    String like;
    String comment;
    String share;

}
