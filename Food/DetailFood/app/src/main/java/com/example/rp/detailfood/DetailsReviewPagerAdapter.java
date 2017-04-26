package com.example.rp.detailfood;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by one on 31/3/16.
 */
public class DetailsReviewPagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public DetailsReviewPagerAdapter(FragmentManager fm, int mNumOfTabs) {
        super(fm);
        this.mNumOfTabs = mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0 :

                DetailsFragment detailsFragment = new DetailsFragment();
                return detailsFragment;

            case 1 :

                ReviewFragment reviewFragment = new ReviewFragment();
                return reviewFragment;


        }

    return null;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
