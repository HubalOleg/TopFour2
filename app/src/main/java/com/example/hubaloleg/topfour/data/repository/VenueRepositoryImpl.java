package com.example.hubaloleg.topfour.data.repository;

import com.example.hubaloleg.topfour.data.cache.VenueCacheTransformer;
import com.example.hubaloleg.topfour.data.mapper.VenueMapper;
import com.example.hubaloleg.topfour.data.remote.api.VenueApi;
import com.example.hubaloleg.topfour.domain.model.Venue;
import com.example.hubaloleg.topfour.domain.repository.VenueRepository;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by hubaloleg on 11.07.17.
 */

public class VenueRepositoryImpl implements VenueRepository {

    private final VenueCacheTransformer mVenueCacheTransformer;
    private final VenueApi mVenueApi;
    private final VenueMapper mDataMapper;

    public VenueRepositoryImpl(VenueCacheTransformer venueCacheTransformer, VenueApi venueApi, VenueMapper dataMapper) {
        mVenueCacheTransformer = venueCacheTransformer;
        mVenueApi = venueApi;
        mDataMapper = dataMapper;
    }

    @Override
    public Observable<List<Venue>> searchVenuesWithCoordinates(String coordinates, int limit) {
        return mVenueApi.searchVenuesWithCoordinates(coordinates, limit)
                .map(searchVenueResponseResponseEntity -> searchVenueResponseResponseEntity.getResponse().getVenueEntityList())
                .map(mDataMapper::transformApiList)
                .compose(mVenueCacheTransformer)
                .map(mDataMapper::transformDBList);
    }

}
