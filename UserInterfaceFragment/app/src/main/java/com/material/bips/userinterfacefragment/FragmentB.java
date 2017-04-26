package com.material.bips.userinterfacefragment;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by bips on 10/14/15.
 */
public class FragmentB extends Fragment {
    TextView text;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_b,container,false);
        text= (TextView) view.findViewById(R.id.textView);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public void changeData(int position){
        Resources res= getResources();
        String[] descriptions= res.getStringArray(R.array.descriptions);
        text.setText(descriptions[position]);

    }
}
