package com.example.carolina.hotels.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.carolina.hotels.PlacesDetailHotels;
import com.example.carolina.hotels.R;
import com.example.carolina.hotels.adapter.CustomRecyclerView;
import com.example.carolina.hotels.adapter.OnItemClickListener;
import com.example.carolina.hotels.database.Database;
import com.example.carolina.hotels.entities.PlacesDetails;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by carolina on 24/06/17.
 */

public class BestTrendingHotels extends Fragment implements FragmentListener {

    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;
    CustomRecyclerView adapter;


    public BestTrendingHotels() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.trending_hotels_fragment, container, false);

        ButterKnife.bind(this, view);
        setAdapter();
        setRecyclerView();

        List<PlacesDetails> listHotels = Database.getInstance().getHotelslist();
        adapter.setList(listHotels);
        adapter.notifyDataSetChanged();
        return view;
    }

    private void setAdapter(){
        if (adapter == null){
            adapter = new CustomRecyclerView(getActivity());
        }
    }

    private void setRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }



    @Override
    public void addToList(PlacesDetails placesDetails) {
        adapter.addToList(placesDetails);
    }
    
}
