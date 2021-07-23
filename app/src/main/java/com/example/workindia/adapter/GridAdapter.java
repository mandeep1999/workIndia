package com.example.workindia.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.workindia.GridFragment;
import com.example.workindia.ListFragment;
import com.example.workindia.R;
import com.example.workindia.model.ListModal;

import java.util.ArrayList;


public class GridAdapter extends BaseAdapter {
    private Context mContext;
    private GridFragment activity;
    private ArrayList<ListModal> itemList;

    // Constructor
    public GridAdapter(Context c, GridFragment activity,  ArrayList<ListModal> itemList) {
        mContext = c;
        this.activity = activity;
        this.itemList = itemList;
    }

    public int getCount() {
        return itemList.size();
    }

    public Object getItem(int position) {
        return itemList.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView1, textView2;
        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            View myLayout = inflater.inflate(R.layout.grid_item, parent, false);
            textView1 = myLayout.findViewById(R.id.item);
            textView2 = myLayout.findViewById(R.id.price);
            String temp1 = itemList.get(position).getName().trim();
            String temp2 = itemList.get(position).getPrice().trim();
            if(temp1.length() > 11){
                temp1 = temp1.substring(0,11) + "...";
            }
            textView1.setText(temp1);
            if(temp2.length() > 11){
                temp2 = temp2.substring(0,11) + "...";
            }
            textView2.setText(temp2);
            return myLayout;
        }
        return convertView;
    }


}