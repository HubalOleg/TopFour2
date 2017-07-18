package com.example.hubaloleg.topfour.data.remote.model.response;

import com.example.hubaloleg.topfour.data.remote.model.entity.venues.VenueEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hubaloleg on 10.07.17.
 */

public class SearchVenueResponse {

    @SerializedName("venues")
    private List<VenueEntity> mVenueEntityList;

    public List<VenueEntity> getVenueEntityList() {
        return mVenueEntityList;
    }

    public void setVenueEntityList(List<VenueEntity> venueEntityList) {
        this.mVenueEntityList = venueEntityList;
    }
}
