package com.example.rp.foodplaceorder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ExpandableHeightListView listview;


    private int[] Image = {R.drawable.foodg,R.drawable.cake};

    private String[] Title ={"Garlic Bread","Cake"};

    private String[] Money = {"100 Rs","100 Rs","250 Rs "};


    private ArrayList<Bean> beans;
    private ListViewBaseAdapter listViewBaseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listview= (ExpandableHeightListView)findViewById(R.id.listview);
        beans= new ArrayList<Bean>();

        for (int i= 0; i< Title.length; i++) {

            Bean beanclass = new Bean(Image[i], Money[i], Title[i]);
            beans.add(beanclass);

        }
        listViewBaseAdapter = new ListViewBaseAdapter(MainActivity.this, beans);
        listview.setAdapter(listViewBaseAdapter);

    }
}
