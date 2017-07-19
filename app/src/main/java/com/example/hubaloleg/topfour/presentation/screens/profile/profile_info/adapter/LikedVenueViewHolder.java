package com.example.hubaloleg.topfour.presentation.screens.profile.profile_info.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.domain.model.venues.LikedVenue;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by kostya on 18.07.17.
 */

public class LikedVenueViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_venue_name)
    TextView mTvVenueName;

    private OnLikedVenueClickListener mListener;

    public LikedVenueViewHolder(View itemView, OnLikedVenueClickListener listener) {
        super(itemView);
        ButterKnife.bind(LikedVenueViewHolder.this, itemView);
        mListener = listener;
    }

    @OnClick(R.id.cl_venue)
    public void onLikedVenueItemClick() {
        mListener.onVenueClick(getAdapterPosition());
    }

    public void bind(LikedVenue likedVenue) {
        mTvVenueName.setText(likedVenue.getName());
    }

    //interface
    public interface OnLikedVenueClickListener {
        void onVenueClick(int position);
    }
}
