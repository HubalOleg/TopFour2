package com.example.hubaloleg.topfour.data.remote.model.response;

import com.example.hubaloleg.topfour.data.remote.model.entity.venues.VenueEntity;
import com.google.gson.annotations.SerializedName;

public class LikesVenuesResponse {
    @SerializedName("count")
    private long count;

    @SerializedName("venues")
    private VenueEntity mLikedVenuesResponse;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public VenueEntity getLikedVenuesResponse() {
        return mLikedVenuesResponse;
    }

    public void setLikedVenuesResponse(VenueEntity likedVenuesResponse) {
        mLikedVenuesResponse = likedVenuesResponse;
    }
}
