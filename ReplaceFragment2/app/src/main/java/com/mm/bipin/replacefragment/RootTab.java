package com.mm.bipin.replacefragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by bips on 1/21/16.
 */
public class RootTab extends Fragment {
    public static RootTab getInstance(String textToPrint){

        RootTab rootTab=new RootTab();
        Bundle bundle=new Bundle();
        bundle.putString("textToPrint",textToPrint);
        rootTab.setArguments(bundle);
        return rootTab;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.roottab,container,false);
        Bundle bundle=getArguments();
        String textToPrint=bundle.getString("textToPrint");
        Toast.makeText(getContext(),textToPrint,Toast.LENGTH_SHORT).show();
        FragmentManager manager=getFragmentManager();
        android.support.v4.app.FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.root_tab,Tab2.getInstance(textToPrint));
        transaction.commit();
        return view;


    }
}
