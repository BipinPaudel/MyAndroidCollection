package adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rp.foodmenu.R;

import java.util.ArrayList;

import helper.Beanclassmd;


/**
 * Created by Rp on 4/5/2016.
 */
public class ListviewAdapterMd extends BaseAdapter {


    Context context;
    ArrayList<Beanclassmd> beansmd;


    public ListviewAdapterMd(Context context, ArrayList<Beanclassmd> beansmd) {
        this.context = context;
        this.beansmd = beansmd;
    }

    @Override
    public int getCount() {
        return  beansmd.size() ;
    }

    @Override
    public Object getItem(int position) {
        return beansmd.get(position);
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

            convertView = layoutInflater.inflate(R.layout.mdlistview,null);


            viewHolder.mdimage= (ImageView)convertView.findViewById(R.id.mdimage);
            viewHolder.mdtitle= (TextView)convertView.findViewById(R.id.mdtitle);
            viewHolder.mdrupee= (TextView)convertView.findViewById(R.id.mdrupee);


            Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/Lato-Semibold.ttf");

                viewHolder.mdtitle.setTypeface(font);


            convertView.setTag(viewHolder);


        }else {

            viewHolder = (ViewHolder)convertView.getTag();

        }


        Beanclassmd beans = (Beanclassmd)getItem(position);

        viewHolder.mdimage.setImageResource(beans.getMdimage());
        viewHolder.mdtitle.setText(beans.getMdtitle());
        viewHolder.mdrupee.setText(beans.getMdrupee());


        return convertView;
    }



    private class ViewHolder{
        ImageView mdimage;
        TextView mdtitle;
        TextView mdrupee;


    }
}
