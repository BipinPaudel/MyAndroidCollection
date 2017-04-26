package com.material.bips.userinterfacefragment;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentA.Communicator {
FragmentA fragA;
    FragmentB fragB;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getFragmentManager();
        fragA = (FragmentA) manager.findFragmentById(R.id.fragmentA);
        fragA.setCommunicator(this);
    }


    @Override
    public void respond(int i) {

    fragB= (FragmentB) manager.findFragmentById(R.id.fragmentB);
        if(fragB!=null && fragB.isVisible()){
            fragB.changeData(i);
        }
        else{
            Intent intent= new Intent(MainActivity.this,Details.class);
            intent.putExtra("index",i);
            startActivity(intent);
        }

    }
}
