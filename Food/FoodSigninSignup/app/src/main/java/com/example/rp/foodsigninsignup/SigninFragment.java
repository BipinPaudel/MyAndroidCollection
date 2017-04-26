package com.example.rp.foodsigninsignup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wolfsoft on 10/11/2015.
 */
public class SigninFragment extends Fragment {

    private View view;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view  =  inflater.inflate(R.layout.fragment_signin, container, false);






        return view;

    }




}
