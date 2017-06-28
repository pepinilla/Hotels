package com.example.carolina.hotels.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.carolina.hotels.R;
import com.example.carolina.hotels.entities.PlacesDetails;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by carolina on 26/06/17.
 */

public class CustomRecyclerView extends RecyclerView.Adapter<CustomRecyclerView.ViewHolder> {

    private List<PlacesDetails> list;
    private OnItemClickListener onItemClickListener;
    Context context;

    public Context getContext() {
        return context;
    }

    public CustomRecyclerView(Context context) {
        this.setList(new ArrayList<PlacesDetails>());
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_places, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PlacesDetails placesDetails = getList().get(position);
        holder.title.setText(placesDetails.getPlace());
        holder.overview.setText(placesDetails.getHotel());

        Picasso.with(getContext())
                .load(placesDetails.getImage())
                .resize(600, 300)
                .into(holder.ivPlaceImage);

        if (this.onItemClickListener != null){
            holder.setOnItemClickListener(placesDetails, this.onItemClickListener);
        }
    }

    @Override
    public int getItemCount() {
        return getList().size();
    }

    public void addToList(PlacesDetails placesDetails){
        getList().add(placesDetails);
        notifyDataSetChanged();
    }

    public List<PlacesDetails> getList() {
        return list;
    }

    public void setList(List<PlacesDetails> list) {
        this.list = list;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.cvPlace)
        CardView cvPlaces;
        @Bind(R.id.ivPlaceImage)
        ImageView ivPlaceImage;
        @Bind(R.id.title)
        TextView title;
        @Bind(R.id.overview)
        TextView overview;
        private View view;


        public ViewHolder(View view) {
            super(view);
            this.view = view;
            ButterKnife.bind(this, view);

        }

        public void setOnItemClickListener(final PlacesDetails placesDetails, final OnItemClickListener ClickListener){
            view.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    ClickListener.OnClick(placesDetails);
                }
            });
        }


    }

}
