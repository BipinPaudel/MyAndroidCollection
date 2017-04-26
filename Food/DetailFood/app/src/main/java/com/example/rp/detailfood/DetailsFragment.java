package com.example.rp.detailfood;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by wolfsoft on 10/11/2015.
 */
public class DetailsFragment extends Fragment {
private TextView description;
    private View view;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view  =  inflater.inflate(R.layout.fragment_details, container, false);


   description = (TextView)view.findViewById(R.id.description);


        Typeface face = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Lato-Semibold.ttf");
        description.setTypeface(face);





        return view;

    }




}
