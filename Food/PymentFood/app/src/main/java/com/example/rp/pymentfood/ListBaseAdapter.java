package com.example.rp.pymentfood;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ListBaseAdapter extends BaseAdapter {

    Context context;

    ArrayList<Beanlist> beanlist;

    private int number = 01;
//
//    Typeface fonts1,fonts2;


    public ListBaseAdapter(Context context, ArrayList<Beanlist> beanlist) {


        this.context = context;
        this.beanlist = beanlist;
    }


    @Override
    public int getCount() {
        return  beanlist.size();
    }

    @Override
    public Object getItem(int position) {
        return beanlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        ViewHolder viewHolder = null;
//
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list,null);

            viewHolder = new ViewHolder();

            viewHolder.image = (ImageView)convertView.findViewById(R.id.image);
            viewHolder.title = (TextView)convertView.findViewById(R.id.title);

            viewHolder.money = (TextView)convertView.findViewById(R.id.money);
            viewHolder.min = (ImageView)convertView.findViewById(R.id.min);
            viewHolder.text = (TextView)convertView.findViewById(R.id.text);
            viewHolder.plus = (ImageView)convertView.findViewById(R.id.plus);



            convertView.setTag(viewHolder);


        }else {

            viewHolder = (ViewHolder)convertView.getTag();
        }



        Beanlist beanlist = (Beanlist)getItem(position);

        viewHolder.image.setImageResource(beanlist.getImage());
        viewHolder.title.setText(beanlist.getTitle());

        viewHolder.money.setText(beanlist.getMoney());


        number = 01;
        viewHolder.text.setText(""+number);

        final ViewHolder finalViewHolder = viewHolder;
        viewHolder.min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (number == 1){
                    finalViewHolder.text.setText("" + number);
            }

                if (number > 1){

                    number = number -1;
                    finalViewHolder.text.setText(""+number);
                }

            }
        });

        final ViewHolder finalViewHolder1 = viewHolder;
        viewHolder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (number == 9) {
                    finalViewHolder1.text.setText("" + number);
                }

                if (number < 9) {

                    number = number + 1;
                    finalViewHolder1.text.setText("" + number);

                }




            }
        });

        return convertView;
    }

    private class ViewHolder{
        ImageView image;
        TextView title;
        TextView money;
        ImageView min;
        TextView text;
        ImageView plus;













    }
}




