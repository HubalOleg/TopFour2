package com.example.hubaloleg.topfour.domain.usecase;

import com.example.hubaloleg.topfour.domain.repository.VenueRepository;

import javax.inject.Inject;

/**
 * Created by hubaloleg on 11.07.17.
 */

public class SearchVenueUseCase {

    private final VenueRepository mVenueRepository;

    @Inject
    SearchVenueUseCase(VenueRepository venueRepository) {
        mVenueRepository = venueRepository;
    }
}
