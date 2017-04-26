package com.mm.bipin.replacefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by bips on 12/31/15.
 */
public class RootFragment extends Fragment {
    public static RootFragment getInstance(){
        RootFragment rootFragment=new RootFragment();
        return rootFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.root_fragment,container,false);

        FragmentTransaction manager=getFragmentManager().beginTransaction();
        manager.replace(R.id.root_fragment,Tab2.getInstance("first ma ho hai"));
        manager.commit();

        return view;
    }
}
