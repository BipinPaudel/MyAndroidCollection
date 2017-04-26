package com.mm.bipin.replacefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by bips on 12/31/15.
 */
public class Tab3 extends Fragment {
    public static Tab3 getInstance(String pass){
        Tab3 tab3=new Tab3();

        Bundle bundle=new Bundle();
        bundle.putString("stringValue",pass);
        tab3.setArguments(bundle);
        return tab3;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_tab3,container,false);
        Bundle bundle=getArguments();
        String ok=bundle.getString("stringValue");
        TextView textView= (TextView) view.findViewById(R.id.tab3);
        textView.setText("Hello from tab3 "+ ok);
        return view;
    }
}
