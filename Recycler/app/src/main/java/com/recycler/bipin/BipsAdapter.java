package com.recycler.bipin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by bips on 5/9/16.
 */
public class BipsAdapter extends RecyclerView.Adapter<BipsAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    List<Information> data= Collections.emptyList();


    public BipsAdapter(Context context,List data){
        inflater=LayoutInflater.from(context);
        this.data=data;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.custom_row,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Information current=data.get(position);
        holder.title.setText(current.title);
        holder.image.setImageResource(current.id);
    }



    @Override
    public int getItemCount() {

        return data.size() ;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.listText);
            image= (ImageView) itemView.findViewById(R.id.listIcon);
        }
    }
}
