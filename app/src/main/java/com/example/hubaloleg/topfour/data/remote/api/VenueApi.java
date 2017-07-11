package com.example.hubaloleg.topfour.data.remote.api;

import com.example.hubaloleg.topfour.data.credential.CredentialStore;
import com.example.hubaloleg.topfour.data.remote.base.ApiInterface;
import com.example.hubaloleg.topfour.data.remote.model.response.ResponseEntity;
import com.example.hubaloleg.topfour.data.remote.model.response.SearchVenueResponse;
import com.example.hubaloleg.topfour.presentation.di.qualifier.ApiVersion;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by hubaloleg on 11.07.17.
 */

public class VenueApi extends BaseDataApi {

    @Inject
    public VenueApi(ApiInterface apiInterface, CredentialStore credentialStore, @ApiVersion String apiVersion) {
        super(apiInterface, credentialStore, apiVersion);
    }

    public Observable<ResponseEntity<SearchVenueResponse>> searchVenues(String coordinates, int limit) {
        return mApiInterface.getSearchVenues(coordinates, limit, mToken, mApiVersion);
    }
}
