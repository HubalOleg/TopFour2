package com.example.hubaloleg.topfour.data.remote.model.response;

import com.example.hubaloleg.topfour.data.remote.model.entity.VenueApi;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hubaloleg on 10.07.17.
 */

public class SearchVenueResponse {

    @SerializedName("venues")
    List<VenueApi> venueApiList;

    public List<VenueApi> getVenueApiList() {
        return venueApiList;
    }

    public void setVenueApiList(List<VenueApi> venueApiList) {
        this.venueApiList = venueApiList;
    }
}
