package com.example.rp.detailfood;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class DetailReview extends AppCompatActivity {
    private ViewPager detailreviewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detailreviewpager = (ViewPager)findViewById(R.id.detailreviewpager);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.detailreviewtablayout);

        tabLayout.addTab(tabLayout.newTab().setText("DETAILS"));
        tabLayout.addTab(tabLayout.newTab().setText("REVIEW"));



        DetailsReviewPagerAdapter detailsReviewPagerAdapter = new DetailsReviewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        detailreviewpager.setAdapter(detailsReviewPagerAdapter);
        detailreviewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                detailreviewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }


        });
    }


}
