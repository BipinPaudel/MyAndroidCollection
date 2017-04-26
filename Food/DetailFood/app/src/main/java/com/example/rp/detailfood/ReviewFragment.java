package com.example.rp.detailfood;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by wolfsoft on 10/11/2015.
 */
public class ReviewFragment extends Fragment {

    private View view;
    ListView listreview;

    private String[] Title ={"Good Food","Nice","Food"};

    private String[] Description = {"awesome food it was great exprience good test greate service ","Decent food when you have limited options",
            "Tastes far better when had fresh at the outlet instead of a home delivery. Do not know about the non veg menu but the mushroom roll and the cheesy panner are a good eat... Best part is the wheat bread they serve"};


    private ArrayList<Beanclassreview> beansre;
    private ListviewAdapterReview listbaseAdapterReview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view  =  inflater.inflate(R.layout.fragment_review, container, false);

        listreview= (ListView)view.findViewById(R.id.listreview);
        beansre= new ArrayList<Beanclassreview>();

        for (int i= 0; i< Title.length; i++) {

            Beanclassreview beanclassre = new Beanclassreview(Title[i],Description[i]);
            beansre.add(beanclassre);

        }

        listbaseAdapterReview = new ListviewAdapterReview(getActivity(), beansre);
        listreview.setAdapter(listbaseAdapterReview);
        return view;

    }




}
