package com.example.hubaloleg.topfour.data.mapper;

import com.example.hubaloleg.topfour.data.remote.model.entity.VenueEntity;
import com.example.hubaloleg.topfour.domain.model.Venue;

/**
 * Created by hubaloleg on 11.07.17.
 */

public class VenueMapper {

    private final CategoryMapper mCategoryMapper;

    public VenueMapper(CategoryMapper categoryMapper) {
        mCategoryMapper = categoryMapper;
    }

    public Venue transorm(VenueEntity venueEntity) {
        return new Venue(
                venueEntity.getId(),
                venueEntity.getName(),
                mCategoryMapper.transormList(venueEntity.getCategoryEntityList())
        );
    }
}
