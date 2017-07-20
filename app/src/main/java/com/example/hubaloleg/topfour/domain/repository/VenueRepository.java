package com.example.hubaloleg.topfour.domain.repository;

import com.example.hubaloleg.topfour.domain.model.elements.Element;
import com.example.hubaloleg.topfour.domain.model.venues.LikedVenue;
import com.example.hubaloleg.topfour.domain.model.venues.Venue;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by hubaloleg on 11.07.17.
 */

public interface VenueRepository {

    Observable<List<Venue>> searchVenuesWithCoordinates(String coordinates, int limit);

    Observable<List<LikedVenue>> getLikedVenueList();

    Observable<List<Element>> fetchMaxSpeedInRadius(String data);
}
