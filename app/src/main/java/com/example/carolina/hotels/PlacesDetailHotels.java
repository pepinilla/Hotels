package com.example.carolina.hotels;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carolina.hotels.entities.PlacesDetails;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by carolina on 25/06/17.
 */

public class PlacesDetailHotels extends AppCompatActivity {

    PlacesDetails placesDetails;
    @Bind(R.id.ivPlaceBackdrop)
    ImageView ivPlaceBackdrop;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.overview2)
    TextView overview;
    @Bind(R.id.fab)
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_detail_hotels);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Place saved", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            placesDetails = (PlacesDetails) extras.getSerializable("PLACES");
            this.setTitle(placesDetails.getPlace());
            overview.setText(placesDetails.getHotel());

            Picasso.with(this)
                    .load(placesDetails.getImage())
                    .into(ivPlaceBackdrop);

        }
    }
}
