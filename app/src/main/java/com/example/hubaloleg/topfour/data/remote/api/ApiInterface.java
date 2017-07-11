package com.example.hubaloleg.topfour.data.remote.api;

import com.example.hubaloleg.topfour.data.remote.model.response.ResponseEntity;
import com.example.hubaloleg.topfour.data.remote.model.response.SearchVenueResponse;
import com.example.hubaloleg.topfour.data.remote.model.response.UserInfoResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hubaloleg on 10.07.17.
 */

public interface ApiInterface {

    @GET(ApiFunctions.GET_SEARCH_VENUES)
    Observable<ResponseEntity<SearchVenueResponse>> getSearchVenues(
            @Query("ll") String coordinates,
            @Query("limit") int limit,
            @Query("oauth_token") String token,
            @Query("v") String v);

    @GET(ApiFunctions.GET_PROFILE_INFO)
    Observable<ResponseEntity<UserInfoResponse>> getUserProfileInfo(@Query("oauth_token") String token);
}
