package com.example.hubaloleg.topfour.data.mapper.venues;

import com.example.hubaloleg.topfour.data.cache.db.VenueDB;
import com.example.hubaloleg.topfour.data.remote.model.entity.user.ItemEntity;
import com.example.hubaloleg.topfour.data.remote.model.entity.venues.LocationEntity;
import com.example.hubaloleg.topfour.data.remote.model.entity.venues.VenueEntity;
import com.example.hubaloleg.topfour.domain.model.venues.LikedVenue;
import com.example.hubaloleg.topfour.domain.model.venues.Location;
import com.example.hubaloleg.topfour.domain.model.venues.Venue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hubaloleg on 11.07.17.
 */

public class VenueMapper {

    private final CategoryMapper mCategoryMapper;

    public VenueMapper(CategoryMapper categoryMapper) {
        mCategoryMapper = categoryMapper;
    }

    public List<VenueDB> transformApiList(List<VenueEntity> venueEntityList) {
        List<VenueDB> venueList = new ArrayList<>();

        for (VenueEntity venueEntity : venueEntityList)
            venueList.add(transformApi(venueEntity));
        return venueList;
    }

    public List<LikedVenue> transformToLikedVenueList(List<ItemEntity> venueEntityList) {
        List<LikedVenue> likedVenues = new ArrayList<>();
        for (ItemEntity venueEntity : venueEntityList)
            likedVenues.add(transformToLikedVenue(venueEntity));
        return likedVenues;
    }

    private LikedVenue transformToLikedVenue(ItemEntity item) {
        LikedVenue likedVenue = new LikedVenue();
        likedVenue.setId(item.getId());
        likedVenue.setName(item.getName());
        likedVenue.setLocation(transformToLocation(item.getLocationEntity()));
        return likedVenue;
    }

    private Location transformToLocation(LocationEntity locationEntity) {
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

    public VenueDB transformApi(VenueEntity venueEntity) {
        return new VenueDB(
                venueEntity.getId(),
                venueEntity.getName()
        );
    }

    public List<Venue> transformDBList(List<VenueDB> venueDBList) {
        List<Venue> venueList = new ArrayList<>();

        for (VenueDB venueDB : venueDBList) {
            venueList.add(transformDB(venueDB));
        }
        return venueList;
    }

    public Venue transformDB(VenueDB venueDB) {
        return new Venue(
                venueDB.getId(),
                venueDB.getName(),
                null
        );
    }
}
