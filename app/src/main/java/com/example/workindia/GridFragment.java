package com.example.workindia;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.workindia.adapter.GridAdapter;
import com.example.workindia.model.ListModal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class GridFragment extends Fragment{
    GridView gridView;
    View rootView;
    GridAdapter adapter;
    ArrayList<ListModal> itemList = new ArrayList<ListModal>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_grid, container,false);
        gridView = (GridView)rootView.findViewById(R.id.gridView_student);
        showData();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             System.out.println("clicked");
            }
        });
        return rootView;
    }


    private void showData() {
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(getContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                "https://run.mocky.io/v3/b6a30bb0-140f-4966-8608-1dc35fa1fadc", null, response -> {

            try {
                Log.d("myapp", "The response is " + response.getString("status"));
                JSONObject object = response.getJSONObject("data");

                JSONArray Jarray  = object.getJSONArray("items");

                for (int i = 0; i < Jarray.length(); i++)
                {
                    String name = Jarray.getJSONObject(i).getString("name");
                    String price = Jarray.getJSONObject(i).getString("price");
                    String extra = Jarray.getJSONObject(i).getString("extra");
                    ListModal item = new ListModal(name, price,extra);
                    itemList.add(item);
                    adapter.notifyDataSetChanged();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, error -> Log.d("myapp", "Something went wrong"));
        requestQueue.add(jsonObjectRequest);

        adapter = new GridAdapter(getActivity(),GridFragment.this, itemList);
        gridView.setAdapter(adapter);
    }



}