package com.example.hubaloleg.topfour.data.remote.api;

import com.example.hubaloleg.topfour.data.credential.CredentialStore;
import com.example.hubaloleg.topfour.data.remote.base.ApiInterface;
import com.example.hubaloleg.topfour.data.remote.model.response.LikesVenuesResponse;
import com.example.hubaloleg.topfour.data.remote.model.response.MaxSpeedResponse;
import com.example.hubaloleg.topfour.data.remote.model.response.ResponseEntity;
import com.example.hubaloleg.topfour.data.remote.model.response.SearchVenueResponse;
import com.example.hubaloleg.topfour.domain.model.elements.Element;
import com.example.hubaloleg.topfour.presentation.di.qualifier.ApiVersion;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by hubaloleg on 11.07.17.
 */

public class VenueApi extends BaseDataApi {

    public static final String HTTPS_OVERPASS_API_DE_API = "https://overpass-api.de/api/interpreter";

    @Inject
    public VenueApi(ApiInterface apiInterface, CredentialStore credentialStore, @ApiVersion String apiVersion) {
        super(apiInterface, credentialStore, apiVersion);
    }

    public Observable<ResponseEntity<SearchVenueResponse>> searchVenuesWithCoordinates(String coordinates, int limit) {
        return mApiInterface.getSearchVenues(coordinates, limit, mToken, mApiVersion);
    }

    public Observable<ResponseEntity<LikesVenuesResponse>> getLikedVenueList() {
        return mApiInterface.getLikesVenues(mToken, mApiVersion);
    }

    public Observable<MaxSpeedResponse> fetchMaxSpeedInRadius(String data) {
        return mApiInterface.getMaxSpeed(HTTPS_OVERPASS_API_DE_API, data);
    }
}
