package com.example.hubaloleg.topfour.presentation.screens.profile.profile_info.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.domain.model.venues.LikedVenue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kostya on 18.07.17.
 */

public class LikedVenueAdapter extends RecyclerView.Adapter<LikedVenueViewHolder> {
    private List<LikedVenue> mLikedVenueList = new ArrayList<>();
    private LikedVenueViewHolder.OnLikedVenueClickListener mOnLikedVenueClickListener;

    public LikedVenueAdapter(LikedVenueViewHolder.OnLikedVenueClickListener onLikedVenueClickListener) {
        mOnLikedVenueClickListener = onLikedVenueClickListener;
    }

    @Override
    public LikedVenueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_venue, parent, false);
        return new LikedVenueViewHolder(view, mOnLikedVenueClickListener);
    }

    @Override
    public void onBindViewHolder(LikedVenueViewHolder holder, int position) {
        holder.bind(mLikedVenueList.get(position));
    }

    public void updateVenueList(List<LikedVenue> likedVenues) {
        mLikedVenueList = likedVenues;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mLikedVenueList.size();
    }
}
