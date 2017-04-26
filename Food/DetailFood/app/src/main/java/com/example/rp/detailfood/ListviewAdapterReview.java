package com.example.rp.detailfood;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rp on 4/5/2016.
 */
public class ListviewAdapterReview extends BaseAdapter {


    Context context;
    ArrayList<Beanclassreview>beansre;


    public ListviewAdapterReview(Context context, ArrayList<Beanclassreview> beansre) {
        this.context = context;
        this.beansre = beansre;
    }



    @Override
    public int getCount() {
        return beansre.size();
    }

    @Override
    public Object getItem(int position) {
        return beansre.get(position);
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

            convertView = layoutInflater.inflate(R.layout.listreview,null);



            viewHolder.title= (TextView)convertView.findViewById(R.id.title);
            viewHolder.description= (TextView)convertView.findViewById(R.id.description);




            convertView.setTag(viewHolder);


        }else {

            viewHolder = (ViewHolder)convertView.getTag();

        }


        Beanclassreview beans = (Beanclassreview)getItem(position);


        viewHolder.title.setText(beans.getTitle());
        viewHolder.description.setText(beans.getDescription());
        return convertView;
    }

    private class ViewHolder{
      TextView title;
        TextView description;



    }
}
