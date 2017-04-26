package com.mm.bipin.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    BipsAdapter adapter;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerList);
        adapter=new BipsAdapter(this,getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    public static List<SingleRowInformation> getData(){
        List<SingleRowInformation> data= new ArrayList<>();
        int[] icons={R.drawable.ic_action,R.drawable.ic_action,
                R.drawable.ic_action,R.drawable.ic_action,R.drawable.ic_action,R.drawable.ic_action,
                R.drawable.ic_action,R.drawable.ic_action,
                R.drawable.ic_action,R.drawable.ic_action,R.drawable.ic_action,R.drawable.ic_action,R.drawable.ic_action,
                R.drawable.ic_action,R.drawable.ic_action,R.drawable.ic_action,R.drawable.ic_action};
        String[] titles={"Sunday","Monday","Tuseday","Wednesday","Thursday","Friday",
                "Sunday","Monday","Tuseday","Wednesday","Thursday","Friday","sd","sd","ewr","wet","qwer"};
        for(int i=0;i<icons.length;i++){
            SingleRowInformation info=new SingleRowInformation();
            info.title=titles[i];
            info.iconId=icons[i];
            data.add(info);

        }
        return data;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
