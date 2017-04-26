package com.recycler.bipin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerView;
    BipsAdapter bipsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= (RecyclerView) findViewById(R.id.recyclerlist);
        bipsAdapter=new BipsAdapter(this,getData());
        recyclerView.setAdapter(bipsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public List getData(){
        List<Information> data=new ArrayList<>();
       int[] icons= {R.drawable.ic_action,R.drawable.ic_action,
                R.drawable.ic_action,R.drawable.ic_action,R.drawable.ic_action,R.drawable.ic_action};
        String[] titles={"Sunday","Monday","Tuseday","Wednesday","Thursday","Friday"};

//        for (int i=0;i<20;i++){
//            icons[i]=R.drawable.ic_action;
//            titles[i]="data"+String.valueOf(i);
//        }
        for(int i=0;i<icons.length;i++){
            Information current=new Information();
            current.id=icons[i];
            current.title=titles[i];
            data.add(current);
        }
        return data;
    }
}
