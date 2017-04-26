package adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rp.foodmenu.R;

import java.util.ArrayList;

import helper.Beanclasss;


/**
 * Created by Rp on 4/5/2016.
 */
public class ListviewAdapterS extends BaseAdapter {


    Context context;
    ArrayList<Beanclasss> beanss;


    public ListviewAdapterS(Context context, ArrayList<Beanclasss> beanss) {
        this.context = context;
        this.beanss = beanss;
    }

    @Override
    public int getCount() {
        return  beanss.size() ;
    }

    @Override
    public Object getItem(int position) {
        return beanss.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;





        if (convertView == null){

            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            viewHolder = new ViewHolder();

            convertView = layoutInflater.inflate(R.layout.slistview,null);


            viewHolder.simage= (ImageView)convertView.findViewById(R.id.simage);
            viewHolder.stitle= (TextView)convertView.findViewById(R.id.stitle);
            viewHolder.srupee= (TextView)convertView.findViewById(R.id.srupee);




            convertView.setTag(viewHolder);


        }else {

            viewHolder = (ViewHolder)convertView.getTag();

        }


        Beanclasss beans = (Beanclasss)getItem(position);

        viewHolder.simage.setImageResource(beans.getSimage());
        viewHolder.stitle.setText(beans.getStitle());
        viewHolder.srupee.setText(beans.getSrupee());


        return convertView;
    }



    private class ViewHolder{
        ImageView simage;
        TextView stitle;
        TextView srupee;


    }
}
