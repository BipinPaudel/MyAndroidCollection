package adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragment.DessertFragment;
import fragment.MainDishesFragment;
import fragment.SiderFragment;


/**
 * Created by one on 31/3/16.
 */
public class TodayMenuPagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public TodayMenuPagerAdapter(FragmentManager fm, int mNumOfTabs) {
        super(fm);
        this.mNumOfTabs = mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0 :

                MainDishesFragment mainDishesFragment = new MainDishesFragment();
                return mainDishesFragment;

            case 1 :

                SiderFragment siderFragment = new SiderFragment();
                return siderFragment;

            case 2 :

                DessertFragment dessertFragment = new DessertFragment();
                return dessertFragment;

        }

    return null;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
