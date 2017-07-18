package com.example.hubaloleg.topfour.presentation.screens.profile.profile_info.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.domain.model.venues.LikedVenue;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kostya on 18.07.17.
 */

public class LikedVenueViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_venue_name)
    TextView mTvVenueName;

    public LikedVenueViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(LikedVenueViewHolder.this, itemView);
    }

    public void bind(LikedVenue likedVenue) {
        mTvVenueName.setText(likedVenue.getName());
    }
}
