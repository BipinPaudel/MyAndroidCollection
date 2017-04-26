package com.example.rp.foodmenu;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import adapters.TodayMenuPagerAdapter;


public class MenuToday extends AppCompatActivity {
    private ViewPager todaymenupager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__today);

        todaymenupager = (ViewPager)findViewById(R.id.todaymenupager);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.todaymenutablayout);

        tabLayout.addTab(tabLayout.newTab().setText("MAIN"));
        tabLayout.addTab(tabLayout.newTab().setText("SIDER"));
        tabLayout.addTab(tabLayout.newTab().setText("DESSERTS"));


        TodayMenuPagerAdapter myPagerAdapter = new TodayMenuPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        todaymenupager.setAdapter(myPagerAdapter);
        todaymenupager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                todaymenupager.setCurrentItem(tab.getPosition());
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
