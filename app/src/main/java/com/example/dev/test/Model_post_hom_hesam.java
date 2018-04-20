package com.example.dev.test;

public class Model_post_hom_hesam {

    byte [] image;
    String des,tozih;

    public Model_post_hom_hesam(byte[] image, String des, String tozih) {
        this.image = image;
        this.des = des;
        this.tozih = tozih;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTozih() {
        return tozih;
    }

    public void setTozih(String tozih) {
        this.tozih = tozih;
    }
}
