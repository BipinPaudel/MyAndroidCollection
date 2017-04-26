package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.rp.foodmenu.R;

import java.util.ArrayList;

import adapters.ListviewAdapterS;
import helper.Beanclasss;


/**
 * Created by wolfsoft on 10/11/2015.
 */
public class SiderFragment extends Fragment {

    private View view;



    ListView slistview;


    private int[] SImage = {R.drawable.photo,R.drawable.photo,R.drawable.photo};

    private String[] STitle ={"Tea &amp; Garlic Tost","Tea &amp; Garlic Tost","Tea &amp; Garlic Tost"};

    private String[] SRupee = {"100 Rs","100 Rs","100 Rs "};


    private ArrayList<Beanclasss> beanss;
    private ListviewAdapterS listbaseAdapterS;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view  =  inflater.inflate(R.layout.fragment_sider, container, false);


        slistview= (ListView)view.findViewById(R.id.slistview);
        beanss= new ArrayList<Beanclasss>();

        for (int i= 0; i< STitle.length; i++) {

            Beanclasss beanclasss = new Beanclasss(SImage[i], STitle[i], SRupee[i]);
            beanss.add(beanclasss);

        }
        listbaseAdapterS = new ListviewAdapterS(getActivity(),beanss);

        slistview.setAdapter(listbaseAdapterS);

        return view;

    }




}
