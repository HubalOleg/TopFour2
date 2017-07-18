package com.example.hubaloleg.topfour.data.mapper.venues;

import com.example.hubaloleg.topfour.data.cache.db.VenueDB;
import com.example.hubaloleg.topfour.data.remote.model.entity.venues.VenueEntity;
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

        for (VenueEntity venueEntity : venueEntityList) {
            venueList.add(transformApi(venueEntity));

        }
        return venueList;
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
