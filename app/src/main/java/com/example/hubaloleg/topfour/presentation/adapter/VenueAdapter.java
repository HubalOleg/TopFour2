package com.example.hubaloleg.topfour.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hubaloleg.topfour.R;
import com.example.hubaloleg.topfour.presentation.model.VenueUI;
import com.example.hubaloleg.topfour.presentation.tools.InitImageUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hubaloleg on 10.07.17.
 */

public class VenueAdapter extends RecyclerView.Adapter<VenueAdapter.VenueViewHolder> {

    private static final String TAG = "VenueAdapter";
    private final Context mContext;

    private List<VenueUI> mVenueList = new ArrayList<>();

    public VenueAdapter(Context context) {
        mContext = context;
    }

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

    public void updateVenues(List<VenueUI> venueList) {
        mVenueList = venueList;
        notifyDataSetChanged();
    }

    class VenueViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_venue_name)
        TextView mVenueNameTextView;
        @BindView(R.id.tv_category)
        TextView mCategoryTextView;
        @BindView(R.id.iv_category_icon)
        ImageView mCategoryIconImageView;

        public VenueViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(VenueViewHolder.this, itemView);
        }

        public void onBind(int position, VenueUI venue) {
            mVenueNameTextView.setText(venue.getName());
            mCategoryTextView.setText(venue.getCategoryName());
            setIcon(venue.getIcon());
        }

        private void setIcon(String iconUrl) {
            Log.d(TAG, "setIcon: " + iconUrl);
            InitImageUtil.initImage(mContext, iconUrl, mCategoryIconImageView);
        }
    }
}
