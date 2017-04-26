package com.mm.bipin.materialslidetab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by bips on 11/15/15.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    CharSequence Titles[];
    int numberOfTitles;
    int condition;
    public ViewPagerAdapter(FragmentManager fm,CharSequence Titles[],int numberOfTitles,int condition) {
        super(fm);
        this.Titles=Titles;
        this.numberOfTitles=numberOfTitles;
        this.condition=condition;
    }

    @Override
    public Fragment getItem(int i) {
        if (i==0){


            return Tab1Fragment.init(condition);
        }
        else
        {
         Tab2Fragment tab2Fragment=new Tab2Fragment();
            return tab2Fragment;
        }
    }

    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    @Override
    public int getCount() {
        return numberOfTitles;
    }
}
