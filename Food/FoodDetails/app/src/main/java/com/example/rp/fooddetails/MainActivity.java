package com.example.rp.fooddetails;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ExpandableHeightListView listview;




    private String[] Title ={"Italian pizza","Fresh Pasta","Garlic Bread"};

    private String[] Rupee = {"Rs 100","Rs 210 ","Rs 500 "};


    private ArrayList<Bean> beans;
    private ListViewBaseAdapter listViewBaseAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        listview = (ExpandableHeightListView)findViewById(R.id.listview);
        beans= new ArrayList<Bean>();

        for (int i= 0; i< Title.length; i++) {

            Bean beanclass = new Bean(Title[i], Rupee[i]);
            beans.add(beanclass);

        }
        listViewBaseAdapter = new ListViewBaseAdapter(MainActivity.this, beans);

        listview.setAdapter(listViewBaseAdapter);
    }
}
