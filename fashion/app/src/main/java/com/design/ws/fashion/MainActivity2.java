package com.design.ws.fashion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
ImageView back;
    private ArrayList<String> DAYS;
    private ArrayList<String> YEARS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        spinner1 = (Spinner)findViewById(R.id.spinner1);

        spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner3 = (Spinner)findViewById(R.id.spinner3);

        back = (ImageView)findViewById(R.id.back);


        String[] items = new String[]{"Month","Jan", "Feb", "Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, items);
        spinner1.setAdapter(adapter);


        DAYS = new ArrayList<>();

        String[] items2 = new String[]{"Date", "1", "2",};

        DAYS.add(0, "Day");

        for (int i=1; i<=31; i++){

            DAYS.add(i, ""+i);
        }

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.spinner_item, DAYS);
        spinner2.setAdapter(adapter2);



        YEARS = new ArrayList<>();
        String[] items3 = new String[]{"1", "2", "3"};
        YEARS.add(0, "Year");

        for (int i=1980; i<=2016; i++){

            YEARS.add(i-1979, "" + i);
        }

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, R.layout.spinner_item, YEARS);
        spinner3.setAdapter(adapter3);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(it);
            }
        });


    }
}
