package com.example.workindia;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.workindia.adapter.AdapterList;
import com.example.workindia.model.ListModal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class ListFragment extends Fragment{
    private RecyclerView recyclerView;
    View rootView;
    AdapterList adapter;
    ArrayList<ListModal> itemList = new ArrayList<ListModal>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container,false);
        recyclerView = rootView.findViewById(R.id.home_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        showData();
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
                    if(extra.equals("null"))extra = "";
                    ListModal item = new ListModal(name,"MRP : " + price,extra);
                    itemList.add(item);
                    adapter.notifyDataSetChanged();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, error -> Log.d("myapp", "Something went wrong"));
        requestQueue.add(jsonObjectRequest);

        adapter = new AdapterList(ListFragment.this, itemList);
        recyclerView.setAdapter(adapter);
    }

}