package com.example.hubaloleg.topfour.data.remote.base;

import com.example.hubaloleg.topfour.data.remote.model.response.LikesVenuesResponse;
import com.example.hubaloleg.topfour.data.remote.model.response.MaxSpeedResponse;
import com.example.hubaloleg.topfour.data.remote.model.response.ResponseEntity;
import com.example.hubaloleg.topfour.data.remote.model.response.SearchVenueResponse;
import com.example.hubaloleg.topfour.data.remote.model.response.UserInfoResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

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
    Observable<ResponseEntity<UserInfoResponse>> getUserProfileInfo(
            @Query("oauth_token") String token,
            @Query("v") String version);

    @GET(ApiFunctions.GET_VENUE_LIKES)
    Observable<ResponseEntity<LikesVenuesResponse>> getLikesVenues(
            @Query("oauth_token") String token,
            @Query("v") String version
    );

    @GET
    Observable<MaxSpeedResponse> getMaxSpeed(
            @Url String url, @Query("data") String data);
}
