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

public class BestTrendingPlaces extends Fragment implements OnItemClickListener, FragmentListener {

    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;
    CustomRecyclerView adapter;


    public BestTrendingPlaces() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.best_places_fragments, container, false);

        ButterKnife.bind(this, view);
        setAdapter();
        setRecyclerView();

        List<PlacesDetails> list = Database.getInstance().getList();
        adapter.setList(list);
        adapter.notifyDataSetChanged();
           return view;
    }

    private void setAdapter(){
        if (adapter == null){
            adapter = new CustomRecyclerView(getActivity());
            adapter.setOnItemClickListener(this);

        }
    }

    private void setRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void OnClick(PlacesDetails placesDetails) {
        //PlacesDetails placesDetails = list.get(getAdapterPosition());
        Intent i = new Intent(getContext(), PlacesDetailHotels.class);
        i.putExtra("PLACES", placesDetails);
        getContext().startActivity(i);

    }

    @Override
    public void addToList(PlacesDetails placesDetails) {
    adapter.addToList(placesDetails);
    }


}
