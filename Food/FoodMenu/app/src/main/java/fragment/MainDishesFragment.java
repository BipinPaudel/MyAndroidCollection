package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.rp.foodmenu.R;

import java.util.ArrayList;

import adapters.ListviewAdapterMd;
import helper.Beanclassmd;


/**
 * Created by wolfsoft on 10/11/2015.
 */
public class MainDishesFragment extends Fragment {

    private View view;
    ListView mdlistview;


    private int[] MdImage = {R.drawable.photo,R.drawable.foodg,R.drawable.foodk};

    private String[] MdTitle ={"Garlic Tost","Khichadi","Gangu"};

    private String[] MdRupee = {"100 Rs","600 Rs","500 Rs "};


    private ArrayList<Beanclassmd> beansmd;
    private ListviewAdapterMd listbaseAdapterMd;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view  =  inflater.inflate(R.layout.fragment_maindishes, container, false);


        mdlistview= (ListView)view.findViewById(R.id.mdlistview);
        beansmd= new ArrayList<Beanclassmd>();

        for (int i= 0; i< MdTitle.length; i++) {

            Beanclassmd beanclassmd = new Beanclassmd(MdImage[i], MdTitle[i], MdRupee[i]);
            beansmd.add(beanclassmd);

        }
        listbaseAdapterMd = new ListviewAdapterMd(getActivity(), beansmd);
        mdlistview.setAdapter(listbaseAdapterMd);


        return view;

    }




}
