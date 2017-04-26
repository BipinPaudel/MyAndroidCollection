package com.material.bips.listwithimage;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    ListView list;
    String[] titles={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    String[] descriptions={"this is sunday","This is monday","This is tuesday","This is wednesday","this is thursday",
    "this is friday","this is saturday"};
    int[] images={R.drawable.ic_action,R.drawable.ic_action,R.drawable.ic_action,R.drawable.ic_action,
            R.drawable.ic_action,R.drawable.ic_action,R.drawable.ic_action};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list= (ListView) findViewById(R.id.listView);
        BipinAdapter adapter= new BipinAdapter(this,images,titles,descriptions);
        list.setAdapter(adapter);
    }

}

    class BipinAdapter extends  ArrayAdapter<String>{
        Context context;
        int[] imageArray;
        String[] descriptionArray;
        String[] titleArray;
        BipinAdapter(Context context,int[] imgs,String[] titles,String[] descriptions){
            super(context,R.layout.single_row,R.id.textView1,titles);
            this.context=context;
            this.imageArray=imgs;
            this.titleArray=titles;
            this.descriptionArray=descriptions;
        }

        @Override
        public View getView(int position,View convertView,ViewGroup parent){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=inflater.inflate(R.layout.single_row,parent,false);

            ImageView myImage= (ImageView) row.findViewById(R.id.imageView);
            TextView myTitle= (TextView) row.findViewById(R.id.textView1);
            TextView myDescription= (TextView) row.findViewById(R.id.textView2);

            myImage.setImageResource(imageArray[position]);
            myTitle.setText(titleArray[position]);
            myDescription.setText(descriptionArray[position]);

            return row;
        }
    }

