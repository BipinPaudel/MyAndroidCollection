package com.mm.bipin.replacefragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bips on 12/31/15.
 */
public class Tab2 extends Fragment {
    public static Tab2 getInstance(String pass){

        Tab2 tab2=new Tab2();
        Bundle args=new Bundle();
        args.putString("passString",pass);
        tab2.setArguments(args);
        return tab2;
    }
    Spinner dropdown;
    TextView textView;
    ArrayList<String> spinnerItems=new ArrayList<String>(){{
        add("2015");
        add("2014");
    }};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_tab2,container,false);

        Bundle bundle=getArguments();
        String value=bundle.getString("passString");

//        dropdown= (Spinner) view.findViewById(R.id.spinner);
        textView= (TextView) view.findViewById(R.id.tab2);
        textView.setText("hello from tab2 " + value);


        return view;
    }
}
