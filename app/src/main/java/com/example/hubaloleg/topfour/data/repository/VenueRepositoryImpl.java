package com.example.hubaloleg.topfour.data.repository;

import com.example.hubaloleg.topfour.data.cache.VenueCacheTransformer;
import com.example.hubaloleg.topfour.data.mapper.elements.ElementsMapper;
import com.example.hubaloleg.topfour.data.mapper.venues.VenueMapper;
import com.example.hubaloleg.topfour.data.remote.api.VenueApi;
import com.example.hubaloleg.topfour.data.remote.model.entity.venues.VenueEntity;
import com.example.hubaloleg.topfour.data.remote.model.response.LikesVenuesResponse;
import com.example.hubaloleg.topfour.data.remote.model.response.ResponseEntity;
import com.example.hubaloleg.topfour.domain.model.elements.Element;
import com.example.hubaloleg.topfour.domain.model.venues.LikedVenue;
import com.example.hubaloleg.topfour.domain.model.venues.Venue;
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
    private final ElementsMapper mElementsMapper;

    public VenueRepositoryImpl(ElementsMapper elementsMapper, VenueCacheTransformer venueCacheTransformer, VenueApi venueApi, VenueMapper dataMapper) {
        mVenueCacheTransformer = venueCacheTransformer;
        mVenueApi = venueApi;
        mDataMapper = dataMapper;
        mElementsMapper = elementsMapper;
    }

    @Override
    public Observable<List<Venue>> searchVenuesWithCoordinates(String coordinates, int limit) {
        return mVenueApi.searchVenuesWithCoordinates(coordinates, limit)
                .map(searchVenueResponseResponseEntity -> searchVenueResponseResponseEntity.getResponse().getVenueEntityList())
                .map(mDataMapper::transformApiList)
                .compose(mVenueCacheTransformer)
                .map(mDataMapper::transformDBList);
    }

    @Override
    public Observable<List<LikedVenue>> getLikedVenueList() {
        return mVenueApi.getLikedVenueList()
                .map(ResponseEntity::getResponse)
                .map(LikesVenuesResponse::getLikedVenuesResponse)
                .map(VenueEntity::getItemEntityList)
                .map(mDataMapper::transformToLikedVenueList);
    }

    @Override
    public Observable<List<Element>> fetchMaxSpeedInRadius(String data) {
        return mVenueApi.fetchMaxSpeedInRadius(data)
                .map(maxSpeedResponse -> mElementsMapper.transform(maxSpeedResponse.getElementsEntityList()));
    }

}
