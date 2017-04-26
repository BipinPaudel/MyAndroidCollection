package com.mm.bipin.replacefragment;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by bips on 1/21/16.
 */
public class Tab2 extends Fragment {

    Activity mActivity;
    listener mCallback;


    @Override
    public void onAttach(Activity activity) {
        mActivity=(MainActivity)activity;
        super.onAttach(activity);
        mCallback= (listener) mActivity;
    }

    public static Tab2 getInstance(String textToPrint){
        Tab2 tab2= new Tab2();
        Bundle bundle=new Bundle();
        bundle.putString("textToPrint",textToPrint);
        tab2.setArguments(bundle);
        return tab2;
    }
    public static ArrayList<String> spinnerDate= new ArrayList<String>(){{
        add("2015");
        add("2014");
        add("2013");
        add("2012");
    }};
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.tab2,container,false);
        Bundle bundle=getArguments();
        String textToPrint=bundle.getString("textToPrint");
        textView= (TextView) view.findViewById(R.id.tab2_id);
        textView.setText("this is tab 2 with " + textToPrint);
        Toast.makeText(getContext(),textToPrint,Toast.LENGTH_SHORT).show();

        spinner= (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                getContext(),android.R.layout.simple_spinner_dropdown_item,spinnerDate
        );
        spinner.setAdapter(adapter);
        spinner(view);
        return view;
    }

    Spinner spinner;
    public void spinner(View view){

        final int[] counter = {0};
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text=String.valueOf(spinner.getSelectedItem());
                Toast.makeText(getContext(),text,Toast.LENGTH_SHORT).show();
                if(counter[0] ==0){

                }
                else {
                   // mCallback.passText(text);
                }
                counter[0]=counter[0]+1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public interface listener{
        public void passText(String textToPass);
    }
}
