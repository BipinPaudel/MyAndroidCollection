package com.material.bips.userinterfacefragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by bips on 10/14/15.
 */
public class Details extends Activity{
    FragmentManager manager;
    FragmentB fragB;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        Intent intent=getIntent();
        int index=intent.getIntExtra("index", 0);
       Toast.makeText(this, Integer.toString(index), Toast.LENGTH_SHORT).show();
        manager=getFragmentManager();
        fragB= (FragmentB) manager.findFragmentById(R.id.fragmentB);
        if(fragB!=null) {
            fragB.changeData(index);
        }
    }
}
