package com.mm.bipin.replacefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by bips on 1/21/16.
 */
public class Tab1 extends Fragment {

    public static Tab1 getInstance(){
        Tab1 tab1 = new Tab1();
        return tab1;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1,container,false);
        return view;
    }
}
