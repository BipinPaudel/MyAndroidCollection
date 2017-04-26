package com.example.rp.foodsigninsignup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by wolfsoft on 10/11/2015.
 */
public class SignupFragment extends Fragment {

    private View view;


    private TextView book;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view  =  inflater.inflate(R.layout.fragment_signup, container, false);


//        book = (TextView)view.findViewById(R.id.book);


        return view;

    }




}
