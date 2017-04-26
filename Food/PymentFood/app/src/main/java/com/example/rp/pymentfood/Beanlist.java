package com.example.rp.pymentfood;

/**
 * Created by apple on 15/03/16.
 */
public class Beanlist {

    private int image;
    private String title;

    private String money;

    public Beanlist(int image, String title, String money) {
        this.image = image;
        this.title = title;

        this.money = money;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
