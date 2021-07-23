package com.example.workindia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class GridFragment extends Fragment{
    private RecyclerView recyclerView;
    ImageButton plusButton;
    View rootView;
//    private HomeListAdapter adapter;
//    private List<HomeModel> mList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_grid, container,false);
//        recyclerView = rootView.findViewById(R.id.grid_list);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }


    private void showData() {


    }

}