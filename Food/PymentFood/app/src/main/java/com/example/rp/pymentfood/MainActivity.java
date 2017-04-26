package com.example.rp.pymentfood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity  extends AppCompatActivity {
    private ListView listview;
    private TextView payment;

    private FrameLayout paypal;
    private FrameLayout visa;
    private FrameLayout payumoney;
    private FrameLayout netbanking;

    private int[] IMAGE = {R.drawable.photopixle};

    private String[] TITLE = {"Teak & Steel Petanque Set"};

    private String[] MONEY = {"Rs 100.00"};
    private ArrayList<Beanlist> Bean;
    private ListBaseAdapter baseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listview);

        paypal = (FrameLayout) findViewById(R.id.paypal);
        visa = (FrameLayout) findViewById(R.id.visa);
        payumoney = (FrameLayout) findViewById(R.id.payumoney);
        netbanking = (FrameLayout) findViewById(R.id.netbanking);


        paypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickb("S", "1");

            }
        });

        visa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickb("S", "2");

            }
        });

        payumoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickb("S", "3");

            }
        });

        netbanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickb("S", "4");

            }
        });





        Bean = new ArrayList<Beanlist>();

        for (int i = 0; i < TITLE.length; i++) {

            Beanlist bean = new Beanlist(IMAGE[i], TITLE[i], MONEY[i]);
            Bean.add(bean);

        }


        baseAdapter = new ListBaseAdapter(MainActivity.this, Bean) {
        };

        listview.setAdapter(baseAdapter);
    }



    private void clickb(String s , String t) {


        paypal.setBackgroundResource(R.drawable.rect);
        visa.setBackgroundResource(R.drawable.rect);
        payumoney.setBackgroundResource(R.drawable.rect);
        netbanking.setBackgroundResource(R.drawable.rect);


        if(t.equalsIgnoreCase("1")) {
            paypal.setBackgroundResource(R.drawable.rectblue);

        }

        else if(t.equalsIgnoreCase("2")){
            visa.setBackgroundResource(R.drawable.rectblue);



        }

        else if(t.equalsIgnoreCase("3")){
            payumoney.setBackgroundResource(R.drawable.rectblue);




        }
        else if(t.equalsIgnoreCase("4")){
            netbanking.setBackgroundResource(R.drawable.rectblue);




        }


    }
}

