package com.example.hubaloleg.topfour.data.repository;

import com.example.hubaloleg.topfour.data.cache.VenueCache;
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

    private final VenueCache mVenueCache;
    private final VenueApi mVenueApi;
    private final VenueMapper mDataMapper;

    public VenueRepositoryImpl(VenueCache venueCache, VenueApi venueApi, VenueMapper dataMapper) {
        mVenueCache = venueCache;
        mVenueApi = venueApi;
        mDataMapper = dataMapper;
    }

    @Override
    public Observable<List<Venue>> searchVenuesWithCoordinates(String coordinates, int limit) {
        return mVenueApi.searchVenuesWithCoordinates(coordinates, limit)
                .map(searchVenueResponseResponseEntity -> searchVenueResponseResponseEntity.getResponse().getVenueEntityList())
                .map(mDataMapper::transformList);
    }

}
