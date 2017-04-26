package com.mm.bipin.materialslidetab;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by bips on 11/15/15.
 */
public class Tab1Fragment extends android.support.v4.app.Fragment {

    static Tab1Fragment init(int rule){
        Tab1Fragment frag=new Tab1Fragment();
        Bundle b = new Bundle();
        b.putInt("value", rule);
        frag.setArguments(b);
        return frag;

    }

    @Nullable
    @Override


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.tab_1,container,false);
        Bundle b =new Bundle();
        int ss=b.getInt("value",0);
        TextView tt= (TextView) view.findViewById(R.id.textView1);
        tt.setText(Integer.toString(ss));
        Toast.makeText(getContext(),"Tab1 toast",Toast.LENGTH_SHORT).show();
        return view;
    }
}
