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

import helper.Beanclassde;


/**
 * Created by Rp on 4/5/2016.
 */
public class ListviewAdapterDe extends BaseAdapter {


    Context context;
    ArrayList<Beanclassde> beansde;


    public ListviewAdapterDe(Context context, ArrayList<Beanclassde> beansde) {
        this.context = context;
        this.beansde = beansde;
    }

    @Override
    public int getCount() {
        return  beansde.size() ;
    }

    @Override
    public Object getItem(int position) {
        return beansde.get(position);
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

            convertView = layoutInflater.inflate(R.layout.delistview,null);


            viewHolder.deimage= (ImageView)convertView.findViewById(R.id.deimage);
            viewHolder.detitle= (TextView)convertView.findViewById(R.id.detitle);
            viewHolder.derupee= (TextView)convertView.findViewById(R.id.derupee);


            Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/Lato-Semibold.ttf");

                viewHolder.detitle.setTypeface(font);


            convertView.setTag(viewHolder);


        }else {

            viewHolder = (ViewHolder)convertView.getTag();

        }


        Beanclassde beans = (Beanclassde)getItem(position);

        viewHolder.deimage.setImageResource(beans.getDeimage());
        viewHolder.detitle.setText(beans.getDetitle());
        viewHolder.derupee.setText(beans.getDerupee());


        return convertView;
    }



    private class ViewHolder{
        ImageView deimage;
        TextView detitle;
        TextView derupee;


    }
}
