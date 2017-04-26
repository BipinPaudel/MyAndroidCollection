package com.example.rp.fooddetails;

/**
 * Created by apple on 15/03/16.
 *
 * //********LISTVIEW************
 */
public class Bean {


    private String title;
    private String rupee;

    public Bean(String title,String rupee) {
        this.rupee = rupee;
        this.title = title;
    }

    public String getRupee() {
        return rupee;
    }

    public void setRupee(String rupee) {
        this.rupee = rupee;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
