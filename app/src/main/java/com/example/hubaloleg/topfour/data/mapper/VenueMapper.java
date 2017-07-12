package com.example.hubaloleg.topfour.data.mapper;

import com.example.hubaloleg.topfour.data.remote.model.entity.VenueEntity;
import com.example.hubaloleg.topfour.domain.model.Venue;

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

    public List<Venue> transformList(List<VenueEntity> venueEntityList) {
        List<Venue> venueList = new ArrayList<>();

        for (VenueEntity venueEntity : venueEntityList) {
            venueList.add(transform(venueEntity));

        }
        return venueList;
    }

    public Venue transform(VenueEntity venueEntity) {
        return new Venue(
                venueEntity.getId(),
                venueEntity.getName(),
                mCategoryMapper.transormList(venueEntity.getCategoryEntityList())
        );
    }
}
