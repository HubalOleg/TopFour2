package com.example.hubaloleg.topfour.presentation.screens.near_venue.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.domain.model.venues.Venue;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hubaloleg on 10.07.17.
 */

public class VenueAdapter extends RecyclerView.Adapter<VenueAdapter.VenueViewHolder> {

    private List<Venue> mVenueList = new ArrayList<>();

    @Override
    public VenueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_venue, parent, false);

        return new VenueViewHolder(v);
    }

    @Override
    public void onBindViewHolder(VenueViewHolder holder, int position) {
        holder.onBind(position, mVenueList.get(position));
    }

    @Override
    public int getItemCount() {
        return mVenueList.size();
    }

    public void updateVenues(List<Venue> venueList) {
        mVenueList = venueList;
        notifyDataSetChanged();
    }

    class VenueViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_venue_name)
        TextView mVenueNameTextView;

        public VenueViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(VenueViewHolder.this, itemView);
        }

        public void onBind(int position, Venue venue) {
            mVenueNameTextView.setText(venue.getName());
        }
    }
}
