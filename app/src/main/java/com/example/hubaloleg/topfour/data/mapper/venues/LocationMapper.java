package com.example.hubaloleg.topfour.data.mapper.venues;

import com.example.hubaloleg.topfour.data.remote.model.entity.venues.LocationEntity;
import com.example.hubaloleg.topfour.domain.model.venues.Location;

/**
 * Created by kostya on 19.07.17.
 */

public class LocationMapper {

    public Location transform(LocationEntity locationEntity) {
        Location location = new Location();
        location.setAddress(locationEntity.getAddress());
        location.setCity(locationEntity.getCity());
        location.setCountry(locationEntity.getCountry());
        location.setLat(locationEntity.getLat());
        location.setLng(locationEntity.getLng());
        location.setPostalCode(locationEntity.getPostalCode());
        location.setState(locationEntity.getState());
        location.setCountryCode(locationEntity.getCountryCode());
        return location;
    }
}
