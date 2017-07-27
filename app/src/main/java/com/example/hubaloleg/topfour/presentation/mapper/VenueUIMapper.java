package com.example.hubaloleg.topfour.presentation.mapper;

import android.util.Log;

import com.example.hubaloleg.topfour.domain.model.Category;
import com.example.hubaloleg.topfour.domain.model.Icon;
import com.example.hubaloleg.topfour.domain.model.Venue;
import com.example.hubaloleg.topfour.presentation.model.VenueUI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hubaloleg on 13.07.17.
 */

public class VenueUIMapper {

    public List<VenueUI> transformList(List<Venue> venueList) {
        List<VenueUI> venueUIList = new ArrayList<>();

        for (Venue venue : venueList) {
            venueUIList.add(transform(venue));
        }
        return venueUIList;
    }

    public VenueUI transform(Venue venue) {
        VenueUI venueUI = new VenueUI();
        venueUI.setId(venue.getId());
        venueUI.setName(venue.getName());

        if (venue.getCategoryList().size() > 0) {
            Category category = getCategory(venue);
            venueUI.setCategoryName(category.getName());
            venueUI.setIcon(getCategoryIcon(category));

        }

        return venueUI;
    }

    private Category getCategory(Venue venue) {
            Log.d("CHECK CATEGORy", "getCategory: " + venue.getCategoryList().size());

        return venue.getCategoryList().get(0);
    }

    private String getCategoryIcon(Category category) {
        Icon icon = category.getIcon();
        return icon.getPrefix() + ImageSize.THUMBNAIL + icon.getSuffix();
    }
}
