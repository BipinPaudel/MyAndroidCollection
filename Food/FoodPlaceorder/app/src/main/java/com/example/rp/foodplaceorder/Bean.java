package com.example.rp.foodplaceorder;

/**
 * Created by apple on 15/03/16.
 *
 * //********LISTVIEW************
 */
public class Bean {

    private int image;
    private String title;
    private String money;


    public Bean(int image, String money, String title) {
        this.image = image;
        this.money = money;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
