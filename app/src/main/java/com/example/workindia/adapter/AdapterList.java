package com.example.workindia.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workindia.GridFragment;
import com.example.workindia.ListFragment;
import com.example.workindia.R;
import com.example.workindia.model.ListModal;

import java.util.ArrayList;
import java.util.List;


public class AdapterList extends RecyclerView.Adapter<AdapterList.MyViewHolder> {

    private List<ListModal> homeList;
    private ListFragment activity;

    public AdapterList(ListFragment homeActivity, List<ListModal> homeList){
        this.homeList = homeList;
        activity = homeActivity;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity.getActivity()).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(view);
    }



    public Context getContext(){
        return activity.getActivity();
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ListModal homeModel = homeList.get(position);
        holder.name.setText(homeModel.getName());
        holder.shipping.setText(homeModel.getExtra());
        holder.price.setText(homeModel.getPrice() == null ? "" : homeModel.getPrice());
    }



    @Override
    public int getItemCount() {
        return homeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, price, shipping;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            price = itemView.findViewById(R.id.item_price);
            name = itemView.findViewById(R.id.item_name);
            shipping = itemView.findViewById(R.id.shipping);
        }
    }
}