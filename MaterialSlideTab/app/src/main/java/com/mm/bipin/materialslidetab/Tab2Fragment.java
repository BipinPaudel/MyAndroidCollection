package com.mm.bipin.materialslidetab;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by bips on 11/15/15.
 */
public class Tab2Fragment extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tab_2,container,false);
        Toast.makeText(getContext(), "Tab2 toast", Toast.LENGTH_SHORT).show();
        return view;
    }
}
